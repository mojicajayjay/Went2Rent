package went2rent.beans;

import javax.persistence.Column;
import javax.persistence.Id;


public class Reports {

	@Id
	@Column(nullable=false)
	private int report_id;
	
	@Id
	@Column(nullable=false)
	private int car_id;
	
	@Id
	@Column(nullable=false)
	private int user_id;
	
	@Column(nullable=false)
	private String report;

	public Reports () {
		
	}
	
	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "Reports [report_id=" + report_id + ", car_id=" + car_id + ", user_id=" + user_id + ", report=" + report
				+ "]";
	}

}
