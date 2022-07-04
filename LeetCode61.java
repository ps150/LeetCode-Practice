package leetcodepractice;
public class LeetCode61
{

   public class ListNode
   {
      int val;

      ListNode next;

      ListNode()
      {
      }

      ListNode(int val)
      {
         this.val = val;
      }

      ListNode(int val, ListNode next)
      {
         this.val = val;
         this.next = next;
      }
   }

   private void printLinkList(ListNode head)
   {
      ListNode temp = head;
      while (temp != null)
      {
         System.out.println(temp.val);
         temp = temp.next;
      }
   }

   public ListNode rotateRight(ListNode head, int k)
   {
      int length = getListLength(head);

      if (length == 0)
         return head;

      int diff = k % length;
      diff = length - diff;
      if (diff < 0)
      {
         diff = k - (diff);
      }

      if (diff == 0)
         return head;

      addTailToHead(head);
      ListNode prev = head;
      ListNode temp = head;
      while (diff > 0)
      {
         prev = temp;
         temp = temp.next;
         diff = diff - 1;
      }
      prev.next = null;
      return temp;

   }

   private int getListLength(ListNode head)
   {
      int count = 0;
      ListNode temp = head;
      while (temp != null)
      {
         temp = temp.next;
         count++;
      }
      return count;
   }

   private void addTailToHead(ListNode aHead)
   {
      ListNode temp = aHead;
      int count = 0;
      while (temp.next != null)
      {
         temp = temp.next;
      }
      count = count + 1;
      temp.next = aHead;
   }

   public static void main(String[] args)
   {

      LeetCode61 soln = new LeetCode61();
      ListNode l1 = soln.new ListNode(5, null);
      ListNode l2 = soln.new ListNode(4, l1);
      ListNode l3 = soln.new ListNode(3, l2);
      ListNode l4 = soln.new ListNode(2, l3);
      ListNode head = soln.new ListNode(1, l4);

      soln.printLinkList(head);

      System.out.println("After rotation of LinkedList");
      ListNode temproryNode = soln.rotateRight(head, 0);

      soln.printLinkList(temproryNode);
   }

}
