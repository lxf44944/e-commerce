package servlet.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.bean.UserBean;
import dao.imp.UserDao;

public class RegSucServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = session.getAttribute("fuser").toString();

		UserDao dao = new UserDao();
		UserBean bean = dao.getUserBySid(username);
System.out.println(bean.getAdress());
		session.setAttribute("fbean", bean);

		request.getSession().setAttribute("fuser", username);

		response.setContentType("text/html;charset=GBK");

		String userInfoUrl = request.getContextPath()
				+ "/front/jsp/userCenter/userPage.jsp";
		response.sendRedirect(userInfoUrl);

	}

}
