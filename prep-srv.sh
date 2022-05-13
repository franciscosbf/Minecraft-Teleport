#!/bin/bash

SRV="minecraft-server"

function run() {
    java -Xms1024M -Xmx1024M -jar server.jar --nogui
}

# builds the server
if ! ([[ -d $SRV ]] && [[ -f $SRV\/server.jar ]]); then
  ./build-srv.sh
fi

cd $SRV

if ! [[ -f eula.txt ]]; then
  # generates the server
  run
fi

# accepts eula
sed -i 's/eula=false/eula=true/' eula.txt

# builds the world
if ! [[ -d world ]]; then
  while true; do
    read -p "Generate world (this will launch the server -> use Ctrl+C after the server is ready)? (y/n) " input
    if [[ $input =~ ^[yY]{1}$ ]]; then
      # replaces some configs
      sed -i 's/max-players=20/max-players=2/' server.properties
      sed -i 's/view-distance=10/view-distance=4/' server.properties
      sed -i 's/simulation-distance=10/simulation-distance=4/' server.properties
      sed -i 's/max-world-size=29999984/max-world-size=746496/' server.properties
      run
      break
    elif [[ $input =~ ^[nN]{1}$ ]]; then
      break
    fi
  done
fi

cd ..
