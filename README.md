# File Organizer

The File Organizer is a Java application that helps you organize files in a directory by automatically moving them into folders based on their file extensions.

## Installation

To run the File Organizer, you will need to have Java 8 or later installed on your system. You can download the latest version of Java from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).

Once you have Java installed, you can download the source code for the File Organizer from the project's repository. You can either clone the repository using Git or download the ZIP file and extract it.

## Usage

To use the File Organizer, follow these steps:

1. Open a terminal or command prompt and navigate to the directory where you extracted the source code.
2. Compile the Java files using the following command:

   ```
   javac --module-path "C:/javafx/javafx-sdk-26/lib" --add-modules javafx.controls,javafx.fxml -d bin src\FileOrganizer.java src\ListFiles.java src\MappingReader.java
   ```

3. Run the `FileOrganizer` class using the following command:

   ```
   java --module-path "C:/javafx/javafx-sdk-26/lib" --add-modules javafx.controls,javafx.fxml -cp bin FileOrganizer
   ```

4. The application will open a window with a "Select Directory" button. Click the button to select the directory you want to organize.
5. The application will automatically move the files in the selected directory into folders based on their file extensions.

## API

The File Organizer uses the following classes:

- `FileOrganizer`: The main class that extends the `Application` class and creates the GUI.
- `ListFiles`: A utility class that lists the files in a directory and moves them into the appropriate folders.
- `MappingReader`: A class that reads a mapping file (`mapping.txt`) and stores the file extension to folder name mappings.

## Contributing

If you would like to contribute to the File Organizer project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your changes.
3. Make your changes and commit them.
4. Push your changes to your forked repository.
5. Create a pull request to the original repository.

## License

The File Organizer is licensed under the [MIT License](LICENSE).

## Testing

To run the tests for the File Organizer, you can use the following command:

```
javac --module-path "C:/javafx/javafx-sdk-26/lib" --add-modules javafx.controls,javafx.fxml -d bin src\FileOrganizer.java src\ListFiles.java src\MappingReader.java
java --module-path "C:/javafx/javafx-sdk-26/lib" --add-modules javafx.controls,javafx.fxml -cp bin FileOrganizer
```

This will run the application with assertions enabled, which will help catch any issues with the file organization logic.
