class Solution {
    public int trap(int[] height) {
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];
        leftHeight[0] = height[0];
        rightHeight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length - 1; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
            rightHeight[height.length - i - 1] = Math.max(rightHeight[height.length-i], height[height.length - i - 1]);
        }
        int storedWater = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int val = Math.min(leftHeight[i - 1], rightHeight[i + 1]);
            if (val > height[i]) {
                storedWater += (val - height[i]);
            }
        }
        return storedWater;
    }
}
