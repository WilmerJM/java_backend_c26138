package com.lab.repositorios;

import com.lab.dominio.productos.Producto;

import java.util.HashMap;
import java.util.Map;

public class ProductoRegistro {
    private static Map<String, Producto> productos = new HashMap<>();

    public static Map<String, Producto> getProductos() {
        return productos;
    }
}
