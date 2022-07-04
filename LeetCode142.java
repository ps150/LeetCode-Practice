package leetcodepractice;

public class LeetCode142
{
   class ListNode
   {
      int val;

      ListNode next;

      ListNode(int x)
      {
         val = x;
         next = null;
      }
   }

   public ListNode detectCycle(ListNode head)
   {
      ListNode slowPtr = null;
      ListNode fastPtr = head;

      while (fastPtr != null && fastPtr.next != null && fastPtr != slowPtr)
      {
         fastPtr = fastPtr.next.next;
         if (slowPtr == null)
            slowPtr = head;
         slowPtr = slowPtr.next;
      }
      if (fastPtr != null && fastPtr.next == null)
         return null;

      slowPtr = head;

      while (fastPtr != null && fastPtr != slowPtr)
      {
         fastPtr = fastPtr.next;
         slowPtr = slowPtr.next;
      }

      return fastPtr;
   }

   public static void main(String[] args)
   {
      LeetCode142 soln = new LeetCode142();
      ListNode head = soln.new ListNode(3);
      ListNode node1 = soln.new ListNode(2);
      ListNode node2 = soln.new ListNode(0);
      ListNode node3 = soln.new ListNode(-4);
      head.next = node1;
      node1.next = node2;
      node2.next = node3;
      node3.next = node1;

      ListNode cycleNode = soln.detectCycle(head);
      System.out.println(cycleNode.val);
   }

}
