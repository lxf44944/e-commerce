package dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import dao.bean.McTypeBean;
import dao.bean.UserBean;
import dao.db.DbConnection;
import dao.inf.McTypeInf;

public class McTypeDao implements McTypeInf {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private List<McTypeBean> rows;

	@Override
	public List<McTypeBean> selectMcType(HttpServletRequest request) {

		// String nid=request.getParameter("nmaxid");
		// String sname=request.getParameter("sname");
		// String npid=request.getParameter("nminid");
		connection = DbConnection.getCon();
		String sql = "select * from t_mc_type where 1=1 ";

		sql = sql + " order by nid";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			rows = new ArrayList<McTypeBean>();
			while (resultSet.next()) {
				McTypeBean bean = new McTypeBean();
				bean.setNid(resultSet.getString("nid"));
				bean.setSname(resultSet.getString("sname"));
				bean.setNpid(resultSet.getString("npid"));
				rows.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}
		return rows;
	}

	@Override
	public List<McTypeBean> selectMcTypeByNpid(String npid) {

		// String nid=request.getParameter("nmaxid");
		// String sname=request.getParameter("sname");
		// String npid=request.getParameter("nminid");
		connection = DbConnection.getCon();
		String sql = "select * from t_mc_type where npid= " + npid;

		sql = sql + " order by nid";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			rows = new ArrayList<McTypeBean>();
			while (resultSet.next()) {
				McTypeBean bean = new McTypeBean();
				bean.setNid(resultSet.getString("nid"));
				bean.setSname(resultSet.getString("sname"));
				bean.setNpid(resultSet.getString("npid"));
				rows.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}
		return rows;
	}

	@Override
	public boolean addMcType(McTypeBean typeBean) {
		Connection conn = null;
		Statement statement = null;
		String sql = "call add_mc_type"
				+ "('" + typeBean.getSname()
				+ "'," + typeBean.getNpid() + ")";
/*		String sql = "insert into t_mc_type(nid,sname,npid)"
				+ " values(seq_t_mc_type.nextval,'" + typeBean.getSname()
				+ "'," + typeBean.getNpid() + ")";
*/		conn = DbConnection.getCon();
System.out.println(sql);
//System.out.println(typeBean.getNpid());
		List<McTypeBean> list = selectMcTypeByNpid(typeBean.getNpid());
//System.out.println("list="+list);
		for (McTypeBean mcTypeBean : list) {
			if (mcTypeBean.getSname().equals(typeBean.getSname())
					&& mcTypeBean.getNpid().equals(typeBean.getNpid())) {

				return false;
			}
		}
		try {
			//3.创建CallableStatement
            CallableStatement cs = conn.prepareCall("{? = "+sql+"}");
            //给？赋值
            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            //4.执行
            cs.execute();
            int r = cs.getInt(1);
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
	public boolean delMcType(String maxid, String minid) {
		Connection conn = null;
		Statement statement = null;
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql.append("delete from t_mc_type where 1=1 ");
//		sql2.append("delete from t_mc where 1=1 ");
		if (maxid == null) {
			sql.append("and nid=" + minid);
//			sql2.append("and nminid=" + minid);
		} else {
			sql.append("and nid=" + maxid+" or npid="+maxid);
//			sql2.append("and nmaxid=" + maxid);
		}

		// System.out.println(sql.toString());
		// System.out.println(sql2.toString());
		conn = DbConnection.getCon();
		// System.out.println(sql);
		try {
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			statement.addBatch(sql.toString());
//			statement.addBatch(sql2.toString());
			statement.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateMcType(String sname, String sid) {
		Connection conn = null;
		Statement statement = null;
		String sql = "call upd_mc_type('" + sname + "',"
				+ sid+")";
		McTypeBean bean=new McTypeDao().getMcTypeBySid(sid);
		if (new McTypeDao().getMcTypeBySname(sname,bean.getNpid())!=null) {
			return false;
		}
		conn = DbConnection.getCon();
		// System.out.println(sql);
		try {
			//3.创建CallableStatement
            CallableStatement cs = conn.prepareCall("{? = "+sql+"}");
            //给？赋值
            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            //4.执行
            cs.execute();
            int r = cs.getInt(1);
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
	public McTypeBean getMcTypeBySid(String sid) {
		McTypeBean typeBean = null;
		
		String sql = "select * from t_mc_type where nid='" + sid + "'";
		connection = DbConnection.getCon();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				typeBean = new McTypeBean();
				typeBean.setNid(resultSet.getString("nid"));
				typeBean.setSname(resultSet.getString("sname"));
				typeBean.setNpid(resultSet.getString("npid"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}
		
		return typeBean;
	}
	
	public McTypeBean getMcTypeBySname(String sname,String npid) {
		McTypeBean typeBean = null;

		String sql = "select * from t_mc_type where sname='" + sname + "' and npid='"+npid+"'";
		connection = DbConnection.getCon();

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				typeBean = new McTypeBean();
				typeBean.setNid(resultSet.getString("nid"));
				typeBean.setSname(resultSet.getString("sname"));
				typeBean.setNpid(resultSet.getString("npid"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}

		return typeBean;
	}

	@Override
	public String getCount(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
