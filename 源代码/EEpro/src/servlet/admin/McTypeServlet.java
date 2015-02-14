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
import dao.imp.UserDao;

public class McTypeServlet extends HttpServlet {

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
		request.getRequestDispatcher("/background/jsp/shopType.jsp").forward(
				request, response);
	}

}
