/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibraries.Effects;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author polina
 */
public class ZoomTools {

    private static EventHandler zoom;

    /**
     * SetZoomable est une methode qui va affecté le pourcentage du zoom
     * de l'object au quel on va affecter le zoom
     * 
     * @param scale est le pourcenatge du zoom ex : 1.2 pour agrandir 0.8 pour retraissir
     */
    public static void SetZoomable(float scale) {

        zoom = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Object o = event.getSource();
                if (o instanceof Label) {
                    Label L = (Label) o;
                L.setScaleY(scale);
                L.setScaleX(scale); 
                return;
                }
                throw new AbstractMethodError("Object Not Handled Exception");
            }

        };
    }

    public static void InitLabel(Label l) {
        l.setOnMouseEntered(zoom);
        EventHandler retract = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Label L = (Label) event.getSource();
                L.setScaleY(1);
                L.setScaleX(1);
            }

        };
        l.setOnMouseExited(retract);
    }

}
