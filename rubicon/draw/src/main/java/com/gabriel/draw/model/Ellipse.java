package com.gabriel.draw.model;

import com.gabriel.draw.service.EllipseRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

@Data
public class Ellipse extends Shape {

    public Ellipse(Point start, Point end){
        super(start);
        this.setEnd(end);
        this.setColor(Color.BLACK);
        this.setRendererService(new EllipseRendererService());
    }

}
