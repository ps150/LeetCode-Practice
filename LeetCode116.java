package leetcodepractice;
public class LeetCode116
{
   // Definition for a Node.
   class Node
   {
      public int val;

      public Node left;

      public Node right;

      public Node next;

      public Node()
      {

      }

      public Node(int _val)
      {
         val = _val;
      }

      public Node(int _val, Node _left, Node _right, Node _next)
      {
         val = _val;
         left = _left;
         right = _right;
         next = _next;
      }
   };

   int height = 0;

   Node currentRightMostNode = null;

   public Node connect(Node root)
   {
      height(root);
      root.next = null;
      for (int i = 1; i <= height; i++)
      {
         connectAllAtLevel(root, i);
         currentRightMostNode = null;
      }
      return root;
   }

   private void connectAllAtLevel(Node aRoot, int level)
   {
      if (aRoot == null)
         return;

      if (level == 0)
      {
         if (currentRightMostNode == null)
         {
            currentRightMostNode = aRoot;
         }
         else
         {
            currentRightMostNode.next = aRoot;
            currentRightMostNode = aRoot;
         }
      }
      connectAllAtLevel(aRoot.left, level - 1);
      connectAllAtLevel(aRoot.right, level - 1);
   }

   private void height(Node aRoot)
   {
      if (aRoot == null)
         return;
      height = height + 1;
      height(aRoot.left);
   }

   public static void main(String[] args)
   {

   }
}
