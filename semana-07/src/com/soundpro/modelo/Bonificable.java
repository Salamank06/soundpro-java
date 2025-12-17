package com.soundpro.modelo;

/**
 * Interfaz que define el contrato para aplicar bonificaciones.
 * Permite bonos porcentuales y montos fijos.
 */
public interface Bonificable {
    double aplicarBono(double porcentaje);
    double aplicarBonoFijo(double monto);
}

