package com.gabriel.drawfx.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Drawing {
    List<Shape> shapes;
    public Drawing(){
        shapes = new ArrayList<>();
    }
}
