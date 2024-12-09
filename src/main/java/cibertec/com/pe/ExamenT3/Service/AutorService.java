package cibertec.com.pe.ExamenT3.Service;

import cibertec.com.pe.ExamenT3.Model.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> listarAutores();
    Autor obtenerAutorPorId(Integer id);
    Autor guardarAutor(Autor autor);
    Autor actualizarAutor(Integer id, Autor autor);
    void eliminarAutor(Integer id);
}
