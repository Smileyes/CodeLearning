package proCity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import proCity.bean.Area;
import proCity.bean.City;
import proCity.bean.Province;
import proCity.dao.IAreaDao;
import proCity.dao.ICityDao;
import proCity.dao.IProDao;

/**
 * 用于处理省份/城市 /区域的请求
 * 采用struts的插件，生成JSON
 * @author Smileyes
 *
 */
@Component
@Scope("prototype")
public class ProCityAction extends ActionSupport {
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

	// 省份的集合
	private List<String> result = new ArrayList<String>();

	public List<String> getResult() {
		return result;
	}

	/*
	 * 获得省份
	 */
	public String province() throws Exception {
		List<Province> list = this.proDao.getAll();
		for (Province pro : list) {
			result.add(pro.getName());
		}
		return SUCCESS;
	}

	/*
	 * 获得城市
	 */
	public String city() {
		Province province = this.proDao.find(sourceName);
		List<City> list = this.cityDao.getCities(province.getId());
		for (City city : list) {
			result.add(city.getName());
		}
		return SUCCESS;
	}

	/*
	 * 获得地区
	 */
	public String area() {
		City city = this.cityDao.find(sourceName);
		List<Area> list = this.areaDao.getAreas(city.getId());
		for (Area area : list) {
			result.add(area.getName());
		}
		return SUCCESS;
	}
}
