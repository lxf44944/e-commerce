package servlet.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.CarBean;
import dao.bean.OrderBean;
import dao.bean.OrderItemBean;
import dao.bean.UserBean;
import dao.imp.OrderDao;
import dao.imp.ShoppingCar;
import dao.imp.UserDao;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("sname");
		String email = req.getParameter("semail");
		String tel = req.getParameter("snumber");
		String address = req.getParameter("sadress");
		String postcode = req.getParameter("spostcode");
		String suser = req.getParameter("suser");
		String pay = req.getParameter("pay");
		String shipping = req.getParameter("shipping");
		String totalType = req.getParameter("totalType");
		String totalCount = req.getParameter("totalCount");
		String totalPrice = req.getParameter("totalPrice");
		ShoppingCar shoppingCar=(ShoppingCar) req.getSession().getAttribute(
				"car");
		List<CarBean> carBeans = shoppingCar.getCarBeans();
		List<OrderItemBean> lists = new ArrayList<OrderItemBean>();
		OrderItemBean itemBean = null;
		for (CarBean carBean : carBeans) {
			itemBean = new OrderItemBean();
			itemBean.setNmcid(carBean.getMcBean().getNid());
			itemBean.setSmcname(carBean.getMcBean().getSname());
			itemBean.setSdescription(carBean.getMcBean().getSdescription());
			itemBean.setSimg(carBean.getMcBean().getSimg());
			itemBean.setNcount(String.valueOf(carBean.getCount()));
			itemBean.setNprice(carBean.getMcBean().getNprice());
			itemBean.setNtotalprice(String.valueOf(shoppingCar.getTotalPrice()));
			lists.add(itemBean);

		}
		OrderBean orderBean = new OrderBean(null, suser, null, pay, shipping,
				totalType, totalCount, totalPrice, null, null, null, null,
				name, address, postcode, tel, email);
		boolean is = new OrderDao().addOrder(orderBean, lists);
		//System.out.println("is=" + is);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		if (is) {
			out.println("<script language=\"javascript\">");
			ShoppingCar car = (ShoppingCar) req.getSession()
					.getAttribute("car");
			car.clearAll();
			out.println("alert('恭喜您，下单成功！');");
			out.println("location.href='MyOrderServlet?fuser="+suser+"';");

			out.println("</script>");
			// req.getSession().setAttribute("fuser", user);
			// req.getRequestDispatcher("RegSucServlet").forward(req, resp);

		} else {
			out.println("<script language=\"javascript\">");
			out.println("alert('下单失败！');");
			out.println("window.history.back();");
			out.println("</script>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
