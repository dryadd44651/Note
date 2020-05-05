# Sort Dictionary
```
table = {'anacell': 2, 'betacellular': 3, 'cetracular': 1, 'deltacellular': 1, 'eurocell': 0}
s = sorted(table.items(), key=operator.itemgetter(1),reverse=True)
print([i[0] for i in s])

#['betacellular', 'anacell', 'cetracular', 'deltacellular', 'eurocell']
```

## py to exe
```
pip install auto-py-to-exe
auto-py-to-exe
```
