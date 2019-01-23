package sample;

public class PlayerUi implements PlayerUI{
    COLOR color;
    String name ;
    String ident ;

    PlayerUi(String Name,String  Ident,COLOR color){
        this.color=color;
        name=Name;
        ident=Ident;
    }
    @Override
    public void MakeActive() {

    }
}
