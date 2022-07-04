package leetcodepractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode133
{
   class Node
   {
      public int val;

      public List<Node> neighbors;

      public Node()
      {
         val = 0;
         neighbors = new ArrayList<Node>();
      }

      public Node(int _val)
      {
         val = _val;
         neighbors = new ArrayList<Node>();
      }

      public Node(int _val, ArrayList<Node> _neighbors)
      {
         val = _val;
         neighbors = _neighbors;
      }
   }

   public Node cloneGraph(Node node)
   {
      Map<Integer, Node> visitedMap = new HashMap<Integer, Node>();
      Node clonedNode = new Node(node.val);
      visitedMap.put(clonedNode.val, clonedNode);

      createClonedNode(clonedNode, node, visitedMap);
      return clonedNode;
   }

   private void createClonedNode(Node aClonedNode, Node aNode, Map<Integer, Node> visitedMap)
   {
      ArrayList<Node> neighborsList = new ArrayList<Node>();
      for (int i = 0; i < aNode.neighbors.size(); i++)
      {
         Node n = aNode.neighbors.get(i);
         Node clon = visitedMap.getOrDefault(n.val, null);
         if (clon == null)
         {
            clon = new Node(n.val);
            visitedMap.put(n.val, clon);
            createClonedNode(clon, n, visitedMap);
         }
         neighborsList.add(clon);
      }
      aClonedNode.neighbors = neighborsList;
   }

   public static void main(String[] args)
   {
      LeetCode133 soln = new LeetCode133();
      Node nod1 = soln.new Node(1);
      Node nod2 = soln.new Node(2);
      Node nod3 = soln.new Node(3);
      Node nod4 = soln.new Node(4);
      List<Node> l1 = new ArrayList<LeetCode133.Node>();
      l1.add(nod2);
      l1.add(nod4);
      nod1.neighbors = l1;

      List<Node> l2 = new ArrayList<LeetCode133.Node>();
      l2.add(nod1);
      l2.add(nod3);
      nod2.neighbors = l2;

      List<Node> l3 = new ArrayList<LeetCode133.Node>();
      l3.add(nod4);
      l3.add(nod2);
      nod3.neighbors = l3;

      List<Node> l4 = new ArrayList<LeetCode133.Node>();
      l4.add(nod1);
      l4.add(nod3);
      nod4.neighbors = l4;

      soln.cloneGraph(nod1);
      System.out.println("Done");
   }

}
