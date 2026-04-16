package com.joange.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joange.model.Pelicula;
import com.joange.repository.PeliculaRepo;
import com.joange.service.PeliculaService;

/**
 * Implementación del servicio de Pelicula.
 */
@Service
public class PeliculaServiceImpl implements PeliculaService {
    
    @Autowired
    PeliculaRepo peliculaRepositorio;

    @Override
    public List<Pelicula> findAllPelicula() {
        return peliculaRepositorio.findAll();
    }

    @Override
    public Optional<Pelicula> findPeliculaById(Long id) {
        return peliculaRepositorio.findById(id);
    }

    @Override
    public Pelicula savePelicula(Pelicula nuevaPelicula) {
        if (nuevaPelicula != null) {
            return peliculaRepositorio.save(nuevaPelicula);
        }
        return new Pelicula();
    }

    @Override
    public String deletePelicula(Long id) {
        Optional<Pelicula> p = peliculaRepositorio.findById(id);
        if (p.isPresent()) {
            peliculaRepositorio.deleteById(id);
            return "Película eliminada";
        }
        return "La película no existe";
    }

    @Override
    public List<Pelicula> findByDirectorId(Long idDirector) {
        return peliculaRepositorio.findByDirectorId(idDirector);
    }

    @Override
    public List<Pelicula> findPeliculasSinDirector() {
        return peliculaRepositorio.findPeliculasSinDirector();
    }
}
