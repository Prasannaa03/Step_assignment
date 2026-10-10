import java.util.*;

public class Week04 {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length; int[] answer = new int[n]; int prefix = 1;
        for (int i = 0; i < n; i++) { answer[i] = prefix; prefix *= nums[i]; }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) { answer[i] *= suffix; suffix *= nums[i]; }
        return answer;
    }

    static int maxSubArray(int[] nums) {
        int current = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) { current = Math.max(nums[i], current + nums[i]); best = Math.max(best, current); }
        return best;
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    out.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int lv = nums[left], rv = nums[right];
                    while (left < right && nums[left] == lv) left++;
                    while (left < right && nums[right] == rv) right--;
                } else if (sum < 0) left++; else right--;
            }
        }
        return out;
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>(); freq.put(0, 1);
        int sum = 0, count = 0;
        for (int value : nums) { sum += value; count += freq.getOrDefault(sum - k, 0); freq.put(sum, freq.getOrDefault(sum, 0) + 1); }
        return count;
    }

    static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { int mid = left + (right - left) / 2; if (nums[mid] > nums[right]) left = mid + 1; else right = mid; }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
