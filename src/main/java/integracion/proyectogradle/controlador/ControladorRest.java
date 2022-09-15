package integracion.proyectogradle.controlador;

import integracion.proyectogradle.entity.Categoria;
import integracion.proyectogradle.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ControladorRest {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categoria")
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }

    @GetMapping("/categoria/{id}")
    public Categoria findAll(@PathVariable Long id){
        return categoriaService.findById(id).orElse(null);
    }

    @DeleteMapping("/categoria/{id}")
    public void delete(@PathVariable Long id){
        categoriaService.delete(id);
    }

    @PostMapping("/categoria")
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }

    @PutMapping("/categoria/{id}")
    public Categoria update(@RequestBody Categoria categoria, @PathVariable Long id){
        Categoria actual = categoriaService.findById(id).orElse(null);
        actual.setDescripcion(categoria.getDescripcion());
        actual.setEstado(categoria.getEstado());
        return categoriaService.save(actual);
    }
}
