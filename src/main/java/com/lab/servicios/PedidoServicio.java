package com.lab.servicios;

import com.lab.dominio.pedidos.Pedido;
import com.lab.dominio.productos.Producto;

import java.util.Map;

public interface PedidoServicio {

    Pedido crearPedido(Map<Producto, Integer> productos);

    Map<Integer, Pedido> listarPedidos();

    double calcularTotal(Pedido pedido);
}
