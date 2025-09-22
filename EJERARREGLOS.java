import java.util.Scanner;
public class EJERARREGLOS {
    static String[] meses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    static String[] departamentos = {"Ropa", "Deportes", "Juguetería"};
    static double[][] ventas = new double[12][3];

    static Scanner sc = new Scanner(System.in);
    static Integer parseMes(String input) {
        input = input.trim().toLowerCase();

        if (input.matches("\\d+")) {
            int idx = Integer.parseInt(input) - 1;
            if (idx >= 0 && idx < meses.length) return idx;
            return null;
        }
       
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].toLowerCase().equals(input)) return i;
        }
    
        if (input.length() >= 2) {
            String pref = input.substring(0, Math.min(3, input.length()));
            for (int i = 0; i < meses.length; i++) {
                if (meses[i].toLowerCase().startsWith(pref)) return i;
            }
        }
        return null;
    }
    static Integer parseDepto(String input) {
        input = input.trim().toLowerCase();
      
        if (input.matches("\\d+")) {
            int idx = Integer.parseInt(input) - 1;
            if (idx >= 0 && idx < departamentos.length) return idx;
            return null;
        }
       
        for (int j = 0; j < departamentos.length; j++) {
            if (departamentos[j].toLowerCase().equals(input)) return j;
        }
      
        if (input.length() >= 2) {
            String pref = input.substring(0, Math.min(3, input.length()));
            for (int j = 0; j < departamentos.length; j++) {
                if (departamentos[j].toLowerCase().startsWith(pref)) return j;
            }
        }
        return null;
    }
    static void insertarVenta() {
        System.out.println("\n-> Insertar venta");
        System.out.print("Mes (número 1-12 o nombre): ");
        Integer i = parseMes(sc.nextLine());
        if (i == null) {
            System.out.println(" Mes no válido.");
            return;
        }
        System.out.println("Departamentos: 1-Ropa  2-Deportes  3-Juguetería");
        System.out.print("Departamento: ");
        Integer j = parseDepto(sc.nextLine());
        if (j == null) {
            System.out.println(" Departamento no válido.");
            return;
        }
        System.out.print("Monto de la venta: ");
        if (!sc.hasNextDouble()) {
            System.out.println(" Monto inválido.");
            sc.nextLine();
            return;
        }
        double monto = sc.nextDouble(); sc.nextLine();
        ventas[i][j] = monto;
        System.out.println(" Guardado: " + meses[i] + " - " + departamentos[j] + " = " + monto);
    }

    static void buscarVenta() {
        System.out.println("\n-> Buscar venta");
        System.out.print("Mes: ");
        Integer i = parseMes(sc.nextLine());
        if (i == null) {
            System.out.println(" Mes no válido.");
            return;
        }
        System.out.print("Departamento: ");
        Integer j = parseDepto(sc.nextLine());
        if (j == null) {
            System.out.println(" Departamento no válido.");
            return;
        }
        System.out.println(" Resultado: " + meses[i] + " - " + departamentos[j] + " = " + ventas[i][j]);
    }

    static void eliminarVenta() {
        System.out.println("\n-> Eliminar venta");
        System.out.print("Mes: ");
        Integer i = parseMes(sc.nextLine());
        if (i == null) {
            System.out.println(" Mes no válido.");
            return;
        }
        System.out.print("Departamento: ");
        Integer j = parseDepto(sc.nextLine());
        if (j == null) {
            System.out.println(" Departamento no válido.");
            return;
        }
        ventas[i][j] = 0;
        System.out.println(" Eliminado: " + meses[i] + " - " + departamentos[j]);
    }

    static void mostrarVentas() {
        System.out.println("\n Ventas actuales:");
        System.out.printf("%-12s%-12s%-12s%-12s%n", "Mes", "Ropa", "Deportes", "Juguetería");
        for (int i = 0; i < meses.length; i++) {
            System.out.printf("%-12s%-12.2f%-12.2f%-12.2f%n",
                    meses[i], ventas[i][0], ventas[i][1], ventas[i][2]);
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1) Insertar venta");
            System.out.println("2) Buscar venta");
            System.out.println("3) Eliminar venta");
            System.out.println("4) Mostrar todas las ventas");
            System.out.println("5) Salir");
            System.out.print("Opción: ");
            String opc = sc.nextLine().trim();
            switch (opc) {
                case "1": insertarVenta(); break;
                case "2": buscarVenta(); break;
                case "3": eliminarVenta(); break;
                case "4": mostrarVentas(); break;
                case "5": System.out.println("Saliendo"); return;
                default: System.out.println(" Opción inválida.");
            }
        }
    }
}
