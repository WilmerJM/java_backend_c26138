package com.lab.pedidos;

import com.lab.productos.Producto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

public class Pedido {


    private final int id;
    private LocalDate fecha;
    private final Map<Producto, Integer> productos;
    private double montoTotal;

    public Pedido(int idPedido, Map<Producto, Integer> productos) {
        id = idPedido;
        this.productos = Collections.unmodifiableMap(productos);
        fecha = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", productos=[\n" + productos +
                "], montoTotal=" + montoTotal +
                '}';
    }
}
