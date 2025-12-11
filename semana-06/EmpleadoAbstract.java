public abstract class EmpleadoAbstract {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;

    public EmpleadoAbstract(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }

    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre + " | ID: " + identificacion);
    }

    public abstract double calcularSalario();
    public abstract String obtenerDescripcion();
}
