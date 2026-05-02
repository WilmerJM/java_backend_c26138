package com.lab.productos;

import java.util.Objects;

public abstract class Producto {
    private final String id;
    private final String nombre;
    private Double precio;
    private Integer stock;

    public Producto(String id,String nombre, Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean tieneStock() { return this.stock > 0; }

    @Override
    public String toString() {
        return "{" +
                "id=" + id  +
                ", nombre=" + nombre +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
