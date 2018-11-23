package carservice.web.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_item")
public class ServiceItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_item_id")
	private long serviceItemId;

	@Column(name="car_id")
	private long carId;

	@Column(name="service_date")
	private Date serviceDate;
	
	@Column(name="location")
	private String location;

	@Column(name="service_company")
	private String serviceCompany;

	@Column(name="description")
	private String description;

	public long getServiceItemId() {
		return serviceItemId;
	}

	public void setServiceItemId(long serviceItemId) {
		this.serviceItemId = serviceItemId;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getServiceCompany() {
		return serviceCompany;
	}

	public void setServiceCompany(String serviceCompany) {
		this.serviceCompany = serviceCompany;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
