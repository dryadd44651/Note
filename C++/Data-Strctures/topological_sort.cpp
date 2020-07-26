#include <iostream>
#include<vector>
#include<set>
#include<queue>
#include <algorithm>
using namespace std;

class Node {
public:
    int val = 0;
    //Adjacency list
    vector<int> neighbors;
    
    Node(int _val, vector<int> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

};
class Graph{
public:
    vector<Node*> nodes;
    vector<int> order;
    set<int> visited;
    bool isVisited(int id) {
        return visited.find(id) != visited.end();
    };
    bool isInOrder(int id) {
    return find(order.begin(), order.end(), id) != order.end();
    };
    void top_sort_dfs(){
        order.clear();
        for(int i = 0;i<nodes.size();i++){
            if(not dfs(nodes[i])){
                cout<<"cycle"<<endl;
                break;
            }
            visited.clear();
        }
        reverse(order.begin(),order.end()); 
    }
    bool dfs(Node *n){
        if(isInOrder(n->val))
            return true;
        if(isVisited(n->val))
            return false;
        else
            visited.insert(n->val);
        if(n->neighbors.size()>0)
            for(auto i:n->neighbors)
                if(!dfs(nodes[i]))
                    return false;
        order.push_back(n->val);
        //cout<<n->val<<" ";
        return true;
    }
    void top_sort_bfs(){
        order.clear();
        vector<int> preCount(nodes.size());
        for(int i = 0;i<nodes.size();i++){
            for(auto n:nodes[i]->neighbors)
                preCount[n]+=1;
        }
        queue<int> myqueue;
        for(int i = 0;i<nodes.size();i++){
            if(preCount[i]==0){
                myqueue.push(i);
                order.push_back(i);
                //cout<<i<<" ";
            }
        }

        while(myqueue.size()>0){
            int idx = myqueue.front();
            myqueue.pop();
            for(auto n:nodes[idx]->neighbors){
                preCount[n]-=1;
                // cout<<idx<<" "<<n<<" "<<preCount[n]<<endl;
                if(preCount[n]==0){
                    order.push_back(n);
                    myqueue.push(n);
                }
                    
            }
        }
        if(order.size()<nodes.size())
            cout<<"cycle"<<endl;
    }
    void bfs(Node *n){
        
    }
    void show(){
        for(auto n:nodes)
            cout<<n->val<<" ";
    }

};

int main() {
    vector<vector<int>> edges = {{2},{2},{4},{4},{5},{}};//acycle
    //vector<vector<int>> edges = {{2},{2},{4},{4},{5},{0}};//cycle
    Graph graph;
    for(int i=0;i<edges.size();i++)
        graph.nodes.push_back(new Node(i,edges[i]));

    graph.top_sort_dfs();
    for(auto i:graph.order)
        cout<<i<<" ";
    cout<<endl;
    graph.top_sort_bfs();
    for(auto i:graph.order)
        cout<<i<<" ";
    cout<<endl;
    //graph.show();
}
