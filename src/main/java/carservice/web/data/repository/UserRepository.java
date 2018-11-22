package carservice.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carservice.web.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
