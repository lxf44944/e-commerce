package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.OrderBean;
import dao.imp.OrderDao;

public class CheckOrderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sstatus = request.getParameter("status");
		String smsg = request.getParameter("smsg");
		String sid = request.getParameter("sid");
		String sauser=(String) request.getSession().getAttribute("suser");
		OrderDao orderDao = new OrderDao();
		orderDao.checkOrder(sstatus,smsg,sauser, sid);
		
		
		request.getRequestDispatcher("BorderServlet")
				.forward(request, response);
	}

}
