package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.draw.controller.DrawingController; // Import DrawingController
import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode; // Import ShapeMode
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingFrame extends JFrame {

    public DrawingFrame(AppService appService){
        super("Simple Drawing Application"); // Set frame title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation

        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        // Set layout for the frame to accommodate the drawing view and buttons
        setLayout(new BorderLayout());

        DrawingView drawingView = new DrawingView(appService);
        add(drawingView, BorderLayout.CENTER); // Add drawing view to the center

        // Initialize the DrawingController with the AppService and DrawingView
        // This links mouse events on drawingView to the controller's logic
        new DrawingController(appService, drawingView);

        // --- Create a panel for shape selection buttons ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center buttons within the panel

        // Button for drawing lines
        JButton lineButton = new JButton("Draw Line");
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appService.setShapeMode(ShapeMode.Line);
                System.out.println("Shape Mode set to Line"); // Console feedback
            }
        });
        buttonPanel.add(lineButton);

        // Button for drawing rectangles
        JButton rectangleButton = new JButton("Draw Rectangle");
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appService.setShapeMode(ShapeMode.Rectangle);
                System.out.println("Shape Mode set to Rectangle"); // Console feedback
            }
        });
        buttonPanel.add(rectangleButton);

        // Button for drawing ellipses
        JButton ellipseButton = new JButton("Draw Ellipse");
        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appService.setShapeMode(ShapeMode.Ellipse);
                System.out.println("Shape Mode set to Ellipse"); // Console feedback
            }
        });
        buttonPanel.add(ellipseButton);

        // Add the button panel to the top (NORTH) of the frame
        add(buttonPanel, BorderLayout.NORTH);

        setSize(800, 600); // Set initial size for the frame
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
    }
}
