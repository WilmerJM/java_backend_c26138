package com.lab.repositorios;

import com.lab.dominio.pedidos.Pedido;

import java.util.HashMap;
import java.util.Map;

public class PedidoRegistro {
    private static Map<Integer, Pedido> pedidos = new HashMap<>();
    private static int id = 0;
    public  static Map<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        PedidoRegistro.id = id;
    }
}
