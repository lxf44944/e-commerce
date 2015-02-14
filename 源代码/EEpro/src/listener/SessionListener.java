package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session=event.getSession();
		Object count=session.getServletContext().getAttribute("count");
		if (count==null) {
			session.getServletContext().setAttribute("count",1);
		} else {
			int cou=Integer.valueOf(count.toString());
			cou++;
			session.getServletContext().setAttribute("count",cou);
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session=event.getSession();
//		Object count=session.getServletContext().getAttribute("count");
//		int cou=Integer.valueOf(count.toString());
//		cou--;
//		session.getServletContext().setAttribute("count", cou);

	}

}
