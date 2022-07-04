package leetcodepractice;
public class LeetCode82
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

   public ListNode deleteDuplicates(ListNode head)
   {
      if (head == null)
         return null;

      ListNode newHead = findNewHead(head);
      if (newHead != null)
      {
         removeDuplicateFromHead(newHead);
      }
      return newHead;
   }

   private void removeDuplicateFromHead(ListNode aNewHead)
   {
      ListNode temp = aNewHead.next;
      ListNode tailNode = null;
      aNewHead.next = tailNode;
      while (temp != null)
      {
         ListNode nextNode = temp.next;
         if (nextNode != null)
         {
            if (nextNode.val != temp.val)
            {
               if (tailNode == null)
               {
                  tailNode = temp;
                  aNewHead.next = tailNode;
               }
               else
               {
                  tailNode.next = temp;
               }
               tailNode = temp;
            }
            else
            {
               int nodeVal = temp.val;
               while (temp != null && temp.val == nodeVal)
               {
                  temp = temp.next;
               }
               continue;
            }
            temp = temp.next;
         }
         else
         {
            if (tailNode == null)
            {
               tailNode = temp;
               aNewHead.next = tailNode;
            }
            else
            {
               tailNode.next = temp;
               tailNode = temp;
            }
            temp = temp.next;
         }
      }
      if (tailNode != null)
         tailNode.next = null;
   }

   private ListNode findNewHead(ListNode aHead)
   {
      int currentNumCount = 1;
      int currentNum = aHead.val;
      ListNode temp = aHead.next;
      if (temp != null && temp.val != aHead.val)
         return aHead;
      if (temp == null)
      {
         return aHead;
      }

      ListNode prevNode = null;
      while (temp != null)
      {
         if (temp.val == currentNum)
         {
            currentNumCount++;
         }
         else if (temp.val != currentNum)
         {
            if (currentNumCount == 1)
            {
               return prevNode;
            }
            currentNumCount = 1;
            currentNum = temp.val;
         }

         prevNode = temp;
         temp = temp.next;
      }

      if (currentNumCount == 1)
         return prevNode;

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
      LeetCode82 soln = new LeetCode82();
      // ListNode l1 = soln.new ListNode(5, null);
      // ListNode l2 = soln.new ListNode(4, l1);
      // ListNode l3 = soln.new ListNode(3);
      ListNode l4 = soln.new ListNode(3);
      ListNode l5 = soln.new ListNode(3, l4);
      ListNode l6 = soln.new ListNode(2, l5);
      ListNode head = soln.new ListNode(1, l6);
      soln.printLinkList(head);
      ListNode singleItemHead = soln.deleteDuplicates(head);
      System.out.println("Duplicates removed see : ");
      soln.printLinkList(singleItemHead);
   }

}
