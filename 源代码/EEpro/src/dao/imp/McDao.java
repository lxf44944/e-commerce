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
import dao.db.DbConnection;
import dao.inf.McInf;

public class McDao implements McInf {

	private Connection connection;

	private ResultSet resultSet;
	List<McBean> list;
	private McBean mcBean;

	@Override
	public List<McBean> selectMc(HttpServletRequest request) {
		String nmaxid = request.getParameter("nmaxid");
		String nminid = request.getParameter("nminid");
		String sname = request.getParameter("sname");
		Connection connection = DbConnection.getCon();
		Statement statement = null;
		//System.out.println("nminid="+nminid);
		PageDAO pageDAO = new PageDAO(request);
		String sqlCount = "select count(nid) from t_mc where 1=1";
		if (nmaxid != null && !"".equals(nmaxid) && !"-1".equals(nmaxid)) {
			sqlCount = sqlCount + " and nmaxid='" + nmaxid + "'";
		}
		if (sname != null) {
			if (!"".equals(sname.trim()) && !"请输入商品名称".equals(sname.trim())) {
				sqlCount = sqlCount + " and sname like '%" + sname.trim()
						+ "%'";
			}
		}

		if (nminid != null && !nminid.equals("") && !nminid.equals("-1")) {
			sqlCount = sqlCount + " and nminid='" + nminid + "' ";
		}
//		int currentPage = pageDAO.getCurrentPage();
		System.out.println(request.getSession().getAttribute("currentPage"));
		int currentPage=1;
		try {
			 currentPage= (Integer) request.getSession().getAttribute("currentPage");
		} catch (Exception e) {
			currentPage = pageDAO.getCurrentPage();
		}
		
		
		// pageDAO.setPagesize(2);
		int pageSize = pageDAO.getPagesize();
		int totalCount = pageDAO.getRsCountForSQL(sqlCount);
		pageDAO.setRscount(totalCount);
		String pageTool = pageDAO.pagetool(PageDAO.Text);
		request.setAttribute("pageTool", pageTool);

		int startPage = (currentPage - 1) * pageSize + 1;
		int endPage = currentPage * pageSize;

		String sql = "select * from (" 
//				+ "select nid,sname, sdescription, nprice, simg,"
//				+ "decode(t.smctag, 0, '否', 1, '是', '否') smctag,to_char(dcdate,'yyyy-MM-dd HH24:MI:SS') dcdate,"
//				+ "(select b.sname from t_mc_type b where b.nid = t.nmaxid) nmaxid,"
//				+ " (select b.sname from t_mc_type b where b.nid = t.nminid) nminid ,"
				+ "select nid,sname, sdescription, nprice, simg,"
				+ "smctag,dcdate,nmaxid,nminid,"
				+ "rownum rn from VIEW_GOODS t " +
				"where rownum<=" + endPage;
		if (nmaxid != null && !"".equals(nmaxid) && !"-1".equals(nmaxid)) {
			sql = sql + " and maxid='" + nmaxid + "'";
		}
		if (sname != null) {
			if (!"".equals(sname.trim()) && !"请输入商品名称".equals(sname.trim())) {
				sql = sql + " and sname like '%" + sname.trim() + "%'";
			}
		}

		if (nminid != null && !nminid.equals("") && !nminid.equals("-1")) {
			sql = sql + " and minid='" + nminid + "' ";
		}
		sql = sql + ") tt where tt.rn>= " + startPage;
		sql = sql + " order by nid";
System.out.println(sql+"\n"+sqlCount);

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			list = new ArrayList<McBean>();
			while (resultSet.next()) {

				mcBean = new McBean();
				mcBean.setNid(resultSet.getString("nid"));
				mcBean.setSname(resultSet.getString("sname"));
				mcBean.setSdescription(resultSet.getString("sdescription"));
				mcBean.setNprice(resultSet.getString("nprice"));
				mcBean.setSimg(resultSet.getString("simg"));
				mcBean.setSmctag(resultSet.getString("smctag"));
				mcBean.setDcdate(resultSet.getString("dcdate"));
				mcBean.setNmaxid(resultSet.getString("nmaxid"));
				mcBean.setNminid(resultSet.getString("nminid"));
				list.add(mcBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public boolean addMc(McBean mcBean) {
		Connection conn = null;
		Statement statement = null;
		String sql = "call proc_addmc('"
				+ mcBean.getSname()
				+ "','"
				+ mcBean.getSdescription()
				+ "','"
				+ mcBean.getNprice()
				+ "','"
				+ mcBean.getSimg()
				+ "','"
				+ mcBean.getSmctag()
				+ "',sysdate,'"
				+ mcBean.getNmaxid()
				+ "','"
				+ mcBean.getNminid() + "',?)";
/*		String sql = "insert into t_mc(nid,sname,sdescription,nprice,simg,smctag,dcdate,nmaxid,nminid)"
				+ "values(seq_t_mc.nextval,'"
				+ mcBean.getSname()
				+ "','"
				+ mcBean.getSdescription()
				+ "','"
				+ mcBean.getNprice()
				+ "','"
				+ mcBean.getSimg()
				+ "','"
				+ mcBean.getSmctag()
				+ "',sysdate,'"
				+ mcBean.getNmaxid()
				+ "','"
				+ mcBean.getNminid() + "')";
*/		conn = DbConnection.getCon();
		System.out.println(sql);
		try {
//			statement = conn.createStatement();
//			int r = statement.executeUpdate(sql);
			
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

	@Override
	public boolean delMc(String sid) {
		// 
		Connection conn = null;
		Statement statement = null;
		String sql = "call proc_delmc('" + sid + "',?)";

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

	@Override
	public boolean updateMc(McBean mcBean, String sid) {
		Connection conn = null;
		Statement statement = null;
		String sql = "call proc_updatemc('"
				+ mcBean.getSname() + "','"
				+ mcBean.getSdescription() + "','" + mcBean.getNprice()
				+ "','" + mcBean.getSimg() + "','"
				+ mcBean.getSmctag() + "','" + mcBean.getNmaxid() + "','"
				+ mcBean.getNminid() + "' ," + sid+",?)";
/*		String sql = "update t_mc set sname='"
				+ mcBean.getSname() + "',sdescription='"
				+ mcBean.getSdescription() + "',nprice='" + mcBean.getNprice()
				+ "',simg='" + mcBean.getSimg() + "',smctag='"
				+ mcBean.getSmctag() + "',nmaxid='" + mcBean.getNmaxid() + "',nminid='"
				+ mcBean.getNminid() + "' where nid=" + sid;
*/
		conn = DbConnection.getCon();

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
	public McBean getMcBySid(String sid) {
		McBean mcBean = null;
		Statement statement = null;
		/*String sql = "select nid,sname, sdescription, nprice, simg,"
				+ "decode(t.smctag, 0, '否', 1, '是', '否') smctag,to_char(dcdate,'yyyy-MM-dd HH24:MI:SS') dcdate,"
				+ "(select b.sname from t_mc_type b where b.nid = t.nmaxid) nmaxid,"
				+ " (select b.sname from t_mc_type b where b.nid = t.nminid) nminid  from t_mc t where nid='" + sid + "'";
*/		
		String sql = "select * from t_mc where nid='" + sid + "'";
		connection = DbConnection.getCon();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			System.out.println(sql);
			if (resultSet.next()) {
				mcBean = new McBean();
				mcBean.setNid(resultSet.getString("nid"));
				mcBean.setSname(resultSet.getString("sname"));
				mcBean.setSdescription(resultSet.getString("sdescription"));
				mcBean.setNprice(resultSet.getString("nprice"));
				mcBean.setSimg(resultSet.getString("simg"));
				mcBean.setSmctag(resultSet.getString("smctag"));
				mcBean.setDcdate(resultSet.getString("dcdate"));
				mcBean.setNmaxid(resultSet.getString("nmaxid"));
				mcBean.setNminid(resultSet.getString("nminid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}

		return mcBean;
	}

	@Override
	public String getCount(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
