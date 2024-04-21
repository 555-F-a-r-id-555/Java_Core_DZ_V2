# Makefile для сборки Docker-образа и запуска контейнера

# Переменные
JAR_FILE = lesson2.jar
DOCKER_IMAGE = java-program-lesson2
DOCKER_CONTAINER = java-container-lesson2

# Цели
.PHONY: all build run clean

all: build run

# Сборка Docker-образа
build:
    docker build -t $(DOCKER_IMAGE) .

# Запуск контейнера
run:
    docker run --name $(DOCKER_CONTAINER) $(DOCKER_IMAGE)

# Очистка
clean:
    docker stop $(DOCKER_CONTAINER)
    docker rm $(DOCKER_CONTAINER)
    docker rmi $(DOCKER_IMAGE)