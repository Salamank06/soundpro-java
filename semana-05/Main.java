import java.util.List;

public class Main {
    public static void main(String[] args) {
        Personal[] personas = new Personal[3];
        personas[0] = new PersonalPlanta("Ana", "E001", 2000000, 5);
        personas[1] = new PersonalContrato("Luis", "E002", 1500000, 6);
        personas[2] = new PersonalPlanta("María", "E003", 2500000, 3);

        for (Personal p : personas) {
            p.mostrarInfo();
            System.out.println(p.obtenerDescripcion());
            System.out.println("Salario: $" + String.format("%.2f", p.calcularSalario()));
            System.out.println("---");
        }

        SoundProHR hr = new SoundProHR();
        for (Personal p : personas) hr.agregarPersonal(p);

        for (Personal p : personas) {
            double pago = hr.procesarNomina(p);
            double pagoConBono = hr.aplicarBono(pago, 10);
            System.out.println("Pago con bono 10%: $" + String.format("%.2f", pagoConBono));
        }

        Personal encontrado = hr.buscarPersonal("E002");
        System.out.println("Encontrado por ID: " + (encontrado != null ? encontrado.nombre : "N/A"));

        List<Personal> rango = hr.buscarPersonal(2000000, 3000000);
        System.out.println("En rango 2M-3M: " + rango.size());

        Personal filtro = new Personal("Ana", null, 0);
        List<Personal> porNombre = hr.buscarPersonal(filtro);
        System.out.println("Por nombre Ana: " + porNombre.size());
    }
}
