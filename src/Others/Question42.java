package Others;

public class Question42 {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int sum = 0;
        int level = 1;
        while (l < r) {
            if (height[l] < level) {
                l++;
                continue;
            }
            if (height[r] < level) {
                r--;
                continue;
            }
            sum += r - l + 1;
            level++;
        }
        for (int j : height) {
            if (j < level) {
                sum -= j;
            } else {
                sum -= level - 1;
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1, sum = 0;
        int leftMax = height[l], rightMax = height[r];
        while (l < r) {
            if (leftMax <= rightMax) {
                l++;
                if (height[l] > leftMax) {
                    leftMax = height[l];
                }
                sum += leftMax - height[l];
            }else{
                r--;
                if (height[r] > rightMax) {
                    rightMax = height[r];
                }
                sum += rightMax - height[r];
            }
        }
        return sum;
    }

        public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        Question42 a = new Question42();
        System.out.println(a.trap2(height));
    }
}
