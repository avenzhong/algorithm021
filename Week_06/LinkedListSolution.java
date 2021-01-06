import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2021-01-06 22:47
 */
public class LinkedListSolution {

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }

    // 用set集合来装节点，遇到重复的就证明有环
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

