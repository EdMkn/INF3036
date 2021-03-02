package fr.esiea;

import java.util.Collections;
import java.util.List;

public class Element {
    Integer value = null;
    Integer maximum = 0;
    List<Element> maxPath = Collections.emptyList();

    public Element(String value) {
        this.value = Integer.valueOf(value);
    }
}
