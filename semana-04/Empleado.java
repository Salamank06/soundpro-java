public class Empleado {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;

    public Empleado(String nombre, String id, double salario) {
        this.nombre = nombre;
        this.identificacion = id;
        this.salarioBase = salario;
    }

    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("ID: " + identificacion);
    }

    public double calcularSalario() {
        return salarioBase;
    }
}
