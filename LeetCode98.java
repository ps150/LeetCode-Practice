package leetcodepractice;
import javax.swing.text.StyledEditorKit.BoldAction;

public class LeetCode98
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

   public boolean isValidBST(TreeNode root)
   {
      if (root == null)
         return true;

      return validateIsBST(root);

   }

   TreeNode prev;

   private boolean validateIsBST(TreeNode root)
   {
      if (root != null)
      {
         if (!validateIsBST(root.left))
            return false;

         if (prev != null && prev.val >= root.val)
         {
            return false;
         }
         prev = root;
         return validateIsBST(root.right);
      }
      return true;
   }

   public static void main(String[] args)
   {

   }

}
