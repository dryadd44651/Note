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
# /usr/bin/env python3

**find path**
- which python
- which java

