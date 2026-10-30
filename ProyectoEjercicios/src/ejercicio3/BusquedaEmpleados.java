package ejercicio3; // Declara que la clase pertenece al paquete ejercicio3

import java.util.Scanner; // Importa Scanner para leer datos desde el teclado

public class BusquedaEmpleados { // Declara la clase pública BusquedaEmpleados
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in); // Crea el lector que recibe los datos ingresados por teclado

        System.out.print("Numero de empleados: "); // Solicita la cantidad de empleados que se registrarán
        int n = sc.nextInt(); // Lee y guarda el número de empleados
        sc.nextLine(); // Limpia el salto de línea pendiente después de leer el número

        while (n <= 0) { // Repite la lectura mientras la cantidad no sea positiva
            System.out.print("Ingrese una cantidad mayor que cero: "); // Solicita nuevamente una cantidad válida
            n = sc.nextInt(); // Lee la nueva cantidad de empleados
            sc.nextLine(); // Limpia el salto de línea pendiente después de la lectura
        }

        String[] codigos = new String[n]; // Crea el arreglo que guardará los códigos de los empleados
        String[] nombres = new String[n]; // Crea el arreglo que guardará los nombres de los empleados

        for (int i = 0; i < n; i++) { // Recorre una posición por cada empleado
            System.out.println("\nEmpleado " + (i + 1)); // Muestra el número del empleado que se está registrando
            System.out.print("Codigo: "); // Solicita el código del empleado actual
            codigos[i] = sc.nextLine(); // Lee y guarda el código como texto
            System.out.print("Nombre: "); // Solicita el nombre completo del empleado actual
            nombres[i] = sc.nextLine(); // Lee y guarda el nombre completo
        }

        System.out.print("\nCodigo que desea buscar: "); // Solicita el código que se buscará
        String codigoBuscado = sc.nextLine(); // Lee y guarda el código ingresado para la búsqueda
        int posicionEncontrada = -1; // Usa -1 para representar que el código todavía no se ha encontrado

        for (int i = 0; i < codigos.length; i++) { // Recorre todos los códigos registrados
            if (codigos[i].equalsIgnoreCase(codigoBuscado)) { // Compara los códigos sin distinguir mayúsculas y minúsculas
                posicionEncontrada = i; // Guarda la posición del empleado cuyo código coincide
                break; // Termina la búsqueda porque el empleado ya fue encontrado
            }
        }

        if (posicionEncontrada != -1) { // Verifica si se encontró una posición válida
            System.out.println("Nombre del empleado: " + nombres[posicionEncontrada]); // Muestra el nombre asociado con el código
        } else { // Se ejecuta cuando el código no coincide con ningún empleado
            System.out.println("No existe un empleado con ese codigo."); // Informa que no se encontró el código solicitado
        }

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    }
}
