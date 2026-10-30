package ejercicio4; // Declara que la clase pertenece al paquete ejercicio4

import java.util.Random; // Importa Random para generar elementos enteros aleatorios
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class OperacionesMatrices { // Declara la clase pública OperacionesMatrices
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in); // Crea el lector que recibe los datos ingresados por teclado
        Random aleatorio = new Random(); // Crea el generador de números aleatorios

        System.out.print("Numero de filas (M): "); // Solicita la cantidad de filas de las matrices
        int m = sc.nextInt(); // Lee y guarda la cantidad de filas
        System.out.print("Numero de columnas (N): "); // Solicita la cantidad de columnas de las matrices
        int n = sc.nextInt(); // Lee y guarda la cantidad de columnas

        while (m <= 0 || n <= 0) { // Repite la lectura si alguna dimensión no es positiva
            System.out.println("Las dimensiones deben ser mayores que cero."); // Informa que las dimensiones ingresadas no son válidas
            System.out.print("Numero de filas (M): "); // Solicita nuevamente la cantidad de filas
            m = sc.nextInt(); // Lee la nueva cantidad de filas
            System.out.print("Numero de columnas (N): "); // Solicita nuevamente la cantidad de columnas
            n = sc.nextInt(); // Lee la nueva cantidad de columnas
        }

        int[][] matrizA = generarMatriz(m, n, aleatorio); // Genera la primera matriz de M filas por N columnas
        int[][] matrizB = generarMatriz(m, n, aleatorio); // Genera la segunda matriz de M filas por N columnas

        System.out.println("\nMatriz A:"); // Muestra el título de la primera matriz
        imprimirMatriz(matrizA); // Imprime los valores aleatorios de la matriz A
        System.out.println("Matriz B:"); // Muestra el título de la segunda matriz
        imprimirMatriz(matrizB); // Imprime los valores aleatorios de la matriz B

        System.out.println("\n===== OPERACIONES ====="); // Muestra el título del menú de operaciones
        System.out.println("1. Sumar matrices"); // Muestra la opción para sumar las matrices
        System.out.println("2. Restar matrices"); // Muestra la opción para restar la matriz B de la matriz A
        System.out.println("3. Multiplicar matrices"); // Muestra la opción para multiplicar las matrices
        System.out.println("4. Trasponer matrices"); // Muestra la opción para trasponer las dos matrices
        System.out.print("Seleccione una opcion: "); // Solicita al usuario la operación que desea realizar
        int opcion = sc.nextInt(); // Lee y guarda la opción seleccionada

        switch (opcion) { // Evalúa la opción elegida por el usuario
            case 1: // Inicia el caso correspondiente a la suma
                System.out.println("\nResultado de A + B:"); // Muestra el título del resultado de la suma
                imprimirMatriz(sumarMatrices(matrizA, matrizB)); // Calcula e imprime la suma de ambas matrices
                break; // Termina el caso de la suma
            case 2: // Inicia el caso correspondiente a la resta
                System.out.println("\nResultado de A - B:"); // Muestra el título del resultado de la resta
                imprimirMatriz(restarMatrices(matrizA, matrizB)); // Calcula e imprime la resta de ambas matrices
                break; // Termina el caso de la resta
            case 3: // Inicia el caso correspondiente a la multiplicación
                if (m == n) { // Verifica que las matrices M x N puedan multiplicarse entre sí
                    System.out.println("\nResultado de A x B:"); // Muestra el título del resultado de la multiplicación
                    imprimirMatriz(multiplicarMatrices(matrizA, matrizB)); // Calcula e imprime el producto de las matrices
                } else { // Se ejecuta cuando el número de filas y columnas es diferente
                    System.out.println("No se pueden multiplicar dos matrices M x N cuando M es diferente de N."); // Explica por qué no se puede realizar la operación
                }
                break; // Termina el caso de la multiplicación
            case 4: // Inicia el caso correspondiente a la trasposición
                System.out.println("\nMatriz traspuesta de A:"); // Muestra el título de la traspuesta de A
                imprimirMatriz(trasponerMatriz(matrizA)); // Calcula e imprime la matriz traspuesta de A
                System.out.println("Matriz traspuesta de B:"); // Muestra el título de la traspuesta de B
                imprimirMatriz(trasponerMatriz(matrizB)); // Calcula e imprime la matriz traspuesta de B
                break; // Termina el caso de la trasposición
            default: // Se ejecuta si la opción no pertenece al menú
                System.out.println("Opcion no valida."); // Informa que la opción ingresada no existe
        }

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }

    public static int[][] generarMatriz(int filas, int columnas, Random aleatorio) { // Declara el método que crea y llena una matriz aleatoria
        int[][] matriz = new int[filas][columnas]; // Crea una matriz con las dimensiones recibidas
        for (int i = 0; i < filas; i++) { // Recorre todas las filas de la nueva matriz
            for (int j = 0; j < columnas; j++) { // Recorre todas las columnas de la fila actual
                matriz[i][j] = aleatorio.nextInt(10); // Guarda un valor aleatorio entre 0 y 9 en la celda actual
            }
        }
        return matriz; // Devuelve la matriz completamente llena
    }

    public static int[][] sumarMatrices(int[][] a, int[][] b) { // Declara el método que suma dos matrices del mismo tamaño
        int[][] resultado = new int[a.length][a[0].length]; // Crea la matriz que almacenará la suma
        for (int i = 0; i < a.length; i++) { // Recorre todas las filas de las matrices
            for (int j = 0; j < a[0].length; j++) { // Recorre todas las columnas de la fila actual
                resultado[i][j] = a[i][j] + b[i][j]; // Suma los elementos que ocupan la misma posición
            }
        }
        return resultado; // Devuelve la matriz que contiene la suma
    }

    public static int[][] restarMatrices(int[][] a, int[][] b) { // Declara el método que resta dos matrices del mismo tamaño
        int[][] resultado = new int[a.length][a[0].length]; // Crea la matriz que almacenará la resta
        for (int i = 0; i < a.length; i++) { // Recorre todas las filas de las matrices
            for (int j = 0; j < a[0].length; j++) { // Recorre todas las columnas de la fila actual
                resultado[i][j] = a[i][j] - b[i][j]; // Resta el elemento de B al elemento correspondiente de A
            }
        }
        return resultado; // Devuelve la matriz que contiene la resta
    }

    public static int[][] multiplicarMatrices(int[][] a, int[][] b) { // Declara el método que multiplica dos matrices cuadradas
        int tamanio = a.length; // Guarda el número de filas y columnas de las matrices cuadradas
        int[][] resultado = new int[tamanio][tamanio]; // Crea la matriz cuadrada que almacenará el producto
        for (int i = 0; i < tamanio; i++) { // Recorre cada fila de la primera matriz
            for (int j = 0; j < tamanio; j++) { // Recorre cada columna de la segunda matriz
                for (int k = 0; k < tamanio; k++) { // Recorre los elementos que se deben multiplicar y acumular
                    resultado[i][j] += a[i][k] * b[k][j]; // Acumula el producto correspondiente en la celda del resultado
                }
            }
        }
        return resultado; // Devuelve la matriz que contiene la multiplicación
    }

    public static int[][] trasponerMatriz(int[][] matriz) { // Declara el método que intercambia las filas y columnas
        int[][] traspuesta = new int[matriz[0].length][matriz.length]; // Crea la matriz traspuesta con dimensiones invertidas
        for (int i = 0; i < matriz.length; i++) { // Recorre cada fila de la matriz original
            for (int j = 0; j < matriz[0].length; j++) { // Recorre cada columna de la matriz original
                traspuesta[j][i] = matriz[i][j]; // Coloca cada elemento intercambiando su fila y su columna
            }
        }
        return traspuesta; // Devuelve la matriz traspuesta
    }

    public static void imprimirMatriz(int[][] matriz) { // Declara el método que imprime una matriz de enteros
        for (int i = 0; i < matriz.length; i++) { // Recorre todas las filas de la matriz recibida
            for (int j = 0; j < matriz[i].length; j++) { // Recorre todas las columnas de la fila actual
                System.out.printf("%6d", matriz[i][j]); // Imprime cada elemento usando un ancho fijo
            }
            System.out.println(); // Cambia de línea después de imprimir una fila completa
        }
    }
}
