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
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head || !head->next || k == 0) return head;
        
        //Find length and tail
        ListNode* tail = head;
        int len = 1;
        while (tail->next){
            tail = tail->next;
            len++;
        }
        
        tail->next = head;
        
        //finding new tail position
        k = k % len;
        int stepsToNewTail = len - k;
        ListNode* newTail = head;
        for(int i = 1; i < stepsToNewTail; i++){
            newTail = newTail->next;
        }
        
        //New HEad is after the new tail
        ListNode* newHead = newTail->next;
        newTail->next = nullptr;
        
        return newHead;
    }
};