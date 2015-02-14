package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.bean.OrderItemBean;
import dao.db.DbConnection;
import dao.inf.OrderItemInf;

public class OrderItemDao implements OrderItemInf {

	private Connection connection;

	private ResultSet resultSet;
	List<OrderItemBean> list;
	private OrderItemBean orderItemBean;

	@Override
	public List<OrderItemBean> selectOrderItem(String norderid) {

		Connection connection = DbConnection.getCon();
		Statement statement = null;

		String sql = "select * from t_order_item where 1=1 ";
		// System.out.println(sql+"\n");
		if (norderid != null && !"-1".equals(norderid)) {
			sql += " and norderid=" + norderid;
		}
		sql += " order by nid";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			list = new ArrayList<OrderItemBean>();
			while (resultSet.next()) {

				orderItemBean = new OrderItemBean();
				orderItemBean.setNid(resultSet.getString("nid"));
				orderItemBean.setNorderid(resultSet.getString("norderid"));
				orderItemBean.setNmcid(resultSet.getString("nmcid"));
				orderItemBean.setSmcname(resultSet.getString("smcname"));
				orderItemBean.setSdescription(resultSet
						.getString("sdescription"));
				orderItemBean.setSimg(resultSet.getString("simg"));
				orderItemBean.setNcount(resultSet.getString("ncount"));
				orderItemBean.setNprice(resultSet.getString("nprice"));
				orderItemBean
						.setNtotalprice(resultSet.getString("ntotalprice"));

				list.add(orderItemBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public boolean addOrderItem(OrderItemBean orderItemBean) {
		Connection conn = null;
		Statement statement = null;

		String sql = "insert into t_order_item(nid,norderid,nmcid,smcname,sdescription,"
				+ "simg,ncount,nprice ,ntotalprice )"
				+ "values(seq_t_order_item.nextval,'"
				+ orderItemBean.getNorderid()
				+ "','"
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
System.out.println(sql);
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
	public boolean delOrderItem(String sid) {
		//
		Connection conn = null;
		Statement statement = null;
		String sql = "delete from t_order_item where nid='" + sid + "'";

		conn = DbConnection.getCon();
		// System.out.println(sql);
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
	public boolean updateOrderItem(OrderItemBean ordeItemrBean, String sid) {
		Connection conn = null;
		Statement statement = null;

		String sql = "update t_order_item set norderid='"
				+ ordeItemrBean.getNorderid() + "',nmcid='"
				+ ordeItemrBean.getNmcid() + "',smcname='"
				+ ordeItemrBean.getSmcname() + "',sdescription='"
				+ ordeItemrBean.getSdescription() + "',simg='"
				+ ordeItemrBean.getSimg() + "',ncount='"
				+ ordeItemrBean.getNcount() + "',ntotalprice='"
				+ ordeItemrBean.getNtotalprice() + "',nprice='"
				+ ordeItemrBean.getNprice() + "' where nid=" + sid;

		conn = DbConnection.getCon();
		// System.out.println(sql);
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
	public OrderItemBean getOrderBySid(String sid) {
		OrderItemBean orderBean = null;
		Statement statement = null;
		String sql = "select * from t_order_item where norderid='" + sid + "'";
		connection = DbConnection.getCon();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				orderBean = new OrderItemBean();
				orderItemBean.setNid(resultSet.getString("nid"));
				orderItemBean.setNorderid(resultSet.getString("norderid"));
				orderItemBean.setNmcid(resultSet.getString("nmcid"));
				orderItemBean.setSmcname(resultSet.getString("smcname"));
				orderItemBean.setSdescription(resultSet
						.getString("sdescription"));
				orderItemBean.setSimg(resultSet.getString("simg"));
				orderItemBean.setNcount(resultSet.getString("ncount"));
				orderItemBean.setNprice(resultSet.getString("nprice"));
				orderItemBean
						.setNtotalprice(resultSet.getString("ntotalprice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(connection, statement, resultSet);
		}

		return orderBean;
	}

}
