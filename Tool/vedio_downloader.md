- Login to udemy go to the course and play the lecture, for eg. first lecture is running
- Open ‘Developer tools’ by pressing ‘F12’ go to the ‘sources’ tab
- Switch to ‘Snippets’ tab
- Add new snippet with any name for eg. ‘udemy-downloader’
- and paste the code below

```
var videoLink = document.querySelector(".vjs-tech").getAttribute('src');
window.open(videoLink,'_blank');
Save the snippet file using ‘ctrl+s’
And now Right click on the snippet file (udemy-downloader) which have the scripts and click on Run
```
It will download the video for you in selected Quality - (on which it is playing)
Now you only need to follow step number 7 to download your favorite lecture.

