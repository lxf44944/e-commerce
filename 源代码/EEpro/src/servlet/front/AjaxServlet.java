package servlet.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.UserDao;

public class AjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受数据
		String sname = request.getParameter("sname");
//		System.out.println("sname=" + sname);
		String mes = null;
		
		UserDao userDao=new UserDao();
		if (userDao.getUserBySid(sname)!=null) {
			mes = "用户名已经存在，不可以使用";
		} else {
			mes = "恭喜您，用户名可以使用";
		}

		
		//响应ajax请求
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		
		out.print(mes);

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("GBK");

		doGet(request, response);
	}

}
