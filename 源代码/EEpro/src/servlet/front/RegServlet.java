package servlet.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bean.UserBean;
import dao.imp.UserDao;

public class RegServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		String user = req.getParameter("suser");
		String pass = req.getParameter("spass");
		String name = req.getParameter("sname");
		String sex = req.getParameter("sex");
		String birth = req.getParameter("sdate");
		String email = req.getParameter("semail");
		String tel = req.getParameter("snumber");
		String address = req.getParameter("sadress");
		String postcode = req.getParameter("spostcode");
		
	
		UserBean userBean = new UserBean(user, pass, name, sex, birth, email,
				tel, address, postcode,null,null);
		boolean is=new UserDao().addUser(userBean);

		resp.setContentType("text/html;charset=GBK");
		PrintWriter out = resp.getWriter();
	
		if (is) {
			out.println("<script language='javascript'>");
			out.println("alert('恭喜您，注册成功！');");
			req.getSession().setAttribute("fuser", user);
			out.println("location.href='RegSucServlet';");
			
			out.println("</script>");
//			req.getSession().setAttribute("fuser", user);
//			req.getRequestDispatcher("RegSucServlet").forward(
//					req, resp);
			
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('注册失败,用户名已存在！');");
			out.println("window.history.back();");
			out.println("</script>");
		}
		
//		out.println("</html>");
		out.flush();
		out.close();

	}

}
