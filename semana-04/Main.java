public class Main {
    public static void main(String[] args) {
        PersonalSoundPro[] personal = new PersonalSoundPro[3];
        personal[0] = new PersonalPlanta("Ana", "E001", 2000000, 5);
        personal[1] = new PersonalContrato("Luis", "E002", 1500000, 6);
        personal[2] = new PersonalPlanta("María", "E003", 2500000, 3);

        for (PersonalSoundPro p : personal) {
            p.mostrarInfo();
            System.out.println("Salario: $" + String.format("%.2f", p.calcularSalario()));
            System.out.println("---");
        }
    }
}
