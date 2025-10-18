package com.example.productosr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productosr.model.Producto;
import com.example.productosr.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoRepository repo;
    public ProductoController(ProductoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Producto> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Producto get(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    @PostMapping
    public Producto create(@RequestBody Producto p) { return repo.save(p); }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto p) {
        Producto ex = repo.findById(id).orElseThrow();
        ex.setNombre(p.getNombre());
        ex.setPrecio(p.getPrecio());
        return repo.save(ex);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}