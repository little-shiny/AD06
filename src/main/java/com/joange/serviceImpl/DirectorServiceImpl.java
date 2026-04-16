package com.joange.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joange.model.Director;
import com.joange.repository.DirectorRepo;
import com.joange.service.DirectorService;

/**
 * Implementación del servicio de Director.
 * Contiene la lógica de negocio y llama al repositorio.
 * 
 * La anotación @Service indica a Spring que esta clase es un servicio
 * y debe ser gestionada como un bean.
 */
@Service
public class DirectorServiceImpl implements DirectorService {
    
    /**
     * Inyección de dependencias: Spring inyecta automáticamente
     * una instancia del repositorio.
     */
    @Autowired
    DirectorRepo directorRepositorio;

    @Override
    public List<Director> findAllDirector() {
        return directorRepositorio.findAll();
    }

    @Override
    public Optional<Director> findDirectorById(Long id) {
        return directorRepositorio.findById(id);
    }

    @Override
    public Director saveDirector(Director nuevoDirector) {
        if (nuevoDirector != null) {
            return directorRepositorio.save(nuevoDirector);
        }
        return new Director();
    }

    @Override
    public String deleteDirector(Long id) {
        Optional<Director> d = directorRepositorio.findById(id);
        if (d.isPresent()) {
            directorRepositorio.deleteById(id);
            return "Director eliminado satisfactoriamente";
        }
        return "El director no existe";
    }

    @Override
    public String updateDirector(Director directorActualizar) {
        if (directorRepositorio.findById(directorActualizar.getIdDirector()).isPresent()) {
            directorRepositorio.save(directorActualizar);
            return "Director " + directorActualizar.getIdDirector() + " actualizado";
        }
        return "No se ha podido actualizar " + directorActualizar.getIdDirector();
    }

    @Override
    public List<Director> findOldDirector() {
        return directorRepositorio.findOldDirector();
    }
}
