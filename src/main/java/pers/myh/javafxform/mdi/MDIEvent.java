/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pers.myh.javafxform.mdi;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.image.ImageView;

/**
 * @author myh - 20/08/2019
 */
public class MDIEvent extends Event {

    private static final long serialVersionUID = 2249682426993045124L;
    public static final EventType<MDIEvent> EVENT_CLOSED = new EventType<>(ANY, "EVENT_CLOSED");
    public static final EventType<MDIEvent> EVENT_MINIMIZED = new EventType<>(ANY, "EVENT_MINIMIZED");
    public ImageView imgLogo;

    public MDIEvent(ImageView logoImage, EventType<? extends Event> eventType) {
        super(eventType);
        imgLogo = logoImage;
    }

    public MDIEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
