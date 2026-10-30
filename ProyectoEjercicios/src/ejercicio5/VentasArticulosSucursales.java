package ejercicio5; // Declara que la clase pertenece al paquete ejercicio5

import java.util.Locale; // Importa Locale para leer números decimales con punto
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class VentasArticulosSucursales { // Declara la clase pública VentasArticulosSucursales
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Crea el lector y configura el punto como separador decimal

        System.out.print("Numero de articulos (N): "); // Solicita la cantidad de artículos diferentes
        int n = sc.nextInt(); // Lee y guarda el número de artículos
        System.out.print("Numero de sucursales (M): "); // Solicita la cantidad de sucursales de la fábrica
        int m = sc.nextInt(); // Lee y guarda el número de sucursales

        while (n <= 0 || m <= 0) { // Repite la lectura si alguna cantidad no es positiva
            System.out.println("Las cantidades deben ser mayores que cero."); // Informa que los valores ingresados no son válidos
            System.out.print("Numero de articulos (N): "); // Solicita nuevamente la cantidad de artículos
            n = sc.nextInt(); // Lee la nueva cantidad de artículos
            System.out.print("Numero de sucursales (M): "); // Solicita nuevamente la cantidad de sucursales
            m = sc.nextInt(); // Lee la nueva cantidad de sucursales
        }

        double[][] precios = new double[n][m]; // Crea la tabla de precios por artículo y sucursal
        int[][] cantidadesVendidas = new int[n][m]; // Crea la tabla de cantidades vendidas por artículo y sucursal
        double[] totalPorArticulo = new double[n]; // Crea el arreglo para acumular el valor vendido de cada artículo
        double[] totalPorSucursal = new double[m]; // Crea el arreglo para acumular el valor vendido de cada sucursal

        System.out.println("\nREGISTRO DE PRECIOS"); // Muestra el título para llenar la primera tabla
        for (int i = 0; i < n; i++) { // Recorre cada artículo de la tabla de precios
            for (int j = 0; j < m; j++) { // Recorre cada sucursal donde se vende el artículo actual
                System.out.print("Precio del articulo " + (i + 1) + " en la sucursal " + (j + 1) + ": $"); // Solicita el precio de una combinación artículo-sucursal
                precios[i][j] = sc.nextDouble(); // Lee y guarda el precio en la celda correspondiente
            }
        }

        System.out.println("\nREGISTRO DE CANTIDADES VENDIDAS"); // Muestra el título para llenar la segunda tabla
        for (int i = 0; i < n; i++) { // Recorre cada artículo de la tabla de cantidades
            for (int j = 0; j < m; j++) { // Recorre cada sucursal donde se vendió el artículo actual
                System.out.print("Unidades del articulo " + (i + 1) + " vendidas en la sucursal " + (j + 1) + ": "); // Solicita la cantidad vendida de una combinación
                cantidadesVendidas[i][j] = sc.nextInt(); // Lee y guarda la cantidad vendida en la celda correspondiente
            }
        }

        for (int i = 0; i < n; i++) { // Recorre cada artículo para calcular sus ventas
            for (int j = 0; j < m; j++) { // Recorre cada sucursal para procesar la celda actual
                double venta = precios[i][j] * cantidadesVendidas[i][j]; // Calcula el valor vendido multiplicando precio por cantidad
                totalPorArticulo[i] += venta; // Acumula la venta en el total del artículo actual
                totalPorSucursal[j] += venta; // Acumula la venta en el total de la sucursal actual
            }
        }

        System.out.println("\nTOTAL DE VENTAS POR ARTICULO"); // Muestra el título del primer reporte de totales
        for (int i = 0; i < n; i++) { // Recorre el arreglo de totales por artículo
            System.out.printf("Articulo %d: $%.2f%n", i + 1, totalPorArticulo[i]); // Imprime el total monetario del artículo actual
        }

        System.out.println("\nTOTAL DE VENTAS POR SUCURSAL"); // Muestra el título del segundo reporte de totales
        for (int j = 0; j < m; j++) { // Recorre el arreglo de totales por sucursal
            System.out.printf("Sucursal %d: $%.2f%n", j + 1, totalPorSucursal[j]); // Imprime el total monetario de la sucursal actual
        }

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }
}
