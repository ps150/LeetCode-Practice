package leetcodepractice;

public class LeetCode156
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

   TreeNode newHeadNode;

   public TreeNode upsideDownBinaryTree(TreeNode root)
   {
      return rotateTree(root, null);
   }

   private TreeNode rotateTree(TreeNode aRoot, TreeNode parentNode)
   {
      if (aRoot == null)
         return null;

      rotateTree(aRoot.left, aRoot);
      if (aRoot != null)
      {
         if (aRoot.left == null && aRoot.right == null)
            newHeadNode = aRoot;
         aRoot.right = parentNode;
         aRoot.left = parentNode != null ? parentNode.right : parentNode;
      }
      return null;
   }

   public static void main(String[] args)
   {

   }

}
