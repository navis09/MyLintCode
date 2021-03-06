package easy;

/**
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,0]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 */
public class PeakIndexInMountainArray {
    /**
     * 转化：二分法找数组最大值下标
     *
     * @param array
     * @return
     */
    public int peakIndexInMountainArray(int[] array) {

        if (array == null || array.length < 3) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                return mid;
            }
            if (array[mid] < array[mid + 1] && array[mid] > array[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2};
        new PeakIndexInMountainArray().peakIndexInMountainArray(arr);
    }
}
