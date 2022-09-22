package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.ICategoriaDAO;
import integracion.proyectogradle.entity.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoriaServiceTest {

    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private ICategoriaDAO categoriaDAO;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoria = new Categoria();
        categoria.setId(1L);
        categoria.setEstado(true);
        categoria.setDescripcion("Categoria 1");
    }


    @Test
    void findAll() {

        when(categoriaDAO.findAll()).thenReturn(Arrays.asList(categoria));
        assertNotNull(categoriaService.findAll());
    }
}