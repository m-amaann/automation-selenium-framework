FROM ubuntu:latest
LABEL authors="amaan"

ENTRYPOINT ["top", "-b"]