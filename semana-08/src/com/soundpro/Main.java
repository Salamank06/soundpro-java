package com.soundpro;

import com.soundpro.modelo.*;
import com.soundpro.servicio.SoundProHR;
import com.soundpro.excepciones.*;
import java.util.*;

/**
 * Clase principal que demuestra colecciones avanzadas y comparadores en SoundPro.
 * Incluye HashMap, TreeSet, LinkedHashMap, Comparable y Comparator.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOUNDPRO - SEMANA 08: COLECCIONES AVANZADAS ===\n");

        SoundProHR hr = new SoundProHR();

        // ============================================================
        // CASO 1: Agregar personal (HashMap para acceso rápido)
        // ============================================================
        System.out.println("--- Caso 1: Agregar Personal al HashMap ---");
        try {
            hr.agregarPersonal(new PersonalPlanta("Ana García", "E001", 2000000, 5));
            hr.agregarPersonal(new PersonalContrato("Luis Martínez", "E002", 1500000, 6));
            hr.agregarPersonal(new PersonalPlanta("María López", "E003", 2500000, 3));
            hr.agregarPersonal(new PersonalContrato("Carlos Ruiz", "E004", 1800000, 12));
            hr.agregarPersonal(new PersonalPlanta("Diana Silva", "E005", 3000000, 10));
            System.out.println("✅ Personal agregado exitosamente\n");
        } catch (SalarioInvalidoException | DuplicadoException e) {
            System.err.println("❌ Error: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 2: Intentar agregar ID duplicado
        // ============================================================
        System.out.println("--- Caso 2: Intentar ID Duplicado (Debe Fallar) ---");
        try {
            hr.agregarPersonal(new PersonalPlanta("Pedro Duplicado", "E001", 2200000, 2));
        } catch (SalarioInvalidoException | DuplicadoException e) {
            System.err.println("❌ Excepción capturada: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 3: Búsqueda rápida por ID (HashMap O(1))
        // ============================================================
        System.out.println("--- Caso 3: Búsqueda Rápida por ID ---");
        try {
            PersonalAbstract encontrado = hr.buscarPersonal("E003");
            System.out.println("✓ Encontrado: " + encontrado);
            System.out.println("  Tipo: " + encontrado.obtenerDescripcion());
            System.out.println();
        } catch (PersonalNoEncontradoException e) {
            System.err.println("❌ Error: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 4: Ordenamiento por SALARIO (TreeSet + Comparable)
        // ============================================================
        System.out.println("--- Caso 4: Ordenamiento por Salario (TreeSet) ---");
        System.out.println("Usa Comparable implementado en PersonalAbstract:");
        TreeSet<PersonalAbstract> porSalario = hr.listarPorSalario();
        int posicion = 1;
        for (PersonalAbstract p : porSalario) {
            System.out.println(posicion++ + ". " + p);
        }
        System.out.println();

        // ============================================================
        // CASO 5: Ordenamiento por NOMBRE (Comparator)
        // ============================================================
        System.out.println("--- Caso 5: Ordenamiento por Nombre (Comparator) ---");
        System.out.println("Usa ComparadorPorNombre:");
        List<PersonalAbstract> porNombre = hr.listarPorNombre();
        posicion = 1;
        for (PersonalAbstract p : porNombre) {
            System.out.println(posicion++ + ". " + p);
        }
        System.out.println();

        // ============================================================
        // CASO 6: Ordenamiento por ID (Comparator)
        // ============================================================
        System.out.println("--- Caso 6: Ordenamiento por ID (Comparator) ---");
        System.out.println("Usa ComparadorPorID:");
        List<PersonalAbstract> porID = hr.listarPorID();
        posicion = 1;
        for (PersonalAbstract p : porID) {
            System.out.println(posicion++ + ". " + p.getIdentificacion() + " - " + p.getNombre());
        }
        System.out.println();

        // ============================================================
        // CASO 7: Filtrado por salario mínimo
        // ============================================================
        System.out.println("--- Caso 7: Filtrar por Salario >= $2,000,000 ---");
        List<PersonalAbstract> filtrados = hr.filtrarPorSalarioMinimo(2000000);
        System.out.println("Personal con salario >= $2,000,000:");
        for (PersonalAbstract p : filtrados) {
            System.out.println("  • " + p);
        }
        System.out.println();

        // ============================================================
        // CASO 8: Evaluaciones (LinkedHashMap mantiene orden)
        // ============================================================
        System.out.println("--- Caso 8: Evaluaciones (LinkedHashMap) ---");
        try {
            hr.evaluarPersonal(hr.buscarPersonal("E001"), 92);
            hr.evaluarPersonal(hr.buscarPersonal("E003"), 88);
            hr.evaluarPersonal(hr.buscarPersonal("E005"), 95);
            hr.evaluarPersonal(hr.buscarPersonal("E002"), 78);
            hr.evaluarPersonal(hr.buscarPersonal("E004"), 85);
            System.out.println();
        } catch (PersonalNoEncontradoException | CalificacionInvalidaException e) {
            System.err.println("❌ Error: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 9: Mostrar historial de evaluaciones (orden inserción)
        // ============================================================
        System.out.println("--- Caso 9: Historial de Evaluaciones ---");
        hr.mostrarEvaluaciones();

        // ============================================================
        // CASO 10: Nómina completa
        // ============================================================
        System.out.println("\n--- Caso 10: Nómina Completa ---");
        hr.mostrarNomina();

        // ============================================================
        // CASO 11: Estadísticas del sistema
        // ============================================================
        System.out.println("\n--- Caso 11: Estadísticas ---");
        Map<String, Object> stats = hr.obtenerEstadisticas();
        System.out.println("Total de personal: " + stats.get("total"));
        System.out.println("Personal de planta: " + stats.get("planta"));
        System.out.println("Personal por contrato: " + stats.get("contrato"));
        System.out.println(String.format("Antigüedad promedio: %.2f años", stats.get("antiguedadPromedio")));

        // ============================================================
        // CASO 12: Demostración de Collections.sort con lambda
        // ============================================================
        System.out.println("\n--- Caso 12: Ordenamiento con Lambda (Java 8+) ---");
        List<PersonalAbstract> listaTemporal = new ArrayList<>(hr.listarPorID());
        
        // Ordenar por salario base (menor a mayor)
        listaTemporal.sort((p1, p2) -> Double.compare(p1.getSalarioBase(), p2.getSalarioBase()));
        System.out.println("Ordenado por salario BASE (menor a mayor):");
        posicion = 1;
        for (PersonalAbstract p : listaTemporal) {
            System.out.println(posicion++ + ". " + p.getNombre() + " - Base: $" + String.format("%.2f", p.getSalarioBase()));
        }

        System.out.println("\n✅ Programa finalizado correctamente.");
        System.out.println("📊 Resumen: " + hr.cantidadPersonal() + " personas en el sistema.");
        System.out.println("\n=== COLECCIONES USADAS ===");
        System.out.println("✓ HashMap<String, PersonalAbstract> - Búsqueda O(1) por ID");
        System.out.println("✓ TreeSet<PersonalAbstract> - Ordenamiento automático por salario");
        System.out.println("✓ LinkedHashMap<String, Integer> - Evaluaciones con orden de inserción");
        System.out.println("✓ ArrayList<PersonalAbstract> - Listas temporales para ordenamiento");
        System.out.println("\n=== COMPARADORES USADOS ===");
        System.out.println("✓ Comparable<PersonalAbstract> - Orden natural por salario");
        System.out.println("✓ ComparadorPorNombre - Orden alfabético por nombre");
        System.out.println("✓ ComparadorPorID - Orden lexicográfico por ID");
        System.out.println("✓ Lambda (p1, p2) -> ... - Ordenamiento inline");
    }
}

