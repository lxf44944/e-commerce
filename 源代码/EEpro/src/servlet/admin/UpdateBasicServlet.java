package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xml.AdminDao;

import dao.bean.McBean;
import dao.bean.UserBean;
import dao.imp.McDao;

public class UpdateBasicServlet extends HttpServlet {

	
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
	//System.out.println(user);	
		UserBean userBean = new UserBean(user, pass, name, sex, birth, email,
				tel, address, postcode,null,null);
		String task=request.getParameter("task");
		String filePath=this.getServletContext().getRealPath("/xml/Admin.xml");
		AdminDao adminDao=new AdminDao(filePath);
		if (task!=null) {
			if ("update".equals(task)) {
				if(adminDao.updateUser(userBean)){	
					out.print("<script type=\"text/javascript\">");
					out.print("alert('资料修改成功');");
					UserBean bean=adminDao.selectSingleUser(user);
			
					request.getSession().setAttribute("bean", bean);
					out.println("location.href='background/jsp/basics.jsp';");
					out.println("	</script>");
					}
			} else if ("pass".equals(task)) {
				if(adminDao.updatePass(user, oldPass, pass)){
					out.print("<script type=\"text/javascript\">");
			
					out.print("alert('密码修改成功');");
					out.println("location.href='background/jsp/basics.jsp';");
					out.println("	</script>");
					}else{
						out.print("<script type=\"text/javascript\">");
						out.print("alert('旧密码错误');");
						out.println("window.history.back();");
						out.println("	</script>");
					}
			}
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
