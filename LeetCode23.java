
package leetcodepractice;

public class LeetCode23
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

   public ListNode mergeKLists(ListNode[] lists)
   {
      return divideAndConquere(lists, 0, lists.length - 1);
   }

   private ListNode divideAndConquere(ListNode[] aLists, int start, int end)
   {
      if (start > end)
         return null;
      if (start == end)
         return aLists[start];

      int mid = (start + end) / 2;
      ListNode l1 = divideAndConquere(aLists, start, mid);
      ListNode l2 = divideAndConquere(aLists, mid + 1, end);
      return mergeList(l1, l2);
   }

   private ListNode mergeList(ListNode aL1, ListNode aL2)
   {
      ListNode temp1;
      ListNode temp2;
      ListNode head = null;
      if (aL1 == null && aL2 == null)
         return null;

      if (aL1 != null && aL2 != null && aL1.val < aL2.val)
      {
         temp1 = aL1;
         temp2 = aL2;
      }
      else
      {
         temp1 = aL2;
         temp2 = aL1;
      }
      head = temp1;
      while (temp1 != null && temp1.next != null && temp2 != null)
      {
         if (temp1.next.val < temp2.val)
         {
            temp1 = temp1.next;
         }
         else
         {
            ListNode temp = temp1.next;
            temp1.next = temp2;
            temp1 = temp2;
            temp2 = temp;
         }

      }
      if (temp2 != null)
      {
         if (temp1 != null)
         {
            temp1.next = temp2;
         }
         else
         {
            head = temp2;
         }
      }
      return head;
   }

   public static void main(String[] args)
   {

   }

}
