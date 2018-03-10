package went2rent.beans;

import javax.persistence.Column;
import javax.persistence.Id;

public class Car {

	@Id
	@Column(nullable=false)
	private int car_id;
	
	@Column(nullable=false)
	private String car_name;
	
	@Column(nullable=false)
	private String car_platenumber;
	
	@Column(nullable=true)
	private String car_color;

	@Column(nullable=true)
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Car() {
		
	}
	
	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_platenumber() {
		return car_platenumber;
	}

	public void setCar_platenumber(String car_platenumber) {
		this.car_platenumber = car_platenumber;
	}

	public String getCar_color() {
		return car_color;
	}

	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", car_name=" + car_name + ", car_platenumber=" + car_platenumber
				+ ", car_color=" + car_color + ", path=" + path + "]";
	}

}
