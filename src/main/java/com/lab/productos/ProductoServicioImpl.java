package com.lab.productos;

import java.util.Map;
import java.util.NoSuchElementException;

public class ProductoServicioImpl implements ProductoServicio {

    @Override
    public boolean existeProducto(String nombre) {
        return ProductoRegistro.getProductos().containsKey(nombre);
    }

    @Override
    public boolean crearProducto(String nombre, double precio, int stock) {

        if (ProductoRegistro.getProductos().containsKey(nombre)) return false;
        Producto producto = new ProductoBasico(nombre, precio, stock);
        ProductoRegistro.getProductos().put(nombre, producto);

        return true;
    }

    @Override
    public Map<String, Producto> listarProductos() {
        if (ProductoRegistro.getProductos().isEmpty()) {
            throw new NoSuchElementException("No Hay productos registrados");
        }

        return ProductoRegistro.getProductos();
    }

    @Override
    public boolean eliminarProducto(String nombre) {

        return ProductoRegistro.getProductos().remove(nombre, ProductoRegistro.getProductos().get(nombre));
    }

    @Override
    public Producto obtenerProducto(String nombre) {
        if (ProductoRegistro.getProductos().containsKey(nombre))
            return ProductoRegistro.getProductos().get(nombre);

        throw new NoSuchElementException("Producto "+nombre+" no existe en el registro.");
    }

    @Override
    public Producto modificarProducto(Producto producto,double precio, int stock) {

        if (precio > 0) producto.setPrecio(precio);
        if (stock > -1) producto.setStock(stock);
        return producto;
    }


}
