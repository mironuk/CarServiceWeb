package carservice.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carservice.web.data.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
