import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Gestor semanal de gastos");
    }

    // Método para registrar gastos
    public static void registrarGasto(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            Scanner scanner) {

        System.out.print("Introduce el concepto del gasto: ");
        String concepto = scanner.nextLine();

        System.out.println("\nCategorías disponibles:");
        System.out.println("1. Alimentos");
        System.out.println("2. Transporte");
        System.out.println("3. Materiales escolares");
        System.out.println("4. Entretenimiento");
        System.out.println("5. Otros");

        String categoria = "";
        boolean categoriaValida = false;

        while (categoriaValida == false) {
            System.out.print("Selecciona el número de la categoría (1-5): ");
            int opcionCategoria = scanner.nextInt();
            scanner.nextLine();

            switch (opcionCategoria) {
                case 1:
                    categoria = "Alimentos";
                    categoriaValida = true;
                    break;
                case 2:
                    categoria = "Transporte";
                    categoriaValida = true;
                    break;
                case 3:
                    categoria = "Materiales escolares";
                    categoriaValida = true;
                    break;
                case 4:
                    categoria = "Entretenimiento";
                    categoriaValida = true;
                    break;
                case 5:
                    categoria = "Otros";
                    categoriaValida = true;
                    break;
                default:
                    System.out.println("Categoría no válida. Intenta de nuevo.");
            }
        }

        double monto = 0;
        boolean montoValido = false;

        while (montoValido == false) {
            System.out.print("Introduce el monto: $");
            monto = scanner.nextDouble();
            scanner.nextLine();

            if (monto > 0) {
                montoValido = true;
            } else {
                System.out.println("El monto debe ser mayor a cero. Intenta de nuevo.");
            }
        }

        conceptos.add(concepto);
        categorias.add(categoria);
        montos.add(monto);

        System.out.println("¡Gasto registrado con éxito!");
    }

    // Método para mostrar gastos
    public static void mostrarGastos(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        System.out.println("\nGASTOS REGISTRADOS\n");

        if (conceptos.size() == 0) {
            System.out.println("Todavía no hay gastos registrados.");
        } else {
            for (int i = 0; i < conceptos.size(); i++) {
                System.out.println((i + 1) + ". " + conceptos.get(i) + " | " + categorias.get(i) + " | $" + montos.get(i));
            }
        }
    }

}
// listado terminado