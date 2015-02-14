package dao.inf;

import java.util.List;

import dao.bean.OrderItemBean;

//增删改查（传request进来查询）、getCount(String sql)  六个方法
public interface OrderItemInf {
	public List<OrderItemBean> selectOrderItem(String norderid);

	public boolean addOrderItem(OrderItemBean orderItemBean);

	public boolean delOrderItem(String sid);

	public boolean updateOrderItem(OrderItemBean orderItemBean, String sid);

	public OrderItemBean getOrderBySid(String norderid);


}
