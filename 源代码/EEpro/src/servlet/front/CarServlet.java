package servlet.front;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.imp.ShoppingCar;

public class CarServlet extends HttpServlet {

	 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=GBK;");
		ShoppingCar shoppingCar=null;
		String task=request.getParameter("task");
		String nid= request.getParameter("nid");
		int count = 0;
//		System.out.println("task="+task);
//		System.out.println("nid="+nid);
//		String regex="/^\\+?[1-9][0-9]*$/";
//		Pattern pattern=Pattern.compile(regex);
//		Matcher matcher=pattern.matcher(request.getParameter("count"));
//		if (matcher.find()) {
			
		
		
		try {
			 count=Integer.parseInt(request.getParameter("count"));
		} catch (Exception e) {
			count=1;
		}
//System.out.println("count="+count);
request.setAttribute("count", count);
//		} 
		HttpSession session=request.getSession();
		Object object=session.getAttribute("car");
		
		if (object==null) {
			shoppingCar=new ShoppingCar();
			
		}else{
			
			shoppingCar=(ShoppingCar)object;
		}
		session.setAttribute("car", shoppingCar);
		
		if ("buy".equals(task)) {
			
			shoppingCar.buy(nid);
		} else if ("update".equals(task)) {
			shoppingCar.updateCar(nid,count);
		}else if ("remove".equals(task)) {
			shoppingCar.remove(nid);
		}else if ("clear".equals(task)) {
			shoppingCar.clearAll();
		}
		
		response.sendRedirect(request.getContextPath()+"/front/jsp/carPage.jsp");
		
	}
}
