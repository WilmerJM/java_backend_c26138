package com.lab;

import com.lab.menuprincipal.MenuPrincipal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcionDelUsuario;
        MenuPrincipal menu;

        do{
            try {
                System.out.println("Ingrese el opcion del usuario");
                opcionDelUsuario = sc.nextInt();
                menu = MenuPrincipal.getMenuPrincipal(opcionDelUsuario);

                switch (menu){
                    case AGREGAR_PRODUCTO: {
                        System.out.println("producto agregado");
                        break;
                    }
                    case LISTAR_PRODUCTOS: {
                        System.out.println("lista de productos");
                        break;
                    }
                    case BUSCAR_ACTUALIZAR_PRODUCTO: {
                        System.out.println("producto encontrado");
                        break;
                    }
                    case ELIMINAR_PRODUCTO: {
                        System.out.println("producto eliminado");
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
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Opción inválida. Por favor ingrese un numero valido");
                        menu = MenuPrincipal.NO_NULL;
                        sc.nextLine();
            }
        }while ( menu != MenuPrincipal.SALIR );

        sc.close();
        System.out.println("Programa finalizado");
    }
}
