package control.level;

import control.Position;

import java.util.ArrayList;

public class Level3 implements ArrayLevel{
    @Override
    public ArrayList<Position> Ground() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        for (int i = 0; i < 1000; i = i + 22) {
            positionsArray.add(new Position(i, 41));
        }
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Brick() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(60, 20));  //chao
        positionsArray.add(new Position(80, 20));
        positionsArray.add(new Position(190, 22));
        positionsArray.add(new Position(290, 22));
        positionsArray.add(new Position(327, 18));
        positionsArray.add(new Position(462, 27));
        positionsArray.add(new Position(520, 22));
        positionsArray.add(new Position(669, 22));
        positionsArray.add(new Position(715, 16));
        positionsArray.add(new Position(770, 16));
        positionsArray.add(new Position(800, 22));
        positionsArray.add(new Position(840, 22));
        positionsArray.add(new Position(910, 22));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Peak() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(100, 32));
        positionsArray.add(new Position(120, 32));
        positionsArray.add(new Position(212, 20));
        positionsArray.add(new Position(223, 18));
        positionsArray.add(new Position(358, 20));
        positionsArray.add(new Position(385, 22));
        positionsArray.add(new Position(493, 22));
        positionsArray.add(new Position(548, 22));
        positionsArray.add(new Position(560, 22));
        positionsArray.add(new Position(645, 32));
        positionsArray.add(new Position(690, 32));
        positionsArray.add(new Position(740, 32));
        positionsArray.add(new Position(800, 32));
        positionsArray.add(new Position(883, 22));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> Key() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(140, 25));
        positionsArray.add(new Position(235, 5));
        positionsArray.add(new Position(310, 7));
        positionsArray.add(new Position(370, 31));
        positionsArray.add(new Position(560, 8));
        positionsArray.add(new Position(565, 32));
        positionsArray.add(new Position(705, 5));
        positionsArray.add(new Position(760, 31));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> FinalPiece() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(960, 5));
        positionsArray.add(new Position(960, 16));
        positionsArray.add(new Position(960, 27));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> PowerUp() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(710, 32));
        return positionsArray;
    }

    @Override
    public ArrayList<Position> DoubleKeys() {
        ArrayList<Position> positionsArray = new ArrayList<>();
        positionsArray.add(new Position(883, 5));
        return positionsArray;
    }
}