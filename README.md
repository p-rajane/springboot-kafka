# Springboot Kafka Application

A POC application to demonstrate how kafka can be integrate with spring boot framework, using spring boot kafka provided libraries.

## Installation

- Download [Apache Kafka](https://kafka.apache.org/downloads) installation, with recommended stable version is [3.7.0/Scala 2.12](https://archive.apache.org/dist/kafka/3.7.0/kafka_2.12-3.7.0.tgz)
- Extract the downloaded .tgz file to 'C' drive or whichever preferable location. 

> [!IMPORTANT]
> Make sure, you won't have the bin path of Kafka folder too long, else in Command Prompt, the startup command throws an error while starting Kafka server.

- Post extraction, go to Kafka folder directory, and create two folders at config,bin folder levels, and name it as **kafka-logs** & **zookeeper**.
- Now, go to **config** folder and edit zookeeper.properties and server.properties files.
- In zookeeper.properties, edit/set dataDir variable with your zookeeper folder path, like ```dataDir=C:\Users\kafka\zookeeper```
- In server.properties, edit/set log.dirs variable with your kafka-logs folder path, like ```log.dirs=C:\Users\prajane\kafka\kafka-logs```
- Now, its time to start your zookeeper server. Go to the bin folder, if you are using windows, go to bin\windows folder and open command prompt.
and run below command 
```zookeeper-server-start.bat ..\..\config\zookeeper.properties```
- Similarly, like zookeeper, start the Kafka server, and make sure zookeeper server is still running. Open another command prompt at windows folder and run below command.
```kafka-server-start.bat ..\..\config\server.properties```
- To verify if Kakfa server is running, run below command to get list of topics created. By default, it will show 0 topics if not created.
```kafka-topics.bat --list --bootstrap-server localhost:9092```
- Your Kakfa server is started successfully.
