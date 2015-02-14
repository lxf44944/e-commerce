package dao.bean;


public class CarBean {
	
	McBean mcBean;
	int count;

	public CarBean() {
		// TODO Auto-generated constructor stub
	}

	public CarBean(McBean mcBean, int count) {
		super();
		this.mcBean = mcBean;
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj instanceof CarBean) {
			CarBean objMc = (CarBean) obj;
			McBean bean=objMc.getMcBean();
//			System.out.println("this.getMcBean().getNid()="+this.getMcBean().getNid());
//			System.out.println("tbean.getNid()="+bean.getNid());
			if (this.getMcBean().getNid().equals(bean.getNid())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	

	public McBean getMcBean() {
		return mcBean;
	}

	public void setMcBean(McBean mcBean) {
		this.mcBean = mcBean;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


}
