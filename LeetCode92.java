package leetcodepractice;
public class LeetCode92
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

   public ListNode reverseBetween(ListNode head, int m, int n)
   {
      ListNode mNode = head;
      ListNode mPrevNode = null;
      int c = m;
      while (mNode != null && m > 1)
      {
         mPrevNode = mNode;
         mNode = mNode.next;
         m--;
      }

      ListNode temp = mNode;
      ListNode previousNode = null;
      ListNode currentNode = mNode;

      n = n - c + 1;
      while (currentNode != null && n >= 1)
      {
         ListNode nextNode = currentNode.next;
         currentNode.next = previousNode;
         previousNode = currentNode;
         currentNode = nextNode;
         n--;
      }
      
      temp.next = currentNode;
      if (mPrevNode != null)
         mPrevNode.next = previousNode;
      else
         head = previousNode;

      return head;
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

   public static void main(String[] args)
   {

      LeetCode92 soln = new LeetCode92();
      ListNode l3 = soln.new ListNode(5);
      ListNode l4 = soln.new ListNode(4, l3);
      ListNode l5 = soln.new ListNode(3, l4);
      ListNode l6 = soln.new ListNode(2, l5);
      ListNode head = soln.new ListNode(1, l6);
      soln.printLinkList(head);
      System.out.println("Reverse link list");
      soln.printLinkList(soln.reverseBetween(head, 2, 4));
   }

}
