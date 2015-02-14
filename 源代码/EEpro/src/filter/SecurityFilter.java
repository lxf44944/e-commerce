package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.java.swing.plaf.windows.resources.windows;

public class SecurityFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		Object loginObject = session.getAttribute("suser");
//		System.out.println(loginObject);
		PrintWriter out=response.getWriter();
		if (loginObject == null) {
			out.println("<html>");
			out.println("<head>");
			out.println("<html>");
			out.println("<script language=\"javascript\">");
			out.println("alert('您还未登录，请先登录再进行操作！');");
			String url=servletRequest.getContextPath()+ "/background/adminLogin.jsp";
			String login="window.top.location.href='"+url+"'";
			out.println(login);
			
			out.println("</script>");
			
			out.println("</head>");
			out.println("</html>");
//			servletResponse.sendRedirect(servletRequest.getContextPath()
//					+ "/background/adminLogin.jsp");
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
