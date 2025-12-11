public class PersonalContrato extends PersonalSoundPro {
    private int mesesContrato;

    public PersonalContrato(String nombre, String id, double salario, int meses) {
        super(nombre, id, salario);
        this.mesesContrato = meses;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }
}
