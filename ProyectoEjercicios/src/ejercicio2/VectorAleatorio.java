package ejercicio2; // Declara que la clase pertenece al paquete ejercicio2

import java.util.Random; // Importa Random para generar valores enteros aleatorios
import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class VectorAleatorio { // Declara la clase pública VectorAleatorio
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in); // Crea el lector que recibe los datos ingresados por teclado
        Random aleatorio = new Random(); // Crea el generador de números aleatorios
        final int TAMANIO = 20; // Define que el vector original siempre tendrá 20 elementos
        int[] vectorOriginal = new int[TAMANIO]; // Crea el vector original de 20 posiciones
        int[] indicesImpares = new int[TAMANIO / 2]; // Crea el vector para los elementos ubicados en índices impares

        for (int i = 0; i < vectorOriginal.length; i++) { // Recorre todas las posiciones del vector original
            vectorOriginal[i] = aleatorio.nextInt(51); // Guarda un número aleatorio entre 0 y 50 en cada posición
        }

        System.out.println("Vector original:"); // Muestra el título del vector generado
        imprimirVector(vectorOriginal); // Imprime todos los valores del vector original

        System.out.print("\nNumero que desea buscar: "); // Solicita el número que se buscará en el vector
        int numeroBuscado = sc.nextInt(); // Lee y guarda el número ingresado
        boolean encontrado = false; // Inicializa la bandera que controla si se encontró el número

        for (int i = 0; i < vectorOriginal.length; i++) { // Recorre el vector original para buscar todas las coincidencias
            if (vectorOriginal[i] == numeroBuscado) { // Compara el elemento actual con el número buscado
                System.out.println("El numero se encuentra en el indice " + i + "."); // Informa el índice donde se encontró el número
                encontrado = true; // Registra que se encontró al menos una coincidencia
            }
        }

        if (!encontrado) { // Verifica si el recorrido terminó sin encontrar el número
            System.out.println("El numero no se encuentra en el vector."); // Informa que el valor buscado no existe
        }

        int posicion = 0; // Inicializa la siguiente posición disponible del segundo vector
        for (int i = 1; i < vectorOriginal.length; i += 2) { // Recorre los índices impares 1, 3, 5 y así sucesivamente
            indicesImpares[posicion] = vectorOriginal[i]; // Copia el elemento del índice impar al segundo vector
            posicion++; // Avanza a la siguiente posición del segundo vector
        }

        System.out.println("\nVector formado con los indices impares:"); // Muestra el título del segundo vector
        imprimirVector(indicesImpares); // Imprime el vector formado con los índices impares

        int mayoresA20 = 0; // Inicializa el contador de elementos mayores que 20
        for (int valor : indicesImpares) { // Recorre directamente cada valor del segundo vector
            if (valor > 20) { // Comprueba si el valor actual es mayor que 20
                mayoresA20++; // Aumenta el contador cuando el valor cumple la condición
            }
        }

        System.out.println("Cantidad de elementos mayores a 20: " + mayoresA20); // Muestra el resultado del conteo solicitado
        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }

    public static void imprimirVector(int[] vector) { // Declara un método para imprimir cualquier vector de enteros
        System.out.print("["); // Imprime el corchete inicial del vector
        for (int i = 0; i < vector.length; i++) { // Recorre todas las posiciones del vector recibido
            System.out.print(vector[i]); // Imprime el elemento de la posición actual
            if (i < vector.length - 1) { // Verifica si todavía quedan elementos por imprimir
                System.out.print(", "); // Separa el elemento actual del siguiente
            }
        }
        System.out.println("]"); // Imprime el corchete final y cambia de línea
    }
}
