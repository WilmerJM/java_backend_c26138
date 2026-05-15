package com.lab.servicios;

import com.lab.excepciones.StockInsuficienteException;
import com.lab.dominio.pedidos.Pedido;
import com.lab.dominio.productos.Producto;
import com.lab.repositorios.PedidoRegistro;

import java.util.Map;

public class PedidoServicioImpl implements PedidoServicio {

    @Override
    public Pedido crearPedido(Map<Producto, Integer> productos) {

        productos.forEach((producto, cantidad) -> {
            Integer stock = producto.getStock();
            if (stock <= 0 || cantidad > stock) {
                throw new StockInsuficienteException("Stock insuficiente para producto: " + producto.getNombre());
            }
        });

        int id = PedidoRegistro.getId() + 1;
        PedidoRegistro.setId(id);
        Pedido pedido = new Pedido(
                id, productos
        );
        PedidoRegistro.getPedidos().put(id, pedido);
        pedido.setMontoTotal(calcularTotal(pedido));

        productos.forEach((producto, cantidad) -> {
            Integer stock = producto.getStock();
            stock -= cantidad;
            if (stock < 0) stock = 0;
            producto.setStock(stock);
        });
        return pedido;
    }

    @Override
    public Map<Integer, Pedido> listarPedidos() {
        return PedidoRegistro.getPedidos();
    }

    @Override
    public double calcularTotal(Pedido pedido) {

        Map<Producto, Integer> productos = pedido.getProductos();

        return productos.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrecio() * entry.getValue())
                .sum();
    }
}
