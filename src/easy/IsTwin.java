package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given two strings s and t, each time you can exchange the characters on the odd or even bits of s,
 * that is, the characters on the odd bits can be swaped with the characters of other odd bits,
 * and even bits characters can be swaped with other even bits characters.
 * Ask if you can exchange s to t after several exchanges.
 */
public class IsTwin {

    public static void main(String[] args) {
        System.out.println(new IsTwin().isTwin2("abcd", "cbad"));
    }

    /**
     * @param s: the first string
     * @param t: the second string
     * @return: If they are twin strings
     */
    public String isTwin(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return "No";
        }

        List<Character> oddList = new ArrayList<>();
        List<Character> evenList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                evenList.add(s.charAt(i));
            } else {
                oddList.add(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (i % 2 == 0) {
                if (evenList.contains(t.charAt(i))) {
                    evenList.remove((Character) t.charAt(i));
                } else {
                    return "No";
                }
            } else {
                if (oddList.contains(t.charAt(i))) {
                    oddList.remove((Character)t.charAt(i));
                } else {
                    return "No";
                }
            }
        }

        if (evenList.size() == 0 && oddList.size() == 0) {
            return "Yes";
        }

        return "No";
    }

    public String isTwin2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return "No";
        }

        Map<Character, Integer> oddMap = new HashMap<>();
        Map<Character, Integer> evenMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (evenMap.containsKey(s.charAt(i))) {
                    evenMap.put(s.charAt(i), evenMap.get(s.charAt(i)) + 1);
                } else {
                    evenMap.put(s.charAt(i), 1);
                }
            } else {
                if (oddMap.containsKey(s.charAt(i))) {
                    oddMap.put(s.charAt(i), oddMap.get(s.charAt(i)) + 1);
                } else {
                    oddMap.put(s.charAt(i), 1);
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (i % 2 == 0) {
                if (!evenMap.containsKey(t.charAt(i)) || evenMap.get(t.charAt(i)) == 0) {
                    return "No";
                } else {
                    evenMap.put(t.charAt(i), evenMap.get(t.charAt(i)) - 1);
                }
            } else {
                if (!oddMap.containsKey(t.charAt(i)) || oddMap.get(t.charAt(i)) == 0) {
                    return "No";
                } else {
                    oddMap.put(t.charAt(i), oddMap.get(t.charAt(i)) - 1);
                }
            }
        }

        for (Character c : evenMap.keySet()) {
            if (evenMap.get(c) != 0) {
                return "No";
            }
        }
        for (Character c : oddMap.keySet()) {
            if (oddMap.get(c) != 0) {
                return "No";
            }
        }
        return "Yes";
    }


}
