package com.gabriel.draw.service;

import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.drawfx.service.MoverService;
import com.gabriel.drawfx.service.ScalerService;

import java.awt.*;

public class  DrawingAppService implements AppService {
    final private Drawing drawing;
    private Color color;
    Color fill;
    private ShapeMode shapeMode = ShapeMode.Line;
    private DrawMode drawMode = DrawMode.Idle;

    MoverService moverService;
    ScalerService scalerService;

    public DrawingAppService(){
        drawing = new Drawing();
        moverService = new MoverService();
        scalerService = new ScalerService();
    }

    @Override
    public ShapeMode getShapeMode() {
        return shapeMode;
    }

    @Override
    public void setShapeMode(ShapeMode shapeMode) {
        this.shapeMode = shapeMode;
    }

    @Override
    public DrawMode getDrawMode() {
        return drawMode;
    }

    @Override
    public void setDrawMode(DrawMode drawMode) {
        this.drawMode = drawMode;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getFill() {
        return fill;
    }

    @Override
    public void setFill(Color color) {
        this.fill = fill;
    }

    @Override
    public void move(Shape shape, Point newLoc) {
        moverService.move(shape, newLoc);}

    @Override
    public void scale(Shape shape, Point newEnd) {
        shape.setEnd(newEnd);
    }

    @Override
    public void create(Shape shape) {
        this.drawing.getShapes().add(shape);
    }

    @Override
    public void close() {
        System.exit(0);
    }

    @Override
    public Object getModel() {
        return drawing;
    }
}
