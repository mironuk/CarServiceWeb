package carservice.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carservice.web.data.model.ServiceItem;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {

}
