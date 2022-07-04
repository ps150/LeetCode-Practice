package leetcodepractice;

public class LeetCode138
{
   class Node
   {
      int val;

      Node next;

      Node random;

      public Node(int val)
      {
         this.val = val;
         this.next = null;
         this.random = null;
      }
   }

   public Node copyRandomList(Node head)
   {
      if(head == null)
         return null;
      Node clonedNode = new Node(head.val);

      deepCloneList(head, clonedNode);
      return clonedNode;
   }

   private void deepCloneList(Node aHead, Node aClonedNode)
   {
      Node temp = aHead;
      Node clonNode = aClonedNode;

      // Added the node in between.
      while (temp.next != null)
      {
         clonNode.next = temp.next;
         temp.next = clonNode;
         temp = temp.next.next;
         clonNode = new Node(temp.val);
      }
      Node n = temp.next;
      temp.next = clonNode;
      clonNode.next = n;

      // Add the random pointer.

      temp = aHead;
      while (temp.next.next != null)
      {
         Node randoPtr = temp.random;
         Node clon = temp.next;
         if (randoPtr != null)
            clon.random = randoPtr.next;
         else
            clon.random = null;
         temp = temp.next.next;
      }
      if(temp.random != null)
      temp.next.random = temp.random.next;

      // remove the cloned list from the actual list.

      Node head1 = aHead;
      Node head2 = aHead.next;

      while (head2.next != null)
      {
         head1.next = head1.next.next;
         head2.next = head2.next.next;
         head1 = head1.next;
         head2 = head2.next;
      }
      head1.next = null;

   }

   public static void main(String[] args)
   {
      LeetCode138 soln = new LeetCode138();
      Node head = soln.new Node(7);

      Node chil1 = soln.new Node(13);
      Node chil2 = soln.new Node(11);
      Node chil3 = soln.new Node(10);
      Node chil4 = soln.new Node(1);
      head.next = chil1;
      chil1.next = chil2;
      chil2.next = chil3;
      chil3.next = chil4;

      chil1.random = head;
      chil2.random = chil4;
      chil3.random = chil2;
      chil4.random = head;

      soln.copyRandomList(head);

   }

}
