package pers.myh.javafxform.mdi;


import javafx.scene.Node;

/**
 * @author myh - 20/08/2019
 */


public class Utility {

    /**
     * @param mainPane
     * @return
     */
    public static MDIWindow getMDIWindow(Node mainPane){
        MDIWindow mdiW = (MDIWindow) mainPane.getParent().getParent();
        return mdiW;
    }
}
