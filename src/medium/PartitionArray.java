package medium;


/**
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 * Example
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 *
 */
public class PartitionArray {


    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] < k) {
                left++;
            }
            while (right > left && nums[right] >= k) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }
        if (nums[left] >= k) {
            return left;
        }
        return left + 1;
    }
}
