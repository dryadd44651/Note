 // struct TreeNode {
 //     int val;
 //     TreeNode *left;
 //     TreeNode *right;
 //     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 // };

void prettyPrintTree(TreeNode* node, string prefix = "", bool isLeft = true) {
    if (node == nullptr) {
        cout << "Empty tree";
        return;
    }

    if(node->right) {
        prettyPrintTree(node->right, prefix + (isLeft ? "│   " : "    "), false);
    }

    cout << prefix + (isLeft ? "└── " : "┌── ") + to_string(node->val) + "\n";

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
void insert(TreeNode* node, int val){
    
    if(val>node->val){
        if(!node->right){
            node->right = new TreeNode(val);
        }
        else
            insert(node->right,val);    
    }
    else{
        if(!node->left){
            node->left = new TreeNode(val);
        }
        else
            insert(node->left,val);
    }
}
void deleteNode(TreeNode* &node,int val){
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
            TreeNode* pred = node->left;
            //find predecessor (left max)
            while(pred->right)
                pred = pred->right;
            //node->val = pred->val;
            deleteNode(node->left,pred->val);
            TreeNode* old = node;
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
void inOrder(TreeNode* node){
    if(!node)
        return;
    inOrder(node->left);
    cout<<node->val<<' ';
    inOrder(node->right);
}
void BFS(TreeNode* node){
    queue<TreeNode*> node_queue;
    node_queue.push(node);
    while(node_queue.size()!=0){
        TreeNode* curr = node_queue.front();
        node_queue.pop();
        cout<<curr->val<<' ';
        if(curr->left)
            node_queue.push(curr->left);
        if(curr->right)
            node_queue.push(curr->right);
    }
}
int main() {
    int line[] = {50, 40, 80, 20, 45, 60, 100, 70, 65, 42, 44, 30, 25, 35, 33};
    // TreeNode* root = NULL;
    // for(int i =0;i<15;i++)
    //     insert(root,line[i]);
    TreeNode* root = new TreeNode(line[0]);
    for(int i = 1;i<15;i++)
        insert(root,line[i]);
    prettyPrintTree(root);
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
