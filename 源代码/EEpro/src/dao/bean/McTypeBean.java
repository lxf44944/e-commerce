package dao.bean;

public class McTypeBean {
	String nid;
	String sname;
	String npid;

	public McTypeBean() {
		super();
	}

	public McTypeBean(String nid, String sname, String npid) {
		super();
		this.nid = nid;
		this.sname = sname;
		this.npid = npid;
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

	public String getNpid() {
		return npid;
	}

	public void setNpid(String npid) {
		this.npid = npid;
	}

}
