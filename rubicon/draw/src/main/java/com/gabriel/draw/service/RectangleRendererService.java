package com.gabriel.draw.service;

import com.gabriel.draw.model.Rectangle;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;


public class RectangleRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Rectangle rectangle = (Rectangle) shape;

        if (xor) {
            g.setXORMode(Color.WHITE);
            g.setColor(shape.getColor());
        } else {
            g.setPaintMode();
            g.setColor(shape.getColor());
        }

        int x = Math.min(rectangle.getLocation().x, rectangle.getEnd().x);
        int y = Math.min(rectangle.getLocation().y, rectangle.getEnd().y);
        int width = Math.abs(rectangle.getLocation().x - rectangle.getEnd().x);
        int height = Math.abs(rectangle.getLocation().y - rectangle.getEnd().y);

        g.drawRect(x, y, width, height);


    }
}
