def foo(n):
    while n<10:
        n+=1
        yield n

g = foo(0)
for i in g:#g : 1,2,3...10
    print(i)

g1= foo(0)
print(next(g1))# get 1
print(next(g1))# get 2
print(next(g1))# get 3
