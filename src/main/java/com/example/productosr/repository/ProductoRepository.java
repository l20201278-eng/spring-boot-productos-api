package com.example.productosr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productosr.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}