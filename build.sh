#!/bin/bash

# prepares the server if it isn't created/ready
./prep-srv.sh

# builds the plugin and generates a docker image with the srv
sudo mvn clean
mvn package
sudo mvn docker:build