package top_liked.medium;

/**
 * 11. Container With Most Water
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        var s = new ContainerWithMostWater();
        System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            if (h * w > result) {
                result = h * w;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
