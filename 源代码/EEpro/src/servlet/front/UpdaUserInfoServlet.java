package servlet.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xml.AdminDao;
import dao.bean.UserBean;
import dao.imp.UserDao;

public class UpdaUserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String user = request.getParameter("suser");
		String pass = request.getParameter("spass");
		String oldPass = request.getParameter("soldpass");
		String name = request.getParameter("sname");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("sdate");
		String email = request.getParameter("semail");
		String tel = request.getParameter("snumber");
		String address = request.getParameter("sadress");
		String postcode = request.getParameter("spostcode");
		// System.out.println(user);
		UserBean userBean = new UserBean(user, pass, name, sex, birth, email,
				tel, address, postcode, null, null);
		String task = request.getParameter("task");
		UserDao userDao = new UserDao();
		if (task != null) {
			if ("update".equals(task)) {
				if (userDao.updateUser(userBean, user)) {
					out.print("<script type=\"text/javascript\">");
					out.print("alert('资料修改成功');");
					UserBean fbean=userDao.getUserBySid(user);
					request.getSession().setAttribute("fbean", fbean);
					out.println("location.href='front/jsp/userCenter/userPage.jsp';");
					out.println("	</script>");
				}
			} else if ("pass".equals(task)) {
				if (userDao.updatePass(user, oldPass, pass)) {
					out.print("<script type=\"text/javascript\">");

					out.print("alert('密码修改成功');");
					out.println("location.href='front/jsp/userCenter/userPage.jsp';");
					out.println("	</script>");
				} else {
					out.print("<script type=\"text/javascript\">");
					out.print("alert('旧密码错误');");
					out.println("window.history.back();");
					out.println("	</script>");
				}
			}
		}
	}
}
