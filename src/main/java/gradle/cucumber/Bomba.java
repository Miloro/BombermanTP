package gradle.cucumber;

import static java.lang.Thread.sleep;

public class Bomba {
    
    public Bomba(){}


    public void estallarEn(Tablero tablero, Integer posicionX, Integer posicionY) {
        try{sleep(3000);
            tablero.quitarMuroDeMelaminaEnRadio(3,posicionX, posicionY);}
        catch (InterruptedException e) {
            e.printStackTrace();
        } {}

    }
}
