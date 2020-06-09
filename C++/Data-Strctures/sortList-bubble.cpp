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
        ListNode *dummy1 = new ListNode(-1);
        ListNode *dummy2 = new ListNode(0);
        dummy1->next = dummy2;
        dummy2->next = head;

        ListNode *prev1 = dummy1;
        ListNode *prev2 = dummy2;
        ListNode *curr = head;
        bool odered = 0;
        while(!odered){
            prev1 = dummy1;
            prev2 = dummy1->next;
            curr = dummy1->next->next;
            odered = 1;
            while(curr){
                if(curr->val < prev2->val){
                    prev1->next = curr;
                    prev2->next = curr->next;
                    curr->next = prev2;
                    odered = 0;
                }
                prev1 = prev2;
                prev2 = curr;
                curr = curr->next;
            }
        }
    return dummy1->next->next;
    }
};
