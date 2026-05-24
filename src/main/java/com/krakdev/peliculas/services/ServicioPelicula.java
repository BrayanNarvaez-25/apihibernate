package com.krakdev.peliculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

    @Autowired
    private PeliculaRepository repo;

    public Pelicula crear(Pelicula p) {
        return repo.save(p);
    }
    public List<Pelicula> listar() {
        return repo.findAll();
    }
    public Pelicula buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
    public Pelicula actualizar(Long id, Pelicula p) {
        p.setId(id);
        return repo.save(p);
    }
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }
    public List<Pelicula> buscarPorGenero(String g) {
        return repo.findByGenero(g);
    }
    public List<Pelicula> buscarPorDisponible(boolean d) {
        return repo.findByDisponible(d);
    }
}