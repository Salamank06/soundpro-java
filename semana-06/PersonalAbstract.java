public abstract class PersonalAbstract {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;

    public PersonalAbstract(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }

    public void mostrarInfo() {
        System.out.println("Personal: " + nombre + " | ID: " + identificacion);
    }

    public abstract double calcularSalario();
    public abstract String obtenerDescripcion();
}
