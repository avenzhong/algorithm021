package Week_02;

import java.util.HashMap;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-12-13 00:08
 */
public class TwoSum {

    // 暴力解法
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return new int[0];
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    // 哈希表解法
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> cache = new HashMap<>();
        cache.get(1);
        for(int i = 0; i < nums.length; i++) {
            // 用一个变量complement存储目标与当前值的差值
            int complement = target -  nums[i] ;
            // 判断complement是否存到哈希表过
            if(cache.containsKey(complement)) {
                return new int[]{cache.get(complement),i};
            }
            // 将当前的值作为key存入哈希表
            cache.put(nums[i], i);
        }
        return new int[2];
    }
}
