package dao.imp;

import java.util.ArrayList;
import java.util.List;

import dao.bean.CarBean;
import dao.bean.McBean;
import dao.inf.ShopCarInf;

public class ShoppingCar implements ShopCarInf {
	int totalType;
	int totalCount;
	float totalPrice;
	List<CarBean> carBeans = new ArrayList<CarBean>();

	@Override
	public boolean buy(String nid) {
		// System.out.println("nid="+nid);
		McBean mcBean = new McDao().getMcBySid(nid);
		if (mcBean == null) {
			mcBean = new McBean();
		}
		CarBean carBean = new CarBean(mcBean, 1);
		if (carBeans.contains(carBean)) {
			CarBean oldCarBean = carBeans.get(carBeans.indexOf(carBean));
			oldCarBean.setCount(oldCarBean.getCount() + 1);
			compute();
		} else {
			carBeans.add(carBean);
			compute();
		}
		return false;
	}

	@Override
	public boolean updateCar(String nid, int count) {

		CarBean oldCarBean = null;
		// System.out.println("id="+id);
		for (CarBean carBean : carBeans) {
			if (carBean.getMcBean().getNid().equals(nid)) {
				oldCarBean = carBean;
			}
		}
		oldCarBean.setCount(count);
		compute();
		return false;
	}

	@Override
	public boolean remove(String nid) {
		CarBean oldCarBean = null;
		// System.out.println("id="+id);
		for (CarBean carBean : carBeans) {
			if (carBean.getMcBean().getNid().equals(nid)) {
				oldCarBean = carBean;
			}
		}

		carBeans.remove(oldCarBean);
		compute();
		return false;
	}

	@Override
	public boolean clearAll() {
		carBeans.clear();
		totalCount = 0;// 总数与价格置零
		totalPrice = 0;// 计算总个数与价格
		totalType=0;
		compute();
		return false;
	}

	@Override
	public boolean compute() {
		float price;
		totalType=0;
		totalCount = 0;
		totalPrice = 0;
		for (CarBean carBean : carBeans) {
			totalCount += carBean.getCount();
			totalType =totalType+1;
			try {
				price = Float.parseFloat(carBean.getMcBean().getNprice());
			} catch (Exception e) {
				price = 0;
			}
			totalPrice += carBean.getCount() * price;
		}
		System.out.println(totalType);
		return false;
	}

	
	public int getTotalType() {
		return totalType;
	}

	public void setTotalType(int totalType) {
		this.totalType = totalType;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CarBean> getCarBeans() {
		return carBeans;
	}

	public void setCarBeans(List<CarBean> carBeans) {
		this.carBeans = carBeans;
	}

}
