package com.lab.pedidos;

import com.lab.productos.Producto;

import java.util.Map;

public interface PedidoServicio {

    Pedido crearPedido(Map<Producto, Integer> productos);

    Map<Integer, Pedido> listarPedidos();

    double calcularTotal(Pedido pedido);
}
