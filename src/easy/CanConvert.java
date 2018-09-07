package easy;


/**
 * Given two string S and T, determine if S can be changed to T by deleting some letters (including 0 letter)
 *
 * "adcadcadcdaac"
 * "adddaa"
 * return false
 */
public class CanConvert {

    /**
     * @param s: string S
     * @param t: string T
     * @return: whether S can convert to T
     */
    public boolean canConvert(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return false;
        }

        //start index of substring
        int subIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            String subString = s.substring(subIndex);
            if (subString.indexOf(c) > -1) {
                subIndex += subString.indexOf(c) + 1;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean canConvert2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return false;
        }
        //index of S
        int i = 0;
        //index of T
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(j)){
                j++;
            }
            i++;

            if (j == t.length()) {
                return true;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        System.out.println(new CanConvert().canConvert2("adcadcadcdac", "adddaa"));
        System.out.println(new CanConvert().canConvert2("abbbaa", "aba"));
    }
}
