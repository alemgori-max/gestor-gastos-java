import java.util.ArrayList;
public class Main {


    public static void main(String[] args) {
        System.out.println("Gestor semanal de gastos");


        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();

        conceptos.add("chetos");
        conceptos.add("juguete");
        conceptos.add("gas");
        conceptos.add("Luz");

        categorias.add("Comida");
        categorias.add("Escuela");
        categorias.add("Transporte");
        categorias.add("Escuela");

        montos.add(50.00);
        montos.add(180.00);
        montos.add(75.00);
        montos.add(73.50);

        mostrarResumen(conceptos, categorias, montos);
        }

        public static double calcularTotal(ArrayList<Double> montos){

            if (montos == null || montos.isEmpty()) {
                return 0.0;
            }

            double total = 0.0;
            for (int i = 0; i < montos.size(); i++) {
                total += montos.get(i);
            }
            return total;
        }


    public static int obtenerPosicionGastoMayor(ArrayList<Double> montos){
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