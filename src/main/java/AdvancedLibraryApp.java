import java.util.ArrayList;
import java.util.Scanner;

public class AdvancedLibraryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> libros = new ArrayList<>();
        String opcion;

        do {
            System.out.println("\n--- Librería Virtual ---");
            System.out.println("1. Agregar Libro(s)");
            System.out.println("2. Mostrar Libros");
            System.out.println("3. Buscar Libro por Índice numérico");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        agregarLibros(libros, scanner);
                        break;
                    case "2":
                        mostrarLibros(libros);
                        break;
                    case "3":
                        buscarLibro(libros, scanner);
                        break;
                    case "4":
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato numérico inválido.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Índice fuera de límites.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (!opcion.equals("4"));

        scanner.close();
    }

    private static void agregarLibros(ArrayList<String> libros, Scanner scanner) {
        System.out.print("¿Cuántos libros desea agregar (máximo " + (100 - libros.size()) + ")? ");
        int numeroLibros = Integer.parseInt(scanner.nextLine());
        numeroLibros = Math.min(numeroLibros, 100 - libros.size()); // Limita a un máximo de 100 libros en total

        for (int i = 0; i < numeroLibros; i++) {
            System.out.print("Ingrese el nombre del libro " + (libros.size() + 1) + ": ");
            String libro = scanner.nextLine();
            libros.add(libro);
        }
    }

    private static void mostrarLibros(ArrayList<String> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la librería.");
        } else {
            System.out.println("Libros en la librería:");
            for (int i = 0; i < libros.size(); i++) {
                System.out.println((i + 1) + ". " + libros.get(i));
            }
        }
    }

    private static void buscarLibro(ArrayList<String> libros, Scanner scanner) {
        System.out.print("Ingrese el índice numérico del libro: ");
        int indice = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.println("Libro en el índice " + (indice + 1) + ": " + libros.get(indice));
    }
}