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

public class FrontLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Object count = this.getServletContext().getAttribute("count");
		String username = request.getParameter("suser");
		String password = request.getParameter("spass");
		String checkCode = request.getParameter("code");
		HttpSession session = request.getSession();
		String rand = session.getAttribute("rand").toString();
		// System.out.println(username + ":" + password);
		// String message = null;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");

		if (rand.equals(checkCode)) {
			UserDao dao = new UserDao();
			UserBean bean = dao.getUserBySid(username);
			session.setAttribute("fbean", bean);
			System.out.println(bean.getStatus() + "=" + bean.getLevel());
			if (bean != null) {
				if ("否".equals(bean.getStatus())) {
					if (bean.getUser().equals(username)
							&& bean.getPass().equals(password)) {
						request.getSession().setAttribute("fuser", username);
						// message = "登陆成功";
						// System.out.println(message);
						response.setContentType("text/html;charset=GBK");
						String user = request.getParameter("suser");
						Cookie cookieUser = new Cookie("fuser", user);
						cookieUser.setMaxAge(365 * 24 * 60 * 60);
						response.addCookie(cookieUser);
						String userInfoUrl = request.getContextPath()
								+ "/front/jsp/userCenter/userPage.jsp";
						response.sendRedirect(userInfoUrl);
						// System.out.println(count);
					} else {
						out.print("<script type=\"text/javascript\">");
						out.print("alert('密码错误！');");
						out.println("window.history.back();");
						out.print("</script>");
					}
				} else {
					out.print("<script type=\"text/javascript\">");
					out.print("alert('账号被冻结，请联系管理员！');");
					out.println("window.history.back();");
					out.print("</script>");
				}
			} else {
				out.print("<script type=\"text/javascript\">");
				out.print("alert('账号错误！');");
				out.println("window.history.back();");
				out.print("</script>");
			}
		} else {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('验证码错误！');");
			out.println("window.history.back();");
			out.print("</script>");
		}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
