package com.lab.menuprincipal;

public enum OpcionMenuPrincipal {

    AGREGAR_PRODUCTO(1),
    LISTAR_PRODUCTOS(2),
    BUSCAR_PRODUCTO(3),
    ELIMINAR_PRODUCTO(4),
    ACTUALIZAR_PRODUCTO(5),
    CREAR_PEDIDO(6),
    LISTAR_PEDIDOS(7),
    SALIR(8),
    VER_OPCIONES(9);

    private final int opcion;

    OpcionMenuPrincipal(int opcion) {
        this.opcion = opcion;
    }


    public static OpcionMenuPrincipal getOpcionMenuPrincipal(int opcionDelUsuario) {
        for (OpcionMenuPrincipal menuPrincipal : OpcionMenuPrincipal.values()) {

            if (menuPrincipal.opcion == opcionDelUsuario) return menuPrincipal;
        }
        throw new IllegalArgumentException("El número ingresado no coincide con alguna opción válida del menú.");
    }
}
