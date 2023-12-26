package control.level;

import control.Position;

import java.util.ArrayList;

public class Level1 implements ArrayLevel{
    @Override
    public ArrayList<Position> Ground() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        for (int i = 0; i < 555; i = i + 22) {
            positionsArray.add(new Position(i, 41));
        }
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Brick() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(60, 32));  //chao
        positionsArray.add(new Position(120, 20));
        positionsArray.add(new Position(180, 20));
        positionsArray.add(new Position(300, 24));
        positionsArray.add(new Position(360, 24));
        positionsArray.add(new Position(381, 24));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Peak() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(150, 32));
        positionsArray.add(new Position(240, 19));
        positionsArray.add(new Position(330, 32));
        positionsArray.add(new Position(400, 24));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Key() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(210, 30));
        positionsArray.add(new Position(330, 5));
        positionsArray.add(new Position(470, 18));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> FinalPiece() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(530, 5));
        positionsArray.add(new Position(530, 16));
        positionsArray.add(new Position(530, 27));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> PowerUp() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        return positionsArray;
    }

    @Override
    public ArrayList<Position> DoubleKeys() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        return positionsArray;
    }
}