package gui.LanternaGUI;

import blocks.Element;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import control.level.Level;
import control.Option;

import control.Position;
import gui.Image;
import state.PlayState;


import java.io.IOException;

public class Lanterna {
    private MenuLanterna menuLanterna;
    private InstructionLanterna instructionLanterna;
    private PlayLanterna playLanterna;
    private SettingsLanterna settingsLanterna;
    private GameOverLanterna gameOverLanterna;
    private WinningLanterna winningLanterna;
    private LosingLanterna losingLanterna;
    private StoreLanterna storeLanterna;
    private Screen screen;
    public int width;
    public int height;
    private Terminal terminal;

    //geral
    public Lanterna() throws IOException {
        if (terminal == null && screen == null) {
            terminal = createTerminal(170, 50);
            screen = createScreen(terminal);
        }
        initializeClasses();
    }

    private void initializeClasses() {
        menuLanterna = new MenuLanterna(screen);
        instructionLanterna = new InstructionLanterna(screen);
        playLanterna = new PlayLanterna(screen, getWidth(), getHeight());
        settingsLanterna = new SettingsLanterna(screen);
        gameOverLanterna = new GameOverLanterna(screen);
        winningLanterna = new WinningLanterna(screen);
        losingLanterna = new LosingLanterna(screen);
        storeLanterna = new StoreLanterna(screen);
    }

    public Screen getScreen() {
        return screen;
    }
    public int getWidth(){ return width;}
    public int getHeight(){ return height;}

    protected Terminal createTerminal(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    protected Screen createScreen(Terminal terminal) throws IOException {
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void background(String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }

    public void drawImage(String filename, Position position, String color) throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        Image image = new Image(graphics, filename, position, color);
    }

    //Menu
    public int MenuProcessKey(Option prevOption) throws IOException {
        return menuLanterna.MenuProcessKey(prevOption);
    }

    public void MenudrawOption(int option, String color) throws IOException { //color = "#A41623"
        menuLanterna.MenudrawOption(option,color);
    }

    //Instructions
    public void InstructiondrawText(Position position, String RectColor, String textColor) {
        instructionLanterna.InstructiondrawText(position, RectColor, textColor);
    }

    public int InstructionProcessKey() throws IOException {
        return instructionLanterna.InstructionProcessKey();
    }

    //Play

    public int PlayProcessKey(Element SquareElement, PlayState playState) throws IOException {
        return playLanterna.PlayProcessKey(SquareElement, playState);
    }

    public void PlaydrawSquare(Element element) throws IOException {
        playLanterna.PlaydrawSquare(element);
    }

    public void PlaydrawElement(Element element, int relativePosition) throws IOException {
        playLanterna.PlaydrawElement(element,relativePosition);
    }

    public void drawKeys(int keys, Level level, String color){
        playLanterna.drawKeys(keys, level, color);
    }


    //settings
    public void SettingsdrawText(Position position, String RectColor, String TextColor) {
        settingsLanterna.SettingsdrawText(position, RectColor, TextColor);
    }


    public int SettingsProcessKey(Option currentOption) throws IOException {
        return settingsLanterna.SettingsProcessKey(currentOption);
    }

    public void SettingsdrawOptions(int option) {
        settingsLanterna.SettingsdrawOptions(option);
    }

    //game Over
    public void drawGameOver() throws IOException {
        gameOverLanterna.drawGameOver();
    }

    public int GameOverProcessKey() throws IOException {
        return gameOverLanterna.GameOverProcessKey();
    }

    //win
    public void drawWin() throws IOException {
        winningLanterna.drawWin();
    }

    public int WinningProcessKey() throws IOException {
        return winningLanterna.WinningProcessKey();
    }

    //lose
    public void drawLose() throws IOException {
        losingLanterna.drawLose();
    }

    //store
    public void StoredrawText(Position position, String RectColor, String TextColor){
        storeLanterna.StoredrawText(position, RectColor, TextColor);
    }

    public void StoredrawColor(){
        storeLanterna.StoredrawColor();
    }

    public void StoredrawSquares(Position position) throws IOException {
        storeLanterna.StoredrawSquares(position);
    }

    public void StoredrawPrice(Position position) {
        storeLanterna.StoredrawPrice(position);
    }

    public void StoredrawOptions(int option) throws IOException {
        storeLanterna.StoredrawOptions(option);
    }

    public int StoreProcessKey(Option currentOption) throws IOException{
        return storeLanterna.StoreProcessKey(currentOption);
    }

    public void drawMoney(){
        storeLanterna.drawMoney();
    }

    public int StoreMensager(int can){
        return storeLanterna.StoreMensager(can);
    }
}