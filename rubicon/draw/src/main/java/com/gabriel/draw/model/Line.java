package com.gabriel.draw.model;


import com.gabriel.draw.service.LineRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;


@Data
public class Line extends Shape {

    public Line(Point start, Point end){
        super(start);
        this.setEnd(end);
        this.setColor(Color.CYAN);
        this.setRendererService(new LineRendererService());
    }
}
