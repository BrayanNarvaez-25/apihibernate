package com.krakdev.peliculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private ServicioPelicula servicio;

    @PostMapping
    public ResponseEntity<Pelicula> crear(
        @RequestBody Pelicula p) {
        return ResponseEntity.ok(servicio.crear(p));
    }

    @GetMapping
    public ResponseEntity<List<Pelicula>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> porId(
        @PathVariable Long id) {
        return ResponseEntity.ok(servicio.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(
        @PathVariable Long id,
        @RequestBody Pelicula p) {
        return ResponseEntity.ok(servicio.actualizar(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(
        @PathVariable Long id) {
        return ResponseEntity.ok(servicio.eliminar(id));
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Pelicula>> porGenero(
        @RequestParam String genero) {
        return ResponseEntity.ok(servicio.buscarPorGenero(genero));
    }

    @GetMapping("/disponible")
    public ResponseEntity<List<Pelicula>> porDisponible(
        @RequestParam boolean disponible) {
        return ResponseEntity.ok(servicio.buscarPorDisponible(disponible));
    }
}
