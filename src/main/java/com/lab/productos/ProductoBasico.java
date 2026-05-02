package com.lab.productos;

import java.util.UUID;

public class ProductoBasico extends Producto{

    public ProductoBasico(String nombre, Double precio, Integer stock) {
        super(UUID.randomUUID().toString(), nombre, precio, stock);
    }
}
