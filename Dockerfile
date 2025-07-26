FROM ubuntu:latest
LABEL authors="aman"

ENTRYPOINT ["top", "-b"]