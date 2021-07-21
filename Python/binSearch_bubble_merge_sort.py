def mergesort(src):
    def merge(src1,src2):
        dst=[]
        while src1 and src2:
            if src1[0]<src2[0]:
                dst.append(src1.pop(0))
            else:
                dst.append(src2.pop(0))
        dst.extend(src1 or src2)
        return dst
    size = len(src)
    if size>1:
        return merge(mergesort(src[:size//2]),mergesort(src[size//2:]))
    return src
            

def bubble(src):
    change = False
    size = len(src)
    for i in range(size):
        change = False
        for j in range(size):
            if src[i]<src[j]:
                src[i],src[j] = src[j],src[i]
                change = True
        if change == False:
            return src
    return src
    
def bin(arr,tar):
    l,r = 0,len(arr)-1
    while l<r:
        mid=(l+r)//2
        if tar>arr[mid]:
            l=mid+1
        elif tar<arr[mid]:
            r=mid-1
        else:
            return mid
    return -1

arr = [2,1,3,7,6,8,4,5,3]
print(mergesort(arr))
# arr[:] clone
sarr = bubble(arr[:])
print(sarr)

print(bin(sarr,2))
print(bin(sarr,3))
print(bin(sarr,4))
