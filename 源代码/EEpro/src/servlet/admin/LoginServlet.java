package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xml.AdminDao;

import dao.bean.UserBean;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Object count = this.getServletContext().getAttribute("count");
		String username = request.getParameter("suser");
		String password = request.getParameter("spass");
		String checkCode = request.getParameter("code");
		HttpSession session = request.getSession();
		String rand = session.getAttribute("rand").toString();
//		System.out.println(username + ":" + password);
		String message = null;
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
	
		if (rand.equals(checkCode)) {
			String filePath=this.getServletContext().getRealPath("/xml/Admin.xml");
			UserBean bean=new AdminDao(filePath).selectSingleUser(username);
			session.setAttribute("bean", bean);
			if (bean!=null) {
				if (bean.getUser().equals(username) && bean.getPass().equals(password)) {
					request.getSession().setAttribute("suser", username);
					message = "µÇÂ½³É¹¦";
					response.setContentType("text/html;charset=GBK");
					String user = request.getParameter("suser");
					Cookie cookieUser = new Cookie("suser", user);
					cookieUser.setMaxAge(365 * 24 * 60 * 60);
					response.addCookie(cookieUser);
					String userInfoUrl = request.getContextPath()
							+ "/background/jsp/mainFrame.jsp";
					response.sendRedirect(userInfoUrl);
//					System.out.println(count);
				}else{
					out.print("<script type=\"text/javascript\">");
					out.print("alert('ÃÜÂë´íÎó£¡');");
					out.println("window.history.back();");
					out.print("</script>");
				}
			}else{
				out.print("<script type=\"text/javascript\">");
				out.print("alert('ÕËºÅ´íÎó£¡');");
				out.println("window.history.back();");
				out.print("</script>");
			}
		} else {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('ÑéÖ¤Âë´íÎó£¡');");
			out.println("window.history.back();");
			out.print("</script>");
		}
		
		if (message == null) {
			
		} else {
			
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
