package com.gabriel.drawfx.service;

import com.gabriel.drawfx.model.Shape;
import java.awt.*;

public interface RendererService {
    void render(Graphics g, Shape shape, boolean xor);
}
