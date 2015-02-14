package servlet.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;


import dao.bean.McBean;
import dao.bean.McTypeBean;
import dao.imp.McDao;
import dao.imp.McTypeDao;

public class AddMcServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		//所有的页面提交的信息全部保存在map
				Map<String, String> data = null;
				int r = 0;
				try {
					data = parseRequest(request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = -1;

				}
		McBean mcBean=new McBean();
		McDao mcDao=new McDao();
		String simg;

		if (data.get("simg")==null||data.get("simg").equals("")) {
			simg="NoGood.gif";
		}else {
			simg=data.get("simg");
		}
		mcBean.setSname(data.get("sname"));
		mcBean.setSmctag(data.get("smctag"));
		mcBean.setSimg(simg);
		mcBean.setSdescription(data.get("sdescription"));
		mcBean.setNprice(data.get("nprice"));
		mcBean.setNminid(data.get("nminid"));
		mcBean.setNmaxid(data.get("nmaxid"));
		
		if(mcDao.addMc(mcBean)){		
	
			out.print("<script type=\"text/javascript\">");
			out.println("alert('添加成功！');");
			out.println("location.href='BackMcServlet';");
			out.println("</script>");
			
			
		}else{
			
			out.print("<script type=\"text/javascript\">");
			out.println("alert('添加失败！');");
			out.println("window.history.back();");
			out.println("</script>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		
		out.close();
	}
	
	public Map<String, String> parseRequest(HttpServletRequest request)
			throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		DiskFileUpload diskFileUpload = new DiskFileUpload();
		List<FileItem> list = diskFileUpload.parseRequest(request);
		for (FileItem fileItem : list) {
			// 如果是普通文本
			if (fileItem.isFormField()) {
				// 表单中的元素的name及value
				String fieldName = fileItem.getFieldName();
				String value = fileItem.getString();

				map.put(fieldName, value);

			} else {
				// 文件 获得原来的文件名
				String oldFileName = fileItem.getName();
				// 如果客户端没有提交文件 ""
				if (!"".equals(oldFileName)) {
					// 重新生成不重复的文件名
					String newFileName = CopyFileName
							.makeNewFileName(oldFileName);

					//如果要把文件写入当前的工程中 需要配置虚拟目录 server.xml,在配置连接池的地方
					//<Context path="/EE1301_FileUpload" docBase="D:\Workspaces\EE1301_FileUpload\WebRoot"> 
//					</Context>
					String realPath = this.getServletContext().getRealPath(
							"/mcimg/" + newFileName);

					fileItem.write(new File(realPath));

					String fieldName = fileItem.getFieldName();
					map.put(fieldName, newFileName);
				} else {
					String fieldName = fileItem.getFieldName();
					map.put(fieldName, "");

				}

			}

		}

		return map;
	}

}
