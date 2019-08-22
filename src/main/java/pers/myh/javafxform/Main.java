package pers.myh.javafxform;

import pers.myh.javafxform.mdi.MDICanvas;
import pers.myh.javafxform.mdi.MDIWindow;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author myh - 20/08/2019
 */
public class Main extends Application {
    int count = 0;
    public static HostServices hostServices;

    @Override
    public void start(Stage primaryStage) throws Exception {
        hostServices = getHostServices();

        //Creat main Pane Layout
        AnchorPane mainPane = new AnchorPane();
        mainPane.setPrefSize(800, 600);
        //Creat MDI Canvas Container
        MDICanvas mdiCanvas = new MDICanvas(MDICanvas.Theme.DEFAULT);
        //Fit it to the main Pane
        AnchorPane.setBottomAnchor(mdiCanvas, 0d);
        AnchorPane.setLeftAnchor(mdiCanvas, 0d);
        AnchorPane.setTopAnchor(mdiCanvas, 25d);//Menu place
        AnchorPane.setRightAnchor(mdiCanvas, 0d);
        //Put the container Into the main pane
        mainPane.getChildren().add(mdiCanvas);

        //Create a 'New MDI Window' Button
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        // File menu - new, save, exit
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(newMenuItem, new SeparatorMenuItem(), exitMenuItem);
        newMenuItem.setOnAction(actionEvent -> {
            Node content = null;
            try {
                content = FXMLLoader.load(getClass().getResource("/MyContent.fxml"));
            } catch (Exception e) {
            }
            count++;
            //Create a Default MDI Withou Icon
            MDIWindow mdiWindow = new MDIWindow("UniqueID" + count,
                    new ImageView("/assets/WindowIcon.png"),
                    "Title " + count,
                    content);
            //Set MDI Size
            //Add it to the container
            mdiWindow.maximizeRestoreMdiWindow();
            mdiCanvas.addMDIWindow(mdiWindow);
        });
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        menuBar.getMenus().addAll(fileMenu);
        mainPane.getChildren().add(menuBar);

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
