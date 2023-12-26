package control;

import blocks.Element;
import control.level.Level;

import java.util.ArrayList;


public class Collision {
    static ArrayList<Element> blocks;
    Level currentlevel;

    public Collision(){
      currentlevel = new Level();
      blocks = currentlevel.getBlocks();
    }

    public static ArrayList<Element> CheckCollisionList (Element e, ArrayList < Element > list){
        ArrayList<Element> collisionList = new ArrayList<>();
        for (Element other : list) {
            if (CheckCollision(e, other))
                collisionList.add(other);
        }
        return collisionList;
    }
    public static boolean CheckCollision(Element e, Element other){
        boolean NoXCollision = e.getXRightSquare() <= other.getXLeft() || e.getXLeftSquare() >= other.getXRight();
        boolean NoYCollision = e.getYBottomSquare() <= other.getYTop() || e.getYTopSquare() >= other.getYBottom();
        return !NoYCollision && !NoXCollision;
    }
}
