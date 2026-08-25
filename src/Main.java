import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("CONTROL PERSONAL DE LOS GASTOS");


        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();
        }

    public static double calcularTotal(ArrayList<Double> montos) {
        double total = 0.0;
        for (double monto : montos) {
            total += monto;
        }
        return total;
    }

    public static int obtenerPosicionGastoMayor(ArrayList<Double> montos) {
        if (montos == null || montos.isEmpty()) {
            return -1;
        }

        int posicion = 0;
        for (int i = 1; i < montos.size(); i++) {
            if (montos.get(i) > montos.get(posicion)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static double calcularTotalPorCategoria(
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            String categoriaBuscada){
        if (categorias == null || montos == null || categorias.isEmpty() || montos.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (int i = 0; i < categorias.size() && i < montos.size(); i++) {
            if (categorias.get(i).equals(categoriaBuscada)) {
                total += montos.get(i);
            }
        }

        return total;
    }

    public static void mostrarResumen(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos){
        System.out.println("RESUMEN SEMANAL");
        System.out.println();

        if (montos == null || montos.isEmpty()) {
            System.out.println("Gastos: 0");
            System.out.println("Gasto total: $0.00");
            System.out.println("Promedio : $0.00");
            System.out.println("Gasto mayor: No hay gastos");
            return;
        }

        double total = calcularTotal(montos);
        double promedio = total / montos.size();

        int posicionMayor = obtenerPosicionGastoMayor(montos);

        System.out.println("Número de gastos: " + montos.size());
        System.out.printf("Gasto total: $%.2f%n", total);
        System.out.printf("Promedio por gasto: $%.2f%n", promedio);

        if (conceptos != null && posicionMayor < conceptos.size()) {
            System.out.printf("Gasto mayor: %s, $%.2f%n",
                    conceptos.get(posicionMayor),
                    montos.get(posicionMayor));
        }





    }






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

