package com.soundpro.excepciones;

/**
 * Excepción lanzada cuando una calificación está fuera del rango válido (0-100).
 * Se utiliza en el proceso de evaluación de personal.
 */
public class CalificacionInvalidaException extends Exception {
    
    public CalificacionInvalidaException(int calificacion) {
        super("Calificación inválida: " + calificacion + ". Debe estar entre 0 y 100.");
    }

    public CalificacionInvalidaException(String mensaje) {
        super(mensaje);
    }

    public CalificacionInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

