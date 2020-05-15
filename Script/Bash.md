# Grep
*grep is a command-line utility for searching plain-text data sets for lines that match a regular expression。*

## Valid Phone Numbers
Assume that file.txt has the following content:
```
987-123-4567
123 456 7890
(123) 456-7890
```
Your script should output the following valid phone numbers:
```
987-123-4567
(123) 456-7890
```
**command**
```
grep "^\(([0-9]\{3\}) \|[0-9]\{3\}-\)[0-9]\{3\}-[0-9]\{4\}$" file.txt
```
**explain**
```
^: start with

\(([0-9]\{3\}) \|[0-9]\{3\}-\)

(A or B )
A:([0-9]\{3\}) 
B:[0-9]\{3\}-

[0-9]:number 0~9
\{3\}:{3} repeat 3 times
$:end
(no $ (001) 345-00001 will match)
```
# Print Line
- awk print 2th line
- head print 1~2 line and tail print last line
```
awk "NR == 2" test.txt
head -2 test.txt | tail -1
```
# Transpose File
Given a text file file.txt, transpose its content.
```
name age
alice 21
ryan 30
Output the following:

name alice ryan
age 21 30
```
sample1
```
awk '
{     
   print $var
}' file.txt

result:

name age
alice 21
ryan 30
```
sample2
```
awk '
{     
   print $1
}' file.txt

result:

name
alice
ryan
```
solution
```
awk '
{     
    for (i = 1; i <= NF; i++) {
        s[i] = s[i] " " $i
    }
}END{
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file.txt

#got three row part '{for}' will run three times
#NR: row 123
#NF: number of col 222
#END: first part for finished(three times)
#second part for print
```
# Word Frequency

Assume that words.txt has the following content:
```
the day is sunny the the
the sunny is is
```
Your script should output the following, sorted by descending frequency:
```
the 4
is 3
sunny 2
day 1
```
**solution1**
```
awk '\
{ for (i=1; i<=NF; i++) 
   ++D[$i];
}
END { 
   for (i in D) 
      print i, D[i]

}' words.txt | sort -nr -k 2
```
part1: use dictionary skill get frequency
```
awk '\
{ for (i=1; i<=NF; i++) 
   ++D[$i];
}
END { 
   for (i in D) 
      print i, D[i]

}' words.txt

output:

day 1
sunny 2
the 4
is 3
```
part2: sort
```
words.txt | sort -nr -k 2

sort -n means "compare according to string numerical value".
sort -r means "reverse the result of comparisons".
sort -k 2 means "sort by the second word"

```
**solution2**
```
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'
```
- tr -s: truncate the string with target string, but only remaining one instance (e.g. multiple whitespaces)
- sort: To make the same string successive so that uniq could count the same string fully and correctly.
- uniq -c: uniq is used to filter out the repeated lines which are successive, -c means counting
- sort -r: -r means sorting in descending order
- awk '{ print $2, $1 }': To format the output



