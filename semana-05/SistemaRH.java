import java.util.ArrayList;
import java.util.List;

public class SistemaRH {
    private final ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null) empleados.add(empleado);
        System.out.println(empleado.obtenerDescripcion());
    }

    public double procesarNomina(Empleado empleado) {
        return empleado.calcularSalario();
    }

    public Empleado buscarEmpleado(String id) {
        for (Empleado e : empleados) if (e.identificacion.equals(id)) return e;
        return null;
    }

    public List<Empleado> buscarEmpleado(Empleado prototipo) {
        ArrayList<Empleado> r = new ArrayList<>();
        for (Empleado e : empleados) {
            boolean ok = true;
            if (prototipo.nombre != null) ok &= e.nombre.equalsIgnoreCase(prototipo.nombre);
            if (prototipo.identificacion != null) ok &= e.identificacion.equals(prototipo.identificacion);
            if (prototipo.salarioBase > 0) ok &= e.calcularSalario() >= prototipo.salarioBase;
            if (ok) r.add(e);
        }
        return r;
    }

    public List<Empleado> buscarEmpleado(double minSalario, double maxSalario) {
        ArrayList<Empleado> r = new ArrayList<>();
        for (Empleado e : empleados) if (e.calcularSalario() >= minSalario && e.calcularSalario() <= maxSalario) r.add(e);
        return r;
    }

    public double aplicarBono(double monto) {
        return monto + 100000.0;
    }

    public double aplicarBono(double monto, double porcentaje) {
        return monto * (1.0 + (porcentaje / 100.0));
    }
}
