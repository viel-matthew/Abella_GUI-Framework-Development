package com.gabriel.draw.service;

import com.gabriel.draw.model.Ellipse; // Import your Rectangle class
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;

public class EllipseRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Ellipse ellipse = (Ellipse) shape;

        if (xor) {
            g.setXORMode(Color.WHITE);
            g.setColor(shape.getColor());
        } else {
            g.setPaintMode();
            g.setColor(shape.getColor());
        }

        int x = Math.min(ellipse.getLocation().x, ellipse.getEnd().x);
        int y = Math.min(ellipse.getLocation().y, ellipse.getEnd().y);
        int width = Math.abs(ellipse.getLocation().x - ellipse.getEnd().x);
        int height = Math.abs(ellipse.getLocation().y - ellipse.getEnd().y);

        g.drawOval(x, y, width, height);

    }
}
