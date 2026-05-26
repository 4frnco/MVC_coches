/**
 * Clase que representa la entidad Coche.
 * @author Franco
 * @version 2.0
 */
public class Coche {
    private String matricula;
    private String modelo;
    private Integer velocidad;
    private double kilometrosRecorridos;
    private double gasolinaLitros;

    /**
     * Constructor de la clase Coche.
     * @param modelo Modelo del vehículo.
     * @param matricul Matrícula única del vehículo.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometrosRecorridos = 0.0;
        this.gasolinaLitros = 50.0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public double getGasolinaLitros() {
        return gasolinaLitros;
    }

    public void setGasolinaLitros(double gasolinaLitros) {
        this.gasolinaLitros = gasolinaLitros;
    }
}