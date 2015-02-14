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

public class BorderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderDao orderDao = new OrderDao();
		List<OrderBean> orders = orderDao.selectOrder(request);
		String sstatus = request.getParameter("sstatus");
		String sdgdate = request.getParameter("sdgdate");
		String edgdate = request.getParameter("edgdate");
		String smcname = request.getParameter("smcname");
		String scuser = request.getParameter("scuser");
		request.setAttribute("orders", orders);
		request.setAttribute("sstatus", sstatus);
		request.setAttribute("sdgdate", sdgdate);
		request.setAttribute("edgdate", edgdate);
		request.setAttribute("smcname", smcname);
		request.setAttribute("scuser", scuser);
		request.getRequestDispatcher("/background/jsp/border.jsp")
				.forward(request, response);
	}

}
