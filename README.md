## Minecraft Teleport

Spigot plugin that registers a command which allows teleporting to a player location.

### Plugin specification

The default version of spigot api is set to 1.18 and located at `src/main/resources/plugin.yml`

### Some notes about compilation

- It is done by using maven
- Java version: `1.8`
- The `pom.xml` file specifies all you need in order to compile the plugin
</br>&nbsp;&nbsp;&nbsp;&nbsp;_Custom properties:_
    - `plugin.folder` specifies the destination of the plugin
    - `docker.img.name` contains the name of the docker image that has the server + plugin

### Automated development

Scripts were made in [bash 5.1.16](https://www.gnu.org/software/bash/)

- `build-srv.sh` builds the server with the latest version and copies the **server.jar** to the **minecraft-server** folder
- `prep-srv.sh` executes **build-srv.sh** if necessary, generates the server and accepts eula
- `build.sh` builds the plugin and generates a docker image with a prepared server + created plugin (firstly, verifies if the server is created and ready to use)
- `run.sh` launches the docker with the server