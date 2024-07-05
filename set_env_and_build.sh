#!/bin/bash

# Set environment variables
export PGHOST=monorail.proxy.rlwy.net
export PGPORT=15728
export PORT=8080

# Run Maven clean install and start the application
mvn clean install && mvn spring-boot:run
