package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.OrderBean;
import dao.bean.OrderItemBean;
import dao.imp.OrderDao;
import dao.imp.OrderItemDao;

public class BviewOrderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		OrderDao orderDao=new OrderDao();
		OrderBean orderBean= orderDao.getOrderBySid(sid);
		List<OrderItemBean> orderItemBeans=new OrderItemDao().selectOrderItem(sid);
		String sstatus=request.getParameter("sstatus");
		String dgdate=request.getParameter("dgdate");
		request.setAttribute("order", orderBean);
		request.setAttribute("orderItems", orderItemBeans);
		request.setAttribute("sstatus", sstatus);
		request.setAttribute("dgdate", dgdate);
		request.getRequestDispatcher("/background/jsp/viewOrder.jsp").forward(request, response);
	}

}
