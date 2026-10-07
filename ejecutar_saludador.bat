bat_content = """@echo off
echo =========================================
echo   Compilar y Ejecutar Sistema Saludador
echo =========================================
echo.

:: IMPORTANTE: Cambia la siguiente ruta a la ubicacion real de la carpeta 'lib' de tu JavaFX SDK
set PATH_TO_FX="C:\\ruta\\a\\tu\\javafx-sdk\\lib"

echo [1/2] Compilando SistemaSaludador.java...
javac --module-path %PATH_TO_FX% --add-modules javafx.controls SistemaSaludador.java

if %ERRORLEVEL% neq 0 (
    echo.
    echo Hubo un error durante la compilacion. Verifica que la ruta de PATH_TO_FX sea correcta.
    pause
    exit /b %ERRORLEVEL%
)

echo [2/2] Compilacion exitosa. Iniciando la aplicacion...
java --module-path %PATH_TO_FX% --add-modules javafx.controls SistemaSaludador

echo.
echo Ejecucion finalizada.
pause
"""

with open("ejecutar_saludador.bat", "w") as f:
    f.write(bat_content)

print("File generated successfully. [file-tag: ejecutar_saludador.bat]")
