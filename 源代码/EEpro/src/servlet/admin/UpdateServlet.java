package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xml.AdminDao;
import dao.bean.UserBean;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("suser");
		String filePath=this.getServletContext().getRealPath("/xml/Admin.xml");
//		AdminDao adminDao=new AdminDao(filePath);
			UserBean bean=new AdminDao(filePath).selectSingleUser(user);
			//System.out.println(bean.getUser());
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("/background/jsp/updotherAdm.jsp").forward(
					request, response);
			
		
		
	}

}
