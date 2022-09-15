package integracion.proyectogradle.dao;


import integracion.proyectogradle.entity.Categoria;
import integracion.proyectogradle.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
    public Usuario findByEmailAndPass(String email, String pass);
    public Usuario findByEmail(String email);


}
