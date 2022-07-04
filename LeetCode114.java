package leetcodepractice;
public class LeetCode114
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

   public void flatten(TreeNode root)
   {
      flattenBTUtil(root);
   }

   private void flattenBTUtil(TreeNode aRoot)
   {
      if (aRoot == null)
         return;
      flattenBTUtil(aRoot.left);
      flattenBTUtil(aRoot.right);
      TreeNode left = aRoot.left;
      if (left != null)
      {
         while (left.right != null)
         {
            left = left.right;
         }
         left.right = aRoot.right;
         aRoot.right = aRoot.left;
         aRoot.left = null;
      }
   }

   public static void main(String[] args)
   {

   }

}
