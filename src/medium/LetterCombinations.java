package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LetterCombinations
 * TODO 自动生成的注释，需修改
 *
 * @author jinxin
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        int len = digits.length();
        Queue<String> queue= new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = digits.charAt(i);
            List<String> characters = numberToLetter(c);
            if (queue.isEmpty()) {
                queue.addAll(characters);
                continue;
            }
            while (queue.peek().length() != i + 1) {
                String letters = queue.poll();
                for (String str : characters) {
                    queue.add(letters + str);
                }
            }
        }
        list.addAll(queue);
        return list;
    }

    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while(true) {
                String s = list.get(0);
                if (s.length() == i + 1) {
                    break;
                }
                list.remove(0);
                list.addAll(combine(s, num));
            }

        }
        return list;
    }

    private List<String> combine(String s, int num) {
        List<String> list = new ArrayList<>();
        String toCombine = arr[num];
        for (int i = 0; i < toCombine.length(); i++) {
            list.add(s + toCombine.charAt(i));
        }
        return list;
    }

    private List<String> numberToLetter(char number) {
        List<String> list = new LinkedList<>();
        if (number == '2') {
            list.add("a");
            list.add("b");
            list.add("c");
        } else if (number == '3') {
            list.add("d");
            list.add("e");
            list.add("f");
        } else if (number == '4') {
            list.add("g");
            list.add("h");
            list.add("i");
        } else if (number == '5') {
            list.add("j");
            list.add("k");
            list.add("l");
        } else if (number == '6') {
            list.add("m");
            list.add("n");
            list.add("o");
        } else if (number == '7') {
            list.add("p");
            list.add("q");
            list.add("r");
            list.add("s");
        } else if (number == '8') {
            list.add("t");
            list.add("u");
            list.add("v");
        } else if (number == '9') {
            list.add("w");
            list.add("x");
            list.add("y");
            list.add("z");
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
        System.out.println(new LetterCombinations().letterCombinations2("23"));
    }

}
