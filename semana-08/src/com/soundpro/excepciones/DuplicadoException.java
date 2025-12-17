package com.soundpro.excepciones;

/**
 * Excepción lanzada cuando se intenta agregar personal con ID duplicado.
 * Garantiza unicidad de identificaciones en el sistema.
 */
public class DuplicadoException extends Exception {
    
    public DuplicadoException(String mensaje) {
        super(mensaje);
    }

    public DuplicadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

