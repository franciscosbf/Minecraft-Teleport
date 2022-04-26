## Minecraft Teleport

Spigot plugin that registers a command which allows teleporting to a player location.

### Plugin specification

- The default version of spigot api is set to 1.18 and located at `src/main/resources/plugin.yml`

### Some notes about compilation

- It is done by using maven
- Java version: `1.8`
- The `pom.xml` file specifies all you need in order to compile the plugin. Keep in mind that the `outputFile` tag specifies the destination of the `.jar` file (default is minecraft-server/plugins/tp-plugin.jar)
- You can see an example [here](https://www.spigotmc.org/wiki/creating-a-plugin-with-maven-using-intellij-idea/#compiling) about plugin compilation using IntelliJ IDE 