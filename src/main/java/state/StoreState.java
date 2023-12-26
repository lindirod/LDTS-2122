package state;

import control.Controller;
import control.Option;
import control.Position;
import gui.LanternaGUI.Lanterna;

import java.io.IOException;

public class StoreState extends OptionState{
    Controller controller;
    Option option;
    Lanterna lanterna;
    public static Boolean[] ColoreSelled= new Boolean[]{false, false, false, false};
    public static Boolean[] SquareSelled= new Boolean[]{false, false, false, false};

    public static int getColorSelect() {
        return ColorSelect;
    }

    public static int getSquareSelect() {
        return SquareSelect;
    }

    public static int ColorSelect=0;
    public static int SquareSelect=0;
    static int money;
    static int[] moneytobuy = new int[]{100,200,400,700};
    int can=0;

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        StoreState.money = money;
    }

    protected StoreState(Controller controller, Lanterna lanterna) throws IOException {
        this.lanterna = lanterna;
        option = new Option(1);
        this.controller = controller;
    }

    @Override
    public void draw() throws IOException {
        lanterna.background("#040926");
        lanterna.drawImage("src/main/resources/Store_ascii-art/nameStore",new Position(65,6),"#336699");
        lanterna.StoredrawText(new Position(63,21), "#336699", "#000000");
        lanterna.drawMoney();
        lanterna.StoredrawColor();
        lanterna.StoredrawSquares(new Position(82,19));
        lanterna.StoredrawPrice(new Position(82,19));
        lanterna.StoredrawOptions(option.getOption());
        can = lanterna.StoreMensager(can);
        lanterna.refresh();
    }

    @Override
    public int run() throws IOException {
        int flag = lanterna.StoreProcessKey(option);
        if (flag == 2) {
            flag = 0;
            GoMenu();
        } else if(flag>=10 && flag <=25){
            can = buy(flag-10);
            flag=0;
        }
        return flag;
    }

    public int buy(int flag){
        if(flag >= 1 && flag <= 4) return Colorbuy(flag);
        else if(flag >= 11 && flag <= 14) return Squarebuy(flag);
        return 0;
    }

    public int Colorbuy(int flag) {
            if (ColoreSelled[flag - 1]) {
                ColorSelect = flag;
                return 2;
            } else if (getMoney() >= moneytobuy[flag-1]) {
                ColoreSelled[flag - 1] = true;
                setMoney(money - moneytobuy[flag-1]);
            }else return 1;
        return 0;
    }

    public int Squarebuy(int flag) {
        flag -= 10;
            if (SquareSelled[flag - 1]) {
                SquareSelect = flag;
                return 2;
            } else if (getMoney() >= moneytobuy[flag - 1]) {
                SquareSelled[flag - 1] = true;
                setMoney(money - moneytobuy[flag - 1]);
            } else return 1;
        return 0;
    }

    public void GoMenu() throws IOException {
        this.controller.ChangeState(new MenuOptionState(this.controller,lanterna));
    }

}
