package com.soundpro.excepciones;

/**
 * Excepción lanzada cuando un salario no cumple con los requisitos mínimos.
 * Un salario inválido puede ser negativo o estar fuera del rango permitido.
 */
public class SalarioInvalidoException extends Exception {
    
    public SalarioInvalidoException(String mensaje) {
        super(mensaje);
    }

    public SalarioInvalidoException(String mensaje, double salarioInvalido) {
        super(mensaje + " Valor recibido: $" + String.format("%.2f", salarioInvalido));
    }

    public SalarioInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

