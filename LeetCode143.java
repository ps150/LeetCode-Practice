package leetcodepractice;

public class LeetCode143
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

   public void reorderList(ListNode head)
   {
      ListNode secondHead = divideLinkList(head);
      ListNode temp = head;
      while (temp != null || secondHead != null)
      {
         ListNode firstListNextNode = temp.next;
         ListNode secondNodeNextHead = secondHead.next;
         temp.next = secondHead;
         secondHead.next = firstListNextNode;
         temp = firstListNextNode;
         secondHead = secondNodeNextHead;
      }

   }

   private ListNode divideLinkList(ListNode aHead)
   {
      ListNode slowPtr = aHead;
      ListNode fastPtr = aHead;
      while (aHead != null && aHead.next != null)
      {
         fastPtr = fastPtr.next.next;
         slowPtr = slowPtr.next;
      }
      if (slowPtr != null)
      {
         ListNode secondHead = slowPtr.next;
         slowPtr.next = null;
         secondHead = reverseLinkList(secondHead);
         return secondHead;
      }
      return null;
   }

   private ListNode reverseLinkList(ListNode aSecondHead)
   {
      ListNode currentNode = aSecondHead;
      ListNode prevNode = null;
      while (currentNode != null)
      {
         ListNode nextNode = currentNode.next;
         currentNode.next = prevNode;
         prevNode = currentNode;
         currentNode = nextNode;
      }
      return prevNode;
   }

   public static void main(String[] args)
   {

   }

}
