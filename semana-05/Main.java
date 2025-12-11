import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new EmpleadoPlanta("Ana", "E001", 2000000, 5);
        empleados[1] = new EmpleadoContrato("Luis", "E002", 1500000, 6);
        empleados[2] = new EmpleadoPlanta("María", "E003", 2500000, 3);

        for (Empleado emp : empleados) {
            emp.mostrarInfo();
            System.out.println(emp.obtenerDescripcion());
            System.out.println("Salario: $" + String.format("%.2f", emp.calcularSalario()));
            System.out.println("---");
        }

        SistemaRH rh = new SistemaRH();
        for (Empleado emp : empleados) rh.agregarEmpleado(emp);

        for (Empleado emp : empleados) {
            double pago = rh.procesarNomina(emp);
            double pagoConBono = rh.aplicarBono(pago, 10);
            System.out.println("Pago con bono 10%: $" + String.format("%.2f", pagoConBono));
        }

        Empleado encontrado = rh.buscarEmpleado("E002");
        System.out.println("Encontrado por ID: " + (encontrado != null ? encontrado.nombre : "N/A"));

        List<Empleado> rango = rh.buscarEmpleado(2000000, 3000000);
        System.out.println("En rango 2M-3M: " + rango.size());

        Empleado filtro = new Empleado("Ana", null, 0);
        List<Empleado> porNombre = rh.buscarEmpleado(filtro);
        System.out.println("Por nombre Ana: " + porNombre.size());
    }
}
