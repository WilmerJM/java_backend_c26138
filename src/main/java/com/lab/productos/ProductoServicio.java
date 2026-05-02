package com.lab.productos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoServicio {
    private static final Map<String, Producto> productos = new HashMap<>();
    private static  Scanner sc;

    public static boolean crearProducto() {
        sc.nextLine();
        System.out.println("ingrese el nombre del producto: ");
        String nombre = sc.nextLine().trim().toLowerCase();
        if (productos.containsKey(nombre)) return false;

        System.out.println("ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        if (precio <= 0) throw new IllegalArgumentException("El precio no puede ser menor o igual a 0");

        System.out.println("ingrese el stock del producto: ");
        int stock = sc.nextInt();
        if (stock < 0) throw new IllegalArgumentException("El stock no puede ser menor que 0");

        Producto producto = new ProductoBasico(nombre, precio, stock);
        productos.put(nombre, producto);

        return true;
    }

    public static void listarProductos() {
        if (productos.isEmpty()) System.out.println("No existen productos");
        productos.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static boolean eliminarProducto() {
        sc.nextLine();
        System.out.println("Nombre del producto: ");
        String nombre = sc.nextLine();
        return productos.remove(nombre, productos.get(nombre));
    }

    public static void buscarProducto() {
        sc.nextLine();
        System.out.println("Nombre del producto: ");
        String nombre = sc.nextLine();
        if (productos.containsKey(nombre)) {
            productos.forEach((key, producto) -> System.out.println(key + ": " + producto));
        }else {
            System.out.println("No existe "+nombre+" en el registro");
        }
    }


    public static void setScanner(Scanner sc){
        ProductoServicio.sc = sc;
    }
}
