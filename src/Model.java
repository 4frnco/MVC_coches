import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos y la lógica de negocio.
 * @author Franco
 * @version 2.0
 */
public class Model {
    private ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo almacena en el sistema.
     * @param modelo Modelo del coche.
     * @param matricul Matrícula única del coche.
     * @return El coche recién creado.
     */
    public Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche según su matrícula.
     * @param matricula Matrícula a buscar.
     * @return El coche encontrado o null si no existe.
     */
    public Coche getCoche(String matricula) {
        for (Coche e : parking) {
            if (e.getMatricula().equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche específico.
     * @param matricula Matrícula del coche.
     * @param v Nueva velocidad.
     * @return La nueva velocidad, o -1 si el coche no existe.
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.setVelocidad(v);
            return coche.getVelocidad();
        }
        return -1;
    }

    /**
     * Devuelve la velocidad de un coche según su matrícula.
     * @param matricula Matrícula del coche.
     * @return La velocidad actual, o -1 si el coche no existe.
     */
    public int getVelocidad(String matricula) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            return coche.getVelocidad();
        }
        return -1;
    }

    /**
     * Avanza el coche una cantidad de metros, suma kilómetros y descuenta gasolina.
     * @param matricula Matrícula del coche.
     * @param metros Metros que avanza el coche.
     * @return true si el coche existe y avanzó, false en caso contrario.
     */
    public boolean avanzar(String matricula, double metros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            double kilometros = metros / 1000.0;
            coche.setKilometrosRecorridos(coche.getKilometrosRecorridos() + kilometros);

            double consumo = kilometros + (coche.getVelocidad() * 0.05);
            coche.setGasolinaLitros(Math.max(0, coche.getGasolinaLitros() - consumo));
            return true;
        }
        return false;
    }

    /**
     * Añade litros de gasolina al tanque del coche.
     * @param matricula Matrícula del coche.
     * @param litros Litros de gasolina a repostar.
     * @return true si el coche existe y se repostó, false en caso contrario.
     */
    public boolean cargarGasolina(String matricula, double litros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.setGasolinaLitros(coche.getGasolinaLitros() + litros);
            return true;
        }
        return false;
    }
}