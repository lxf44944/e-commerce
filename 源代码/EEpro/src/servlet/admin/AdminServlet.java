package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xml.AdminDao;
import dao.bean.UserBean;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user = request.getParameter("suser");
		String pass = request.getParameter("spass");
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
		String username=(String) request.getSession().getAttribute("suser");
		String level=adminDao.selectSingleUser(username).getLevel();
		if("0".equals(level)){
		if (task!=null) {
			if ("add".equals(task)) {
				adminDao.addUser(userBean);
				List<UserBean> bean=adminDao.selectUserList(null, null);
				//System.out.println(bean);
						HttpSession session = request.getSession();
						session.setAttribute("beans", bean);
			}else if("remove".equals(task)){
				adminDao.deleteUser(user);
				List<UserBean> bean=adminDao.selectUserList(null, null);
				//System.out.println(bean);
						HttpSession session = request.getSession();
						session.setAttribute("beans", bean);
			}else if ("update".equals(task)) {
				adminDao.updateUser(userBean);
				List<UserBean> bean=adminDao.selectUserList(null, null);
				//System.out.println(bean);
						HttpSession session = request.getSession();
						session.setAttribute("beans", bean);
			}
			

		}else{
			List<UserBean> bean=adminDao.selectUserList(name, sex);
			//System.out.println(bean);
					HttpSession session = request.getSession();
					session.setAttribute("beans", bean);
					session.setAttribute("sname", name);
					session.setAttribute("sex", sex);
		}
		}else{
			PrintWriter out=response.getWriter();
			out.print("<script type=\"text/javascript\">");
			out.print("alert('您不是超级管理员，无权访问信息！');");
			out.println("window.history.back();");
			out.print("</script>");
			out.flush();
			out.close();
		}
		

		response.setContentType("text/html;charset=GBK");
		
		String userInfoUrl = request.getContextPath()
				+ "/background/jsp/adminShow.jsp";
		response.sendRedirect(userInfoUrl);
	}

}
