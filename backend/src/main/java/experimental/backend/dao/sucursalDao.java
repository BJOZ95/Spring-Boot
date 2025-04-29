package experimental.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import experimental.backend.entity.Sucursal;

@Repository
public interface sucursalDao extends JpaRepository <Sucursal, Long> {

}
   