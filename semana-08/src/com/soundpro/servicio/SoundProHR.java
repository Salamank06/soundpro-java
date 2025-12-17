package com.soundpro.servicio;

import com.soundpro.modelo.*;
import com.soundpro.excepciones.*;
import com.soundpro.util.ComparadorPorNombre;
import com.soundpro.util.ComparadorPorID;
import java.util.*;

/**
 * Gestor avanzado de recursos humanos de SoundPro.
 * Utiliza HashMap para acceso rápido por ID y TreeSet para ordenamiento automático.
 */
public class SoundProHR {
    // HashMap: Acceso O(1) por ID
    private final HashMap<String, PersonalAbstract> personalPorID = new HashMap<>();
    
    // TreeSet: Ordenamiento automático por salario (mayor a menor)
    private final TreeSet<PersonalAbstract> personalOrdenado = new TreeSet<>();
    
    // LinkedHashMap: Mantiene orden de inserción para evaluaciones
    private final LinkedHashMap<String, Integer> evaluaciones = new LinkedHashMap<>();

    /**
     * Agrega personal al sistema.
     * @throws DuplicadoException si el ID ya existe
     */
    public void agregarPersonal(PersonalAbstract p) throws DuplicadoException {
        if (p == null) {
            throw new IllegalArgumentException("El personal no puede ser null");
        }
        
        if (personalPorID.containsKey(p.getIdentificacion())) {
            throw new DuplicadoException("Ya existe personal con ID: " + p.getIdentificacion());
        }
        
        personalPorID.put(p.getIdentificacion(), p);
        personalOrdenado.add(p);
        System.out.println("✓ Agregado: " + p.obtenerDescripcion());
    }

    /**
     * Busca personal por ID usando HashMap (O(1)).
     */
    public PersonalAbstract buscarPersonal(String id) throws PersonalNoEncontradoException {
        PersonalAbstract p = personalPorID.get(id);
        if (p == null) {
            throw new PersonalNoEncontradoException(id);
        }
        return p;
    }

    /**
     * Retorna lista de personal ordenada por nombre.
     */
    public List<PersonalAbstract> listarPorNombre() {
        List<PersonalAbstract> lista = new ArrayList<>(personalPorID.values());
        lista.sort(new ComparadorPorNombre());
        return lista;
    }

    /**
     * Retorna lista de personal ordenada por ID.
     */
    public List<PersonalAbstract> listarPorID() {
        List<PersonalAbstract> lista = new ArrayList<>(personalPorID.values());
        lista.sort(new ComparadorPorID());
        return lista;
    }

    /**
     * Retorna personal ordenado por salario (mayor a menor) usando TreeSet.
     */
    public TreeSet<PersonalAbstract> listarPorSalario() {
        return new TreeSet<>(personalOrdenado);
    }

    /**
     * Filtra personal con salario mayor o igual al especificado.
     */
    public List<PersonalAbstract> filtrarPorSalarioMinimo(double salarioMin) {
        List<PersonalAbstract> resultado = new ArrayList<>();
        for (PersonalAbstract p : personalPorID.values()) {
            if (p.calcularSalario() >= salarioMin) {
                resultado.add(p);
            }
        }
        resultado.sort(Collections.reverseOrder()); // Mayor a menor
        return resultado;
    }

    /**
     * Procesa nómina de un empleado específico.
     */
    public double procesarNomina(PersonalAbstract p) {
        return p.calcularSalario();
    }

    /**
     * Evalúa personal y almacena resultado en LinkedHashMap.
     */
    public void evaluarPersonal(PersonalAbstract p, int calificacion) 
            throws CalificacionInvalidaException {
        if (p instanceof Evaluable) {
            ((Evaluable) p).setCalificacion(calificacion);
            evaluaciones.put(p.getIdentificacion(), calificacion);
            System.out.println("✓ Evaluación registrada: " + calificacion + " → " + ((Evaluable) p).nivel());
        } else {
            System.out.println("⚠ El personal no es evaluable");
        }
    }

    /**
     * Muestra nómina completa con total.
     */
    public void mostrarNomina() {
        System.out.println("\n=== NÓMINA COMPLETA ===");
        double total = 0;
        for (PersonalAbstract p : personalPorID.values()) {
            double salario = p.calcularSalario();
            total += salario;
            System.out.println(p.getNombre() + " (" + p.getIdentificacion() + "): $" + String.format("%.2f", salario));
        }
        System.out.println("TOTAL: $" + String.format("%.2f", total));
    }

    /**
     * Muestra historial de evaluaciones en orden de registro.
     */
    public void mostrarEvaluaciones() {
        System.out.println("\n=== HISTORIAL DE EVALUACIONES ===");
        for (Map.Entry<String, Integer> entry : evaluaciones.entrySet()) {
            try {
                PersonalAbstract p = buscarPersonal(entry.getKey());
                if (p instanceof Evaluable) {
                    System.out.println(p.getNombre() + ": " + entry.getValue() + " → " + ((Evaluable) p).nivel());
                }
            } catch (PersonalNoEncontradoException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Retorna cantidad total de personal.
     */
    public int cantidadPersonal() {
        return personalPorID.size();
    }

    /**
     * Retorna estadísticas del sistema.
     */
    public Map<String, Object> obtenerEstadisticas() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("total", cantidadPersonal());
        
        double sumaAntiguedad = 0;
        int countPlanta = 0;
        for (PersonalAbstract p : personalPorID.values()) {
            if (p instanceof PersonalPlanta) {
                countPlanta++;
                sumaAntiguedad += ((PersonalPlanta) p).getAnosAntiguedad();
            }
        }
        
        stats.put("planta", countPlanta);
        stats.put("contrato", cantidadPersonal() - countPlanta);
        stats.put("antiguedadPromedio", countPlanta > 0 ? sumaAntiguedad / countPlanta : 0);
        
        return stats;
    }
}

