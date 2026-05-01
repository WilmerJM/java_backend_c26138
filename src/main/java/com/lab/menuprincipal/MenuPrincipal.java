package com.lab.menuprincipal;

public enum MenuPrincipal {

    AGREGAR_PRODUCTO(1),
    LISTAR_PRODUCTOS(2),
    BUSCAR_ACTUALIZAR_PRODUCTO(3),
    ELIMINAR_PRODUCTO(4),
    CREAR_PEDIDO(5),
    LISTAR_PEDIDOS(6),
    SALIR(7),
    NO_NULL(8);

    private final int opcion;

    MenuPrincipal(int opcion) {
        this.opcion = opcion;
    }


    /**
     * Retorna la instancia de MenuPrincipal asociada al número.
     * @param opcionDelUsuario el número de la opción.
     * @return la instancia correspondiente.
     * @throws IllegalArgumentException si el número no coincide con ninguna opción.
     */
    public static MenuPrincipal getMenuPrincipal(int opcionDelUsuario) {
        for (MenuPrincipal menuPrincipal : MenuPrincipal.values()) {

            if (menuPrincipal.opcion == opcionDelUsuario) return menuPrincipal;
        }
        throw new IllegalArgumentException();
    }
}
