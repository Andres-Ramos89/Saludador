# Saludador
GUÍA DE COMPILACIÓN Y EJECUCIÓN - SISTEMA SALUDADOR (JAVAFX)

Esta guía detalla los pasos para ejecutar la aplicación "SistemaSaludador.java" desde la terminal de comandos o utilizando un IDE moderno.

PRERREQUISITOS

Para compilar y ejecutar este código base sin gestores de dependencias (como Maven o Gradle), necesitas tener instalado en tu sistema:

Java Development Kit (JDK): Versión 11 o superior (se recomiendan versiones LTS como Java 17 o 21). Asegúrate de tener configurada la variable de entorno JAVA_HOME o que el comando 'java' y 'javac' funcionen en tu terminal.

JavaFX SDK: Descarga la versión correspondiente a tu sistema operativo desde la página oficial de Gluon (https://gluonhq.com/products/javafx/).

Descomprime el archivo descargado en una carpeta de tu preferencia (ej. C:\javafx-sdk o /Users/tu-usuario/javafx-sdk).

COMPILACIÓN (Desde la Terminal)

Abre tu terminal y navega hasta la carpeta donde guardaste el archivo "SistemaSaludador.java".
Debes indicar al compilador (javac) dónde encontrar las librerías de JavaFX.

Ejecuta el siguiente comando, reemplazando la ruta de ejemplo por la ruta real donde descomprimiste la carpeta "lib" de tu JavaFX SDK:

Mac / Linux:
javac --module-path /ruta/absoluta/a/tu/javafx-sdk/lib --add-modules javafx.controls SistemaSaludador.java

Windows:
javac --module-path "C:\ruta\absoluta\a\tu\javafx-sdk\lib" --add-modules javafx.controls SistemaSaludador.java

Nota: Las comillas en Windows son útiles si tu ruta tiene espacios. Si no hay errores, este comando generará varios archivos .class en tu directorio.

EJECUCIÓN (Desde la Terminal)

Una vez compilado, debes usar el comando 'java' pasando los mismos parámetros de la máquina virtual (VM options) para cargar los módulos gráficos al ejecutar.

Mac / Linux:
java --module-path /ruta/absoluta/a/tu/javafx-sdk/lib --add-modules javafx.controls SistemaSaludador

Windows:
java --module-path "C:\ruta\absoluta\a\tu\javafx-sdk\lib" --add-modules javafx.controls SistemaSaludador

¡Al presionar Enter, la interfaz gráfica de tu Sistema Saludador debería abrirse en pantalla!

ALTERNATIVA: EJECUCIÓN DIRECTA CON IDE (Cursor / VS Code)

Si utilizas Cursor o Visual Studio Code y quieres usar el botón "Run" (Play) en lugar de la terminal, debes configurar las VM options en el entorno de depuración:

Asegúrate de tener instalada la extensión "Extension Pack for Java" de Microsoft.

Abre tu proyecto en el IDE.

Ve a la vista "Run and Debug" y crea un archivo "launch.json" (si no lo tienes aún).

Dentro del archivo launch.json, busca la configuración de tu clase principal ("mainClass": "SistemaSaludador") y agrega la propiedad "vmArgs". Debe quedar así:

{
"type": "java",
"name": "Ejecutar SistemaSaludador",
"request": "launch",
"mainClass": "SistemaSaludador",
"vmArgs": "--module-path "C:\ruta\absoluta\a\tu\javafx-sdk\lib" --add-modules javafx.controls"
}

Guarda el archivo launch.json. Ahora, cuando presiones el botón "Run" o "Debug", el IDE inyectará automáticamente la ruta del SDK de JavaFX y la aplicación iniciará correctamente.
