package carservice.web.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="service_item")
public class ServiceItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="service_item_id")
    private long serviceItemId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id")
    private Car car;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
