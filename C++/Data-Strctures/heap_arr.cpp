void print(int arr[]){
    for(int i =1;i<arr[0]+1;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}
void init(int src[],int size,int dst[]){
    dst[0] = size;
    for(int i = 1;i<size+1;i++){
        dst[i] = src[i-1];
        cout<<dst[i]<<" ";
    }
    cout<<endl;
}
int type(int arr[]){
    int size = arr[0],first = arr[1];
    int min = first,max = first;
    for(int i =1;i<=size;i++){
        if(arr[i]>max)
            max = arr[i];
        else if(arr[i]<min)
            min = arr[i];
    }
    if(min==max)
        return 3;
    if(max==first)
        return 2;
    if(min==first)
        return 1;
    else
        return -1;//error
}
void percolate(int arr[],int root,int factor = 1){//percolate down
    //int root = idx;
    int left = root*2,right = root*2+1;
    int min = arr[root],flag = 0;
    if(left<=arr[0] && factor*min>factor*arr[left])
        min = arr[left],flag = 1;
    if(right<=arr[0] && factor*min>factor*arr[right])
        min = arr[right],flag = 2;
    if(flag==1){//chose left, update left
        swap(arr[root],arr[left]);
        percolate(arr,left,factor);
    }else if(flag==2){//chose right, update right
        swap(arr[root],arr[right]);
        percolate(arr,right,factor);
    }
}
//factor = 1: min
//factor = -1: max
void heapify(int arr[],int factor = 1){
    // Index of last non-leaf node 
	int startIdx = arr[0]/2;
    for(int i = startIdx;i > 0;i--)
        percolate(arr,i,factor);
}
//reverse = 0 : Ascending 
//reverse = 1 : Descending  
void heapSort(int arr[],int reverse = 1){
    int root = 1,size = arr[0];
    int factor = (reverse==1)? 1:-1;
    heapify(arr,factor);
    //1 min heap -1 max heap
    while(arr[0]>0){
        percolate(arr,1,factor);
        swap(arr[root],arr[arr[0]]);
        arr[0]--;
    }
    arr[0] = size;
    print(arr);

}
void push(int heap[],int val,int factor = 1){
    //factor = 1: min
    //factor = -1: max
    int t = type(heap);//Foolproof
    if(t==1)
        factor=1;
    else if(t==2)
        factor=-1;
        
    heap[0]++;
    int idx = heap[0];
    heap[idx] = val;
    while(idx>1){//percolate up
        if(factor*heap[idx]<factor*heap[idx/2]){
            swap(heap[idx],heap[idx/2]);
            idx/=2;
        }
        else
            break;
    }
}
int pop(int heap[],int factor = 1){
    int t = type(heap);//Foolproof
    if(t==1)
        factor=1;
    else if(t==2)
        factor=-1;
    int val = heap[1];
    heap[1] = heap[heap[0]];
    heap[0]--;
    percolate(heap,1,factor);
    return val;
}
int main() {
    int arr[] = {35,20,30,7,15,17,1,6};
    int size = sizeof(arr)/sizeof(int);
    int heap[128];
    init(arr,size,heap);
    heapify(heap,1);//min heap
    print(heap);
    push(heap,-1);
    cout<<"pop "<<pop(heap,1)<<endl;
    print(heap);
    heapify(heap,-1);//max heap
    print(heap);
    // push(heap,50,-1);
    // cout<<"pop "<<pop(heap,-1)<<endl;
    // print(heap);
    // cout<<"sort"<<endl;
    // heapSort(heap,0);
    // heapSort(heap,1);
}
