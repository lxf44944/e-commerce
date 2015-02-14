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
import dao.imp.McDao;
import dao.imp.McTypeDao;

public class AddTypeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<McTypeBean> typeBeans = new McTypeDao().selectMcType(request);
		request.setAttribute("typeBeans", typeBeans);
		
		request.getRequestDispatcher("/background/jsp/addType.jsp").forward(
				request, response);
		
	}
	
}
