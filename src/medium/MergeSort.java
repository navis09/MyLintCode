package medium;

import static easy.Sorting.print;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,6,5,3,1,8,2,3,4,5,2,-1,-2,344};
        print(nums);
        new MergeSort().mergeSort(nums);
        print(nums);
    }

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int leftStart = left;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = right;
        int index = 0;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (nums[leftStart] <= nums[rightStart]) {
                temp[index++] = nums[leftStart++];
            } else {
                temp[index++] = nums[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            temp[index++] = nums[leftStart++];
        }
        while (rightStart <= rightEnd) {
            temp[index++] = nums[rightStart++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
        print(nums);

    }

}
