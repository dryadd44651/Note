**help**
- man ls
- ls --help

**ls**
- ls -l ： list
- ls -lh : list with friendly file size
- ls -a : all(include hidden files)

**show**
- cat file: show all
- head -5 file: show first 5 (default is 10)
- tail -5 file: show last 5
- tail -f file: show when file update
- less file: find the string "123" with /123 (q to left, n next, shift last)
- cat file | grep -n srt: find the str in file with line# (-n)
```
cat *.txt > ./tmp/all.txt #write all txt file data into all.txt
```

**wc**
- wc file: show line, word, bytes

**input/output**
- echo hello > hello.txt: redirect to a file
- echo hello >> hello.txt: append
- cat < hello.txt: read hello.txt to cat

**download and play vedio in terminal**
```
#sudo pip install youtube_dl
#download the vedio from https://www.youtube.com/watch?v=pq44-o-vTXo
youtube-dl pq44-o-vTXo -o net.mp4 #download
#sudo apt install ffmpeg
ffmpeg -i net.mp4 net_h264.mp4 # conversion
#sudo apt install mplayer
mplayer -vo caca -quiet net_h264.mp4 # play
```
**Shebang (Unix)**
```
#!/usr/bin/env python3
...python script
```
this python file will open by python3 in default

**find path**
- which python
- which java
- $PWD #current path
- $PATH #system path
- PATH=$PATH:$PWD #add current path to system path(this is temporary)
- write "PATH=$PATH:$PWD" to /.bashrc #permanent add

**chmod**
- chmod +x file: add exe(add too all)
- chmod -r file: remove read
- chmod 741 file: -rwx-r-x-(user group other)

**mv**
- mv hwllo hello #rename to hello
- mv hello ../hello #move to ../

**cp**
- cp a ../a #copy to ../
- cp -r dir ../dir #copy to ../

**rm**
- rm a #delet a (Danger, can't undo)
- rm a b c #delete a b c
- rm -r dir #recursive delete all file in dir
- rm -f a #force delete

**yes**
- yes #print 'y' nonstop (ctrl + C to stop)
- yes 'good' #print 'good' nonstop
- yes | sudo apt-get install ... #y to all install query
- yes 'hello' > hello.txt #append 'hello' to hello.txt nonstop (Danger)

**word count**
- cat a.txt | sort | uniq -c #uniq -c will aggregate and count the word


**mutithread**
If each command do not print string, the command will execute parallelly
```
echo 1 >> test | echo 2 >> test | echo 3 >> test
cat test
2
1
3
```
**xargs**
- *xargs will split the arg and execute it respectively *
- -n3 get 3 elements, -P3 perform 3 at once (max)
```
echo 1 1 1 2 2 2 3 3 3| xargs -n3 -P3 echo
1 1 1
2 2 2
3 3 3
echo 1 1 1 2 2 2 3 3 3| xargs -n2 -P9 echo
1 1
1 2
2 2
3 3
3
echo 1 1 1 2 2 2 3 3 3| xargs -n1 -P9 echo
1
1
1
2
2
2
3
3
3
```
**time**
*running time*
```
time man ls | xargs -n1 >>a
xargs: unmatched single quote; by default quotes are special to xargs unless you use the -0 option

real    0m2.507s
user    0m0.219s
sys     0m1.313s
```
#use more process => run faster (-P100)
```
time man ls | xargs -n1 -P100 >>a
xargs: unmatched single quote; by default quotes are special to xargs unless you use the -0 option

real    0m0.774s
user    0m0.109s
sys     0m1.016s
```
**diff**
*compare the diff*
```
howard@DESKTOP-0QJC6L6:~$ echo 123 > a
howard@DESKTOP-0QJC6L6:~$ echo 1234 > a1
howard@DESKTOP-0QJC6L6:~$ diff a a1
1c1
< 123
---
> 1234
```

**printf**
#a + 3 spaces+b + 1 space+66.12(show 2 digit)
```
printf "%-3s %-1s %-4.2f\n" a b 66.1234
a   b 66.12
#3 spaces + None
printf "%3s %0.0s\n" a b
   a
#%0.0 = %. = %.0 = %0.
```
```
printf "%s\n" {1..100}
1
2
3...
100

printf "1%.s" {1..10}
1111111111h
```
```
howard@DESKTOP-0QJC6L6:~$ printf "1%.s " {1..100} > a
howard@DESKTOP-0QJC6L6:~$ printf "2%.s " {1..100} >> a
howard@DESKTOP-0QJC6L6:~$ printf "3%.s " {1..100} >> a
howard@DESKTOP-0QJC6L6:~$ cat a
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3
```
**find**
find the file
```
sudo find /etc -name python
/etc/apparmor.d/abstractions/python

find  /mnt/c/Users/dryad/OneDrive/ -name 'test*'
/mnt/c/Users/dryad/OneDrive/Desktop/test
/mnt/c/Users/dryad/OneDrive/Desktop/test/test.py
/mnt/c/Users/dryad/OneDrive/Desktop/test/test.txt
```
**grep**
- i stands for ignore case (optional in your case).
- R stands for recursive.
- l stands for "show the file name, not the result itself".
```
howard@DESKTOP-0QJC6L6:~/test$ cat a
123456789
howard@DESKTOP-0QJC6L6:~/test$ cat a1
23456789
grep -ril '1' ./
./a

grep '1' ./a
123456789

grep -r 'print("123")' /mnt/c/Users/dryad/OneDrive
/mnt/c/Users/dryad/OneDrive/Desktop/test/test.py:print("123")

```

