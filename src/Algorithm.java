public class Algorithm {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.printf(findMaxSumInNums(nums) + "");
    }

    //求连续子数组的最大和
    private static int findMaxSumInNums(int[] nums) {
        if (nums.length <= 0 || nums == null) {
            return 0;
        }
        int currentMaxNum = 0;
        int historyMaxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentMaxNum <= 0) {
                currentMaxNum = nums[i];
            } else {
                currentMaxNum += nums[i];
            }
            if (currentMaxNum >= historyMaxNum) {
                historyMaxNum = currentMaxNum;
            }
        }
        return historyMaxNum;

    }
}
