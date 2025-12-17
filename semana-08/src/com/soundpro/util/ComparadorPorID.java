package com.soundpro.util;

import com.soundpro.modelo.PersonalAbstract;
import java.util.Comparator;

/**
 * Comparador que ordena personal por ID (orden lexicográfico).
 */
public class ComparadorPorID implements Comparator<PersonalAbstract> {
    
    @Override
    public int compare(PersonalAbstract p1, PersonalAbstract p2) {
        return p1.getIdentificacion().compareTo(p2.getIdentificacion());
    }
}

