package ejercicio10; // Declara que la clase pertenece al paquete ejercicio10

import java.util.ArrayList; // Importa ArrayList para manejar listas que crecen dinámicamente
import java.util.Locale; // Importa Locale para leer números decimales con punto
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class PedidosRestaurante { // Declara la clase pública PedidosRestaurante
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Crea el lector de teclado configurado con Locale.US

        ArrayList<String> clientes = new ArrayList<>(); // Lista con los nombres de los clientes
        ArrayList<String> platos = new ArrayList<>(); // Lista con los platos solicitados
        ArrayList<Integer> cantidades = new ArrayList<>(); // Lista con las cantidades de cada pedido
        ArrayList<Double> precios = new ArrayList<>(); // Lista con los precios unitarios
        ArrayList<Double> totales = new ArrayList<>(); // Lista con el total a pagar de cada pedido

        String seguir; // Variable que guarda la respuesta para seguir registrando
        do { // Inicia el ciclo do-while para registrar pedidos
            System.out.print("\nNombre del cliente: "); // Pide el nombre del cliente
            clientes.add(sc.nextLine()); // Lee el nombre y lo agrega a la lista de clientes
            System.out.print("Plato solicitado: "); // Pide el plato solicitado
            platos.add(sc.nextLine()); // Lee el plato y lo agrega a la lista de platos
            System.out.print("Cantidad: "); // Pide la cantidad
            int cantidad = sc.nextInt(); // Lee la cantidad pedida
            System.out.print("Precio unitario: "); // Pide el precio unitario
            double precio = sc.nextDouble(); // Lee el precio unitario
            sc.nextLine(); // Limpia el salto de línea pendiente en el teclado

            double total = cantidad * precio; // Calcula el total multiplicando cantidad por precio
            if (total > 50) { // Verifica si el total supera los 50 USD
                total = total * 0.90; // Aplica el 10% de descuento (paga el 90%)
            }

            cantidades.add(cantidad); // Agrega la cantidad a su lista
            precios.add(precio); // Agrega el precio a su lista
            totales.add(total); // Agrega el total a pagar a su lista

            System.out.print("Desea registrar otro pedido? (s/n): "); // Pregunta si se desea registrar otro pedido
            seguir = sc.nextLine(); // Lee la respuesta del usuario
        } while (seguir.equalsIgnoreCase("s")); // Repite mientras la respuesta sea "s"

        double ingresoTotal = 0; // Inicializa en cero el ingreso total del restaurante
        int mayor = 0; // Inicializa en 0 la posición del pedido de mayor valor

        System.out.println("\n=========== PEDIDOS ==========="); // Imprime el título del listado de pedidos
        for (int i = 0; i < clientes.size(); i++) { // Recorre todos los pedidos registrados
            double bruto = cantidades.get(i) * precios.get(i); // Calcula el valor sin descuento del pedido
            System.out.println("Cliente: " + clientes.get(i)); // Imprime el nombre del cliente
            System.out.println("  Plato: " + platos.get(i) + " x" + cantidades.get(i)); // Imprime el plato y la cantidad
            System.out.printf("  Subtotal: $%.2f%n", bruto); // Imprime el subtotal sin descuento
            if (bruto > 50) { // Si el subtotal supera 50 USD
                System.out.printf("  Descuento 10%%: -$%.2f%n", bruto - totales.get(i)); // Muestra el valor descontado
            }
            System.out.printf("  Total a pagar: $%.2f%n", totales.get(i)); // Imprime el total a pagar del pedido

            ingresoTotal += totales.get(i); // Suma el total del pedido al ingreso del restaurante
            if (totales.get(i) > totales.get(mayor)) { // Compara si este pedido es mayor que el mayor encontrado
                mayor = i; // Si lo es, guarda su posición
            }
        }

        System.out.printf("%nIngreso total del restaurante: $%.2f%n", ingresoTotal); // Imprime el ingreso total del restaurante
        System.out.printf("Pedido de mayor valor: %s - %s ($%.2f)%n", // Imprime el pedido de mayor valor
                clientes.get(mayor), platos.get(mayor), totales.get(mayor)); // Con el cliente, el plato y el total

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }
}
