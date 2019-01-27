package easy;


/**
 *
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 *
 * Example
 * Example1:
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * Example2:
 * Given the array [1,2,3,4], the contiguous subarray [1,2,3,4] has the largest sum = 10.
 *
 */
public class MaximumSubarray {

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return 0;
        }
        //max记录全局最大值，sum记录前i个数的和，minSum记录前i个数中0-k的最小值
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }

    public int maxSubArrayGreedy(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        //max记录全局最大值，sum记录区间和，如果当前sum>0，那么可以继续和后面的数求和，否则就从0开始
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArrayGreedy(new int[]{-3,-1,-2,-4,-5}));
    }

}
