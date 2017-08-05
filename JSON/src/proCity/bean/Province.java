package proCity.bean;

import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * 省份
 * 
 * @author Smileyes
 *
 *
*/
@Component()
@Scope("prototype")
public class Province {
	private int id;
	private String name;
	private Set<City> citys;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCitys() {
		return citys;
	}

	public void setCitys(Set<City> citys) {
		this.citys = citys;
	}

}
