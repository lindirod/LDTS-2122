package control.level;

import control.Position;

import java.util.ArrayList;

public class Level2 implements ArrayLevel{
    @Override
    public ArrayList<Position> Ground() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        for (int i = 0; i < 750; i = i + 22) {
            positionsArray.add(new Position(i, 41));
        }
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Brick() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(57, 32));  //chao
        positionsArray.add(new Position(110, 20));
        positionsArray.add(new Position(190, 20));
        positionsArray.add(new Position(230, 15));
        positionsArray.add(new Position(285, 27));
        positionsArray.add(new Position(333, 13));
        positionsArray.add(new Position(380, 17));
        positionsArray.add(new Position(450, 25));
        positionsArray.add(new Position(550, 21));
        positionsArray.add(new Position(580, 13));
        positionsArray.add(new Position(610, 21));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Peak() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(150, 20));
        positionsArray.add(new Position(130, 32));
        positionsArray.add(new Position(150, 32));
        positionsArray.add(new Position(170, 32));
        positionsArray.add(new Position(320, 32));
        positionsArray.add(new Position(375, 32));
        positionsArray.add(new Position(473, 25));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Key() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(210, 10));
        positionsArray.add(new Position(310, 15));
        positionsArray.add(new Position(410, 31));
        positionsArray.add(new Position(470, 5));
        positionsArray.add(new Position(515, 31));
        positionsArray.add(new Position(600, 31));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> FinalPiece() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(675, 5));
        positionsArray.add(new Position(675, 16));
        positionsArray.add(new Position(675, 27));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> PowerUp() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(345, 32));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> DoubleKeys() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(215, 30));
        return positionsArray;
    }

}