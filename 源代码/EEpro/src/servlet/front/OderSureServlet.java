package servlet.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OderSureServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String payType = request.getParameter("pay");
		String shipType = request.getParameter("shipping");
		request.setAttribute("pay", payType);
		request.setAttribute("shipping", shipType);
		request.getRequestDispatcher("/front/jsp/userCenter/orderPage.jsp")
				.forward(request, response);
	}

}
