package com.bazarapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bazarapi.model.Producto;
import com.bazarapi.service.ProductoServiceInterface;

@RestController
public class ProductoController {
    
    @Autowired
    private ProductoServiceInterface service;

    @PostMapping ("/productos/crear")
    public void saveProducto(@RequestBody Producto p){
        this.service.saveProducto(p);
    }

    @GetMapping ("/productos/traer")
    public List<Producto> getAllProductos(){
        return this.service.getAllProductos();
    }

    @GetMapping ("/productos/traer/{id}")
    public Producto getProducto(@PathVariable Integer id){
        return this.service.getProducto(id);
    }

    @DeleteMapping ("/productos/eliminar/{id}")
    public void deleteProducto(@PathVariable Integer id){
        this.service.deleteProducto(id);
    }

    @PutMapping ("/productos/editar/{id}")
    public void editProducto(@PathVariable Integer id, @RequestBody Producto p){
        this.service.editProducto(id, p);
    }

    // Prueba para buscar por otras claves que no sean ID (no lo pedía el ejercicio)
    @GetMapping ("/productos/nombre/{nombre}")
    public List<Producto> getProducto(@PathVariable String nombre){
        return this.service.getProducto(nombre);
    }

    // Devuelvo una lista por si hay varios con el mismo precio
    @GetMapping("/productos/barato")
    public List<Producto> getMasBaratos(){
        return this.service.getMasBarato();
    }

    @GetMapping("/productos/caro")
    public List<Producto> getMasCaros(){
        return this.service.getMasBarato();
    }

    @GetMapping ("/productos/ordenar/barato")
    public List<Producto> orderPrecioAsc(){
        return this.service.orderProductosBarato();
    }

    @GetMapping ("/productos/ordenar/caro")
    public List<Producto> orderPrecioDesc(){
        return this.service.orderProductosCaro();
    }
    
}
