package control.level;


import control.Position;

import java.util.ArrayList;

public class LevelController {
    private ArrayLevel arrayLevel;

    public LevelController(ArrayLevel arrayLevel) {
        this.arrayLevel = arrayLevel;
    }

    public ArrayList<Position> Ground(){
        return this.arrayLevel.Ground();
    }
    public ArrayList<Position> Brick(){
        return this.arrayLevel.Brick();
    }
    public ArrayList<Position> Peak(){
        return this.arrayLevel.Peak();
    }
    public ArrayList<Position> Key(){
        return this.arrayLevel.Key();
    }
    public ArrayList<Position> FinalPiece(){
        return this.arrayLevel.FinalPiece();
    }
    public ArrayList<Position> PowerUp(){
        return this.arrayLevel.PowerUp();
    }
    public ArrayList<Position> DoubleKeys(){
        return this.arrayLevel.DoubleKeys();
    }
}