package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingController;
import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;

public class DrawingView extends JPanel {
    AppService appService;

    public DrawingView(AppService appService){

        this.appService = appService;
        DrawingController drawingController = new DrawingController(appService, this);
    }

    @Override
    public void paint(Graphics g) {
        Drawing drawing = (Drawing) appService.getModel();
        for(Shape shape : drawing.getShapes()){
            shape.getRendererService().render(g, shape, false);
        }
    }
}
