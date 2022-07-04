package leetcodepractice;
public class LeetCode105
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

   public TreeNode buildTree(int[] preorder, int[] inorder)
   {
      if (preorder.length == 0)
         return null;

      return createBST(preorder, inorder, 0, inorder.length - 1);

   }

   int prorderIndex = 0;

   private TreeNode createBST(int[] aPreorder, int[] aInorder, int inorderFirstIndx, int inorderLastIndx)
   {
      if (prorderIndex >= aPreorder.length || inorderFirstIndx > inorderLastIndx)
         return null;
      if (inorderFirstIndx == inorderLastIndx)
      {
         TreeNode temp = new TreeNode(aPreorder[prorderIndex]);
         prorderIndex++;
         return temp;
      }

      TreeNode root = new TreeNode(aPreorder[prorderIndex]);

      int index = searchIndex(aPreorder[prorderIndex], aInorder);
      prorderIndex++;

      root.left = createBST(aPreorder, aInorder, inorderFirstIndx, index - 1);
      root.right = createBST(aPreorder, aInorder, index + 1, inorderLastIndx);

      return root;
   }

   private int searchIndex(int aItem, int[] aInorder)
   {
      return binarySearch(aInorder, aItem);
   }

   private int binarySearch(int[] aInorder, int aItem)
   {
      for (int i = 0; i < aInorder.length; i++)
      {
         if (aInorder[i] == aItem)
            return i;
      }

      return -1;
   }

   private void inorder(TreeNode root)
   {
      if (root == null)
         return;
      inorder(root.left);
      System.out.println(root.val);
      inorder(root.right);
   }

   private void preOrder(TreeNode root)
   {
      if (root == null)
         return;

      System.out.println(root.val);
      preOrder(root.left);
      preOrder(root.right);
   }

   public static void main(String[] args)
   {
      LeetCode105 soln = new LeetCode105();
      int[] preorder = { 1, 2 };
      int[] inorder = { 1, 2 };
      TreeNode root = soln.buildTree(preorder, inorder);

      soln.inorder(root);

      System.out.println("--Pre order---");
      soln.preOrder(root);
   }

}
