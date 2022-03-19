<h1 align="center">Kafka Producer</h1>

<p align="center">
Development project to apply knowledge about Kafka</p>

### 🛠 Technologies
___
The following tools were used in building the project:

- [Java](https://www.java.com/pt-BR/)
- [Lombok](https://projectlombok.org/)
- [Spring 2.5.5](https://spring.io/blog/2021/08/19/spring-boot-2-5-5-available-now)
- [Kafka](https://kafka.apache.org/)

### ✅ Prerequisites
___
Before starting, you will need to have the following tools installed on your machine:
[Git](https://git-scm.com/) and [Java](https://www.java.com/pt-BR/).
Besides, it's good to have an editor to work with the code like [Intellij](https://www.jetbrains.com/pt-br/idea/)

### 🎲 Running the project
___
```bash
# Clone this repository
$ git clone <https://github.com/MatheusFaxina/example-kafka-producer.git>

# Access the project folder in terminal/cmd
$ cd example-kafka-producer

# Generate infrastructure
$ make infra

# Delete infrastructure (Optional)
$ make remove-infra

# Go to the server folder
$ mvn clean package

# Install the dependencies
$ java -jar target/example-kafka-producer-0.0.1-SNAPSHOT.jar

# The server will start on port:3000 - go to <http://localhost:8080>
```

### ➕ Details of the developed solution
___
*Two public endpoints were developed in the H database and messages on topics that different endpoints

### ✒️ Author
___
<a href="https://www.linkedin.com/in/matheusvfaxina/">
 <img style="border-radius: 50%;" src="https://media-exp1.licdn.com/dms/image/C4E03AQHrHj9yWmIbgg/profile-displayphoto-shrink_800_800/0/1610406929592?e=1636588800&v=beta&t=7og_fNQRDlbZp38HsaQ5sV9MMBrxVqO-YkPJKfUyYZo" width="100px;" alt=""/>
 <br />
 <sub><b>Matheus Faxina</b></sub></a> <a href="https://www.linkedin.com/in/matheusvfaxina/" title="Linkedin"></a>

[![Gmail Badge](https://img.shields.io/badge/-matheus.vfaxina@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:matheus.vfaxina@gmail.com)](mailto:matheus.vfaxina@gmail.com)
