package medium;

/**
 * Search
 * TODO 自动生成的注释，需修改
 *
 * @author jinxin
 */
public class Search {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (target < nums[0] && target > nums[len - 1]) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (target == nums[left]) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new Search().search(testArr, target));
    }

}
