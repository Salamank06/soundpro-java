package com.soundpro.modelo;

import com.soundpro.excepciones.SalarioInvalidoException;
import com.soundpro.excepciones.CalificacionInvalidaException;

/**
 * Representa personal con contrato temporal.
 * No incluye bonificación por antigüedad.
 */
public class PersonalContrato extends PersonalAbstract implements Evaluable, Bonificable {
    private int mesesContrato;
    private int calificacion;

    public PersonalContrato(String nombre, String id, double salario, int meses) 
            throws SalarioInvalidoException {
        super(nombre, id, salario);
        if (meses <= 0) {
            throw new IllegalArgumentException("Los meses de contrato deben ser positivos");
        }
        this.mesesContrato = meses;
    }

    @Override
    public double calcularSalario() { 
        return salarioBase; 
    }

    @Override
    public String obtenerDescripcion() { 
        return "Contrato, meses: " + mesesContrato; 
    }

    @Override
    public void setCalificacion(int calificacion) throws CalificacionInvalidaException {
        if (calificacion < 0 || calificacion > 100) {
            throw new CalificacionInvalidaException(calificacion);
        }
        this.calificacion = calificacion;
    }

    @Override
    public int getCalificacion() { return calificacion; }

    @Override
    public String nivel() { 
        return calificacion >= 85 ? "Bueno" : "Mejorable"; 
    }

    @Override
    public double aplicarBono(double porcentaje) { 
        return calcularSalario() * (1.0 + porcentaje / 100.0); 
    }

    @Override
    public double aplicarBonoFijo(double monto) { 
        return calcularSalario() + monto; 
    }
}

