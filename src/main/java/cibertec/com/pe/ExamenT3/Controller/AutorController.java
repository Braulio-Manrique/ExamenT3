package cibertec.com.pe.ExamenT3.Controller;

import cibertec.com.pe.ExamenT3.Model.Autor;
import cibertec.com.pe.ExamenT3.Service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }
    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarAutores();
    }

    @GetMapping("/{id}")
    public Autor obtenerAutorPorId(@PathVariable Integer id) {
        return autorService.obtenerAutorPorId(id);
    }

    @PostMapping
    public Autor guardarAutor(@RequestBody Autor autor) {
        return autorService.guardarAutor(autor);
    }

    @PutMapping("/{id}")
    public Autor actualizarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        return autorService.actualizarAutor(id, autor);
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Integer id) {
        autorService.eliminarAutor(id);
    }
}

