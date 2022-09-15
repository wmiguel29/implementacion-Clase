package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IProductoDAO;
import integracion.proyectogradle.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoDAO productoDAO;
    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoDAO.deleteById(id);
    }



}
