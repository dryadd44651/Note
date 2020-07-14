#include <iostream>
#include <string>
#include<vector>
#include<list>
#include<queue>
#include <algorithm>
using namespace std;

// Definition for a Node.
class Node {
public:
    int val,id;
    //Adjacency list
    list<Node*> neighbors;
    
    Node(int _val,int _id) {
        val = _val;
        id = _id;
        neighbors = list<Node*>();
    }

};
class Graph{
public:
    vector<Node*> nodes;
    int currID = 0;
    vector<int> visited;
    Graph(vector<vector<int>> vec){
        for(int i=0;i<vec.size();i++){
            nodes.push_back(new Node(0,currID));
            currID++;
        }
            
        for(int i=0;i<vec.size();i++)
            for(int j=0;j<vec[i].size();j++)
                nodes[i]->neighbors.push_back(nodes[vec[i][j]]);
    }
    Graph(int nums){
        for(int i=0;i<nums;i++){
            nodes.push_back(new Node(0,currID));
            currID++;
        }
    }
    void add_edge(int a,int b){
        nodes[a]->neighbors.push_back(nodes[b]);
        nodes[b]->neighbors.push_back(nodes[a]);
    }
    void Adj_Matrix(){
        for(int i = 0;i<nodes.size();i++){
            for(int j = 0;j<nodes.size();j++){
                if(isFinded(nodes[i]->neighbors,j))
                    cout<<1<<" ";
                else
                    cout<<0<<" ";
            }
            cout<<endl;
        }
            
    }
    void showVertices(){
        for(auto node:nodes){
            cout<<"node: "<<node->id<<" neighbors: ";
            for(auto neighbor:node->neighbors)
                cout<<neighbor->id<<" ";
            cout<<endl;
        }
    }
    bool isVisited(int id) {
        return find(visited.begin(), visited.end(), id) != visited.end();
    };
    bool isFinded(list<Node*> lis,int id) {
        for(auto i:lis)
            if(i->id==id)
                return true;
        return false;
    };
  
    void DFS_traversal(int id){
        DFS(id);
        visited.clear();
    }
    void DFS(int id){
        //id in visited
        if(isVisited(id))
            return;
        visited.push_back(id);
        Node* node = nodes[id];
        cout<<node->id<<" ";
        for(auto neighbor:node->neighbors)
            DFS(neighbor->id);
    }
    void BFS_traversal(int id){
        queue<Node*> queue;
        Node* node = nodes[id];
        visited.push_back(id);
        queue.push(node);
        while(queue.size()>0){
            Node* n = queue.front();
            queue.pop();
            cout<<n->id<<" ";
            for(auto neighbor:n->neighbors){
                //if id not in visited
                if(!isVisited(neighbor->id)){
                    visited.push_back(neighbor->id);
                    queue.push(neighbor);
                }
            }
        }
        visited.clear();
    }
};

int main() {
    // vector<vector<int>> vec ={{1,4},{0,2},{1,4},{5,9,11,12},{0,1,2,6},
    //                           {3,7,8},{4},{5,10},{5,9,10,12,14},
    //                           {3,8,10,13},{7,8,9,13,14},{3,12,13,14},
    //                           {3,11,13},{8,8,10,11,12},{8,10,11}};
    //Graph graph(vec);
    vector<vector<int>> edges = {{ 0, 1},{ 0, 2},{ 0, 3},{ 1, 2},{ 2, 3},
                                 { 1, 4},{ 2, 4},{ 2, 5},{ 3, 5},{ 4, 5},
                                 { 6, 7},{ 7, 8},{ 6, 9},{ 7, 9},{ 7,10},
                                 { 8,11},{ 8,14},{10,11},{10,12},{10,13},
                                 {11,13},{11,14},{12,13},{13,14},{12,14}};
    Graph graph(15);
    for(auto edge:edges){
        graph.add_edge(edge[0],edge[1]);
    }
    //graph.Adj_Matrix();
    //Adjacency list show
    //graph.showVertices();
    cout<<"DFS traversal"<<endl;
    graph.DFS_traversal(0);
    graph.DFS_traversal(6);
    cout<<endl;
    cout<<"BFS traversal"<<endl;
    graph.BFS_traversal(0);
    graph.BFS_traversal(6);
    cout<<endl;
    
}


