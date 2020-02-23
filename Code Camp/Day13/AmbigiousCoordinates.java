// Question link : https://leetcode.com/problems/ambiguous-coordinates/

import java.util.ArrayList;
import java.util.List;

public class AmbigiousCoordinates {

    public static void main(String[] args) {
        System.out.println(new AmbigiousCoordinates().ambiguousCoordinates("(100100123)"));
    }

    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1,s.length()-1);
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String leftString = s.substring(0, i);
            String rightString = s.substring(i);

            List<String> left = getValidCombinations(leftString);
            List<String> right = getValidCombinations(rightString);

            for (String lCoord : left) {
                for (String rCoord : right) {
                    String coordinate = "(" + lCoord + ", " + rCoord + ")";
                    System.out.println("coordinate is " + coordinate);
                    answer.add(coordinate);
                }
            }

        }
        return answer;

    }

    private List<String> getValidCombinations(String s) {
        ArrayList<String> validCombinations = new ArrayList<>();
        if (validateCoordinate(s, false)) {
            validCombinations.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String coord = s.substring(0, i) + "." + s.substring(i);
            if (validateCoordinate(coord, true)) {
                validCombinations.add(coord);
            }
        }
        return validCombinations;
    }

    private boolean validateCoordinate(String s, boolean isDotted) {
        if (s.length() == 1) {
            return true;
        }
        if (isDotted) {
            if (s.endsWith("0") || (s.startsWith("0"))) {
                return false;
            }
            return true;
        } else {
            if (s.startsWith("0")) {
                return false;
            }
            return true;
        }
    }

}
