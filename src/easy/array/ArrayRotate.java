package easy.array;

/**
 * ArrayRotate
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * @author jinxin
 */
public class ArrayRotate {

    /**
     * Method 1
     * Every time rotate one step to the right, and rotate k times
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int rotateLen = k % len;
        if (rotateLen == 0) {
            return;
        }
        while(rotateLen != 0) {
            int temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            rotateLen--;
        }
    }

    /**
     * Method 2
     * 1. Rotate the whole array
     * 2. Rotate array from index 0 to k-1, and k-1 to the end.
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int rotateLen = k % len;
        if (rotateLen == 0) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, rotateLen - 1);
        reverse(nums, rotateLen, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
