import java.util.Scanner;

public class Tarea2 {

    public static void main(String[] args) {
        // aca declaro los 4 tipos de datos primitivos 
        int ejecucion = 0;
        double promedio1D = 0.0;
        boolean seguir = true;
        char Seccion = 'A';

        Scanner sc = new Scanner(System.in);

        System.out.println("--- Tarea 2 programacion ---");
        System.out.println("Seccion: " + Seccion);

        while (seguir) {
            /* 
               arreglo una dimension 
               aca le pedimos al usuario el tamano y los datos
               y luego calculamos el mas grande y el mas pequeno
            */
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
            double suma1D = 0;

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

            // aca calculamos el maximo minimo y el promedio
            int max = vector[0];
            int min = vector[0];

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] > max) {
                    max = vector[i];
                }
                if (vector[i] < min) {
                    min = vector[i];
                }
                suma1D = suma1D + vector[i];
            }

            promedio1D = suma1D / cant;

            System.out.println("---- resultados 1d ----");
            System.out.println("El numero mas grande es: " + max);
            System.out.println("El numero mas pequeno es: " + min);
            System.out.println("El promedio final es: " + promedio1D);

            /*
               matriz 2d
               pedimos filas y columnas para armar la matris
               se imprime de forma cuadrada y se suma todo
            */
            System.out.println("\n----- ejercicio 2: matris 2D -----");

            int filas = 0;
            int cols = 0;

            // pedir filas con validacion
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

            // pedir columnas con validacion
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

            // llenando la matris doble for
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

            // mostrando la matris ordenada y sumando todo en una sola pasada
            System.out.println("----- contenido de la matris -----");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matris[i][j] + "\t");
                    sumaMatris = sumaMatris + matris[i][j];
                }
                System.out.println(); // salto de linea para imprimir bonito la fila
            }

            System.out.println("La suma de todos los elementos es: " + sumaMatris);

            // preguntar si quiere repetir el programa
            System.out.print("\nDesea volver a ejecutar el programa? (1 = si, 0 = no): ");
            if (sc.hasNextInt()) {
                int resp = sc.nextInt();
                if (resp != 1) {
                    seguir = false;
                }
            } else {
                seguir = false;
            }
            ejecucion++;
        }

        System.out.println("\nPrograma terminado ejecuciones totales: " + ejecucion);
        sc.close();
    }
}