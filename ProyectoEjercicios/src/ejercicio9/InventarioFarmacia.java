package ejercicio9; // Declara que la clase pertenece al paquete ejercicio9

import java.util.ArrayList; // Importa ArrayList para manejar listas que crecen dinámicamente
import java.util.Locale; // Importa Locale para leer números decimales con punto
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class InventarioFarmacia { // Declara la clase pública InventarioFarmacia
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Crea el lector de teclado configurado con Locale.US

        ArrayList<String> nombres = new ArrayList<>(); // Lista que guarda los nombres de los medicamentos
        ArrayList<Integer> stocks = new ArrayList<>(); // Lista que guarda el stock actual de cada medicamento
        ArrayList<Integer> minimos = new ArrayList<>(); // Lista que guarda el stock mínimo de cada medicamento
        ArrayList<Double> precios = new ArrayList<>(); // Lista que guarda el precio unitario de cada medicamento

        int opcion; // Declara la variable de la opción del menú
        do { // Inicia el ciclo do-while que repite el menú
            System.out.println("\n===== FARMACIA ====="); // Imprime el título del menú
            System.out.println("1. Registrar medicamento"); // Imprime la opción 1: registrar medicamento
            System.out.println("2. Medicamentos bajo el stock minimo"); // Imprime la opción 2: medicamentos bajo el mínimo
            System.out.println("3. Valor total del inventario"); // Imprime la opción 3: valor total del inventario
            System.out.println("4. Registrar venta"); // Imprime la opción 4: registrar una venta
            System.out.println("5. Reporte general"); // Imprime la opción 5: reporte general
            System.out.println("0. Salir"); // Imprime la opción 0: salir
            System.out.print("Opcion: "); // Pide al usuario que elija una opción
            opcion = sc.nextInt(); // Lee la opción elegida
            sc.nextLine(); // Limpia el salto de línea que queda después de nextInt

            switch (opcion) { // Evalúa la opción con una estructura switch
                case 1: // Caso 1: registro de un medicamento
                    System.out.print("Nombre: "); // Pide el nombre del medicamento
                    nombres.add(sc.nextLine()); // Lee el nombre completo y lo agrega a la lista
                    System.out.print("Stock actual: "); // Pide el stock actual
                    stocks.add(sc.nextInt()); // Lee el stock y lo agrega a la lista
                    System.out.print("Stock minimo: "); // Pide el stock mínimo
                    minimos.add(sc.nextInt()); // Lee el stock mínimo y lo agrega a la lista
                    System.out.print("Precio unitario: "); // Pide el precio unitario
                    precios.add(sc.nextDouble()); // Lee el precio y lo agrega a la lista
                    System.out.println("Medicamento registrado."); // Confirma que el medicamento fue registrado
                    break; // Termina el caso 1

                case 2: // Caso 2: medicamentos con stock bajo el mínimo
                    boolean hayBajos = false; // Bandera que indica si se encontró algún medicamento con stock bajo
                    for (int i = 0; i < nombres.size(); i++) { // Recorre todos los medicamentos registrados
                        if (stocks.get(i) < minimos.get(i)) { // Verifica si el stock actual es menor que el mínimo
                            System.out.println("- " + nombres.get(i) + " (stock: " + stocks.get(i) // Imprime el nombre y el stock del medicamento
                                    + ", minimo: " + minimos.get(i) + ")"); // Junto con su stock mínimo
                            hayBajos = true; // Marca que sí hay medicamentos con stock bajo
                        }
                    }
                    if (!hayBajos) { // Si no se encontró ninguno
                        System.out.println("Ningun medicamento esta bajo el minimo."); // Muestra un mensaje indicándolo
                    }
                    break; // Termina el caso 2

                case 3: // Caso 3: valor económico total del inventario
                    double valorTotal = 0; // Inicializa en cero el acumulador del valor total
                    for (int i = 0; i < nombres.size(); i++) { // Recorre todos los medicamentos
                        valorTotal += stocks.get(i) * precios.get(i); // Suma stock por precio de cada medicamento
                    }
                    System.out.printf("Valor total del inventario: $%.2f%n", valorTotal); // Imprime el valor total con dos decimales
                    break; // Termina el caso 3

                case 4: // Caso 4: registrar una venta y actualizar el stock
                    System.out.print("Nombre del medicamento vendido: "); // Pide el nombre del medicamento vendido
                    String buscado = sc.nextLine(); // Lee el nombre buscado
                    int pos = -1; // Inicializa la posición en -1 (no encontrado)
                    for (int i = 0; i < nombres.size(); i++) { // Recorre la lista de nombres
                        if (nombres.get(i).equalsIgnoreCase(buscado)) { // Compara el nombre sin importar mayúsculas o minúsculas
                            pos = i; // Si coincide, guarda la posición encontrada
                        }
                    }
                    if (pos == -1) { // Si la posición sigue en -1
                        System.out.println("No existe ese medicamento."); // Indica que el medicamento no existe
                    } else { // Caso contrario, el medicamento sí existe
                        System.out.print("Cantidad vendida: "); // Pide la cantidad vendida
                        int vendida = sc.nextInt(); // Lee la cantidad vendida
                        if (vendida > stocks.get(pos)) { // Verifica si se quiere vender más de lo que hay en stock
                            System.out.println("No hay stock suficiente."); // Indica que no hay stock suficiente
                        } else { // Caso contrario, la venta es posible
                            stocks.set(pos, stocks.get(pos) - vendida); // Resta la cantidad vendida al stock y lo actualiza en la lista
                            System.out.println("Stock actualizado: " + stocks.get(pos)); // Muestra el nuevo stock del medicamento
                        }
                    }
                    break; // Termina el caso 4

                case 5: // Caso 5: reporte general del inventario
                    System.out.printf("%-20s %-8s %-8s %-10s %-10s%n", "Nombre", "Stock", "Minimo", "Precio", "Subtotal"); // Imprime los encabezados de la tabla del reporte
                    for (int i = 0; i < nombres.size(); i++) { // Recorre todos los medicamentos
                        System.out.printf("%-20s %-8d %-8d $%-9.2f $%-9.2f%n", nombres.get(i), stocks.get(i), // Imprime nombre, stock, mínimo, precio
                                minimos.get(i), precios.get(i), stocks.get(i) * precios.get(i)); // Y el subtotal (stock por precio) de cada medicamento
                    }
                    break; // Termina el caso 5

                case 0: // Caso 0: salir del programa
                    System.out.println("Fin del programa."); // Muestra el mensaje de fin del programa
                    break; // Termina el caso 0

                default: // Caso por defecto: cualquier otra opción
                    System.out.println("Opcion no valida."); // Indica que la opción no es válida
            }
        } while (opcion != 0); // El menú se repite mientras la opción sea distinta de 0

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }
}
