package ejercicio6; // Declara que la clase pertenece al paquete ejercicio6

import java.util.Locale; // Importa Locale para leer números decimales con punto
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class VentasVendedores { // Declara la clase pública VentasVendedores
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Crea el lector de teclado configurado con Locale.US

        System.out.print("Numero de vendedores: "); // Pide al usuario el número de vendedores
        int n = sc.nextInt(); // Lee y guarda el número de vendedores en n
        System.out.print("Numero de anios: "); // Pide al usuario el número de años
        int m = sc.nextInt(); // Lee y guarda el número de años en m

        double[][] ventas = new double[n][m]; // Crea la matriz de ventas de n filas (vendedores) por m columnas (años)

        for (int i = 0; i < n; i++) { // Recorre cada vendedor (filas de la matriz)
            System.out.println("\nVendedor " + (i + 1)); // Muestra el número del vendedor que se está registrando
            for (int j = 0; j < m; j++) { // Recorre cada año (columnas de la matriz)
                System.out.print("  Ventas del anio " + (j + 1) + ": "); // Pide la venta del vendedor en el año actual
                ventas[i][j] = sc.nextDouble(); // Lee la venta y la guarda en la posición [i][j] de la matriz
            }
        }

        double[] totalVendedor = new double[n]; // Crea un arreglo para acumular el total de cada vendedor
        double[] totalAnio = new double[m]; // Crea un arreglo para acumular el total de cada año
        double totalEmpresa = 0; // Inicializa en cero el acumulador del total de la empresa

        for (int i = 0; i < n; i++) { // Recorre nuevamente cada vendedor
            for (int j = 0; j < m; j++) { // Recorre cada año del vendedor actual
                totalVendedor[i] += ventas[i][j]; // Suma la venta al total del vendedor i
                totalAnio[j] += ventas[i][j]; // Suma la venta al total del año j
                totalEmpresa += ventas[i][j]; // Suma la venta al total general de la empresa
            }
        }

        System.out.println("\nTotal por vendedor:"); // Muestra el título del reporte por vendedor
        for (int i = 0; i < n; i++) { // Recorre los totales de cada vendedor
            System.out.printf("  Vendedor %d: $%.2f%n", i + 1, totalVendedor[i]); // Imprime el total del vendedor con dos decimales
        }

        System.out.println("\nTotal por anio:"); // Muestra el título del reporte por año
        for (int j = 0; j < m; j++) { // Recorre los totales de cada año
            System.out.printf("  Anio %d: $%.2f%n", j + 1, totalAnio[j]); // Imprime el total del año con dos decimales
        }

        System.out.printf("%nTotal de la empresa: $%.2f%n", totalEmpresa); // Imprime el total de ventas de toda la empresa

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }
}
