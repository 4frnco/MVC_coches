/**
 * Clase Controller que orquesta la aplicación.
 * @author Franco
 * @version 2.0
 */
public class Controller {

    /**
     * Método main que lanza el flujo principal.
     * @param args Argumentos de la línea de comando.
     */
    public static void main(String[] args) {
        View miView = new View();
        Model miModel = new Model();

        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");

        System.out.println("================ Sistema Iniciado ================");

        while (true) {
            String[] respuesta = miView.menu();

            if (respuesta[0].equals("s")) {
                System.out.println("Saliendo...");
                break;
            }

            if (respuesta[0].equals("c")) {
                miModel.crearCoche(respuesta[1], respuesta[2]);
                System.out.println("[LOG] Coche creado.");
            } else if (respuesta[0].equals("v")) {
                miView.muestraVelocidad(respuesta[1], miModel.getVelocidad(respuesta[1]));
            } else if (respuesta[0].equals("m")) {
                miModel.cambiarVelocidad(respuesta[1], Integer.parseInt(respuesta[2]));
                System.out.println("[LOG] Velocidad actualizada.");
            } else if (respuesta[0].equals("a")) {
                boolean avanzado = miModel.avanzar(respuesta[1], Double.parseDouble(respuesta[2]));
                if (avanzado) {
                    Coche c = miModel.getCoche(respuesta[1]);
                    miView.muestraEstadoAvanzado(respuesta[1], c.getKilometrosRecorridos(), c.getGasolinaLitros());
                } else {
                    System.out.println("[LOG] Coche no encontrado.");
                }
            } else if (respuesta[0].equals("g")) {
                boolean cargado = miModel.cargarGasolina(respuesta[1], Double.parseDouble(respuesta[2]));
                if (cargado) {
                    Coche c = miModel.getCoche(respuesta[1]);
                    miView.muestraEstadoAvanzado(respuesta[1], c.getKilometrosRecorridos(), c.getGasolinaLitros());
                } else {
                    System.out.println("[LOG] Coche no encontrado.");
                }
            } else {
                System.out.println("[LOG] ERROR opción incorrecta");
            }
        }
    }
}