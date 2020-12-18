import java.util.HashMap;

/**
 * @description
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhongwenjian
 * @create: 2020-12-18 23:59
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 1;
        // 由于多数元素个数大于n/2,所以maj的count会一直大于0
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                maj = nums[i];
            } else if (maj == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return maj;
    }

    // 哈希表方法
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                map.replace(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i]) > n/2) return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }
}
