@echo off
echo Compiling Java files...
javac --module-path "C:/javafx/javafx-sdk-26/lib" --add-modules javafx.controls,javafx.fxml -d bin src\*.java

echo Copying resources...
if exist src\styles.css copy src\styles.css bin\ >nul

echo Running FileOrganizer...
java --module-path "C:/javafx/javafx-sdk-26/lib" --add-modules javafx.controls,javafx.fxml -cp bin FileOrganizer
pause
