package com.soundpro.modelo;

import com.soundpro.excepciones.SalarioInvalidoException;

/**
 * Clase abstracta que representa el personal de SoundPro.
 * Define atributos y comportamientos comunes para todo el personal.
 * Implementa Comparable para ordenamiento natural por salario.
 */
public abstract class PersonalAbstract implements Comparable<PersonalAbstract> {
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
    public double getSalarioBase() { return salarioBase; }

    /**
     * Comparación natural por salario calculado (de mayor a menor).
     */
    @Override
    public int compareTo(PersonalAbstract otro) {
        return Double.compare(otro.calcularSalario(), this.calcularSalario());
    }

    @Override
    public String toString() {
        return String.format("%s [%s] - $%.2f", nombre, identificacion, calcularSalario());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonalAbstract that = (PersonalAbstract) obj;
        return identificacion.equals(that.identificacion);
    }

    @Override
    public int hashCode() {
        return identificacion.hashCode();
    }
}

