/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        ListNode *curr1 = head,*curr2 = head;
        ListNode *prev1 = head,*prev2 = head;
        while(curr1){
            curr2 = curr1;
            while(curr2){
                if(curr2->val < curr1->val){
                    ListNode *tmp = curr2->next;
                    bool isHead = curr1==head;
                    if(!isHead)
                        prev1->next = curr2;
                    if(prev2!=curr1){
                        prev2->next = curr1;
                        curr2->next = curr1->next;
                        curr1->next = tmp;
                    }
                    else{//consecutive node
                        prev2->next = curr2->next;
                        curr2->next = curr1;
                    }
                    tmp = curr1;
                    curr1 = curr2;
                    curr2 = tmp;
                    if(isHead)
                        head = curr1;
                }
                prev2 = curr2;
                curr2 = curr2->next;
            }
            prev1 = curr1;
            curr1 = curr1->next;
        }
    return head;
    }
};
