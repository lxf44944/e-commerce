package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.bean.McBean;
import dao.bean.UserBean;
import dao.db.DbConnection;
import dao.inf.UserInf;

public class UserDao implements UserInf{

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ArrayList<UserBean> list;


	public boolean addUser(UserBean userBean) {
		Connection conn = null;
		Statement statement = null;
		String sql = "insert into t_user(suser,pass,name,sex,birth,email,tel,address,postcode)"
				+ "values('"
				+ userBean.getUser()
				+ "','"
				+ userBean.getPass()
				+ "','"
				+ userBean.getName()
				+ "','"
				+ userBean.getSex()
				+ "','"
				+ userBean.getBirth()
				+ "','"
				+ userBean.getEmail()
				+ "','"
				+ userBean.getTel()
				+ "','"
				+ userBean.getAdress()
				+ "','" + userBean.getPostcode()+"')";
		conn = DbConnection.getCon();

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
	public boolean delUser(String sid) {
		Connection conn = null;
		Statement statement = null;
		String sql = "delete from t_user where suser='" + sid + "'";

		conn = DbConnection.getCon();
//		System.out.println(sql);
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


	public boolean updatePass(String user,String oldPass,String pass) {
		Connection conn = null;
		Statement statement = null;
		UserBean userBean=getUserBySid(user);
		if (oldPass.equals(userBean.getPass())) {
			String sql = "update t_user set pass='"
					+ pass  + "' where suser='" + user +"'";
			
			conn = DbConnection.getCon();
//			System.out.println(sql);
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
			
		}
			return false;
		
		
		
		
	}
	public boolean updateUser(UserBean userBean, String sid) {
		Connection conn = null;
		Statement statement = null;
		String sql = "update t_user set name='"
				+ userBean.getName() + "',sex='"
				+ userBean.getSex() + "',birth='" + userBean.getBirth()
				+ "',email='" + userBean.getEmail() + "',tel='"
				+ userBean.getTel() + "',address='" + userBean.getAdress() + "',postcode='"
				+ userBean.getPostcode() + "' where suser='" + sid+"'";

		conn = DbConnection.getCon();
//		System.out.println(sql);
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
	public UserBean getUserBySid(String sname) {
		UserBean user = null;
//System.out.println(sname);
		String sql = "select suser,name,sex,pass,birth,email,tel,address,postcode,to_char(regdate,'yyyy-MM-dd HH24:MI:SS') regdate,"
				+ " status from t_user where suser='" + sname
				 +"'";
		connection = DbConnection.getCon();

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user = new UserBean();
				user.setUser(resultSet.getString("suser"));
				user.setName(resultSet.getString("name"));
				user.setSex(resultSet.getString("sex"));
				user.setBirth(resultSet.getString("birth"));
				user.setEmail(resultSet.getString("email"));
				user.setTel(resultSet.getString("tel"));
				user.setAdress(resultSet.getString("address"));
				user.setPostcode(resultSet.getString("postcode"));
				user.setPass(resultSet.getString("pass"));
				user.setStatus(resultSet.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement,resultSet );
		}

		return user;
	}

	@Override
	public List<UserBean> selectUser(HttpServletRequest request) {
		String suser = request.getParameter("suser");
		String sex = request.getParameter("sex");
		String status = request.getParameter("status");
		Connection connection = DbConnection.getCon();
		Statement statement = null;
		UserBean userBean = null;
		PageDAO pageDAO = new PageDAO(request);
		String sql = "select count(suser) from t_user where 1=1";
		if (suser != null && !"".equals(suser) && !"-1".equals(suser)&&!"请输入用户名".equals(suser)) {
			sql = sql + " and suser like '%" + suser +"%'";
		}
		if (status != null) {
			if (!"".equals(status.trim()) && !"-1".equals(status)) {
				sql = sql + " and status ='" + status.trim()
						+ "'";
			}
		}

		if (sex != null && !sex.equals("") && !sex.equals("-1")) {
			sql = sql + " and sex='" + sex + "'";
		}
		int currentPage = pageDAO.getCurrentPage();
		// pageDAO.setPagesize(2);
		int pageSize = pageDAO.getPagesize();
		int totalCount = pageDAO.getRsCountForSQL(sql);
		pageDAO.setRscount(totalCount);
		String pageTool = pageDAO.pagetool(PageDAO.Text);
		request.setAttribute("pageTool", pageTool);

		int startPage = (currentPage - 1) * pageSize + 1;
		int endPage = currentPage * pageSize;

		String sql1 = "select * from(select suser,name,sex,birth,email,tel,address,postcode,to_char(regdate,'yyyy-MM-dd HH24:MI:SS') regdate,"
				+ " status,"
				+ "rownum rn from t_user t where rownum<=" + endPage;
		
		if (suser != null && !"".equals(suser) && !"-1".equals(suser)&&!"请输入用户名".equals(suser)) {
			sql1 = sql1 + " and suser like '%" + suser +"%'";
		}
		if (status != null) {
			if (!"".equals(status.trim()) && !"-1".equals(status)) {
				sql1 = sql1 + " and status='" + status.trim()
						+ "'";
			}
		}

		if (sex != null && !sex.equals("") && !sex.equals("-1")) {
			sql1 = sql1 + " and sex='" + sex + "'";
		}
		
		sql1 = sql1 + ") tt where tt.rn>= " + startPage;
		sql1 = sql1 + " order by regdate";
		 System.out.println(sql+"\n"+sql1);

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql1);
			list = new ArrayList<UserBean>();
			while (resultSet.next()) {
				
				userBean = new UserBean();
				userBean.setUser(resultSet.getString("suser"));
//				userBean.setPass(resultSet.getString("pass"));
				userBean.setName(resultSet.getString("name"));
				userBean.setSex(resultSet.getString("sex"));
				userBean.setBirth(resultSet.getString("birth"));
				userBean.setEmail(resultSet.getString("email"));
				userBean.setTel(resultSet.getString("tel"));
				userBean.setAdress(resultSet.getString("address"));
				userBean.setPostcode(resultSet.getString("postcode"));
				userBean.setRegdate(resultSet.getString("regdate"));
				userBean.setStatus(resultSet.getString("status"));
				list.add(userBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}
		return list;
	}
	
	public boolean changeStatus(String suser,String status){
		
		Connection conn = null;
		Statement statement = null;
		
		String sql = "update t_user set status='"
				+(status.equals("是")?"否":"是")+
				 "' where suser='" + suser+"'";

		conn = DbConnection.getCon();
		System.out.println((status));
		System.out.println((status.equals("是")?"否":"是"));
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
	public String getCount(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
