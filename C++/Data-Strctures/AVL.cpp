 struct AvlNode {
     int val;
     int height;
     AvlNode *parent;
     AvlNode *left;
     AvlNode *right;
     AvlNode(int x) : val(x), height(0), left(NULL), right(NULL),parent(NULL) {}
 };

void prettyPrintTree(AvlNode* node, string prefix = "", bool isLeft = true) {
    if (node == nullptr) {
        cout << "Empty tree";
        return;
    }

    if(node->right) {
        prettyPrintTree(node->right, prefix + (isLeft ? "│   " : "    "), false);
    }

    cout << prefix + (isLeft ? "└── " : "┌── ") + to_string(node->val);//<<endl;
    // if(node->parent)
    //     cout<<','+to_string(node->parent->val)<<endl;
    cout<<'_'<<node->height<<endl;

    if (node->left) {
        prettyPrintTree(node->left, prefix + (isLeft ? "    " : "│   "), true);
    }
}
// call by reference (can pass null node)
// void insert(TreeNode* &node, int val){
//     if(!node){
//         node = new TreeNode(val);
//         return;
//     }
//     if(val>node->val)
//         insert(node->right,val);
//     else
//         insert(node->left,val);
// }

int height(AvlNode* &node){
    if(!node)
        return -1;
    return max(height(node->left),height(node->right))+1;
}
int type(AvlNode* node){
    int left1 = -1,right1 = -1;
    int left2 = -1,right2 = -1;
    if(node->left)
        left1 = node->left->height;
    if(node->right)
        right1 = node->right->height;
    if(left1>right1){//left
        AvlNode* node2 = node->left;
        if(node2->left)
            left2 = node2->left->height;
        if(node2->right)
            right2 = node2->right->height;
        if(left2>right2)//left left
            return 1;
        else//left right
            return 2;
    }
    else{//right
        AvlNode* node2 = node->right;
        if(node2->left)
            left2 = node2->left->height;
        if(node2->right)
            right2 = node2->right->height;
        if(left2>right2)//right left
            return 3;
        else//right right
            return 4;
    }
}
bool isBalance(AvlNode* node){
    if(!node)
        return true;
    int leftH = -1,rightH = -1;
    if(node->right)
        rightH = node->right->height;
    if(node->left)
        leftH = node->left->height;
    //cout<<leftH<<" "<<rightH<<endl;
    return (abs(rightH-leftH)<2);
}
void insert(AvlNode* root,AvlNode* node){
    if(root->val<node->val){
        if(root->right)
            insert(root->right,node);
        else
            root->right = node;
    }else{
        if(root->left)
            insert(root->left,node);
        else
            root->left = node;
    }
}
AvlNode* Rrotate(AvlNode* &node1){
    AvlNode *parent1,*rchild2,*node2;
    node2 = node1->left;
    if(node1->parent){
        if(node1->parent->right==node1){
            node1->parent->right = node2;
        }
        else{            
            node1->parent->left = node2;
        }
        node2->parent = node1->parent;
    }else{
        node2->parent = NULL;
    }
    
    node1->parent = node2;
    node1->left = NULL;
    if(node2->right){
        rchild2 = node2->right;
        insert(node1,rchild2);
    }    
    node2->right = node1;
    return node2;//root of new tree
}
AvlNode* Lrotate(AvlNode* &node1){
    AvlNode *parent1,*lchild2,*node2;
    node2 = node1->right;
    if(node1->parent){
        if(node1->parent->right==node1){
            node1->parent->right = node2;
        }
        else{            
            node1->parent->left = node2;
        }
        node2->parent = node1->parent;
    }else{
        node2->parent = NULL;
    }
    
    node1->parent = node2;
    node1->right = NULL;
    if(node2->left){
        insert(node1,node2->left);
    }    
    node2->left = node1;
    return node2;//root of new tree
}
void reBalance(AvlNode* &root,AvlNode* node){
    if(!node)
        return;
    //cout<<isBalance(node)<<endl;
    if(isBalance(node))
        reBalance(root,node->parent);
    else{
        int ty = type(node);
        cout<<node->val<<" type "<<ty<<endl;
        
        AvlNode *node2,*node3;
        switch (ty){
            case 1:
                if(root==node)
                    root = Rrotate(node);
                else
                    Rrotate(node);
                break;
            case 2:
                
                node2 = node->left;
                node3 = node->left->right;
                node3->parent = node;
                node2->parent = node3;
                node->left = node3;
                node2->right = NULL;
                node3->left = node2;
                
                if(root==node)
                    root = Rrotate(node);
                else
                    Rrotate(node);
                break;
            case 3:
                node2 = node->right;
                node3 = node2->left;
                node2->parent = node3;
                node3->parent = node;
                node2->left = NULL;
                node3->right = node2;
                node->right = node3;
                
                if(root==node)
                    root = Lrotate(node);
                else
                    Lrotate(node);
                break;
            default:
                if(root==node)
                    root = Lrotate(node);
                else
                    Lrotate(node);
                break;
        }
    }
        
}

void insert(AvlNode* node, int val){
    
    if(val>node->val){
        if(!node->right){
            node->right = new AvlNode(val);
            node->right->parent = node;
        }
        else{
            insert(node->right,val);
        }
        if(node->left)
            node->height = max(node->left->height,height(node->right))+1;
        else
            node->height =height(node->right)+1;
    }
    else{
        if(!node->left){
            node->left = new AvlNode(val);
            node->left->parent = node;
            //reBalance(node);
        }
        else{
            insert(node->left,val);
        }
        if(node->right)
            node->height = max(node->right->height,height(node->left))+1;
        else
            node->height = height(node->left)+1;
    }
}
AvlNode* search(AvlNode* &node,int val){
    if(!node)
        return NULL;
    if(node->val==val)
        return node;
    if(val>node->val)
        return search(node->right,val);
    else
        return search(node->left,val);
}
void deleteNode(AvlNode* &node,int val){
    if(!node)
        return;
    if(node->val==val){
        if(!node->left && !node->right){
            node = NULL;
            return;
        }else if(!node->left && node->right)
            node = node->right;
        else if(node->left && !node->right)
            node = node->left;
        else{
            AvlNode* pred = node->left;
            //find predecessor (left max)
            while(pred->right)
                pred = pred->right;
            //node->val = pred->val;
            deleteNode(node->left,pred->val);
            AvlNode* old = node;
            node = pred;
            node->left = old->left;
            node->right = old->right;
        }
    }
    else{
        if(val>node->val)
            deleteNode(node->right,val);
        else
            deleteNode(node->left,val);
    }
}
void inOrder(AvlNode* node){
    if(!node)
        return;
    inOrder(node->left);
    cout<<node->val<<' ';
    inOrder(node->right);
}
void BFS(AvlNode* node){
    queue<AvlNode*> node_queue;
    node_queue.push(node);
    while(node_queue.size()!=0){
        AvlNode* curr = node_queue.front();
        node_queue.pop();
        cout<<curr->val<<' ';
        if(curr->left)
            node_queue.push(curr->left);
        if(curr->right)
            node_queue.push(curr->right);
    }
}

int main() {
    //int line[] = {50, 40, 80, 20, 45, 60, 100, 70, 65, 42, 44, 30, 25, 35, 33};
    //int line[] = {14, 17, 11, 7, 53, 4, 13};
    //int line[] = {14, 15,11,9,10};//type2 left right
    int line[] = {14, 10,16,18,17};//type3 right left
    
    AvlNode* root = new AvlNode(line[0]);
    for(int i = 1;i<sizeof(line)/sizeof(int);i++){
        insert(root,line[i]);
        reBalance(root,search(root,line[i]));
    }
        
    cout<<endl;
    prettyPrintTree(root);
    //cout<<search(root,11)->val<<endl;
    //cout<<height(root)<<endl;
    //cout<<isBalance(root)<<endl;
    
    // deleteNode(root,50);
    // cout<<"========================"<<endl;
    // prettyPrintTree(root);
    // deleteNode(root,40);
    // cout<<"========================"<<endl;
    // prettyPrintTree(root);
    // deleteNode(root,65);
    // cout<<"========================"<<endl;
    // prettyPrintTree(root);
    // deleteNode(root,35);
    // cout<<"========================"<<endl;
    // prettyPrintTree(root);
    // inOrder(root);
    // cout<<endl;
    //BFS(root);
    
}
