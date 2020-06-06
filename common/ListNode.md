# python
```
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def prettyPrintLinkedList(node):
    while node and node.next:
        print(str(node.val) + "->", end='')
        node = node.next

    if node:
        print(node.val)
    else:
        print("Empty LinkedList")
```
# java
```
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 public static void prettyPrintLinkedList(ListNode node) {
  while (node != null && node.next != null) {
      System.out.print(node.val + "->");
      node = node.next;
  }

  if (node != null) {
    System.out.println(node.val);
  } else {
    System.out.println("Empty LinkedList");
  }
}
```
# c++
```
struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };
 
 void prettyPrintLinkedList(ListNode* node) {
  while (node && node->next) {
      cout << node->val << "->";
      node = node->next;
  }

  if (node)
    cout << node->val << endl;
  else
    cout << "Empty LinkedList" << endl;
  
}
 
```
