package com.soundpro.modelo;

import com.soundpro.excepciones.CalificacionInvalidaException;

/**
 * Interfaz que define el contrato para entidades evaluables.
 * Permite asignar calificaciones y determinar el nivel de desempeño.
 */
public interface Evaluable {
    void setCalificacion(int calificacion) throws CalificacionInvalidaException;
    int getCalificacion();
    String nivel();
}

