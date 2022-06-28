package com.bazarapi.service;

import com.bazarapi.model.Producto;
import java.util.List;

public interface ProductoServiceInterface {

    public void saveProducto(Producto p);
    public Producto getProducto(Integer id);
    public List<Producto> getAllProductos();
    public void editProducto(Integer id, Producto p);
    public void deleteProducto(Integer id);
    public List<Producto> getProducto(String nombre);
    public List<Producto> getMasBarato();
    public List<Producto> getMasCaro();
    public List<Producto> orderProductosBarato();
    public List<Producto> orderProductosCaro();
    
}
