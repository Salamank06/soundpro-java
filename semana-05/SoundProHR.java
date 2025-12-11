import java.util.ArrayList;
import java.util.List;

public class SoundProHR {
    private final ArrayList<Personal> personal = new ArrayList<>();

    public void agregarPersonal(Personal p) {
        if (p != null) personal.add(p);
        System.out.println(p.obtenerDescripcion());
    }

    public double procesarNomina(Personal p) { return p.calcularSalario(); }

    public Personal buscarPersonal(String id) {
        for (Personal e : personal) if (e.identificacion.equals(id)) return e;
        return null;
    }

    public List<Personal> buscarPersonal(Personal prototipo) {
        ArrayList<Personal> r = new ArrayList<>();
        for (Personal e : personal) {
            boolean ok = true;
            if (prototipo.nombre != null) ok &= e.nombre.equalsIgnoreCase(prototipo.nombre);
            if (prototipo.identificacion != null) ok &= e.identificacion.equals(prototipo.identificacion);
            if (prototipo.salarioBase > 0) ok &= e.calcularSalario() >= prototipo.salarioBase;
            if (ok) r.add(e);
        }
        return r;
    }

    public List<Personal> buscarPersonal(double minSalario, double maxSalario) {
        ArrayList<Personal> r = new ArrayList<>();
        for (Personal e : personal) if (e.calcularSalario() >= minSalario && e.calcularSalario() <= maxSalario) r.add(e);
        return r;
    }

    public double aplicarBono(double monto) { return monto + 100000.0; }
    public double aplicarBono(double monto, double porcentaje) { return monto * (1.0 + (porcentaje / 100.0)); }
}
