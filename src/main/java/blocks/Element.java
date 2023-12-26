package blocks;


import control.Position;

public class Element {
    Position position;
    Position screenPosition;
    String bodyColor;
    String faceColor;
    String BodyFilename;
    String FaceFilename;

    int positionUpdate;

    public Position getScreenPosition() {
        return screenPosition;
    }

    public void setScreenPosition(Position screenPosition) {
        this.screenPosition = screenPosition;
    }

    public Element(Position position, String bodyColor, String faceColor, String BodyFilename, String FaceFilename){
        this.position=position;
        this.screenPosition=position;
        this.bodyColor=bodyColor;
        this.faceColor=faceColor;
        this.BodyFilename = BodyFilename;
        this.FaceFilename = FaceFilename;
        positionUpdate=-1;

    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public String getFaceColor() {
        return faceColor;
    }

    public String getBodyFilename() {
        return BodyFilename;
    }

    public String getFaceFilename(){
        return FaceFilename;
    }

    //for the others elements
    public int getXRight(){
        return screenPosition.getX()+23;
    }
    public int getXLeft(){
        return screenPosition.getX()+2;
    }
    public int getYTop(){
        return screenPosition.getY();
    }
    public int getYBottom(){
        return screenPosition.getY()+9;
    }

    //for the Square Jump
    public int getXRightSquare(){
        return position.getX()+23;
    }
    public int getXLeftSquare(){
        return position.getX()+2;
    }
    public int getYTopSquare(){
        return position.getY();
    }
    public int getYBottomSquare(){
        return position.getY()+9;
    }

    public int getPositionUpdate() {
        return positionUpdate;
    }
    public void setPositionUpdate(int positionUpdate) {
        this.positionUpdate = positionUpdate;
    }
}