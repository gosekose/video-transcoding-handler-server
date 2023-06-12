#!/bin/bash

# Check if the services are running
if [[ "$(docker-compose ps -q 2> /dev/null)" != "" ]]; then
    echo "Services are already running"
else
    echo "Starting services"
    docker-compose up --build -d
fi
