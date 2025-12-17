package com.soundpro.excepciones;

/**
 * Excepción lanzada cuando no se encuentra personal en el sistema.
 * Puede ocurrir al buscar por ID o por otros criterios.
 */
public class PersonalNoEncontradoException extends Exception {
    
    public PersonalNoEncontradoException(String id) {
        super("No se encontró personal con ID: " + id);
    }

    public PersonalNoEncontradoException() {
        super("No se encontró personal con los criterios especificados");
    }

    public PersonalNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

