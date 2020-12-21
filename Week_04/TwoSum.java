import java.util.HashMap;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-12-21 23:10
 */
public class TwoSum {

    // 暴力解法
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] ==  target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
    // 过遍数
    // 哈希表
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int complement;
        for(int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }


}
