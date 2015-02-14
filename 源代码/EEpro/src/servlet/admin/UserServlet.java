package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.McBean;
import dao.bean.McTypeBean;
import dao.bean.UserBean;
import dao.imp.McDao;
import dao.imp.McTypeDao;
import dao.imp.UserDao;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		UserDao userDao = new UserDao();
		List<UserBean> beans = userDao.selectUser(request);
//		System.out.println(beans);
		request.setAttribute("beans", beans);
		
		request.setAttribute("suser", request.getParameter("suser"));
		request.setAttribute("sex", request.getParameter("sex"));
		request.setAttribute("status", request.getParameter("status"));
		request.getRequestDispatcher("/background/jsp/userShow.jsp").forward(
				request, response);
	}

}
