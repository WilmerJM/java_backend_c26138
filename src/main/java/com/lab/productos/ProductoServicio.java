package com.lab.productos;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ProductoServicio {

    boolean existeProducto(String nombre);

    boolean crearProducto(String nombre, double precio, int stock);

    Map<String,Producto> listarProductos();

    boolean eliminarProducto(String nombre);

    Producto obtenerProducto(String nombre);

    Producto modificarProducto(Producto producto,double precio, int stock);
}