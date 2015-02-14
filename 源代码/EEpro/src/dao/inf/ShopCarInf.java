package dao.inf;

public interface ShopCarInf {
	
	public boolean buy(String nid);

	public boolean updateCar(String nid,int count);

	public boolean remove(String nid);

	public boolean clearAll();

	public boolean compute();

}
