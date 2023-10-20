
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/mcau92/java-exercises-projects/edit/master/com.cauduro.example.rabbitmq">
    <img src="rabb_img.png" alt="Logo" width="480" height="180">
  </a>

<h3 align="center">Rabbitmq with Spring Boot and Docker</h3>

  <p align="center">
    Tutorial on how to connect two simple Spring boot app with Rabbitmq, as message broker, using Docker
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#usage">Installation</a></li>
      </ul>
    </li>
    <li><a href="#links">Links</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project explain how to get started in order to send message through 2 simple java applications, using Rabbitmq.
Docker is used to host the Rabbitmq server, even for building and running automation



### Built With

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)

## Getting Started

Download the project on your local machine and run, on the main folder, the docker compose command (See the Usage section]
This will start 3 docker container for hosting Rabbitmq server and 2 java application.

### Prerequisites

If you want to run this project on your machine you need:
<ol>
  <li>Java v.17</li>
  <li>Maven v.3.9.2</li>
  <li>Docker v.4.24.0 with Docker compose v.2.22.0</li>
</ol>

Or you can use an IDE with java and maven version already provided.

### Usage

Start Docker on your machine;

Then run, on the main folder, the following command

```
docker-compose up --build
```
or in MacOs/Linux

```
sudo docker-compose up --build
```
After the 3 containers started, go to http://localhost:8080 and type whatever you want for example:
```
http://localhost:8080/hello-it-works?
```

Then you can easily view the log on the sender and recevier container that shows the message.!

## Links

You can follow also the [Spring AMQP](https://spring.io/guides/gs/messaging-rabbitmq/) for going deeper about rabbitmq technology

