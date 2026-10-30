package ejercicio8; // Declara que la clase pertenece al paquete ejercicio8

import java.util.Locale; // Importa Locale para leer números decimales con punto
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class EficienciaOperarios { // Declara la clase pública EficienciaOperarios
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Crea el lector de teclado configurado con Locale.US

        System.out.print("Numero de operarios: "); // Pide al usuario el número de operarios
        int n = sc.nextInt(); // Lee y guarda el número de operarios en n

        String[] codigos = new String[n]; // Crea el arreglo para los códigos de los operarios
        double[] horasAusencia = new double[n]; // Crea el arreglo para las horas de ausencia
        int[] defectuosos = new int[n]; // Crea el arreglo para los pupitres defectuosos
        int[] producidos = new int[n]; // Crea el arreglo para los pupitres producidos
        int[] grados = new int[n]; // Crea el arreglo para el grado de eficiencia calculado

        for (int i = 0; i < n; i++) { // Recorre cada operario
            System.out.println("\nOperario " + (i + 1)); // Muestra el número del operario que se registra
            System.out.print("  Codigo: "); // Pide el código del operario
            codigos[i] = sc.next(); // Lee y guarda el código
            System.out.print("  Horas de ausencia: "); // Pide las horas de ausencia
            horasAusencia[i] = sc.nextDouble(); // Lee y guarda las horas de ausencia
            System.out.print("  Pupitres defectuosos: "); // Pide la cantidad de pupitres defectuosos
            defectuosos[i] = sc.nextInt(); // Lee y guarda los pupitres defectuosos
            System.out.print("  Pupitres producidos: "); // Pide la cantidad de pupitres producidos
            producidos[i] = sc.nextInt(); // Lee y guarda los pupitres producidos

            boolean c1 = horasAusencia[i] <= 3; // Condición 1: verdadero si la ausencia es menor o igual a 3 horas
            boolean c2 = defectuosos[i] < 300; // Condición 2: verdadero si los defectuosos son menos de 300
            boolean c3 = producidos[i] > 10000; // Condición 3: verdadero si los producidos son más de 10000

            if (c1 && c2 && c3) { // Si cumple las tres condiciones
                grados[i] = 20; // El grado es 20
            } else if (c2 && c3) { // Si cumple la segunda y la tercera
                grados[i] = 15; // El grado es 15
            } else if (c1 && c3) { // Si cumple la primera y la tercera
                grados[i] = 13; // El grado es 13
            } else if (c1 && c2) { // Si cumple la primera y la segunda
                grados[i] = 12; // El grado es 12
            } else if (c3) { // Si sólo cumple la tercera
                grados[i] = 9; // El grado es 9
            } else if (c2) { // Si sólo cumple la segunda
                grados[i] = 8; // El grado es 8
            } else if (c1) { // Si sólo cumple la primera
                grados[i] = 7; // El grado es 7
            } else { // Si no cumple ninguna condición
                grados[i] = 5; // El grado es 5
            }
        }

        System.out.println("\n-------------------------------------------------------------"); // Imprime una línea separadora antes de la tabla
        System.out.printf("%-10s %-10s %-13s %-12s %-6s%n", "Codigo", "Ausencia", "Defectuosos", "Producidos", "Grado"); // Imprime los encabezados de la tabla con ancho fijo por columna
        System.out.println("-------------------------------------------------------------"); // Imprime otra línea separadora
        for (int i = 0; i < n; i++) { // Recorre cada operario para mostrar su información
            System.out.printf("%-10s %-10.1f %-13d %-12d %-6d%n", // Imprime en una fila el código, ausencia, defectuosos, producidos
                    codigos[i], horasAusencia[i], defectuosos[i], producidos[i], grados[i]); // Y el grado de eficiencia del operario
        }

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }
}
