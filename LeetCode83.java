package leetcodepractice;
public class LeetCode83
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

   public ListNode partition(ListNode head, int x)
   {
      if (head == null)
         return head;
      ListNode newHead = findNewhead(head, x);
      ListNode secondpartHead = null;
      ListNode tailNode = null;
      if (newHead != head)
      {
         secondpartHead = head;
      }
      else
      {
         // New head is the old head.
         secondpartHead = head;
         while (secondpartHead != null && secondpartHead.val < x)
         {
            tailNode = secondpartHead;
            secondpartHead = secondpartHead.next;
         }
         if (tailNode != null)
            tailNode.next = null;
      }

      ListNode tempNode = secondpartHead;
      ListNode prevNode = null;
      while (tempNode != null)
      {
         if (tempNode.val < x)
         {
            if (tailNode == null)
            {
               tailNode = tempNode;
               newHead.next = tailNode;
               prevNode.next = tempNode.next;
            }
            else
            {
               tailNode.next = tempNode;
               tailNode = tempNode;
               prevNode.next = tempNode.next;
            }
            tempNode = tempNode.next;
            continue;
         }
         prevNode = tempNode;
         tempNode = tempNode.next;
      }

      if (secondpartHead != null)
      {
         if (tailNode != null)
            tailNode.next = secondpartHead;
         else
         {
            if (newHead != null)
               newHead.next = secondpartHead;
            else
            {
               newHead = secondpartHead;
            }
         }
      }
      return newHead;
   }

   private ListNode findNewhead(ListNode aHead, int aX)
   {
      ListNode temp = aHead;
      ListNode prevNode = null;
      while (temp != null)
      {
         if (temp.val < aX)
         {
            if (prevNode == null)
            {
               // Head it self is smaller
               return temp;
            }
            prevNode.next = temp.next;
            return temp;
         }
         prevNode = temp;
         temp = temp.next;
      }
      return null;
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
      LeetCode83 soln = new LeetCode83();
      // ListNode l1 = soln.new ListNode(7, null);
      // ListNode l2 = soln.new ListNode(6, l1);
      // ListNode l3 = soln.new ListNode(0, l2);
      // ListNode l4 = soln.new ListNode(2, l3);
      // ListNode l5 = soln.new ListNode(4, l4);
      // ListNode l6 = soln.new ListNode(1, l5);
      ListNode head = soln.new ListNode(1);
      soln.printLinkList(head);
      System.out.println("Partition print");
      soln.printLinkList(soln.partition(head, 0));

   }

}
