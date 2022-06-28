package com.bazarapi.service;

import com.bazarapi.model.Producto;
import com.bazarapi.repository.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements ProductoServiceInterface {

    @Autowired
    private ProductoRepository productos;

    public void saveProducto(Producto p){
        this.productos.save(p);
    }

    public Producto getProducto(Integer id){
        return this.productos.findById(id).orElse(null);
    }

    public List<Producto> getAllProductos(){
        return this.productos.findAll();
    }

    public void editProducto(Integer id, Producto p){
        Producto act = this.getProducto(id);
        if (act != null){
            act.setNombre(p.getNombre()); act.setStockTotal(p.getStockTotal()); act.setPrecio(p.getPrecio());
            this.productos.save(act); 
        }
    }

    public void deleteProducto(Integer id){
        this.productos.deleteById(id);
    }

    @Override
    public List<Producto> getProducto(String nombre) {
        return this.productos.findByNombre(nombre);
    }

    @Override
    public List<Producto> getMasBarato() {
        return this.productos.getBarato();
    }

    @Override
    public List<Producto> getMasCaro() {
        return this.productos.getCaro();
    }

    @Override
    public List<Producto> orderProductosBarato() {
        return this.productos.findAllByOrderByPrecioAsc();
    }

    @Override
    public List<Producto> orderProductosCaro() {
        return this.productos.findAllByOrderByPrecioDesc();
    }

    
}
