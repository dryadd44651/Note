# run images
- --rm: remove container->remove files
- -p: publish the port
- -e: set any environment variable
- spark
> docker run --rm -p 8888:8888 jupyter/scipy-notebook
- R Rstudio
> docker run --rm -p 8787:8787 -e PASSWORD=yourpasswordhere rocker/rstudio

# remove  container
docker rm -v my-container

# run a command container
- run bash
>- docker exec -it 3084f6cd2f5c bash
>- docker exec -it cfbd0ea95963 bash
# --user root: run as root
docker exec -it --user root cfbd0ea95963 bash

#copy the file between local and container
- docker cp cfbd0ea95963:/home/jovyan/work/test D:/
- docker cp D:/111.txt  cfbd0ea95963:/home/jovyan/work/

# list all container
- docker container ls


# Linux cmd
- apt-get update
- apt-get upgrade
- apt-get install openssh-client
- apt-get install net-tools
