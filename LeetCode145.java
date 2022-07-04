package leetcodepractice;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode145
{
   public class TreeNode
   {
      int val;

      TreeNode left;

      TreeNode right;

      TreeNode()
      {
      }

      TreeNode(int val)
      {
         this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right)
      {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }

   public List<Integer> postorderTraversal(TreeNode root)
   {
      List<Integer> postorderItems = new ArrayList<Integer>();

      populatepostOrderItems(root, postorderItems);
      return postorderItems;
   }

   private void populatepostOrderItems(TreeNode aRoot, List<Integer> aPostorderItems)
   {
      Stack<TreeNode> nodes = new Stack<TreeNode>();
      if (aRoot == null)
         return;
      nodes.push(aRoot);
      TreeNode lastVisited = null;
      TreeNode currentNode = aRoot;
      while (!nodes.isEmpty())
      {
         if (currentNode != null)
         {
            TreeNode leftNode = currentNode.left;
            if (leftNode != null)
            {
               nodes.push(leftNode);
               currentNode = leftNode;
               lastVisited = leftNode;
            }
            else
            {
               TreeNode rightNode = currentNode.right;
               if (rightNode != null)
               {
                  currentNode = rightNode;
                  nodes.push(rightNode);
                  lastVisited = rightNode;
               }
               else
               {
                  currentNode = null;
               }
            }
         }

         if (currentNode == null)
         {

            TreeNode addedNode = nodes.peek();
            if (addedNode.right == lastVisited || addedNode.right == null)
            {
               aPostorderItems.add(nodes.pop().val);
               lastVisited = addedNode;
            }
            else
            {
               nodes.add(addedNode.right);
               currentNode = addedNode.right;
               lastVisited = currentNode;
            }
         }

      }
   }

   public static void main(String[] args)
   {

   }

}
