def quickSort(src):
    arr = src[:]
    size = len(arr)
    if size<=1: return arr
    p = arr[0]
    l,r = 1,size-1
    while(l<r):
        while(p<arr[r] and l<r):r-=1
        while(p>arr[l] and l<r):l+=1
        arr[r],arr[l] = arr[l],arr[r]
    if not arr[r]<p:
        r-=1
    arr[0],arr[r] = arr[r],arr[0]
    print(arr[:r],p,arr[r+1:])
    return quickSort(arr[:r])+[p]+quickSort(arr[r+1:])
arr = [40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90]
res = quickSort(arr)
print(res)
