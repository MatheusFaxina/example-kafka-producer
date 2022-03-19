SHELL = /bin/bash

.DEFAULT_GOAL := help

.PHONY: help

tmpFolder=/tmp/dump

help: ## show this help
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

infra: ## create and start postgres, aws, zookeeper, kafka, schema registry, kafka gui(localhost:9021) and zookeeper gui(localhost:8004) docker instances
	docker-compose -f local/docker-compose.yml build
	docker-compose -f local/docker-compose.yml up -d
	bash local/configure-kafka.sh


remove-infra:
	docker stop zookeeper kafka kafka-schema-registry kafka-control-center zoonavigator
	docker rm zookeeper kafka kafka-schema-registry kafka-control-center zoonavigator
