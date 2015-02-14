package dao.inf;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.bean.UserBean;

//增删改查（传request进来查询）、getCount(String sql)  六个方法
public interface UserInf {
	public List<UserBean> selectUser(HttpServletRequest request);

	public boolean addUser(UserBean userBean);

	public boolean delUser(String sid);

	public boolean updateUser(UserBean userBean, String sid);

	public UserBean getUserBySid(String sid);

	public String getCount(String sql);

}
