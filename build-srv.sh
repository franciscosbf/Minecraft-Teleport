#!/bin/bash

URL="https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar"

TOOLS="buildtools"

# without the last slash
SRV="../minecraft-server"

# creates the buildtools folder
if ! [[ -d $TOOLS ]]; then
  mkdir $TOOLS
fi

cd $TOOLS

# downloads if BuildTools
if ! [[ -f "BuildTools.jar" ]]; then
  wget -O BuildTools.jar $URL
fi

# builds the latest version
java -jar BuildTools.jar --rev latest

# creates the srv folder
if ! [[ -d $SRV ]]; then
  mkdir $SRV
fi

# moves to the srv folder
cp -f spigot-*.jar $SRV\/server.jar

cd ..
