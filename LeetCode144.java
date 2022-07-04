package leetcodepractice;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode144
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

   public List<Integer> preorderTraversal(TreeNode root)
   {
      List<Integer> preorderItems = new ArrayList<Integer>();

      populateTreeItemInPreorder(root, preorderItems);

      return preorderItems;
   }

   private void populateTreeItemInPreorder(TreeNode aRoot, List<Integer> aPreorderItems)
   {
      Stack<TreeNode> nodes = new Stack<TreeNode>();
      while (aRoot != null)
      {
         aPreorderItems.add(aRoot.val);
         if (aRoot.right != null)
            nodes.add(aRoot.right);
         if (aRoot.left != null)
            aRoot = aRoot.left;
         else
         {
            if (!nodes.isEmpty())
            {
               aRoot = nodes.pop();
            }
            else
            {
               aRoot = null;
            }
         }
      }

   }

   public static void main(String[] args)
   {

   }

}
