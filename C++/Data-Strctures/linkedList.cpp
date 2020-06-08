struct Node
{
    int val;
    Node *next;
    Node(int x) : val(x), next(NULL) {}
    Node() : next(NULL){}
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

            if(head == NULL){
                head = tmp;
                tail = tmp;
            }
            else{
                tail->next = tmp;
                tail = tail->next;
            }
        }
        void insertAfter(Node*ref, int val){
                Node *tmp = new Node(val);
                if(ref==tail){
                    tail->next = tmp;
                    tail = tail->next;
                }
                else{
                    tmp->next = ref->next;//set the new node(tmp) first
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


        void delNode(int val){
            Node *pre = head,*curr = head;
            if(curr->val == val){
                head = curr->next;
                curr->next = NULL;
                return;
            }
            curr = curr->next;
            while(curr->next){
                if(curr->val == val){
                    pre->next = curr->next;
                    curr->next = NULL;
                    return;
                }
                pre = curr;
                curr = curr->next;
            }
            if(curr==tail){
                tail = pre;
                pre->next = NULL;
            }
        }
        bool circle(Node *n1,Node *n2){
            if(n1 == n2)
                return true;
            if(!n2 || !n2->next)
                return false;
            else
                return circle(n1->next,n2->next->next);
        }
        Node* middle(Node *n1,Node *n2){
            if(!n2 || !n2->next)
                return n1;
            else
                return middle(n1->next,n2->next->next);
        }
        Node* maxNode(Node *n){
            if(!n->next)
                 return n;
            Node* tmp = maxNode(n->next);
            return (n->val > tmp->val)?n:tmp;
        }
    
};


int main() {
    List list;
    list.insertAfter(1);
    list.insertAfter(2);
    list.insertAfter(3);
    list.insertAfter(4);
    list.insertAfter(3);
    list.insertAfter(2);
    list.insertAfter(1);
    list.insertAfter(5);
    list.insertAfter(list.head->next,8);
    //list.delNode(5);
    list.show();
    //list.tail->next = list.head;
    //cout<<list.circle(list.head,list.head->next)<<endl;
    cout<<list.middle(list.head,list.head->next)->val<<endl;
    cout<<list.maxNode(list.head)->val<<endl;

}
