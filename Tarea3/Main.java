import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main { //variables globales a usar
    static Scanner scanner = new Scanner(System.in);
    static String[] nombres = new String[100];
    static double[] notas = new double[100];
    static int estudiantesAc = 0;



    //_________________________________________________________________________________________
    // funcion para agregar estudiante validando notas
    public static void AgregarEstudiante() {
        System.out.print("Ingrese su Nombre: ");
        String nombre = scanner.nextLine();

        try {
            System.out.print("Ingrese su nota: ");
            double nota = Double.parseDouble(scanner.nextLine());

            // validacion de rango de 0 a 100
            if (nota < 0 || nota > 100) {
                System.out.println("Error, La nota debe estar entre 0 y 100");
                return;
            }

            // guardamos en la posicion actual y incrementamos el contador
            nombres[estudiantesAc] = nombre;
            notas[estudiantesAc] = nota;
            estudiantesAc++;

            System.out.println("Estudiante agregado exitosamente.");

        } catch (NumberFormatException e) {
            System.out.println("Dato inválido, Debe ingresar un valor numérico");
        }
    }





    //_________________________________________________________________________________________
    // bubble sort ordenamiento descendente manual 


    public static void EstudiantesOrdenados() {
        // si no hay nada guardado salimos de una
        if (estudiantesAc == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        // el ciclo i maneja cada pasada completa del algoritmo sobre los datos ingresados
        for (int i = 0; i < estudiantesAc - 1; i++) {
            // el ciclo j compara parejas adyacentes y reduce el limite en cada pasada i
            for (int j = 0; j < estudiantesAc - 1 - i; j++) {
                
                // si la nota de la izquierda es menor q la de la derecha las intercambiamos
                if (notas[j] < notas[j + 1]) {
                    // cambio 
                    double auxNota = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = auxNota;

                    // cambio de nombres al mismo tiempo para no perder la relacion
                    String auxNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = auxNombre;
                }
            }
        }

        // imprimiendo la lista numerada en consola
        System.out.println("\n===== ESTUDIANTES ORDENADOS POR NOTA =====");
        for (int i = 0; i < estudiantesAc; i++) {
            System.out.println((i + 1) + ". " + nombres[i] + " - " + notas[i]);
        }
    }



    //_________________________________________________________________________________________
    // caso base si el indice alcanza estudiantesAc retorna 0.0 cortando las llamadas
    // caso recursivo regresa la nota actual del indice mas la llamada recursiva sumando 1 al indice
    public static double sumarNotasRecursivo(double[] arregloNotas, int indice) {
        if (indice >= estudiantesAc) {
            return 0.0; // caso base
        }
        return arregloNotas[indice] + sumarNotasRecursivo(arregloNotas, indice + 1);
    }




//_________________________________________________________________________________________
    // calcula el promedio con la suma recursiva dividida entre la cantidad de alumnos
    public static void CalcularPromedio() {
        if (estudiantesAc == 0) {
            System.out.println("No hay estudiantes registrados para calcular el promedio.");
            return;
        }

        // llamamos a la recursiva desde el indice 0
        double sumaTotal = sumarNotasRecursivo(notas, 0);



        // dividimos la suma dentro del total
        double promedio = sumaTotal / estudiantesAc;



        
        // imprimimos formateado a 2 decimales
        System.out.printf("El promedio del grupo es: %.2f\n", promedio);
    }




//_________________________________________________________________________________________
    // guarda el listado en notas.txt linea por linea en formato Nombre,Nota
    public static void GuardarEnArchivo() {
        if (estudiantesAc == 0) {
            System.out.println("No hay estudiantes registrados para guardar.");
            return;
        }

        // try with resources para cerrar el archivo solo sin problemos xd
        try (PrintWriter escritor = new PrintWriter(new FileWriter("notas.txt"))) {
            
            for (int i = 0; i < estudiantesAc; i++) {
                escritor.println(nombres[i] + "," + notas[i]);
            }
            
            System.out.println("Archivo 'notas.txt' guardado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
//_________________________________________________________________________________________
    // lee notas.txt linea por linea y mete los datos al sistema
    public static void CargarDesdeArchivo() {
        File archivo = new File("notas.txt");

        // si el archivo no existe tira aviso y no truena el programa
        if (!archivo.exists()) {
            System.out.println("El archivo 'notas.txt' no existe.");
            return;
        }




        
        int cargados = 0;




        try (Scanner lectorArchivo = new Scanner(archivo)) {
            
            while (lectorArchivo.hasNextLine()) {
                String linea = lectorArchivo.nextLine().trim();
                
                if (linea.isEmpty()) continue; 

                // hacemos separacion por coma para separar el nombre de la nota
                String[] partes = linea.split(",");
                
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    double nota = Double.parseDouble(partes[1].trim());




                    if (estudiantesAc < 100) {
                        nombres[estudiantesAc] = nombre;
                        notas[estudiantesAc] = nota;
                        estudiantesAc++;
                        cargados++;
                    }
                }
            }

            System.out.println("Se cargaron " + cargados + " estudiantes exitosamente.");

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado.");
        } catch (NumberFormatException e) {
            System.out.println("Error: El archivo contiene notas con formato numérico inválido.");
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
//_________________________________________________________________________________________
    // menu principal , nada especial
    public static void Menu(){
        boolean cases = true;
        while(cases){
            System.out.println("===SISTEMA DE NOTAS===");
            System.out.println("1. Agregar estudiante ");
            System.out.println("2. Mostrar estudiantes (Ordenados por nota)");
            System.out.println("3. Calcular Promedio del grupo");
            System.out.println("4. Guardar datos en el archivo");
            System.out.println("5. Cargar datos desde el archivo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            String MenuOpcion = scanner.nextLine(); 

            switch (MenuOpcion) {
                case "1":
                    AgregarEstudiante();   
                    break;
                
                case "2":
                    EstudiantesOrdenados();
                    break;

                case "3":
                    CalcularPromedio();
                    break;

                case "4":
                    GuardarEnArchivo();
                    break;

                case "5":
                    CargarDesdeArchivo();
                    break;

                case "6":
                    System.out.println("Hasta luego.");
                    cases = false;
                    break;

                default:
                    System.out.println("Porfavor Ingresa bien la opcion a elegir");
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Menu();
    }
}


//wao pepino



