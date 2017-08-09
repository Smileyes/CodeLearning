package proCity.bean;

import org.springframework.stereotype.Component;

/*
 * 存储了省份和城市的名称，用于JSON中
 * 
 * @author Smileyes
 *
 */
@Component
public class ProCity {
	private String province;
	private String city;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
