package com.soundpro.modelo;

import com.soundpro.excepciones.SalarioInvalidoException;
import com.soundpro.excepciones.CalificacionInvalidaException;

/**
 * Representa personal de planta con contrato indefinido.
 * Incluye bonificación por años de antigüedad.
 */
public class PersonalPlanta extends PersonalAbstract implements Evaluable, Bonificable {
    private int anosAntiguedad;
    private int calificacion;

    public PersonalPlanta(String nombre, String id, double salario, int anos) 
            throws SalarioInvalidoException {
        super(nombre, id, salario);
        if (anos < 0) {
            throw new IllegalArgumentException("Los años de antigüedad no pueden ser negativos");
        }
        this.anosAntiguedad = anos;
    }

    @Override
    public double calcularSalario() {
        double bono = salarioBase * 0.05 * anosAntiguedad;
        return salarioBase + bono;
    }

    @Override
    public String obtenerDescripcion() { 
        return "Planta, años: " + anosAntiguedad; 
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
        return calificacion >= 90 ? "Excelente" : calificacion >= 70 ? "Bueno" : "Mejorable"; 
    }

    @Override
    public double aplicarBono(double porcentaje) { 
        return calcularSalario() * (1.0 + porcentaje / 100.0); 
    }

    @Override
    public double aplicarBonoFijo(double monto) { 
        return calcularSalario() + monto; 
    }

    public int getAnosAntiguedad() { return anosAntiguedad; }
}

