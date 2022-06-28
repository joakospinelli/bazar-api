package com.bazarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bazarapi.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    public List<Producto> findByNombre(String nombre);

    @Query (value = "select * from Producto where precio in(select min(precio) from Producto)",nativeQuery = true)
    public List<Producto> getBarato();

    @Query (value = "select * from Producto where precio in(select max(precio) from Producto)",nativeQuery = true)
    public List<Producto> getCaro();

    public List<Producto> findAllByOrderByPrecioAsc();

    public List<Producto> findAllByOrderByPrecioDesc();

}
