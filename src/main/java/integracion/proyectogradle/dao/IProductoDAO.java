package integracion.proyectogradle.dao;


import integracion.proyectogradle.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {


}
