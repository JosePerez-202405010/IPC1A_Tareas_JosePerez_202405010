import java.util.Scanner;

public class Tarea2 {

    public static void main(String[] args) {
        int ejecucion = 0;
        double promedio1D = 0.0;
        boolean seguir = true;
        char Seccion = 'A';

        Scanner sc = new Scanner(System.in);

        System.out.println("--- Tarea 2 programacion ---");
        System.out.println("Seccion: " + Seccion);

        System.out.println("--- Ejercicio 1: arreglo 1D ---");

        int cant = 0;
        boolean esValido = false;

        // validasion de la cantidad de elementos para que no falle
        while (!esValido) {
            System.out.print("Ingrese el tamano del arreglo (entre 1 y 10): ");
            if (sc.hasNextInt()) {
                cant = sc.nextInt();
                if (cant >= 1 && cant <= 10) {
                    esValido = true;
                } else {
                    System.out.println("error numero fuera de rango intentelo de nuevo");
                }
            } else {
                System.out.println("error no metio un numero entero valido");
                sc.next(); // limpia el scanner si metio letras
            }
        }

        int[] vector = new int[cant];

        // llenado del vector uno por uno
        for (int i = 0; i < cant; i++) {
            boolean numValido = false;
            while (!numValido) {
                System.out.print("Ingrese dato posicion [" + i + "]: ");
                if (sc.hasNextInt()) {
                    vector[i] = sc.nextInt();
                    numValido = true;
                } else {
                    System.out.println("dato invalido porfavor ingrese un numero");
                    sc.next();
                }
            }
        }

        sc.close();
    }
}