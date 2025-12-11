public class Personal {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;

    public Personal(String nombre, String id, double salario) {
        this.nombre = nombre;
        this.identificacion = id;
        this.salarioBase = salario;
    }

    public void mostrarInfo() {
        System.out.println("Personal: " + nombre);
        System.out.println("ID: " + identificacion);
    }

    public double calcularSalario() { return salarioBase; }
    public String obtenerDescripcion() { return "Personal general"; }
}
