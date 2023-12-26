package control.level;

import control.Position;

import java.util.ArrayList;

public interface ArrayLevel {
    public ArrayList<Position> Ground();
    public ArrayList<Position> Brick();
    public ArrayList<Position> Peak();
    public ArrayList<Position> Key();
    public ArrayList<Position> FinalPiece();
    public ArrayList<Position> PowerUp();
    public ArrayList<Position> DoubleKeys();
}