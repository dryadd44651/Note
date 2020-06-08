struct Node
{
    int val;
    Node *next;
    Node *prev;
    Node(int x) : val(x), next(NULL), prev(NULL) {}
    Node() : next(NULL), prev(NULL) {}
};
class List {
    private:
        
    public:
        Node *head,*tail;
        List(){
            head =  NULL;
            tail =  NULL;
        }

        void insertAfter(int val){
            Node *tmp = new Node(val);

            if(head == NULL)
            {
                head = tmp;
                tail = tmp;
            }
            else
            {
                tail->next = tmp;
                tmp->prev = tail;
                tail = tail->next;
            }
        }
        void insertAfter(Node*ref, int val){
                Node *tmp = new Node(val);

                if(ref==tail){
                    tail->next = tmp;
                    tmp->prev = tail;
                    tail = tail->next;
                }
                else{
                    tmp->next = ref->next;//set the new node(tmp) first
                    tmp->prev = ref;
                    ref->next->prev = tmp;
                    ref->next = tmp;
                    
                }
            }
        void show(){
            Node *curr = head;
            while(curr){
                cout<<curr->val;
                curr = curr->next;
            }
            cout<<endl;
        }
        void reverse_show(){
            Node *curr = tail;
            while(curr){
                cout<<curr->val;
                curr = curr->prev;
            }
            cout<<endl;
        }
        void delNode(Node *node){
            if(node==head){
                head = head->next;
                head->prev = NULL;
            }
            else if(node==tail){
                tail = tail->prev;
                tail->next = NULL;
            }
            else{
                node->prev->next = node->next;
                node->next->prev = node->prev;
            }
            node->next = NULL;
            node->prev = NULL;
            delete node;
        }
        void delNode(int val){
            Node *curr = head;
            while(curr){
                if(curr->val == val){
                    //cout<<curr->val<<endl;
                    delNode(curr);
                    
                    return;
                }
                curr = curr->next;
            }
        }
        bool equal(Node *node1,Node *node2){
            //Palindrome
            if((!node1 && !node2)||(node1==node2))
                return true;
            else if(node1->val != node2->val)
                return false;
            else{
                if(node1->next==node2)
                    return true;
                return equal(node1->next,node2->prev);
            }
        }
        void reverse_trav(Node* node){
                if(!node)
                    cout<<endl;
                else{
                    cout<<node->val;
                    reverse_trav(node->prev);
                }
        }
        Node* middle(Node* n1,Node*n2){
            if(n1==n2||n1->next==n2)
                return n1;
            return middle(n1->next,n2->prev);
            
        }
    
};


int main() {
    List listNode;
    listNode.insertAfter(1);
    listNode.insertAfter(2);
    listNode.insertAfter(3);
    //listNode.insertAfter(4);
    listNode.insertAfter(3);
    listNode.insertAfter(2);
    listNode.insertAfter(1);
    listNode.insertAfter(listNode.head->next,8);
    listNode.delNode(8);
    listNode.show();
    listNode.reverse_show();
    //listNode.reverse_trav(listNode.tail);
    cout<<listNode.middle(listNode.head,listNode.tail)->val<<endl;
    
    //cout<<listNode.equal(listNode.head,listNode.tail)<<endl;
    
}
