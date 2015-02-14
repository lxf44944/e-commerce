package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.UserBean;
import dao.imp.UserDao;

public class StatusServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String suser=request.getParameter("cuser");
		String status=request.getParameter("cstatus");
		UserDao userDao = new UserDao();
		 userDao.changeStatus(suser, status);
		 

		request.getRequestDispatcher("UserServlet").forward(
				request, response);
	}

}
