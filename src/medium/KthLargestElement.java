package medium;


import static easy.Sorting.print;

/**
 * Find K-th largest element in an array.
 *
 *
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 *
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 *
 * Challenge
 * O(n) time, O(1) extra memory.
 */
public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = new int[]{9,3,2,4,8,5,3,2,21,54,5};
        print(nums);
        System.out.println(new KthLargestElement().kthLargestElement(3, nums));
        print(nums);
    }

    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        return partition(nums, n - 1, 0, nums.length - 1);
    }

    private int partition(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int pivot = nums[left + (right - left) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if (right >= k && start <= right)
            return partition(nums, k, start, right);
        else if (left <= k && left <= end)
            return partition(nums, k, left, end);
        else
            return nums[k];


    }

}
