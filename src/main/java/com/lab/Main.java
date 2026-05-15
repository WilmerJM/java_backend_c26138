package com.lab;

import com.lab.excepciones.StockInsuficienteException;
import com.lab.menuprincipal.OpcionMenuPrincipal;
import com.lab.dominio.pedidos.Pedido;
import com.lab.servicios.PedidoServicioImpl;
import com.lab.dominio.productos.Producto;
import com.lab.servicios.ProductoServicioImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductoServicioImpl productoServicio = new ProductoServicioImpl();
    private static final PedidoServicioImpl pedidoServicio = new PedidoServicioImpl();

    public static void main(String[] args) {

        OpcionMenuPrincipal opcion;


        do {
            System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Crear Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Actualizar Producto");
            System.out.println("6. Crear Pedido");
            System.out.println("7. Listar Pedidos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int entradaDeUsuario = Integer.parseInt(scanner.nextLine());
                opcion = OpcionMenuPrincipal.getOpcionMenuPrincipal(entradaDeUsuario);

                switch (opcion) {
                    case AGREGAR_PRODUCTO -> menuCrear();
                    case LISTAR_PRODUCTOS -> menuListarProductos();
                    case BUSCAR_PRODUCTO -> menuBuscarProducto();
                    case ELIMINAR_PRODUCTO -> menuEliminarProducto();
                    case ACTUALIZAR_PRODUCTO -> menuActualizarProducto();
                    case CREAR_PEDIDO -> menuCrearPedido();
                    case LISTAR_PEDIDOS -> menuListarPedidos();
                    case SALIR -> {break;}
                    default -> System.out.println("Opción no válida.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: por favor ingrese un número válido.");
                opcion = OpcionMenuPrincipal.VER_OPCIONES;
            }
        } while (opcion != OpcionMenuPrincipal.SALIR);

    }

    private static void menuCrear() {

        String nombreProducto = validarNombreProducto();
        if (productoServicio.existeProducto(nombreProducto)) {
            System.out.println("El producto ya existe");
            return;
        }
        double precio = validarPrecio();
        int stock = validarStock();

        boolean resultado = productoServicio.crearProducto(nombreProducto, precio, stock);
        if (resultado) {
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("No fue posible agregar el producto.");
        }
    }

    private static void menuListarProductos() {
        try {
            Map<String, Producto> productos = productoServicio.listarProductos();
            productos.forEach((k, v) -> System.out.println(k + " - " + v));
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void menuBuscarProducto() {
        String nombreProducto = validarNombreProducto();

        try {
            Producto producto = productoServicio.obtenerProducto(nombreProducto);
            System.out.println(producto);
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void menuEliminarProducto() {
        String nombreProducto = validarNombreProducto();

        if (productoServicio.eliminarProducto(nombreProducto)) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No existe " + nombreProducto + " en el registro.");
        }
    }

    private static void menuActualizarProducto() {
        try {
            String nombreProducto = validarNombreProducto();
            Producto producto = productoServicio.obtenerProducto(nombreProducto);
            System.out.println("Indique precio nuevo: ");
            double precioNuevo = validarPrecio();
            System.out.println("Indique stock nuevo: ");
            int stockNuevo = validarStock();

            producto.setPrecio(precioNuevo);
            producto.setStock(stockNuevo);
            System.out.println("Producto actualizado correctamente.");
            System.out.println(producto);
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void menuCrearPedido() {
        try {

            Map<String, Producto> productos = productoServicio.listarProductos();
            productos.forEach((k, v) -> System.out.println(k + " - " + v));
            Map<Producto, Integer> cantidadProductos = new HashMap<>();
            int cantidad = 0;
            do {
                System.out.println("Agregue un producto al pedido o presione 1 para finalizar");
                String nombreProducto = validarNombreProducto();
                if (nombreProducto.equals("1")) break;
                Producto producto = productoServicio.obtenerProducto(nombreProducto);
                if (cantidadProductos.containsKey(producto)) {
                    System.out.println(producto.getNombre() + " ya fue agregado al pedido.");
                } else {
                    System.out.println("Indique la cantidad del producto: ");
                    cantidad = validarCantidadProducto();
                    cantidadProductos.put(producto, cantidad);
                }

            } while (cantidad != 0);
            if (cantidadProductos.isEmpty()) return;

            Pedido pedido = pedidoServicio.crearPedido(cantidadProductos);
            System.out.println("Pedido agregado correctamente.");
            System.out.println(pedido);

        } catch (NoSuchElementException | StockInsuficienteException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void menuListarPedidos() {
        Map<Integer, Pedido> pedidos = pedidoServicio.listarPedidos();
        pedidos.forEach((id, pedido) -> System.out.println("Pedido ID: " + id + " - Fecha: " +
                pedido.getFecha() + " - Total: $"
                + pedido.getMontoTotal() + " - Productos: \n" +
                pedido.getProductos()
        ));
    }

    private static String validarNombreProducto() {
        do {
            System.out.println("Nombre del producto: ");
            String nombreProducto = scanner.nextLine().trim().toLowerCase();
            if (!nombreProducto.isEmpty()) {
                return nombreProducto;
            }
        } while (true);
    }

    private static double validarPrecio() {
        do {
            System.out.println("Precio: ");
            try {
                double precio = Double.parseDouble(scanner.nextLine());
                if (precio > 0) return precio;
                System.out.println("Error: Precio debe ser mayor a 0.");
            } catch (NumberFormatException exception) {
                System.out.println("Error: Formato de número inválido.");
            }
        } while (true);
    }

    private static int validarStock() {
        do {
            try {
                System.out.println("Stock: ");
                int stock = Integer.parseInt(scanner.nextLine());
                if (stock >= 0) return stock;
                System.out.println("Error: Stock negativo.");
            } catch (NumberFormatException exception) {
                System.out.println("Error: Formato de número inválido.");
            }
        } while (true);
    }

    private static int validarCantidadProducto() {
        do {
            try {
                System.out.println("Cantidad: ");
                int cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad >= 0) return cantidad;

                System.out.println("Error: cantidad negativa.");
            } catch (NumberFormatException exception) {
                System.out.println("Error: Formato de número inválido.");
            }
        } while (true);
    }
}
