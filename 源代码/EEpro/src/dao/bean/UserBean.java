package dao.bean;

public class UserBean {
	private String user;
	private String pass;
	private String name;
	private String sex;
	private String birth;
	private String email;
	private String tel;
	private String adress;
	private String postcode;
	private String regdate;
	private String status;
	private String level;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	

	public UserBean(String user, String pass, String name, String sex,
			String birth, String email, String tel, String address,
			String postcode, String regdate, String status) {
		super();
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.email = email;
		this.tel = tel;
		this.adress = address;
		this.postcode = postcode;
		this.regdate = regdate;
		this.status = status;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
