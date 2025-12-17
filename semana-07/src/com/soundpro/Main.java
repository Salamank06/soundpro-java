package com.soundpro;

import com.soundpro.modelo.*;
import com.soundpro.servicio.SoundProHR;
import com.soundpro.excepciones.*;

/**
 * Clase principal que demuestra el manejo de excepciones en SoundPro.
 * Incluye casos de éxito y error para validar el sistema.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOUNDPRO - SEMANA 07: PAQUETES Y EXCEPCIONES ===\n");

        SoundProHR hr = new SoundProHR();

        // ============================================================
        // CASO 1: Crear personal válido ✅
        // ============================================================
        System.out.println("--- Caso 1: Crear Personal Válido ---");
        try {
            PersonalPlanta ana = new PersonalPlanta("Ana García", "E001", 2000000, 5);
            hr.agregarPersonal(ana);

            PersonalContrato luis = new PersonalContrato("Luis Martínez", "E002", 1500000, 6);
            hr.agregarPersonal(luis);

            PersonalPlanta maria = new PersonalPlanta("María López", "E003", 2500000, 3);
            hr.agregarPersonal(maria);

            System.out.println("✅ Personal creado exitosamente\n");
        } catch (SalarioInvalidoException e) {
            System.err.println("❌ Error: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 2: Intentar crear personal con salario negativo ❌
        // ============================================================
        System.out.println("--- Caso 2: Salario Negativo (Debe Fallar) ---");
        try {
            PersonalPlanta invalido = new PersonalPlanta("Pedro Inválido", "E004", -500000, 2);
            hr.agregarPersonal(invalido);
            System.out.println("✅ Personal creado\n");
        } catch (SalarioInvalidoException e) {
            System.err.println("❌ Excepción capturada correctamente: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 3: Buscar personal existente ✅
        // ============================================================
        System.out.println("--- Caso 3: Buscar Personal Existente ---");
        try {
            PersonalAbstract encontrado = hr.buscarPersonal("E002");
            System.out.println("✓ Encontrado: " + encontrado.getNombre());
            System.out.println("  Salario: $" + String.format("%.2f", encontrado.calcularSalario()) + "\n");
        } catch (PersonalNoEncontradoException e) {
            System.err.println("❌ Error: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 4: Buscar personal inexistente ❌
        // ============================================================
        System.out.println("--- Caso 4: Buscar Personal Inexistente (Debe Fallar) ---");
        try {
            PersonalAbstract noExiste = hr.buscarPersonal("E999");
            System.out.println("✓ Encontrado: " + noExiste.getNombre() + "\n");
        } catch (PersonalNoEncontradoException e) {
            System.err.println("❌ Excepción capturada correctamente: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 5: Evaluaciones válidas ✅
        // ============================================================
        System.out.println("--- Caso 5: Evaluaciones Válidas ---");
        try {
            PersonalAbstract ana = hr.buscarPersonal("E001");
            hr.evaluarPersonal(ana, 92);

            PersonalAbstract luis = hr.buscarPersonal("E002");
            hr.evaluarPersonal(luis, 80);

            PersonalAbstract maria = hr.buscarPersonal("E003");
            hr.evaluarPersonal(maria, 75);

            System.out.println();
        } catch (PersonalNoEncontradoException | CalificacionInvalidaException e) {
            System.err.println("❌ Error: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 6: Calificación inválida (fuera de rango) ❌
        // ============================================================
        System.out.println("--- Caso 6: Calificación Inválida (Debe Fallar) ---");
        try {
            PersonalAbstract maria = hr.buscarPersonal("E003");
            hr.evaluarPersonal(maria, 150); // Fuera de rango 0-100
        } catch (PersonalNoEncontradoException e) {
            System.err.println("❌ Personal no encontrado: " + e.getMessage() + "\n");
        } catch (CalificacionInvalidaException e) {
            System.err.println("❌ Excepción capturada correctamente: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 7: Calificación negativa ❌
        // ============================================================
        System.out.println("--- Caso 7: Calificación Negativa (Debe Fallar) ---");
        try {
            PersonalAbstract ana = hr.buscarPersonal("E001");
            hr.evaluarPersonal(ana, -10);
        } catch (PersonalNoEncontradoException | CalificacionInvalidaException e) {
            System.err.println("❌ Excepción capturada correctamente: " + e.getMessage() + "\n");
        }

        // ============================================================
        // CASO 8: Finally - Mostrar nómina (siempre se ejecuta)
        // ============================================================
        System.out.println("--- Caso 8: Nómina Final (con Finally) ---");
        PersonalAbstract temp = null;
        try {
            temp = new PersonalPlanta("Temporal", "E099", 1800000, 1);
            hr.agregarPersonal(temp);
            System.out.println("✓ Personal temporal agregado\n");
        } catch (SalarioInvalidoException e) {
            System.err.println("❌ Error: " + e.getMessage());
        } finally {
            // Finally SIEMPRE se ejecuta (con o sin excepción)
            System.out.println("🔒 Bloque finally ejecutado: Generando reporte...");
            hr.mostrarNomina();
        }

        System.out.println("\n✅ Programa finalizado correctamente.");
        System.out.println("📊 Total de personal registrado: " + hr.cantidadPersonal());
    }
}

