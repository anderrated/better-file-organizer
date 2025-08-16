import javafx.application.Application; // extended when creating GUI app
import javafx.scene.Scene; // container for visual content
import javafx.scene.control.Button;
import javafx.scene.layout.VBox; // vertical layout pane
import javafx.stage.DirectoryChooser; // select directory
import javafx.stage.Stage; // main application window
import java.io.File; // files/directories in filesystem

public class FileOrganizer extends Application { // DirectorySelector is the class that extends application and uses start method as entry point
    public static void main(String[] args) {
        launch(args); // provided by application, sets up javafx runtime and calls start method
    }

    @Override
    public void start(Stage primaryStage) { // main window provided by javafx system
        primaryStage.setTitle("File Organizer");

        DirectoryChooser directoryChooser = new DirectoryChooser(); // create a directory chooser dialog
        String home = System.getProperty("user.home");
        directoryChooser.setInitialDirectory(new File(home)); // dialog will open pointing to src folder: home of user

        Button button = new Button("Select Directory");
        button.setOnAction(e -> {
            File selectedDirectory = directoryChooser.showDialog(primaryStage); // opens directory chooser window
            // primaryStage is passed so the dialog is linked to the main window
            System.out.println(selectedDirectory.getAbsolutePath()); // prints full path of chosen directory to the console
            ListFiles.listFilesinDirectory(selectedDirectory);
        });


        VBox vBox = new VBox(button);
        //HBox hBox = new HBox(button1, button2);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene); // attaches scene (UI) to the stage (window)
        primaryStage.show(); // display window
    }

}