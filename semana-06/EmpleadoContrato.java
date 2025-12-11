public class EmpleadoContrato extends EmpleadoAbstract implements Evaluable, Bonificable {
    private int mesesContrato;
    private int calificacion;

    public EmpleadoContrato(String nombre, String id, double salario, int meses) {
        super(nombre, id, salario);
        this.mesesContrato = meses;
    }

    @Override
    public double calcularSalario() { return salarioBase; }

    @Override
    public String obtenerDescripcion() { return "Contrato, meses: " + mesesContrato; }

    @Override
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    @Override
    public int getCalificacion() { return calificacion; }

    @Override
    public String nivel() { return calificacion >= 85 ? "Bueno" : "Mejorable"; }

    @Override
    public double aplicarBono(double porcentaje) { return calcularSalario() * (1.0 + porcentaje / 100.0); }

    @Override
    public double aplicarBonoFijo(double monto) { return calcularSalario() + monto; }
}
