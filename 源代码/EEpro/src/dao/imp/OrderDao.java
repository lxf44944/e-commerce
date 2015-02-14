package dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.bean.McBean;
import dao.bean.OrderBean;
import dao.bean.OrderItemBean;
import dao.db.DbConnection;
import dao.inf.McInf;
import dao.inf.OrderInf;

public class OrderDao implements OrderInf {

	private Connection connection;

	private ResultSet resultSet;
	List<OrderBean> list;
	private OrderBean orderBean;

	@Override
	public List<OrderBean> selectOrder(HttpServletRequest request) {
		String sstatus = request.getParameter("sstatus");
		String sdgdate = request.getParameter("sdgdate");
		String edgdate = request.getParameter("edgdate");
		String smcname = request.getParameter("smcname");
		String scuser = request.getParameter("scuser");
		String fuser = request.getParameter("fuser");

		Connection connection = DbConnection.getCon();
		Statement statement = null;
		PageDAO pageDAO = new PageDAO(request);
		String sqlCount = "select count(nid) from t_order where 1=1";
		if (sstatus != null && !"".equals(sstatus) && !"-1".equals(sstatus)) {
			sqlCount = sqlCount + " and sstatus='" + sstatus + "'";
		}
		if (sdgdate != null) {
			if (!"".equals(sdgdate.trim()) && !"请输入下单开始日期".equals(sdgdate.trim())) {
				sqlCount = sqlCount + " and to_char(dgdate,'yyyy-MM-dd') >='"+ sdgdate.trim()
						+"'";
			}
		}
		if (edgdate != null) {
			if (!"".equals(edgdate.trim()) && !"请输入下单结束日期".equals(edgdate.trim())) {
				sqlCount = sqlCount + " and to_char(dgdate,'yyyy-MM-dd') <='"+ edgdate.trim()
						+"'";
			}
		}
		if (scuser != null) {
			if (!"".equals(scuser.trim()) && !"请输入用户名".equals(scuser.trim())) {
				sqlCount = sqlCount + " and scuser like '%" + scuser.trim()
						+ "%'";
			}
		}
		if (smcname != null) {
			if (!"".equals(smcname.trim()) && !"请输入商品名称".equals(smcname.trim())) {
				sqlCount = sqlCount + " and nid in (select norderid from t_order_item where smcname like '%" + smcname.trim()
						+ "%') ";
			}
		}
		if (fuser != null) {
			if (!"".equals(fuser.trim()) && !"请输入用户名".equals(fuser.trim())) {
				sqlCount = sqlCount + " and scuser ='" + fuser.trim()
						+ "'";
			}
		}

		int currentPage = pageDAO.getCurrentPage();
		// pageDAO.setPagesize(2);
		int pageSize = pageDAO.getPagesize();
		int totalCount = pageDAO.getRsCountForSQL(sqlCount);
		pageDAO.setRscount(totalCount);
		String pageTool = pageDAO.pagetool(PageDAO.Text);
		request.setAttribute("pageTool", pageTool);

		int startPage = (currentPage - 1) * pageSize + 1;
		int endPage = currentPage * pageSize;

		String sql = "select * from " 
				/*+"(select nid,scuser,to_char(dgdate,'yyyy-MM-dd HH24:MI:SS') dgdate,spaytype,ssendtype,"
				+ "nmctypesize,nmcsize,ntotalprice ,decode(t.sstatus, 1, '未审核', 2, '通过', '不通过') sstatus,smsg,sauser,dadate,ssname,ssaddress ,"
				+ "sscode,ssphone ,ssemail,"*/
				+"(select nid,scuser,to_char(dgdate,'yyyy-MM-dd HH24:MI:SS') dgdate,spaytype,ssendtype,"
				+ "nmctypesize,nmcsize,ntotalprice ,sstatus,smsg,sauser,dadate,ssname,ssaddress ,"
				+ "sscode,ssphone ,ssemail,"
				
				+ "rownum rn from view_order t where rownum<=" + endPage;

		if (sstatus != null && !"".equals(sstatus) && !"-1".equals(sstatus)) {
			sql = sql + " and sstatus='" + sstatus + "'";
		}
		if (sdgdate != null) {
			if (!"".equals(sdgdate.trim()) && !"请输入下单开始日期".equals(sdgdate.trim())) {
				sql = sql + " and to_char(dgdate,'yyyy-MM-dd') >='"+ sdgdate.trim()
						+"'";
			}
		}
		if (edgdate != null) {
			if (!"".equals(edgdate.trim()) && !"请输入下单结束日期".equals(edgdate.trim())) {
				sql = sql + " and to_char(dgdate,'yyyy-MM-dd') <='"+ edgdate.trim()
						+"'";
			}
		}
		if (scuser != null) {
			if (!"".equals(scuser.trim()) && !"请输入用户名".equals(scuser.trim())) {
				sql = sql + " and scuser like '%" + scuser.trim()
						+ "%'";
			}
		}
		if (smcname != null) {
			if (!"".equals(smcname.trim()) && !"请输入商品名称".equals(smcname.trim())) {
				sql = sql + " and nid in (select norderid from t_order_item where smcname like '%" + smcname.trim()
						+ "%') ";
			}
		}
		if (fuser != null) {
			if (!"".equals(fuser.trim()) && !"请输入用户名".equals(fuser.trim())) {
				sql = sql + " and scuser ='" + fuser.trim()
						+ "'";
			}
		}

		sql = sql + ") tt where tt.rn>= " + startPage;
		sql = sql + " order by nid";
System.out.println(sql + "\n" );

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			list = new ArrayList<OrderBean>();
			while (resultSet.next()) {

				orderBean = new OrderBean();
				orderBean.setNid(resultSet.getString("nid"));
				orderBean.setScuser(resultSet.getString("scuser"));
				orderBean.setDgdate(resultSet.getString("dgdate"));
				orderBean.setSpayType(resultSet.getString("spayType"));
				orderBean.setSsendType(resultSet.getString("ssendType"));
				orderBean.setNmcTypeSize(resultSet.getString("nmcTypeSize"));
				orderBean.setNmcSize(resultSet.getString("nmcSize"));
				orderBean.setNtotalPrice(resultSet.getString("ntotalPrice"));
				orderBean.setSstatus(resultSet.getString("sstatus"));
				orderBean.setSmsg(resultSet.getString("smsg"));
				orderBean.setSauser(resultSet.getString("sauser"));
				orderBean.setDadate(resultSet.getString("dadate"));
				orderBean.setSsname(resultSet.getString("ssname"));
				orderBean.setSsaddress(resultSet.getString("ssaddress"));
				orderBean.setSscode(resultSet.getString("sscode"));
				orderBean.setSsphone(resultSet.getString("ssphone"));
				orderBean.setSsemail(resultSet.getString("ssemail"));
				list.add(orderBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public boolean addOrder(OrderBean orderBean, List<OrderItemBean> lists) {
		Connection conn = null;
		Statement statement = null;
		String sql = "insert into t_order(nid,scuser,dgdate,spaytype,ssendtype,"
				+ "nmctypesize,nmcsize,ntotalprice ,sstatus,ssname,ssaddress ,"
				+ "sscode,ssphone ,ssemail )" + "values(seq_t_order.nextval,'"
				+ orderBean.getScuser()
				+ "',sysdate,'"
				+ orderBean.getSpayType()
				+ "','"
				+ orderBean.getSsendType()
				+ "','"
				+ orderBean.getNmcTypeSize()
				+ "','"
				+ orderBean.getNmcSize()
				+ "','"
				+ orderBean.getNtotalPrice()
				+ "','1','"
				+ orderBean.getSsname()
				+ "','"
				+ orderBean.getSsaddress()
				+ "','"
				+ orderBean.getSscode()
				+ "','"
				+ orderBean.getSsphone()
				+ "','"
				+ orderBean.getSsemail() + "')";
		System.out.println(sql);
		

		conn = DbConnection.getCon();
		
		try {
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			statement.addBatch(sql);
			for (OrderItemBean orderItemBean : lists) {
				String sql2 = "insert into t_order_item(nid,norderid,nmcid,smcname,sdescription,"
						+ "simg,ncount,nprice ,ntotalprice )"
						+ "values(seq_t_order_item.nextval,"
						+ "seq_t_order.currval,'"	
						+ orderItemBean.getNmcid()
						+ "','"
						+ orderItemBean.getSmcname()
						+ "','"
						+ orderItemBean.getSdescription()
						+ "','"
						+ orderItemBean.getSimg()
						+ "','"
						+ orderItemBean.getNcount()
						+ "','"
						+ orderItemBean.getNprice()
						+ "','"
						+ orderItemBean.getNtotalprice() + "')";
				statement.addBatch(sql2);
System.out.println(sql2);
			}
			statement.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConnection.close(conn, statement, null);
		}

		return false;
	}

	@Override
	public boolean delOrder(String sid) {
		//
		Connection conn = null;
		Statement statement = null;
		String sql = "call proc_delmc('" + sid + "',?)";

		conn = DbConnection.getCon();
		// System.out.println(sql);
		try {
			CallableStatement st =conn.prepareCall("{"+sql+"}");  
	        st.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);  
	        st.execute();  
	  
	        int r =st.getInt(1);  //获取输出参数  
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConnection.close(conn, statement, null);
		}

		return false;
	}

	@Override
	public boolean updateOrder(OrderBean orderBean, String sid) {
		Connection conn = null;
		Statement statement = null;
		
		String sql = "call proc_updorder('" + orderBean.getSpayType()
				+ "','" + orderBean.getSsendType() + "','"
				+ orderBean.getSsname() + "','"
				+ orderBean.getSsaddress() + "','"
				+ orderBean.getSscode() + "','"
				+ orderBean.getSsphone() + "','"
				+ orderBean.getSsemail() + "'," + sid+",?)";
		
		conn = DbConnection.getCon();
 System.out.println(sql);
		try {
			CallableStatement st =conn.prepareCall("{"+sql+"}");  
	        st.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);  
	        st.execute();  
	  
	        int r =st.getInt(1);  //获取输出参数  
	        System.out.println(r);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConnection.close(conn, statement, null);
		}
		
		return false;
	}
	
	public boolean checkOrder(String sstatus,String smsg,String sauser, String sid) {
		Connection conn = null;
		Statement statement = null;

		String sql = "update t_order set sstatus='" + sstatus
				+ "',smsg='" + smsg + "',sauser='"
				+ sauser  + "',dadate=sysdate where nid=" + sid;

		conn = DbConnection.getCon();
 System.out.println(sql);
		try {
			statement = conn.createStatement();
			int r = statement.executeUpdate(sql);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConnection.close(conn, statement, null);
		}

		return false;
	}

	@Override
	public OrderBean getOrderBySid(String sid) {
		OrderBean orderBean = null;
		Statement statement = null;
	/*	String sql = "select nid,scuser,to_char(dgdate,'yyyy-MM-dd HH24:MI:SS') dgdate,spaytype,ssendtype,"
				+ "nmctypesize,nmcsize,ntotalprice ,decode(sstatus, 1, '未审核', 2, '通过', '不通过') sstatus,smsg," +
				"sauser,to_char(dadate,'yyyy-MM-dd HH24:MI:SS') dadate,ssname,ssaddress ,"
				+ "sscode,ssphone ,ssemail from t_order where nid='" + sid + "'";*/
		String sql = "select nid,scuser,to_char(dgdate,'yyyy-MM-dd HH24:MI:SS') dgdate,spaytype,ssendtype,"
				+ "nmctypesize,nmcsize,ntotalprice ,sstatus,smsg,sauser,dadate,ssname,ssaddress ,"
				+ "sscode,ssphone ,ssemail from VIEW_ORDER  where nid='" + sid + "'";
		connection = DbConnection.getCon();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				orderBean = new OrderBean();
				orderBean.setNid(resultSet.getString("nid"));
				orderBean.setScuser(resultSet.getString("scuser"));
				orderBean.setDgdate(resultSet.getString("dgdate"));
				orderBean.setSpayType(resultSet.getString("spayType"));
				orderBean.setSsendType(resultSet.getString("ssendType"));
				orderBean.setNmcTypeSize(resultSet.getString("nmcTypeSize"));
				orderBean.setNmcSize(resultSet.getString("nmcSize"));
				orderBean.setNtotalPrice(resultSet.getString("ntotalPrice"));
				orderBean.setSstatus(resultSet.getString("sstatus"));
				orderBean.setSmsg(resultSet.getString("smsg"));
				orderBean.setSauser(resultSet.getString("sauser"));
				orderBean.setDadate(resultSet.getString("dadate"));
				orderBean.setSsname(resultSet.getString("ssname"));
				orderBean.setSsaddress(resultSet.getString("ssaddress"));
				orderBean.setSscode(resultSet.getString("sscode"));
				orderBean.setSsphone(resultSet.getString("ssphone"));
				orderBean.setSsemail(resultSet.getString("ssemail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}

		return orderBean;
	}

	@Override
	public String getCount(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
