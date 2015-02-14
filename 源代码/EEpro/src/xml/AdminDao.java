package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import dao.bean.UserBean;

public class AdminDao {
	private String filePath;
	

	public AdminDao(String filePath) {
		this.filePath = filePath;
	}

	public boolean addUser(UserBean userBean) {
		Document document = readXml();
		Element root = document.getRootElement();
		Element admin = root.addElement("admin");
		admin.addAttribute("sid", userBean.getUser());
		
		Element pass = admin.addElement("pass");
		pass.setText(userBean.getPass());
		Element name = admin.addElement("name");
		name.setText(userBean.getName());
		Element sex = admin.addElement("sex");
		sex.setText(userBean.getSex());
		Element birthday = admin.addElement("birthday");
		birthday.setText(userBean.getBirth());
		Element email = admin.addElement("email");
		email.setText(userBean.getEmail());
		Element number = admin.addElement("number");
		number.setText(userBean.getTel());
		Element adress = admin.addElement("adress");
		adress.setText(userBean.getAdress());
		Element postcode = admin.addElement("postcode");
		postcode.setText(userBean.getPostcode());

	
			writeXml(document);
		
		
		return true;
	}
	
	public UserBean selectSingleUser(String suser){
		Document document=readXml();
		Element root=document.getRootElement();
		String xpath="/admins/admin[@sid='"+suser+"']";
		Node node=root.selectSingleNode(xpath);
		Element userElement=(Element)node;
		
		UserBean userBean=null;
		try {
			userBean=new UserBean();
			userBean.setUser(userElement.attributeValue("sid"));
			userBean.setPass(userElement.elementText("pass"));
			userBean.setName(userElement.elementText("name"));
			userBean.setSex(userElement.elementText("sex"));
			userBean.setBirth(userElement.elementText("birthday"));
			userBean.setEmail(userElement.elementText("email"));
			userBean.setTel(userElement.elementText("number"));
			userBean.setAdress(userElement.elementText("adress"));
			userBean.setPostcode(userElement.elementText("postcode"));
			userBean.setLevel(userElement.elementText("level"));
			return userBean;
		} catch (Exception e) {
			return null;
		}
		
	
	}
	
	
	public List<UserBean> selectUserList( String sname, String sex) {
		Document document = readXml();
		Element root = document.getRootElement();
		String xpath = "/admins/admin";
		if(sname!=null&&!"请输入用户名".equals(sname)){
			xpath=xpath+"[contains(@sid,'"+sname+"')]";
		}
		if(sex!=null&&!sex.equals("-1")){
			xpath=xpath+"/sex[text()='"+sex+"']/..";
			
		}
//System.out.println(xpath);
		
//System.out.println(nodes);		
		UserBean userBean=null;
		List<UserBean> lists = new ArrayList<UserBean>();
		
		List<Element> nodes= root.selectNodes(xpath);
		for (Element userElement : nodes) {
			userBean=new UserBean();
			userBean.setUser(userElement.attributeValue("sid"));
			userBean.setPass(userElement.elementText("pass"));
			userBean.setName(userElement.elementText("name"));
			userBean.setSex(userElement.elementText("sex"));
			userBean.setBirth(userElement.elementText("birthday"));
			userBean.setEmail(userElement.elementText("email"));
			userBean.setTel(userElement.elementText("number"));
			userBean.setAdress(userElement.elementText("adress"));
			userBean.setPostcode(userElement.elementText("postcode"));	
			userBean.setLevel(userElement.elementText("level"));
//			System.out.println(userBean);
			lists.add(userBean);
		}
			return lists;
		}

	public boolean updatePass(String suser,String oldPass,String newPass) {
		Document document = readXml();
		Element root = document.getRootElement();
		String xpath = "/admins/admin[@sid='"+suser+"']";
//		System.out.println(xpath);
		Node node = root.selectSingleNode(xpath);
		Element user = (Element) node;
//		Attribute attribute = user.attribute("sid");
//		attribute.setText("test55");
		Element pass = user.element("pass");
		if (pass.getText().equals(oldPass)) {
			pass.setText(newPass);
			writeXml(document);
			return true;
		} else {
			return false;
		}
		
	}
	public boolean updateUser(UserBean userBean) {
		Document document = readXml();
		Element root = document.getRootElement();
		String xpath = "/admins/admin[@sid='"+userBean.getUser()+"']";
	System.out.println(xpath);
		Node node = root.selectSingleNode(xpath);
		Element user = (Element) node;
//		Attribute attribute = user.attribute("sid");
//		attribute.setText("test55");
		Element name = user.element("name");
		name.setText(userBean.getName());
		Element sex = user.element("sex");
		sex.setText(userBean.getSex());
		Element birthday = user.element("birthday");
		birthday.setText(userBean.getBirth());
		Element email = user.element("email");
		email.setText(userBean.getEmail());
		Element number = user.element("number");
		number.setText(userBean.getTel());
		Element adress = user.element("adress");
		adress.setText(userBean.getAdress());
		Element postcode = user.element("postcode");
		postcode.setText(userBean.getPostcode());
	

		writeXml(document);
		return true;
	}

	public void deleteUser(String sname) {
		Document document = readXml();
		Element root = document.getRootElement();
		String xpath = "/admins/admin[@sid='"+sname+"']";
		Node node = root.selectSingleNode(xpath);
		Element user = (Element) node;
		root.remove(user);

		writeXml(document);
	}

	private void writeXml(Document document) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		format.setIndent("\t");

		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(filePath, false),
					format);
			writer.write(document);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private Document readXml() {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(new File(filePath));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return document;

	}

}
