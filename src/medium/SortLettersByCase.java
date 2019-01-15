package medium;


/**
 *
 * Given a string which contains only letters. Sort it by lower case first and upper case second.
 *
 * Example
 * For "abAcD", a reasonable answer is "acbAD"
 *
 */
public class SortLettersByCase {

    public static void main(String[] args) {
        String s = "abcccDDDccc";
        char[] arr = s.toCharArray();
        print(arr);
        new SortLettersByCase().sortLetters(arr);
        print(arr);

    }

    public static void print(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        if (chars.length == 0) {
            return;
        }
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while(left < right && chars[left] >= 'a' && chars[left] <= 'z') {
                left++;
            }
            while(left < right && chars[right] >= 'A' && chars[right] <= 'Z') {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
    }

}
