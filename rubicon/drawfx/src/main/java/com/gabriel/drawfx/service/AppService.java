package com.gabriel.drawfx.service;

import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;

public interface AppService {
    ShapeMode getShapeMode();
    void setShapeMode(ShapeMode shapeMode);

    DrawMode getDrawMode();
    void setDrawMode(DrawMode drawMode);

    Color getColor();
    void setColor(Color color);

    Color getFill();
    void setFill(Color color);

    void move(Shape shape, Point newLoc);
    void scale(Shape shape, Point newEnd);

    void create(Shape shape);

    void close();

    Object getModel();
}
