package dao.bean;

public class OrderBean {
	String nid;
	String scuser;
	String dgdate;
	String spayType;
	String ssendType;
	String nmcTypeSize;
	String nmcSize;
	String ntotalPrice;
	String sstatus;
	String smsg;
	String sauser;
	String dadate;
	String ssname;
	String ssaddress;
	String sscode;
	String ssphone;
	String ssemail;

	public OrderBean() {
		// TODO Auto-generated constructor stub
	}

	public OrderBean(String nid, String scuser, String dgdate, String spayType,
			String ssendType, String nmcTypeSize, String nmcSize,
			String ntotalPrice, String sstatus, String smsg, String sauser,
			String dadate, String ssname, String ssaddress, String sscode,
			String ssphone, String ssemail) {
		super();
		this.nid = nid;
		this.scuser = scuser;
		this.dgdate = dgdate;
		this.spayType = spayType;
		this.ssendType = ssendType;
		this.nmcTypeSize = nmcTypeSize;
		this.nmcSize = nmcSize;
		this.ntotalPrice = ntotalPrice;
		this.sstatus = sstatus;
		this.smsg = smsg;
		this.sauser = sauser;
		this.dadate = dadate;
		this.ssname = ssname;
		this.ssaddress = ssaddress;
		this.sscode = sscode;
		this.ssphone = ssphone;
		this.ssemail = ssemail;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getScuser() {
		return scuser;
	}

	public void setScuser(String scuser) {
		this.scuser = scuser;
	}

	public String getDgdate() {
		return dgdate;
	}

	public void setDgdate(String dgdate) {
		this.dgdate = dgdate;
	}

	public String getSpayType() {
		return spayType;
	}

	public void setSpayType(String spayType) {
		this.spayType = spayType;
	}

	public String getSsendType() {
		return ssendType;
	}

	public void setSsendType(String ssendType) {
		this.ssendType = ssendType;
	}

	public String getNmcTypeSize() {
		return nmcTypeSize;
	}

	public void setNmcTypeSize(String nmcTypeSize) {
		this.nmcTypeSize = nmcTypeSize;
	}

	public String getNmcSize() {
		return nmcSize;
	}

	public void setNmcSize(String nmcSize) {
		this.nmcSize = nmcSize;
	}

	public String getNtotalPrice() {
		return ntotalPrice;
	}

	public void setNtotalPrice(String ntotalPrice) {
		this.ntotalPrice = ntotalPrice;
	}

	public String getSstatus() {
		return sstatus;
	}

	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}

	public String getSmsg() {
		return smsg;
	}

	public void setSmsg(String smsg) {
		this.smsg = smsg;
	}

	public String getSauser() {
		return sauser;
	}

	public void setSauser(String sauser) {
		this.sauser = sauser;
	}

	public String getDadate() {
		return dadate;
	}

	public void setDadate(String dadate) {
		this.dadate = dadate;
	}

	public String getSsname() {
		return ssname;
	}

	public void setSsname(String ssname) {
		this.ssname = ssname;
	}

	public String getSsaddress() {
		return ssaddress;
	}

	public void setSsaddress(String ssaddress) {
		this.ssaddress = ssaddress;
	}

	public String getSscode() {
		return sscode;
	}

	public void setSscode(String sscode) {
		this.sscode = sscode;
	}

	public String getSsphone() {
		return ssphone;
	}

	public void setSsphone(String ssphone) {
		this.ssphone = ssphone;
	}

	public String getSsemail() {
		return ssemail;
	}

	public void setSsemail(String ssemail) {
		this.ssemail = ssemail;
	}

}
