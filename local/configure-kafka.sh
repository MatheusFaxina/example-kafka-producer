#!/bin/bash

NOCOLOR='\033[0m'
GREEN='\033[0;32m'
CYAN='\033[0;36m'

echo ""
echo -e "${CYAN}Initializing configure Kafka${NOCOLOR}"

docker container exec kafka kafka-topics --create --topic example-kafka-producer.person --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1
docker container exec kafka kafka-topics --create --topic example-kafka-producer.money-movement --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1

echo ""
echo -e "${GREEN}Finish configure Kafka"
