package leetcodepractice;
public class LeetCode19
{

	class ListNode
	{
		int data;

		ListNode next;

		ListNode(int data)
		{
			this.data = data;
		}
	}

	private void addDataInList(int data, ListNode head)
	{
		ListNode tempNode = head;
		while (tempNode.next != null)
		{
			tempNode = tempNode.next;
		}
		ListNode node = new ListNode(data);
		tempNode.next = node;
		node.next = null;
	}

	public static void main(String[] args)
	{
		LeetCode19 soln = new LeetCode19();
		int n = 6;
		ListNode head = soln.new ListNode(1);
		soln.addDataInList(2, head);
		soln.addDataInList(3, head);
		soln.addDataInList(4, head);
		soln.addDataInList(5, head);
		soln.addDataInList(6, head);
		removeNthFromEnd(head, n);
		while (head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}

	}

	private static void removeNthFromEnd(ListNode head, int n)
	{
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		int count = 0;
		ListNode prevPointer = null;
		while (fastPtr != null)
		{
			if (count >= n)
			{
				prevPointer = slowPtr;
				slowPtr = slowPtr.next;
			}
			fastPtr = fastPtr.next;
			count = count + 1;
		}
		if (prevPointer != null)
		{
			deleteNode(prevPointer);
		}
		else
		{
			System.out.print("LinkList length is smaller than n");
		}
	}

	private static void deleteNode(ListNode slowPtr)
	{
		ListNode tempNode = slowPtr.next;
		if (tempNode != null)
		{
			ListNode tempNode1 = tempNode.next;
			slowPtr.next = tempNode1;
		}
		else
		{

		}
	}
}
