package ejercicio7; // Declara que la clase pertenece al paquete ejercicio7

import java.util.Locale; // Importa Locale para leer números decimales con punto
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class NotasEstudiantes { // Declara la clase pública NotasEstudiantes
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Crea el lector de teclado configurado con Locale.US
        final int MATERIAS = 8; // Define la constante MATERIAS con valor 8 (materias por estudiante)

        System.out.print("Numero de estudiantes: "); // Pide al usuario el número de estudiantes
        int n = sc.nextInt(); // Lee y guarda el número de estudiantes en n

        String[] codigos = new String[n]; // Crea un arreglo para guardar el código de cada estudiante
        double[][] notas = new double[n][MATERIAS]; // Crea la matriz de notas: una fila por estudiante y una columna por materia

        for (int i = 0; i < n; i++) { // Recorre cada estudiante
            System.out.print("\nCodigo del estudiante " + (i + 1) + ": "); // Pide el código del estudiante actual
            codigos[i] = sc.next(); // Lee el código y lo guarda en el arreglo codigos
            for (int j = 0; j < MATERIAS; j++) { // Recorre las 8 materias del estudiante
                double nota; // Declara la variable donde se leerá la nota
                do { // Inicia un ciclo do-while para validar la nota
                    System.out.print("  Nota de la materia " + (j + 1) + " (0-10): "); // Pide la nota de la materia actual
                    nota = sc.nextDouble(); // Lee la nota ingresada
                } while (nota < 0 || nota > 10); // Repite la lectura mientras la nota esté fuera del rango 0 a 10
                notas[i][j] = nota; // Guarda la nota válida en la matriz
            }
        }

        double[] promEstudiante = new double[n]; // Crea un arreglo para guardar el promedio de cada estudiante
        int mejor = 0; // Inicializa en 0 la posición del estudiante con mayor promedio

        System.out.println("\nPromedio por estudiante:"); // Muestra el título del reporte de promedios por estudiante
        for (int i = 0; i < n; i++) { // Recorre cada estudiante
            double suma = 0; // Inicializa en cero la suma de notas del estudiante
            for (int j = 0; j < MATERIAS; j++) { // Recorre las materias del estudiante
                suma += notas[i][j]; // Acumula la nota de cada materia
            }
            promEstudiante[i] = suma / MATERIAS; // Calcula el promedio dividiendo la suma para 8
            System.out.printf("  %s: %.2f%n", codigos[i], promEstudiante[i]); // Imprime el código y el promedio del estudiante
            if (promEstudiante[i] > promEstudiante[mejor]) { // Compara si el promedio actual es mayor al mayor encontrado
                mejor = i; // Si es mayor, guarda la posición de ese estudiante
            }
        }

        System.out.println("\nResumen por materia:"); // Muestra el título del resumen por materia
        for (int j = 0; j < MATERIAS; j++) { // Recorre cada materia
            double suma = 0; // Inicializa en cero la suma de notas de la materia
            int aprobados = 0; // Inicializa el contador de aprobados
            int reprobados = 0; // Inicializa el contador de reprobados
            for (int i = 0; i < n; i++) { // Recorre todos los estudiantes en la materia actual
                suma += notas[i][j]; // Acumula la nota del estudiante en la materia
                if (notas[i][j] >= 7) { // Verifica si la nota es mayor o igual a 7 (aprobado)
                    aprobados++; // Suma uno al contador de aprobados
                } else { // Caso contrario (nota menor a 7)
                    reprobados++; // Suma uno al contador de reprobados
                }
            }
            System.out.printf("  Materia %d -> promedio: %.2f | aprobados: %d | reprobados: %d%n", // Imprime el promedio, aprobados y reprobados de la materia
                    j + 1, suma / n, aprobados, reprobados); // Pasando el número de materia, el promedio (suma / n) y los contadores
        }

        System.out.printf("%nEstudiante con mayor promedio: %s (%.2f)%n", codigos[mejor], promEstudiante[mejor]); // Imprime el estudiante con mayor promedio y su valor

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }
}
