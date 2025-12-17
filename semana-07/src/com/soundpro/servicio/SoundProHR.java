package com.soundpro.servicio;

import com.soundpro.modelo.PersonalAbstract;
import com.soundpro.modelo.Evaluable;
import com.soundpro.excepciones.PersonalNoEncontradoException;
import com.soundpro.excepciones.CalificacionInvalidaException;
import java.util.ArrayList;

/**
 * Gestor de recursos humanos de SoundPro.
 * Maneja operaciones de personal con validaciones robustas.
 */
public class SoundProHR {
    private final ArrayList<PersonalAbstract> personal = new ArrayList<>();

    public void agregarPersonal(PersonalAbstract p) {
        if (p != null) {
            personal.add(p);
            System.out.println("✓ Agregado: " + p.obtenerDescripcion());
        }
    }

    public PersonalAbstract buscarPersonal(String id) throws PersonalNoEncontradoException {
        for (PersonalAbstract e : personal) {
            if (e.getIdentificacion().equals(id)) {
                return e;
            }
        }
        throw new PersonalNoEncontradoException(id);
    }

    public double procesarNomina(PersonalAbstract p) {
        return p.calcularSalario();
    }

    public void evaluarPersonal(PersonalAbstract p, int calificacion) 
            throws CalificacionInvalidaException {
        if (p instanceof Evaluable) {
            ((Evaluable) p).setCalificacion(calificacion);
            System.out.println("✓ Evaluación registrada: " + calificacion + " → " + ((Evaluable) p).nivel());
        } else {
            System.out.println("⚠ El personal no es evaluable");
        }
    }

    public void mostrarNomina() {
        System.out.println("\n=== NÓMINA COMPLETA ===");
        double total = 0;
        for (PersonalAbstract p : personal) {
            double salario = p.calcularSalario();
            total += salario;
            System.out.println(p.getNombre() + " (" + p.getIdentificacion() + "): $" + String.format("%.2f", salario));
        }
        System.out.println("TOTAL: $" + String.format("%.2f", total));
    }

    public int cantidadPersonal() {
        return personal.size();
    }
}

