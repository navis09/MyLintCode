package easy;

/**
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *  <p>
 *  数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *  <p>
 *  示例:
 *  <p>
 *  输入:
 *  letters = ["c", "f", "j"]
 *  target = "a"
 *  输出: "c"
 *  <p>
 *  输入:
 *  letters = ["c", "f", "j"]
 *  target = "c"
 *  输出: "f"
 *  <p>
 *  输入:
 *  letters = ["c", "f", "j"]
 *  target = "d"
 *  输出: "f"
 *  <p>
 *  输入:
 *  letters = ["c", "f", "j"]
 *  target = "g"
 *  输出: "j"
 *  <p>
 *  输入:
 *  letters = ["c", "f", "j"]
 *  target = "j"
 *  输出: "c"
 *  <p>
 *  输入:
 *  letters = ["c", "f", "j"]
 *  target = "k"
 *  输出: "c"
 *  注:
 *  <p>
 *  letters长度范围在[2, 10000]区间内。
 *  letters 仅由小写字母组成，最少包含两个不同的字母。
 *  目标字母target 是一个小写字母。
 *  <p>
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 */
public class NextGreatestLetter {

    public char nextGreatestLetter (char[] sortedArr, char target) {
        for (char letter : sortedArr) {
            if (letter > target) {
                return letter;
            }
        }
        return sortedArr[0];
    }

    public static void main(String[] args) {
        char[] sortedArr = new char[]{'c', 'f', 'j'};
        char target = 'z';
        System.out.println(new NextGreatestLetter().nextGreatestLetter(sortedArr, target));
    }
}
