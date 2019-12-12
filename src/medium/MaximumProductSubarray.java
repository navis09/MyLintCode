package medium;

/**
 * MaximumProductSubarray
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @author jinxin
 */
public class MaximumProductSubarray {
    /**
     * 遍历求出所有乘积
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int product = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int subProduct = nums[i];
            int maxSubProduct = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                subProduct = subProduct * nums[j];
                if (subProduct > maxSubProduct) {
                    maxSubProduct = subProduct;
                }
            }
            if (maxSubProduct > product) {
                product = maxSubProduct;
            }
        }
        return product;
    }

    /**
     * 动态规划
     * 维护一个正的最大值和负的最小值，判断当前数的符号，若为负，则最大最小值可能会交换
     */
    public int maxProduct2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int product = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            if (max > product) {
                product = max;
            }
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, -1};
        int[] nums2 = new int[]{2,3,-2,4};
        System.out.println(new MaximumProductSubarray().maxProduct2(nums));
        System.out.println(new MaximumProductSubarray().maxProduct2(nums2));
    }
}
