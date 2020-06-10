/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

string treeNodeToString(TreeNode* root) {
    if (root == nullptr) {
      return "[]";
    }

    string output = "";
    queue<TreeNode*> q;
    q.push(root);
    while(!q.empty()) {
        TreeNode* node = q.front();
        q.pop();

        if (node == nullptr) {
          output += "null, ";
          continue;
        }

        output += to_string(node->val) + ", ";
        q.push(node->left);
        q.push(node->right);
    }
    return "[" + output.substr(0, output.length() - 2) + "]";
}

void trimLeftTrailingSpaces(string &input) {
    input.erase(input.begin(), find_if(input.begin(), input.end(), [](int ch) {
        return !isspace(ch);
    }));
}

void trimRightTrailingSpaces(string &input) {
    input.erase(find_if(input.rbegin(), input.rend(), [](int ch) {
        return !isspace(ch);
    }).base(), input.end());
}

TreeNode* stringToTreeNode(string input) {
    trimLeftTrailingSpaces(input);
    trimRightTrailingSpaces(input);
    input = input.substr(1, input.length() - 2);
    if (!input.size()) {
        return nullptr;
    }

    string item;
    stringstream ss;
    ss.str(input);

    getline(ss, item, ',');
    TreeNode* root = new TreeNode(stoi(item));
    queue<TreeNode*> nodeQueue;
    nodeQueue.push(root);

    while (true) {
        TreeNode* node = nodeQueue.front();
        nodeQueue.pop();

        if (!getline(ss, item, ',')) {
            break;
        }

        trimLeftTrailingSpaces(item);
        if (item != "null") {
            int leftNumber = stoi(item);
            node->left = new TreeNode(leftNumber);
            nodeQueue.push(node->left);
        }

        if (!getline(ss, item, ',')) {
            break;
        }

        trimLeftTrailingSpaces(item);
        if (item != "null") {
            int rightNumber = stoi(item);
            node->right = new TreeNode(rightNumber);
            nodeQueue.push(node->right);
        }
    }
    return root;
}

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

int countN(TreeNode* node, int n){
    if(!node)
        return 0;
    if(node->val==n)
        return 1+countN(node->left,n)+countN(node->right,n);
    else
        return countN(node->left,n)+countN(node->right,n);
}
int countLeaves(TreeNode* node){
    if(!node)
        return 0;
    if(!node->left && !node->right)
        return 1;
    else
        return countLeaves(node->left)+countLeaves(node->right);
}
int count(TreeNode* node){
    if(!node)
        return 0;
    else
        return 1+count(node->left)+count(node->right);
}
TreeNode* parent(TreeNode* root, TreeNode* node){
    if(!root ||node==root)
        return NULL;
    if(root->left==node || root->right ==node)
        return root;
    TreeNode* left = parent(root->left,node);
    if(left)
        return left;
    else
        return parent(root->right,node);
}

TreeNode* mirror(TreeNode* root){
    if(!root)
        return NULL;
    TreeNode* mroot = new TreeNode(root->val);
    mroot->left = mirror(root->right);
    mroot->right = mirror(root->left);
    return mroot;
}
void mirror1(TreeNode* root){
    if(!root)
        return;
    TreeNode* tmp = root->right;
    root->right = root->left;
    root->left = tmp;
    mirror1(root->left);
    mirror1(root->right);
}

void preOrder(TreeNode* root){
    if(!root)
        return;
    cout<<root->val<<' ';
    preOrder(root->left);
    preOrder(root->right);
}
void inOrder(TreeNode* root){
    if(!root)
        return;
    inOrder(root->left);
    cout<<root->val<<' ';
    inOrder(root->right);
}
void postOrder(TreeNode* root){
    if(!root)
        return;
    postOrder(root->left);
    postOrder(root->right);
    cout<<root->val<<' ';
}

int main() {
    string line;
    //getline(cin, line);
    line = "[1, 2, 3, 2, 5, 2, 6, 9]";
    cout<<line<<endl;
    TreeNode* root = stringToTreeNode(line);
    prettyPrintTree(root);
    
    cout<<countN(root,2)<<endl;
    cout<<count(root)<<endl;
    TreeNode* p = parent(root,root->left->right);
    if(p)
        cout<<"parent:"<<p->val<<endl;
    preOrder(root);
    cout<<endl;
    inOrder(root);
    cout<<endl;
    postOrder(root);
    cout<<endl;
    cout<<"number leaves"<<countLeaves(root)<<endl;
    cout<<"number "<<count(root)<<endl;
    TreeNode* mroot = mirror(root);
    prettyPrintTree(mroot);
    mirror1(mroot);
    prettyPrintTree(mroot);
    return 0;
}
