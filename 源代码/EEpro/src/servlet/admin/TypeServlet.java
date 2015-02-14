package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.bean.McTypeBean;
import dao.imp.McTypeDao;
import dao.imp.ShoppingCar;

public class TypeServlet extends HttpServlet {

	 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=GBK;");
		McTypeDao typeDao=new McTypeDao();
		McTypeBean typeBean=new McTypeBean();
		String task=request.getParameter("btask");
		String maxid= request.getParameter("bmaxid");
		String minid= request.getParameter("bminid");
		String sid=null;
		if (maxid==null) {
			sid=minid;
		} else {
			sid=maxid;
		}
		String sname=request.getParameter("typeName");
//		System.out.println(task);
//		System.out.println(sid);
//		System.out.println(maxid);
//		System.out.println(minid);
//System.out.println(sname);
//request.setAttribute("typeName", sname);
//		} 
	boolean is = false;
		
		 if ("update".equals(task)) {
			is= typeDao.updateMcType(sname, sid);
		}else if ("remove".equals(task)) {
			is=typeDao.delMcType(maxid,minid);
		}else if ("add".equals(task)) {
			is=typeDao.addMcType(typeBean);
		}
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
		 if (is) {
				out.println("<script language=\"javascript\">");
				
				out.println("alert('操作成功！');");
				out.println("location.href='McTypeServlet';");

				out.println("</script>");
				

			} else {
				out.println("<script language=\"javascript\">");
				out.println("alert('操作失败！');");
				out.println("location.href='McTypeServlet';");
				out.println("</script>");
			}
		
	//	response.sendRedirect(request.getContextPath()+"/McTypeServlet");
		
	}
}
