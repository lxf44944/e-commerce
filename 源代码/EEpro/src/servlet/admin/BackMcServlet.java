package servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.McBean;
import dao.bean.McTypeBean;
import dao.imp.McDao;
import dao.imp.McTypeDao;

public class BackMcServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		McDao mcDao = new McDao();
		List<McBean> beans = mcDao.selectMc(request);
		request.setAttribute("beans", beans);
		List<McTypeBean> typeBeans = new McTypeDao().selectMcType(request);
		request.setAttribute("typeBeans", typeBeans);
		request.setAttribute("sname", request.getParameter("sname"));
		request.setAttribute("smaxid", request.getParameter("nmaxid"));
		request.setAttribute("sminid", request.getParameter("nminid"));
	//	System.out.println("back="+ request.getParameter("nminid"));
		request.getRequestDispatcher("/background/jsp/shopShow.jsp").forward(
				request, response);
	}

}
