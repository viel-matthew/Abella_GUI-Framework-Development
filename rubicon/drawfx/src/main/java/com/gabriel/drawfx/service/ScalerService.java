package com.gabriel.drawfx.service;

import com.gabriel.drawfx.model.Shape;

import java.awt.*;

public final class  ScalerService {
    void scale(Shape shape, Point newEnd){
        shape.setEnd(newEnd);
    }
}
