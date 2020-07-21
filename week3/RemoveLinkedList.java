package week3;

/**
 * 链表基本操作 remove
 * 要用node.next来判断 因为要保留node信息 才能把两个node链接起来
 * 逻辑模型漏洞 val的数不连续 是间隔的
 * 实际上并不是 可以连续
 * 1.避免了头指针不确定的情况
 * 2.但是思维逻辑上有漏洞 认为这个值的数不是连续在一起的 所以造成了第一版的错误
 */
public class RemoveLinkedList {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    ListNode dummy = new ListNode(), temp = new ListNode();
    dummy.next = head;
    head = dummy;
    // mistake 1: head != null
    while (head != null && head.next != null) {
      if (head.next.val != val) {
        head = head.next;
        continue;
      }
      temp = head.next;
      while (temp != null && temp.val == val) {
        temp = temp.next;
      }
      head.next = temp;
      head = head.next;
      /**
       * temp = head.next;
      head.next = temp.next;
      temp.next = null;
      head = head.next;
       */
    }
    return dummy.next;
  }
}