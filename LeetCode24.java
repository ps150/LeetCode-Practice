package leetcodepractice;

public class LeetCode24
{

   class ListNode
   {
      int val;

      ListNode next;

      public ListNode(int val)
      {
         this.val = val;
      }
   }

   public ListNode swapPairs(ListNode head)
   {
      if (head == null || head.next == null)
         return head;
      ListNode prevNode = null;
      ListNode nextNode = head.next;
      ListNode currentNode = head;

      while (currentNode != null && nextNode != null)
      {
         currentNode.next = nextNode.next;
         nextNode.next = currentNode;
         if (prevNode != null)
            prevNode.next = nextNode;
         else
         {
            head = nextNode;
         }
         prevNode = currentNode;
         currentNode = currentNode.next;
         if (currentNode != null)
            nextNode = currentNode.next;
      }

      return head;
   }

   public ListNode reverseKGroup(ListNode head, int k)
   {
      if (head == null || head.next == null)
         return head;

      ListNode prevNode = null;
      ListNode nextNode = head.next;
      ListNode currentNode = head;
      int counter = 1;
      while (currentNode != null && counter <= k)
      {
         currentNode.next = prevNode;
         prevNode = currentNode;
         currentNode = nextNode;

         counter = counter + 1;

         if (currentNode != null)
            nextNode = currentNode.next;
      }

      return prevNode;
   }

   private void printLinkList(ListNode head)
   {
      ListNode tempNode = head;
      while (tempNode != null)
      {
         System.out.println(tempNode.val);
         tempNode = tempNode.next;
      }
   }

   public static void main(String[] args)
   {
      LeetCode24 leetCode24 = new LeetCode24();
      ListNode head = leetCode24.new ListNode(1);
      ListNode node1 = leetCode24.new ListNode(2);
      head.next = node1;
      ListNode nod2 = leetCode24.new ListNode(3);
      node1.next = nod2;
      ListNode nod3 = leetCode24.new ListNode(4);
      nod2.next = nod3;
      leetCode24.printLinkList(head);
      ListNode newHead = leetCode24.swapPairs(head);
      System.out.println("------------Print link list after swap--------");
      leetCode24.printLinkList(newHead);
      System.out.println("------------Reverse of the Link List-----------");
      ListNode reverseHead = leetCode24.reverseKGroup(newHead, 10);
      leetCode24.printLinkList(reverseHead);
   }

}
