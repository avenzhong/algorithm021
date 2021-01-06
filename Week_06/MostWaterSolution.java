/**
 * @description
 * @author: zhongwenjian
 * @create: 2021-01-04 12:21
 */
public class MostWaterSolution {

    // 双指针迭代，每次迭代移动值最小的指针
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, t = height.length - 1;
        int area = 0, ans = 0;
        while(left < right) {
            area = Math.min(height[left], height[right]) * t;
            ans = Math.max(ans, area);
            if(height[left] <= height[right]) {
                left++;
            }else {
                right--;
            }
            t--;
        }
        return ans;
    }
}
