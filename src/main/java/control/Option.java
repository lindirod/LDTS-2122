package control;

public class Option {
    int option;

    //Instruções das options
    //1 -> Store
    //2-> Instruction
    //3 -> Play
    //4 -> Settings
    //5 -> Player

    public Option(){
       option = 3;
    }

    public Option(int i) {
        option =i;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}
