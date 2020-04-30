# run images
## spark
> docker run --rm -p 8888:8888 jupyter/scipy-notebook
## R Rstudio
> docker run --rm -p 8787:8787 -e PASSWORD=yourpasswordhere rocker/rstudio


docker exec -it 3084f6cd2f5c bash

docker exec -it cfbd0ea95963 bash

docker exec -it --user root cfbd0ea95963 bash

docker cp cfbd0ea95963:/home/jovyan/work/test D:/
docker cp D:/111.txt  cfbd0ea95963:/home/jovyan/work/

docker container ls



sudo apt-get update
sudo apt-get upgrade
sudo apt-get install openssh-client

apt-get install net-tools
