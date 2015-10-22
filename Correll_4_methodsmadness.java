/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correll_4_javafxintro;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Correll_4_methodsmadness extends Application {

    public static void main(String[] args) {
        launch(args);
            }
        //
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Patterns(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawYellowTriangle(GraphicsContext gc, int x, int y) {
        double[] xPoints = {x - 25, x, x + 25};
        double[] yPoints = {y + 50, y - 25, y + 50};
        gc.setFill(Color.YELLOW);
        gc.fillPolygon(xPoints, yPoints, 3);
    }
    
    private void drawPurpleCircle(GraphicsContext gc, int x, int y, int w) {
        gc.setFill(Color.PURPLE);
        gc.fillOval(x, y, w, w);
    }
    
    private void drawGreenTriangle(GraphicsContext gc, int x, int y) {
        double[] xPoints = {x - 25, x, x + 25};
        double[] yPoints = {y + 50, y - 25, y + 50};
        gc.setFill(Color.GREEN);
        gc.fillPolygon(xPoints, yPoints, 3);
    }
    
    private void drawBlueCircle(GraphicsContext gc, int x, int y, int w) {
        gc.setFill(Color.BLUE);
        gc.fillOval(x, y, w, w);
    }
    
    private void drawRedCircle(GraphicsContext gc, int x, int y, int w) {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, w, w);
    }
    
    private void writeText(GraphicsContext gc, int x, int y, int i) {
        String num = ""+i;
        gc.setFill(Color.RED);
        gc.fillText(num, x, y);
    }
    
    private void Patterns(GraphicsContext gc) {
        for (int i = 1; i < 26;) {
            for(int y = 50; y < 500; y+= 100) {
                for (int x = 50; x < 500; x+= 100) {
                    if (i % 7 == 0){
                        drawYellowTriangle(gc, x, y);
                        //writeText(gc, x, y, i);
                    } else if (i % 5 == 0){
                        drawPurpleCircle(gc, x - 25, y, 45);
                        //writeText(gc, x, y, i);
                    } else if (i % 3 == 0){
                        drawGreenTriangle(gc, x, y);
                        //writeText(gc, x, y, i);
                    } else if (i % 2 == 0){
                        drawBlueCircle(gc, x - 25, y, 45);
                        //writeText(gc, x, y, i);
                    } else {
                        drawRedCircle(gc, x - 25, y, 45);
                        //writeText(gc, x, y, i);
                    }
                    i++;
                }
            }
            }
            }  
    }
    

