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
command
```
grep "^\(([0-9]\{3\}) \|[0-9]\{3\}-\)[0-9]\{3\}-[0-9]\{4\}$" file.txt

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
