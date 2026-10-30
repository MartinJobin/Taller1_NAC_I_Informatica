package ejercicio1; // Declara que la clase pertenece al paquete ejercicio1

import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class EstudiantesReprobados { // Declara la clase pública EstudiantesReprobados
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in); // Crea el lector que recibe los datos ingresados por teclado

        System.out.print("Cantidad de estudiantes reprobados por materia: "); // Solicita la dimensión de los dos arreglos
        int n = sc.nextInt(); // Lee y guarda la dimensión ingresada por el usuario

        while (n <= 0) { // Repite la lectura si la dimensión no es un número positivo
            System.out.print("Ingrese una cantidad mayor que cero: "); // Informa que se necesita una dimensión válida
            n = sc.nextInt(); // Lee nuevamente la dimensión de los arreglos
        }

        String[] matematica = new String[n]; // Crea el arreglo de cédulas de quienes reprobaron Matemática
        String[] ingles = new String[n]; // Crea el arreglo de cédulas de quienes reprobaron Inglés
        String[] ambasMaterias = new String[n]; // Crea el arreglo que almacenará las cédulas comunes
        int cantidadAmbas = 0; // Inicializa el número de estudiantes que reprobaron las dos materias

        System.out.println("\nCEDULAS DE REPROBADOS EN MATEMATICA"); // Muestra el título para ingresar el primer arreglo
        for (int i = 0; i < n; i++) { // Recorre todas las posiciones del arreglo de Matemática
            System.out.print("Cedula del estudiante " + (i + 1) + ": "); // Solicita la cédula correspondiente a la posición actual
            matematica[i] = sc.next(); // Lee la cédula como texto para conservar posibles ceros iniciales
        }

        System.out.println("\nCEDULAS DE REPROBADOS EN INGLES"); // Muestra el título para ingresar el segundo arreglo
        for (int i = 0; i < n; i++) { // Recorre todas las posiciones del arreglo de Inglés
            System.out.print("Cedula del estudiante " + (i + 1) + ": "); // Solicita la cédula correspondiente a la posición actual
            ingles[i] = sc.next(); // Lee la cédula como texto para conservar posibles ceros iniciales
        }

        for (int i = 0; i < n; i++) { // Recorre cada cédula del arreglo de Matemática
            boolean encontrada = false; // Indica si la cédula actual también aparece en el arreglo de Inglés
            for (int j = 0; j < n && !encontrada; j++) { // Busca la cédula actual en todas las posiciones de Inglés
                if (matematica[i].equals(ingles[j])) { // Comprueba si las dos cédulas son iguales
                    encontrada = true; // Marca que el estudiante reprobó las dos materias
                }
            }
            boolean repetida = false; // Indica si la cédula ya fue agregada al tercer arreglo
            for (int j = 0; j < cantidadAmbas; j++) { // Recorre solamente las posiciones ocupadas del tercer arreglo
                if (matematica[i].equals(ambasMaterias[j])) { // Comprueba si la cédula ya se encuentra almacenada
                    repetida = true; // Marca la cédula para evitar que se agregue nuevamente
                }
            }
            if (encontrada && !repetida) { // Verifica que la cédula sea común y que todavía no se haya agregado
                ambasMaterias[cantidadAmbas] = matematica[i]; // Guarda la cédula en la siguiente posición disponible
                cantidadAmbas++; // Aumenta la cantidad de estudiantes que reprobaron ambas materias
            }
        }

        System.out.println("\nVector de Matematica:"); // Muestra el título del primer vector
        imprimirVector(matematica, n); // Envía el vector de Matemática al método que lo imprime
        System.out.println("Vector de Ingles:"); // Muestra el título del segundo vector
        imprimirVector(ingles, n); // Envía el vector de Inglés al método que lo imprime
        System.out.println("Vector de estudiantes que reprobaron ambas materias:"); // Muestra el título del tercer vector
        imprimirVector(ambasMaterias, cantidadAmbas); // Imprime solamente las posiciones ocupadas del tercer vector

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }

    public static void imprimirVector(String[] vector, int cantidad) { // Declara un método para imprimir un vector de cédulas
        System.out.print("["); // Imprime el corchete inicial del vector
        for (int i = 0; i < cantidad; i++) { // Recorre las posiciones que se deben mostrar
            System.out.print(vector[i]); // Imprime el elemento de la posición actual
            if (i < cantidad - 1) { // Verifica si todavía quedan elementos por imprimir
                System.out.print(", "); // Separa el elemento actual del siguiente
            }
        }
        System.out.println("]"); // Imprime el corchete final y cambia de línea
    }
}
