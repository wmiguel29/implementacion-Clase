package integracion.proyectogradle.controlador;

import integracion.proyectogradle.entity.Categoria;
import integracion.proyectogradle.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> findById(@PathVariable Long id){

        Categoria categoria =categoriaService.findById(id).orElse(null);
        Map<String,String> response = new HashMap<>();

        if(categoria == null){
            response.put("mensaje","La categoria con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
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
    public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable Long id){
        Categoria actual = categoriaService.findById(id).orElse(null);
        Map<String,String> response = new HashMap<>();

        if(actual == null){
            response.put("mensaje","La categoria con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            actual.setDescripcion(categoria.getDescripcion());
            actual.setEstado(categoria.getEstado());
            categoriaService.save(actual);

        }
        catch (Exception e){
            response.put("mensaje","Error al actualizar la categoria");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Categoria>(actual, HttpStatus.OK);
        //return categoriaService.save(actual);
    }
}
