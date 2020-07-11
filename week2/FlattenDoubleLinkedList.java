package week2;

/**
 * 链表的基本操作
 * 链表题目 尽量不要用递归 容易造成stackoverflow
 */
public class FlattenDoubleLinkedList {
  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  }

  public Node flatten(Node head) {
    if (head == null) {
      return head;
    }
    Node curr = head, temp = head;
    while (curr != null) {
      if (curr.child == null) {
        curr = curr.next;
        continue;
      }
      temp = findChildTail(curr.child);
      temp.next = curr.next;
      if (curr.next != null) {
        curr.next.prev = temp;
      }
      curr.next = curr.child;
      curr.child = null;
      curr = curr.next;
    }
    return head;    
  }

  private Node findChildTail(Node child) {
    while (child.next != null) {
      child = child.next;
    }
    return child;
  }
}
