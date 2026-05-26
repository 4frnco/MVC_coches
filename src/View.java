import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario (Interfaz por consola).
 * @author Franco
 * @version 2.0
 */
public class View {
    private Scanner sc;

    /**
     * Constructor que inicializa el Scanner.
     */
    public View() {
        this.sc = new Scanner(System.in);
        sc.useDelimiter(System.lineSeparator());
    }

    /**
     * Muestra la velocidad de un coche por consola.
     * @param matricula Matrícula del coche.
     * @param v Velocidad actual.
     * @return true tras mostrar el mensaje.
     */
    public boolean muestraVelocidad(String matricula, Integer v) {
        if (v == -1) {
            System.out.println("Coche con matrícula " + matricula + " no encontrado.");
            return false;
        }
        System.out.println(matricula + ": " + v + " km/hr");
        return true;
    }

    /**
     * Muestra el estado actual de la gasolina y los kilómetros de un coche.
     * @param matricula Matrícula del coche.
     * @param km Kilómetros recorridos.
     * @param gasolina Litros de gasolina restantes.
     */
    public void muestraEstadoAvanzado(String matricula, double km, double gasolina) {
        System.out.println(matricula + " -> Kilómetros: " + km + " km | Gasolina: " + gasolina + " L");
    }

    /**
     * Despliega el menú principal y recoge la opción del usuario.
     * @return Array de Strings con los comandos introducidos.
     */
    public String[] menu() {
        System.out.println("\n¿Qué quieres hacer?\n1. Crear coche\n2. Mostrar Velocidad\n3. Cambiar Velocidad\n4. Avanzar (metros)\n5. Cargar Gasolina (litros)\n6. Salir");
        int opcion = sc.nextInt();

        if (opcion == 1) {
            System.out.println("Matrícula:");
            String matricula = sc.next();
            System.out.println("Modelo:");
            String modelo = sc.next();
            return new String[]{"c", modelo, matricula};
        } else if (opcion == 2) {
            System.out.println("Introduce matricula del coche:");
            String matricula = sc.next();
            return new String[]{"v", matricula};
        } else if (opcion == 3) {
            System.out.println("Introduce matricula del coche:");
            String matricula = sc.next();
            System.out.println("Introduce la nueva velocidad:");
            String velocidad = sc.next();
            return new String[]{"m", matricula, velocidad};
        } else if (opcion == 4) {
            System.out.println("Introduce matricula del coche:");
            String matricula = sc.next();
            System.out.println("Introduce metros a avanzar:");
            String metros = sc.next();
            return new String[]{"a", matricula, metros};
        } else if (opcion == 5) {
            System.out.println("Introduce matricula del coche:");
            String matricula = sc.next();
            System.out.println("Introduce litros a cargar:");
            String litros = sc.next();
            return new String[]{"g", matricula, litros};
        } else {
            return new String[]{"s"};
        }
    }
}