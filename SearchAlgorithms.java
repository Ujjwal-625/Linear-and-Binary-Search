import java.util.Arrays;

public class SearchAlgorithms {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        int missingPositive = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missingPositive);

        Arrays.sort(nums); // Sort before binary search
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }

    // Linear Search for First Missing Positive
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // Binary Search for Target Index
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}