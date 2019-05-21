package gradle.cucumber;

import static java.lang.Thread.sleep;

public class Bomba {
    
    public Bomba(){}


    public void estallarEn(Tablero tablero, Integer posicionX, Integer posicionY, Bomberman bomberman) {
        try{sleep(3000);
            tablero.quitarElementosEnRadio(3,posicionX, posicionY, bomberman);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } {}

    }
}
