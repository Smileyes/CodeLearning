package beanToJson;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import proCity.bean.Area;
import proCity.bean.City;
import proCity.bean.Province;
import proCity.dao.IAreaDao;
import proCity.dao.ICityDao;
import proCity.dao.IProDao;

/**
 * 用于处理省份/城市 /区域的请求
 * 采用第三方工具库，生成JSON
 * 
 * @author Smileyes
 *
 */
@Component
@Scope("prototype")
public class BeanToJsonAction extends ActionSupport {
	@Resource
	private IProDao proDao;
	@Resource
	private ICityDao cityDao;
	@Resource
	private IAreaDao areaDao;
	// 存储了上一级的元素名称
	private String sourceName;

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	/*
	 * 获得省份
	 */
	/**
	 * @return
	 * @throws Exception
	 * @Param
	 */
	public String province() throws Exception {
		List<Province> list = this.proDao.getAll();
		JsonConfig jsonConfig = new JsonConfig(); // 建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false); // 设置默认忽略
		jsonConfig.setExcludes(new String[] { "citys" });// 设置过滤项
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pt = response.getWriter();
		pt.write(jsonArray.toString());
		pt.flush();
		pt.close();
		return null;
	}

	/*
	 * 获得城市
	 */
	public String city() throws Exception {
		Province province = this.proDao.find(sourceName);
		List<City> list = this.cityDao.getCities(province.getId());
		JsonConfig jsonConfig = new JsonConfig(); // 建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false); // 设置默认忽略
		jsonConfig.setExcludes(new String[] { "province", "areas" });// 设置过滤项
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pt = response.getWriter();
		pt.write(jsonArray.toString());
		pt.flush();
		pt.close();
		return null;
	}

	/*
	 * 获得地区
	 */
	public String area() throws Exception {
		City city = this.cityDao.find(sourceName);
		List<Area> list = this.areaDao.getAreas(city.getId());
		JsonConfig jsonConfig = new JsonConfig(); // 建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false); // 设置默认忽略
		jsonConfig.setExcludes(new String[] { "city" });// 设置过滤项
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pt = response.getWriter();
		pt.write(jsonArray.toString());
		pt.flush();
		pt.close();
		return null;
	}
}
