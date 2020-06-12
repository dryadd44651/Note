#string
print('string')
str = "123"
str+="4"
print(str)

#stack
print('stack')
stack = []
stack.append(1)
stack.append(2)
stack.append(3)
print(stack.pop(0))

#queue
print('queue')
queue = []
queue.append(1)
queue.append(2)
queue.append(3)
print(queue.pop())

#heap
print('heap')
heap = [6,2,3,4,5]
heapify(heap)#option
heappush(heap, 1)
heappush(heap, 7)
print(heap)
print(heappop(queue))

#Map
print('map')
map = {}
map['one'] =1
map['two'] =2
map['three'] =3
print(map)
#very usful
#with default value
#defaultdict(lambda:float(inf))
listMap = defaultdict(list) 
listMap[1].append(11)
print(listMap[0],listMap[1])
intMap = defaultdict(int)
intMap[1]+=1
print(intMap[0],intMap[1])

#list operation
print('list')
arr = [i+10 for i in range(10)]
print(arr)
print(arr[1:-1])
print(arr[-1])
print(arr.index(15))#reverse find index

#sort
print('sort')
print(sorted(arr, reverse=True))
print(sorted(arr, key=lambda x:-x))
random = [(2, 2), (3, 4), (4, 1), (1, 3)]
random.sort(key=lambda x:x[1])
print(random)
letter={'a':9,'b':8,'c':7}
print(letter)
print(sorted(letter.items(), key=lambda x:x[0]))#sort by key
print(sorted(letter.items(), key=lambda x:x[1]))#sort by val
print(sorted(list(letter.keys())))#sort by key
print(sorted(list(letter.values())))#sort by val
      
employees = [
    {'Name': 'Alan Turing', 'age': 25, 'salary': 10000},
    {'Name': 'Sharon Lin', 'age': 30, 'salary': 8000},
    {'Name': 'John Hopkins', 'age': 18, 'salary': 1000},
    {'Name': 'Mikhail Tal', 'age': 40, 'salary': 15000},
]

employees.sort(key=lambda x: x.get('Name'))
print(employees, end='\n\n')

#bisect
data = [('red', 5),('red2', 5), ('blue', 1), ('yellow', 8), ('black', 0)]
data.sort(key=lambda r: r[1])
keys = [r[1] for r in data]         # precomputed list of keys
print(keys)
print(bisect_left(keys, 5))
print(bisect_right(keys, 5))

#set
set1 = {"apple", "banana", "cherry"}
set1.add("orange")
set1.remove("banana")
print(set1)
print(set1.union({1, 2, 3}))
set1.update({'a','b','c'})
print(set1)


# py to exe
//pip install auto-py-to-exe
//auto-py-to-exe


