public class PersonalPlanta extends Personal {
    private int anosAntiguedad;

    public PersonalPlanta(String nombre, String id, double salario, int anos) {
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
}
