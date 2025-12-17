package com.soundpro.util;

import com.soundpro.modelo.PersonalAbstract;
import java.util.Comparator;

/**
 * Comparador que ordena personal por nombre alfabéticamente (A-Z).
 */
public class ComparadorPorNombre implements Comparator<PersonalAbstract> {
    
    @Override
    public int compare(PersonalAbstract p1, PersonalAbstract p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}

