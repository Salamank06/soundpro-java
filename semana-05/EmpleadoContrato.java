public class EmpleadoContrato extends Empleado {
    private int mesesContrato;

    public EmpleadoContrato(String nombre, String id, double salario, int meses) {
        super(nombre, id, salario);
        this.mesesContrato = meses;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    @Override
    public String obtenerDescripcion() {
        return "Contrato, meses: " + mesesContrato;
    }
}
