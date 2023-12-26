package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import control.Position;

public class Image {
    Scanner scanner;
    File image;

    public Image(TextGraphics graphics, String filename, Position position, String color) throws IOException {
        image = new File(filename + ".txt");
        if(image == null) {
            return;
        }
        try {
            scanner = new Scanner(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int len = 0;
        for(int i=0; scanner.hasNextLine(); i++) {
            String line = scanner.nextLine();
            len = line.length();
            for (int x = 0; x < len; x++) {
                if (line.charAt(x) != ' ') {
                    graphics.setBackgroundColor(TextColor.Factory.fromString(color));
                    graphics.setForegroundColor(TextColor.Factory.fromString(color));
                    String ch = String.valueOf(line.charAt(x));
                    graphics.putString(x + position.getX(), i + position.getY(), ch);
                }
            }
        }
    }

}