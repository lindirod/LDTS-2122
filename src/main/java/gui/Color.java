package gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Color {
    Map<String, String> color;

    public Map<String, String> getColor() {
        return color;
    }

    public Color(int option) {
        color = new HashMap<>();
        if(option==0){
            color0();
        } else if(option==1){
            color1();
        } else if (option == 2){
            color2();
        } else if(option==3){
            color3();
        } else if (option==4){
            color4();
        }

    }

    private void color0() {
        color.put("BodySquare", "#FFF95B");
        color.put("FaceSquare", "#FF930F");
        color.put("BodyBricks", "#219EBC");
        color.put("FaceBricks", "#000000");
        color.put("Background", "#001A70");
        color.put("Ground", "#00CC7C");
        color.put("Final", "#B429F9");
    }

    private void color1() {
        color.put("BodySquare", "#9D69F2");
        color.put("FaceSquare", "#3ECCBB");
        color.put("BodyBricks", "#208AF5");
        color.put("FaceBricks", "#0E6FCF");
        color.put("Background", "#DC964e");
        color.put("Ground", "#BF02BF");
        color.put("Final", "#DE5FDE");
    }

    private void color2() {
        color.put("BodySquare", "#D5CCFF");
        color.put("FaceSquare", "#FF80CC");
        color.put("BodyBricks", "#D4A373");
        color.put("FaceBricks", "#FFE1CC");
        color.put("Background", "#fffAE5");
        color.put("Ground", "#A8BADC");
        color.put("Final", "#7D1128");
    }

    private void color3() {
        color.put("BodySquare", "#DD7373");
        color.put("FaceSquare", "#AEA5BC");
        color.put("BodyBricks", "#7F5751");
        color.put("FaceBricks", "#203B2F");
        color.put("Background", "#0096c7");
        color.put("Ground", "#3B3561");
        color.put("Final", "#667CA4");
    }

    private void color4() {
        color.put("BodySquare", "#B89193");
        color.put("FaceSquare", "#7B51AD");
        color.put("BodyBricks", "#AFC495");
        color.put("FaceBricks", "#936FBF");
        color.put("Background", "#FABBBF");
        color.put("Ground", "#C97D81");
        color.put("Final", "#3DA6A1");
    }
}