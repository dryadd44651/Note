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


