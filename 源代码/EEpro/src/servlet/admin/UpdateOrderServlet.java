package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.OrderBean;
import dao.imp.OrderDao;

public class UpdateOrderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String nid = request.getParameter("nid");
		String pay = request.getParameter("pay");
		String shipping = request.getParameter("shipping");
		String sname = request.getParameter("sname");
		String sadress = request.getParameter("sadress");
		String spostcode = request.getParameter("spostcode");
		String snumber = request.getParameter("snumber");
		String semail = request.getParameter("semail");

		OrderBean orderBean=new OrderBean();
		orderBean.setSpayType(pay);
		orderBean.setSsendType(shipping);
		orderBean.setSsname(sname);
		orderBean.setSsaddress(sadress);
		orderBean.setSscode(spostcode);
		orderBean.setSsphone(snumber);
		orderBean.setSsemail(semail);
		
		OrderDao orderDao = new OrderDao();
		orderDao.updateOrder(orderBean, nid);
		
		
		request.getRequestDispatcher("BorderServlet")
				.forward(request, response);
	}

}
