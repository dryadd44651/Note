# common usage
```
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

```
```
string
1234
stack
1
queue
3
heap
[1, 4, 2, 6, 5, 3, 7]
1
map
{'one': 1, 'two': 2, 'three': 3}
[] [11]
0 1
list
[10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
[11, 12, 13, 14, 15, 16, 17, 18]
19
5
sort
[19, 18, 17, 16, 15, 14, 13, 12, 11, 10]
[19, 18, 17, 16, 15, 14, 13, 12, 11, 10]
[(4, 1), (2, 2), (1, 3), (3, 4)]
{'a': 9, 'b': 8, 'c': 7}
[('a', 9), ('b', 8), ('c', 7)]
[('c', 7), ('b', 8), ('a', 9)]
['a', 'b', 'c']
[7, 8, 9]
[{'Name': 'Alan Turing', 'age': 25, 'salary': 10000}, {'Name': 'John Hopkins', 'age': 18, 'salary': 1000}, {'Name': 'Mikhail Tal', 'age': 40, 'salary': 15000}, {'Name': 'Sharon Lin', 'age': 30, 'salary': 8000}]
```

## py to exe
```
pip install auto-py-to-exe
auto-py-to-exe
```

