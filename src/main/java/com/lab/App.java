package com.lab;

import com.lab.menuprincipal.MenuPrincipal;
import com.lab.productos.ProductoServicio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductoServicio.setScanner(sc);

        int opcionDelUsuario;
        MenuPrincipal menu;

        mostrarBanner();
        do{
            try {

                System.out.println("➤ Seleccione una opción o 7 para ver nuevamente las opciones");
                opcionDelUsuario = sc.nextInt();
                menu = MenuPrincipal.getMenuPrincipal(opcionDelUsuario);

                switch (menu){
                    case AGREGAR_PRODUCTO: {
                        if (ProductoServicio.crearProducto()){
                            System.out.println("Producto agregado exitosamente");
                        }else {
                            System.out.println("Producto ya existe");
                        }
                        break;
                    }
                    case LISTAR_PRODUCTOS: {
                        ProductoServicio.listarProductos();
                        break;
                    }
                    case BUSCAR_ACTUALIZAR_PRODUCTO: {

                        ProductoServicio.buscarProducto();
                        break;
                    }
                    case ELIMINAR_PRODUCTO: {

                        if (ProductoServicio.eliminarProducto()){
                            System.out.println("Producto eliminado exitosamente");
                        }else {
                            System.out.println("No existe el producto en el registro");
                        }
                        break;
                    }
                    case CREAR_PEDIDO: {
                        System.out.println("pedido creado");
                        break;
                    }
                    case LISTAR_PEDIDOS: {
                        System.out.println("Lista de pedidos");
                        break;
                    }
                    case SALIR: {
                        System.out.println("hasta luego");
                        break;
                    }
                    case VER_OPCIONES: {
                        mostrarBanner();
                        break;
                    }
                }
            } catch (InputMismatchException | IllegalArgumentException exception) {
                        if (exception instanceof InputMismatchException) {
                            System.out.println("Opción inválida. Por favor ingrese un numero valido");
                        }
                        if (exception instanceof IllegalArgumentException) {
                            System.out.println(exception.getMessage());
                        }
                        menu = MenuPrincipal.VER_OPCIONES;
                        sc.nextLine();
            }
        }while ( menu != MenuPrincipal.SALIR );

        sc.close();
        System.out.println("Programa finalizado");
    }

    public static void mostrarBanner(){
        System.out.println("******************************************");
        System.out.println("*      SISTEMA DE GESTIÓN DE STOCK       *");
        System.out.println("******************************************");
        for (MenuPrincipal menu : MenuPrincipal.values()){
            if (menu == MenuPrincipal.VER_OPCIONES) return;
            System.out.printf("[%d] %s%n",menu.ordinal()+1,menu.name().replace("_"," "));
        }
    }


}
