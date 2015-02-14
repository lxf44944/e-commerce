package servlet.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.McBean;
import dao.imp.McDao;

public class ItemDetailServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nid=request.getParameter("nid");
		McBean mcBean=new McDao().getMcBySid(nid);
		request.setAttribute("mcbean", mcBean);
		request.getRequestDispatcher("/front/jsp/itemDetailPage.jsp").forward(request, response);
	}

}
