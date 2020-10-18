# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None, weights = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
        self.weights = weights if weights is not None else []

def Dijkstra(nodes,start):
        heap = []
        
        for i,node in enumerate(nodes):
            if node == start:
                heap.append((0,i))
            else:
                heap.append((float('inf'),i))
        #connect = [[0 for _ in range(len(heap))]for _ in range(len(heap))]
        connect = [-1 for _ in range(len(heap))]
        heapify(heap)
        while heap:
            curr = nodes[heap[0][1]]
            val = heap[0][0]
            for weight,neighbor in zip(curr.weights, curr.neighbors):
                #print(neighbor)
                tmp = [i for i,x in enumerate(heap) if x[1]==neighbor]
                if tmp:
                    i = tmp[0]
                    if val+weight<heap[i][0]:
                        heap[i]=(val+weight,heap[i][1])
                        connect[neighbor] = heap[0][1]
                        
                    #heap[i] = (min(val+weight,heap[i][0]),heap[i][1])
            print(heap)
            heap.pop(0)
            heapify(heap)
        print(connect)
def BellmenFord(nodes,start):
    size = len(nodes)
    dist = list(range(size))
    pre = list(range(size))
    flag = True
    for i,v in enumerate(nodes):
        if v==start:
            dist[i] = 0
        else:
            dist[i] = float('inf')
        pre[i] = None
    #print(dist)
    edges = {}
    for n1,v1 in enumerate(nodes):#from n1 to n2 with weight w
            for n2,w in zip(v1.neighbors,v1.weights):
                edges[(n1,n2)]=w
    #print(edges)
    for i in range(size-1):
        change = 0
        for edge in edges:
            val = dist[edge[0]]+edges[edge]
            if val<dist[edge[1]]:
                change+=1
                dist[edge[1]] = val
                pre[edge[1]] = edge[0]
        if change==0:break
    
    if change!=0:flag = False
    
    # for edge in edges:
    #     if dist[edge[1]]>dist[edge[0]]+edges[edge]:
    #         flag = False
    #         break
    print(dist)
    print(pre)
    #False: Negative cycle
    return flag
            
vals = [0,1,2,3,4,5]
neighbors = [[1,2,3],[0,2,4],[0,1,3,4,5],[0,2,5],[1,2],[2,3]]
weights = [[8,2,4],[8,7,2],[2,7,1,3,9],[4,1,5],[2,3],[9,5]]
#weights = [[8,6,4],[8,7,2],[6,7,1,0,-8],[4,1,5],[2,0],[-8,5]]
nodes = []
for val,neighbor,weight in zip(vals,neighbors,weights):
    #print(val,neighbor,weight)
    nodes.append(Node(val,neighbor,weight))
# for node in nodes:
#     print(node.val)

#Dijkstra(nodes,nodes[0])

print(BellmenFord(nodes,nodes[0]))


