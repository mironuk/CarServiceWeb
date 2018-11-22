package carservice.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carservice.web.data.model.ServiceItem;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {

}
