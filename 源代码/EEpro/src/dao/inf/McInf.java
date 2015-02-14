package dao.inf;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.bean.McBean;
import dao.bean.UserBean;

//增删改查（传request进来查询）、getCount(String sql)  六个方法
public interface McInf {
	public List<McBean> selectMc(HttpServletRequest request);

	public boolean addMc(McBean mcBean);

	public boolean delMc(String sid);

	public boolean updateMc(McBean mcBean, String sid);

	public McBean getMcBySid(String sid);

	public String getCount(String sql);

}
