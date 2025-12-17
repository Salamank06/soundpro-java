package com.soundpro.modelo;

import com.soundpro.excepciones.SalarioInvalidoException;

/**
 * Clase abstracta que representa el personal de SoundPro.
 * Define atributos y comportamientos comunes para todo el personal.
 */
public abstract class PersonalAbstract {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;

    public PersonalAbstract(String nombre, String identificacion, double salarioBase) 
            throws SalarioInvalidoException {
        if (salarioBase < 0) {
            throw new SalarioInvalidoException("El salario base no puede ser negativo.", salarioBase);
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación no puede estar vacía");
        }
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }

    public void mostrarInfo() {
        System.out.println("Personal: " + nombre + " | ID: " + identificacion);
    }

    public abstract double calcularSalario();
    public abstract String obtenerDescripcion();

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
}

