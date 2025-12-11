import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<EmpleadoAbstract> lista = new ArrayList<>();
        EmpleadoPlanta ana = new EmpleadoPlanta("Ana", "E001", 2000000, 5);
        EmpleadoContrato luis = new EmpleadoContrato("Luis", "E002", 1500000, 6);
        lista.add(ana);
        lista.add(luis);

        for (EmpleadoAbstract e : lista) {
            e.mostrarInfo();
            System.out.println(e.obtenerDescripcion());
            System.out.println("Salario: $" + String.format("%.2f", e.calcularSalario()));
            System.out.println("---");
        }

        Evaluable ev1 = ana; Bonificable bo1 = ana;
        Evaluable ev2 = luis; Bonificable bo2 = luis;

        ev1.setCalificacion(92);
        ev2.setCalificacion(80);
        System.out.println("Ana nivel: " + ev1.nivel());
        System.out.println("Luis nivel: " + ev2.nivel());
        System.out.println("Ana bono 10%: $" + String.format("%.2f", bo1.aplicarBono(10)));
        System.out.println("Luis bono fijo 100k: $" + String.format("%.2f", bo2.aplicarBonoFijo(100000)));
    }
}
