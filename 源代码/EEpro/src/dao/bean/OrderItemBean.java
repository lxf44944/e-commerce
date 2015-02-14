package dao.bean;

public class OrderItemBean {
	String nid;
	String norderid;
	String nmcid;
	String smcname;
	String sdescription;
	String simg;
	String ncount;
	String nprice;
	String ntotalprice;

	public OrderItemBean() {
		// TODO Auto-generated constructor stub
	}

	public OrderItemBean(String nid, String norderid, String nmcid,
			String smcname, String sdescription, String simg, String ncount,
			String nprice, String ntotalprice) {
		super();
		this.nid = nid;
		this.norderid = norderid;
		this.nmcid = nmcid;
		this.smcname = smcname;
		this.sdescription = sdescription;
		this.simg = simg;
		this.ncount = ncount;
		this.nprice = nprice;
		this.ntotalprice = ntotalprice;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNorderid() {
		return norderid;
	}

	public void setNorderid(String norderid) {
		this.norderid = norderid;
	}

	public String getNmcid() {
		return nmcid;
	}

	public void setNmcid(String nmcid) {
		this.nmcid = nmcid;
	}

	public String getSmcname() {
		return smcname;
	}

	public void setSmcname(String smcname) {
		this.smcname = smcname;
	}

	public String getSdescription() {
		return sdescription;
	}

	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}

	public String getSimg() {
		return simg;
	}

	public void setSimg(String simg) {
		this.simg = simg;
	}

	public String getNcount() {
		return ncount;
	}

	public void setNcount(String ncount) {
		this.ncount = ncount;
	}

	public String getNprice() {
		return nprice;
	}

	public void setNprice(String nprice) {
		this.nprice = nprice;
	}

	public String getNtotalprice() {
		return ntotalprice;
	}

	public void setNtotalprice(String ntotalprice) {
		this.ntotalprice = ntotalprice;
	}

}
