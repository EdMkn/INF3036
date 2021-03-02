package fr.esiea;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    List<Element> elements;

    public Line(String[] elements) {
        this.elements = Arrays.stream(elements).map(Element::new).collect(Collectors.toList());
    }

    public Element getElement(int position) {
        return elements.get(position);
    }

}
