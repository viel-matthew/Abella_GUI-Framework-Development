package com.gabriel.draw.controller;

import com.gabriel.draw.model.Line;
import com.gabriel.draw.model.Rectangle;
import com.gabriel.draw.model.Ellipse;
import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.draw.view.DrawingView;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingController  implements MouseListener, MouseMotionListener {
    private Point end;
    final private DrawingView drawingView;

    Shape currentShape;
    AppService appService;
    public DrawingController(AppService appService, DrawingView drawingView){
        this.appService = appService;
        this.drawingView = drawingView;
        drawingView.addMouseListener(this);
        drawingView.addMouseMotionListener(this);
        appService.setDrawMode(DrawMode.Idle);
        appService.setShapeMode(ShapeMode.Line);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point start;
        if(appService.getDrawMode() == DrawMode.Idle) {
            start = e.getPoint();

            if(appService.getShapeMode() == ShapeMode.Line) {
                currentShape = new Line(start,start);
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,false );
                appService.setDrawMode(DrawMode.MousePressed);
            } else if (appService.getShapeMode() == ShapeMode.Rectangle) {
                currentShape = new Rectangle(start, start);
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, false);
                appService.setDrawMode(DrawMode.MousePressed);
            } else if (appService.getShapeMode() == ShapeMode.Ellipse) {
                currentShape = new Ellipse(start, start);
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, false);
                appService.setDrawMode(DrawMode.MousePressed);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(appService.getDrawMode() == DrawMode.MousePressed){
            if(appService.getShapeMode() == ShapeMode.Line) {
                end = e.getPoint();
                appService.create(currentShape);
                appService.setDrawMode(DrawMode.Idle);
            } else if (appService.getShapeMode() == ShapeMode.Rectangle) {
                end = e.getPoint();
                appService.create(currentShape);
                appService.setDrawMode(DrawMode.Idle);
            } else if (appService.getShapeMode() == ShapeMode.Ellipse) {
                end = e.getPoint();
                appService.create(currentShape);
                appService.setDrawMode(DrawMode.Idle);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(appService.getDrawMode() == DrawMode.MousePressed) {
            end = e.getPoint();

            if (appService.getShapeMode() == ShapeMode.Line) {
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true );
                appService.scale(currentShape,end);
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true );
            } else if (appService.getShapeMode() == ShapeMode.Rectangle) {
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, true);
                appService.scale(currentShape, end);
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, true);
            } else if (appService.getShapeMode() == ShapeMode.Ellipse) {
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, true);
                appService.scale(currentShape, end);
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, true);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
