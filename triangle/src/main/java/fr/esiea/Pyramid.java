package fr.esiea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pyramid {
    private List<Line> pyramid = new ArrayList<>();

    public Pyramid(String s) {
        String[] elements = s.split(" ");

        int nbElementsOnLine = 1;
        int position = 0;

        while (position < elements.length) {
            Line l = new Line(Arrays.copyOfRange(elements, position, position + nbElementsOnLine));
            //System.out.println("position = " + position + ", positionFin=" + (position + nbElementsOnLine));
            position += nbElementsOnLine;
            nbElementsOnLine++;
            //System.out.println(position);
            pyramid.add(l);
        }
    }

    public int getHeight() {
        return pyramid.size();
    }

    public Element getElement(int lineIndex, int position) {
        return pyramid.get(lineIndex).getElement(position);
    }
}
