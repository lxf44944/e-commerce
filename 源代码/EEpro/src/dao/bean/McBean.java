package dao.bean;

public class McBean {
	String nid;
	String sname;
	String sdescription;
	String nprice;
	String simg;
	String smctag;
	String dcdate;
	String nmaxid;
	String nminid;

	public McBean() {
		super();
	}

	public McBean(String nid, String sname, String sdescription, String nprice,
			String simg, String smctag, String dcdate, String nmaxid,
			String nminid) {
		super();
		this.nid = nid;
		this.sname = sname;
		this.sdescription = sdescription;
		this.nprice = nprice;
		this.simg = simg;
		this.smctag = smctag;
		this.dcdate = dcdate;
		this.nmaxid = nmaxid;
		this.nminid = nminid;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSdescription() {
		return sdescription;
	}

	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}

	public String getNprice() {
		return nprice;
	}

	public void setNprice(String nprice) {
		this.nprice = nprice;
	}

	public String getSimg() {
		return simg;
	}

	public void setSimg(String simg) {
		this.simg = simg;
	}

	public String getSmctag() {
		return smctag;
	}

	public void setSmctag(String smctag) {
		this.smctag = smctag;
	}

	public String getDcdate() {
		return dcdate;
	}

	public void setDcdate(String dcdate) {
		this.dcdate = dcdate;
	}

	public String getNmaxid() {
		return nmaxid;
	}

	public void setNmaxid(String nmaxid) {
		this.nmaxid = nmaxid;
	}

	public String getNminid() {
		return nminid;
	}

	public void setNminid(String nminid) {
		this.nminid = nminid;
	}

}
