# Supermarket API

This project was developed with the intention of putting into practice the content obtained during courses on Java, Servlet, Spring Boot, and Database. With this, I developed an API REST to access data through HTTP requests: using GET, POST, PUT, and DELETE via the PostMan application.

## How to use?

Before performing the necessary configurations to run the API, it is necessary to have some applications and tools where we will use them for the API usage.

* VSCode
* PostMan
* TablePlus
* Docker

### Step 1: Download all files from this repository

By downloading all the files from this repository, we will open them through the VSCode code editor.

### Step 2: Open the file `Docker-composer.yml`

This file is responsible for having all the necessary configurations for the API to run.

### Step 3: Execute the command `docker compose up`

When entering the application terminal and executing the command `docker compose up`, Docker will download all necessary dependencies for the image to function.

### Step 4: Execute the API through VScode

To execute the API through VScode, it is necessary to enter and find the file called `SupermarketApiApplication.java`. This class is responsible for managing the initialization of our project with Spring Boot, which is only possible because of the `@SpringBootApplication` annotation.

To start the execution of our API, we can use the `execute button` or press `Ctrl + F5`.

#### How to know that the application is starting?

When running the Spring Boot application, we will notice that in the terminal, the `Spring` logo will be displayed and below it, the name `::Spring Boot ::` will be displayed as follows:

![image](https://github.com/Ghustavo516/Supermercado-API/assets/41215700/8d97958b-4ee9-4a10-a80c-d346553ac337)

#### How to know that the API is running?

After Spring Boot initializes and loads all necessary modules for operation without displaying any errors, Spring Boot will display a message indicating that the TomCat server is running and indicating the port it is using, usually, this port is 8080.

With the API already running and all dependencies downloaded and installed for the API to work, we will use the PostMan application to send HTTP requests, such as GET, POST, PUT, and DELETE.

  



