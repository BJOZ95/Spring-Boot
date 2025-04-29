package experimental.backend.service;

import java.util.List;

import experimental.backend.entity.Sucursal;

public interface sucursalService {

    public List<Sucursal> findall();
    public Sucursal save(Sucursal sucursal);
    public Sucursal findById(Long id);
    public Sucursal update(Sucursal sucursal, Long id);
    public void delete(Sucursal sucursal);

}
