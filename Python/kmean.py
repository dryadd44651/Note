point = [(2,10), (2,5), (8,4), (5,8), (7,5), (6,4), (1,2), (4,9)]
centers = [(2,5), (5,8), (4,9)] #(10,5), (2,9), (3,3) #(2,5), (5,8), (4,9)
clust = [[],[],[]]

dist = lambda p1,p2 : ((p1[0]-p2[0])**2+(p1[1]-p2[1])**2)**0.5
def cen(c):
    size = len(c)
    x,y = 0,0
    for i in c:
        x+=i[0]
        y+=i[1]
    return (round(x/size,2),round(y/size,2))
d = []
for k in range(5):
    for i,p in enumerate(point):
        #print(dist((0,0),p))
        d.append(dist(centers[0],p)) 
        d.append(dist(centers[1],p)) 
        d.append(dist(centers[2],p)) 
        #print(d)
        #print(min(enumerate(d),key=operator.itemgetter(1)))
        clust[min(enumerate(d),key=operator.itemgetter(1))[0]].append(p)
        d = []

    print(clust)
    centers[0] = cen(clust[0])
    centers[1] = cen(clust[1])
    centers[2] = cen(clust[2])
    clust = [[],[],[]]
    print(centers)

