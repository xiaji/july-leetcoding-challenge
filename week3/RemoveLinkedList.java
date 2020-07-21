package week3;

/**
 * 链表基本操作 remove
 * 要用node.next来判断 因为要保留node信息 才能把两个node链接起来
 */
public class RemoveLinkedList {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1), temp = new ListNode(-1);
    dummy.next = head;
    head = dummy;
    // mistake 1: head != null
    while (head.next != null) {
      if (head.next.val != val) {
        head = head.next;
        continue;
      }
      temp = head.next;
      head.next = temp.next;
      temp.next = null;
      head = head.next;
    }
    return dummy.next;
  }
}