package fr.esiea;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class MaximumPath {

    Pyramid pyramid;

    public MaximumPath(String s) {
        pyramid = new Pyramid(s);

    }

    public int maximum() {
        List<Integer> path = maxPath(0,0);
        return path.stream().reduce((i, i2) -> i + i2).get();
    }

    private List<Integer> maxPath(int lineIndex, int position) {

        List<Integer> bestPossiblePath = new ArrayList<>();
        bestPossiblePath.add(pyramid.getElement(lineIndex, position).value);

        if(lineIndex >= pyramid.getHeight()-1) return bestPossiblePath;

        List<Integer> maxPath1 = maxPath(lineIndex+1, position);
        List<Integer> maxPath2 = maxPath(lineIndex+1, position+1);

        bestPossiblePath.addAll(bestBetween(maxPath1, maxPath2));

        return bestPossiblePath;
    }

    private Collection<? extends Integer> bestBetween(List<Integer> maxPath1, List<Integer> maxPath2) {
        int sum1 = maxPath1.stream().reduce((acc, valeur) -> acc+valeur).get();
        int sum2 = maxPath2.stream().reduce((integer, integer2) -> integer+integer2).get();

        if(sum1 > sum2) {
            return maxPath1;
        } else {
            return maxPath2;
        }
    }


    public String maximumPath() {
        return maxPath(0, 0).stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
