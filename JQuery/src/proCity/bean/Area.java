package proCity.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * 区域
 * 
 * @author Smileyes
 *
 */

@Component()
@Scope("prototype")
public class Area {
	private int id;
	private String name;
	private City city;

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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
