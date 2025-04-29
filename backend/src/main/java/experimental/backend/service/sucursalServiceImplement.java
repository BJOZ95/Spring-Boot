package experimental.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import experimental.backend.dao.sucursalDao;
import experimental.backend.entity.Sucursal;
import jakarta.transaction.Transactional;

@Service
public class sucursalServiceImplement implements sucursalService {

    @Autowired
    private sucursalDao sucursalDao;


    @Override
    @Transactional
    public List<Sucursal> findall() {
        return (List<Sucursal>) sucursalDao.findAll();
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalDao.save(sucursal);
    }

    @Override
    public Sucursal findById(Long id) {
        return sucursalDao.findById(id).orElse(null);
    }

    @Override
    public Sucursal update(Sucursal sucursal, Long id) {
        sucursal.setId(id);
        return sucursalDao.save(sucursal);
    }

    @Override
    public void delete(Sucursal sucursal) {
        sucursalDao.delete(sucursal);
    }
}
