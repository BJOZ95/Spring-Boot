package experimental.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import experimental.backend.entity.person;

@Repository
public interface personDao extends JpaRepository <person, Long> {
   
}
