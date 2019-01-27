package medium;

import static easy.Sorting.print;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,6,5,3,1,8,2,3,4,5,2,-1,-2,344};
        print(nums);
        new QuickSort().quicksort(nums);
        print(nums);
    }

    public void quicksort(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    private void partition(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;

        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
                System.out.println("pivot: " + pivot);
                print(nums);
            }
        }
        partition(nums, start, right);
        partition(nums, left, end);

    }


}
