public class EmpleadoPlanta extends EmpleadoAbstract implements Evaluable, Bonificable {
    private int anosAntiguedad;
    private int calificacion;

    public EmpleadoPlanta(String nombre, String id, double salario, int anos) {
        super(nombre, id, salario);
        this.anosAntiguedad = anos;
    }

    @Override
    public double calcularSalario() {
        double bono = salarioBase * 0.05 * anosAntiguedad;
        return salarioBase + bono;
    }

    @Override
    public String obtenerDescripcion() { return "Planta, años: " + anosAntiguedad; }

    @Override
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    @Override
    public int getCalificacion() { return calificacion; }

    @Override
    public String nivel() { return calificacion >= 90 ? "Excelente" : calificacion >= 70 ? "Bueno" : "Mejorable"; }

    @Override
    public double aplicarBono(double porcentaje) { return calcularSalario() * (1.0 + porcentaje / 100.0); }

    @Override
    public double aplicarBonoFijo(double monto) { return calcularSalario() + monto; }
}
