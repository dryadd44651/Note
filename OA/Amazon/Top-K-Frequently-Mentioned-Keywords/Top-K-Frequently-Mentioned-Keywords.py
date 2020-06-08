import re
from collections import Counter
import heapq

k = 2
keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]
# Output:
# ["betacellular", "anacell"]

# Explanation:
# "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
def topKFrequent(k, keywords, reviews):
    '''
    k: int
    keywwords: list of string
    reviews: list of string
    '''
    word_list = []

    for review in reviews:
        word_list += set(review.lower().replace('[^a-z0-9]', '').split())

    count = Counter(word_list)
    #print(count)
    heap = []
    for word, freq in count.items():
        if word in keywords:
            #heap:root is min => get max -freq
            heapq.heappush(heap, (-freq,word))
            print((freq,word))


    return [heapq.heappop(heap)[1] for i in range(k)]
    # table = {}
    # for word in keywords:
    #     if word not in table: table[word] = 0
    #     if word not in count: table[word] = 0
    #     table[word] = count[word]
    # print(table)
    # s = sorted(table.items(), key=operator.itemgetter(1),reverse=True)
    # print([i[0] for i in s])
    # return([i[0] for i in s[:k]])

print(topKFrequent(k, keywords, reviews))
