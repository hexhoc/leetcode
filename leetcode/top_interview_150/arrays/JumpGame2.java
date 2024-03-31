package top_interview_150.arrays;

/*
45. Jump Game II
Medium
 */
public class JumpGame2 {

    public static void main(String[] args) {
        var s = new JumpGame2();
        System.out.println(s.jump(new int[]{3,2,1,0,4}));
        System.out.println(s.jump(new int[]{9,7,9,4,8,1,6,1,5,6,2,1,7,9,0}));
        System.out.println(s.jump(new int[]{1,2,3}));
        System.out.println(s.jump(new int[]{2,1}));
        System.out.println(s.jump(new int[]{1,1,1,1}));
        System.out.println(s.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
        System.out.println(s.jump(new int[]{2,3,0,1,4}));
        System.out.println(s.jump(new int[]{2,5,0,0}));
        System.out.println(s.jump(new int[]{0}));
    }

    public int jump(int[] nums) {

        int position = 0;
        int maxPosition = Math.min(position + nums[position], nums.length-1);
        int jump = 0;

        while (maxPosition > 0) {
            int newMaxPosition = 0;
            if (maxPosition < nums.length-1) {
                // find new max position
                for (int i = position + 1; i <= maxPosition; i++) {
                    if (i + nums[i] > newMaxPosition) {
                        position = i;
                        newMaxPosition = Math.min(i + nums[i], nums.length - 1);
                    }
                }
            }
            // jump to new position
            if (newMaxPosition == 0 && maxPosition < nums.length-1) {
                jump = 0;
            } else {
                jump++;
            }

            maxPosition = newMaxPosition;

        }
        
        return jump;
    }

}
