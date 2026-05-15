# Java Backend - Proyecto de Pre-entrega (Comisión C26138)

Este repositorio contiene el desarrollo de la aplicación para la pre-entrega del curso Java Backend. El sistema permite la gestión de productos y pedidos a través de una arquitectura en capas.

## 🚀 Funcionalidades
- **Gestión de Productos (CRUD):** Creación, lectura, actualización y eliminación de productos.
- **Módulo de Pedidos:** Creación y listado de pedidos con lógica de negocio integrada.
- **Cálculos Automáticos:** El sistema calcula el monto total del pedido y actualiza automáticamente el stock disponible.

> **Nota:** La aplicación no cuenta con datos precargados. Es necesario crear los productos manualmente al iniciar por primera vez.

## 🏗️ Arquitectura del Proyecto

Se ha implementado una **arquitectura por capas** para separar las responsabilidades de forma clara:

### 1. Capa de Presentación
* **Paquete:** `com.lab`
* **Clase Main:** Punto de entrada que gestiona la interacción con el usuario, valída las entradas y captura excepciones.
* **Paquete `com.lab.menuprincipal`:** Contiene un `Enum` que define las operaciones disponibles, facilitando la navegación y el mantenimiento del menú.

### 2. Capa de Servicios (Lógica de Negocio)
* **Paquete:** `com.lab.servicios`
* **Interfaces:**
    * `ProductoServicio`: Define el contrato para las operaciones CRUD de productos.
    * `PedidoServicio`: Gestiona la creación de pedidos, listados y reglas de negocio (precios y stock).

### 3. Capa de Acceso a Datos (Repositorios)
* **Paquete:** `com.lab.repositorios`
* **Persistencia:** Se utilizan dos clases que implementan colecciones de tipo `Map` para almacenar y gestionar los datos en memoria.

### 4. Capa de Dominio
* **Paquete:** `com.lab.dominio`
* **Entidades:** Clases `Producto` y `Pedido`, que representan los objetos centrales del negocio.

### 5. Excepciones Personalizadas
* **Paquete:** `com.lab.excepciones`
* Incluye lógica específica para el manejo de errores de stock, asegurando que la aplicación responda correctamente ante inconsistencias en el inventario.

---