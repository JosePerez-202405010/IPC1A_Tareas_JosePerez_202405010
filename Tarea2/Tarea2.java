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

        // Arreglo 1D rápido
        int cant = 1;
        int[] vector = {5};
        promedio1D = 5.0;

        System.out.println("\n----- ejercicio 2: matris 2D -----");

        int filas = 0;
        int cols = 0;

        boolean fValida = false;
        while (!fValida) {
            System.out.print("Ingrese cantidad de filas (1 a 5): ");
            if (sc.hasNextInt()) {
                filas = sc.nextInt();
                if (filas >= 1 && filas <= 5) {
                    fValida = true;
                } else {
                    System.out.println("filas fuera de rango");
                }
            } else {
                System.out.println("ingrese solo numeros porfavor");
                sc.next();
            }
        }

        boolean cValida = false;
        while (!cValida) {
            System.out.print("Ingrese cantidad de columnas (1 a 5): ");
            if (sc.hasNextInt()) {
                cols = sc.nextInt();
                if (cols >= 1 && cols <= 5) {
                    cValida = true;
                } else {
                    System.out.println("columnas fuera de rango");
                }
            } else {
                System.out.println("ingrese solo numeros porfavor");
                sc.next();
            }
        }

        int[][] matris = new int[filas][cols];
        int sumaMatris = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                boolean mValido = false;
                while (!mValido) {
                    System.out.print("Dato en posicion [" + i + "][" + j + "]: ");
                    if (sc.hasNextInt()) {
                        matris[i][j] = sc.nextInt();
                        mValido = true;
                    } else {
                        System.out.println("ingrese un numero entero valido");
                        sc.next();
                    }
                }
            }
        }

        System.out.println("----- contenido de la matris -----");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matris[i][j] + "\t");
                sumaMatris = sumaMatris + matris[i][j];
            }
            System.out.println();
        }

        System.out.println("La suma de todos los elementos es: " + sumaMatris);
        sc.close();
    }
}