package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.McTypeBean;
import dao.imp.McTypeDao;

public class TypeAddServlet extends HttpServlet {

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
		McTypeBean bean=new McTypeBean();
		McTypeDao typeDao=new McTypeDao();
		bean.setNpid(request.getParameter("nmaxid"));
		bean.setSname(request.getParameter("typeName"));
		
		if(typeDao.addMcType(bean)){		
	
			out.print("<script type=\"text/javascript\">");
			out.println("alert('添加成功！');");
			out.println("location.href='McTypeServlet';");
			out.println("</script>");
			
			
		}else{
			
			out.print("<script type=\"text/javascript\">");
			out.println("alert('添加失败,该类别已存在！');");
			out.println("location.href='AddTypeServlet';");
			out.println("</script>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		
		out.close();
		
	}

}
