package cibertec.com.pe.ExamenT3.Service;

import cibertec.com.pe.ExamenT3.Model.Autor;
import cibertec.com.pe.ExamenT3.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAutorService implements AutorService {
    private final AutorRepository autorRepository;
    public IAutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor obtenerAutorPorId(Integer id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor actualizarAutor(Integer id, Autor autor) {
        Autor existente = obtenerAutorPorId(id);
        existente.setNomautor(autor.getNomautor());
        existente.setApeautor(autor.getApeautor());
        existente.setFechcacautor(autor.getFechcacautor());
        return autorRepository.save(existente);
    }

    @Override
    public void eliminarAutor(Integer id) {
        autorRepository.deleteById(id);
    }
}
