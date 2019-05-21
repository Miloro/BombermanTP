package gradle.cucumber;

import java.util.HashMap;

public class Tablero {
    private HashMap<Integer,HashMap<Integer,Celda>> celdas;
    private int cantidadDeFilas;
    private int cantidadDeColumnas;

    public Tablero(Integer cantidadFilas, Integer  cantidadColumnas){
        this.celdas = new HashMap<Integer,HashMap<Integer,Celda>>();

        for (int i=0; i<cantidadColumnas; i++){
            this.celdas.put(i,this.mapaDeFilas(cantidadFilas));
        }
        this.cantidadDeFilas = cantidadFilas;
        this.cantidadDeColumnas = cantidadColumnas;
    }

    private HashMap<Integer,Celda> mapaDeFilas(Integer cantidadFilas) {
        HashMap<Integer,Celda> filaCeldas = new HashMap<Integer,Celda>();
        for (int i=0; i<cantidadFilas; i++){
            filaCeldas.put(i,new Celda());
        }
        return filaCeldas;
    }

    public void setearMuroEnCelda(Integer posicionX, Integer posicionY) {
        this.dameLaCelda(posicionX,posicionY).setearMuro();
    }

    private Celda dameLaCelda(Integer posicionX, Integer posicionY) {
        return this.celdas.get(posicionX).get(posicionY);
    }

    public boolean celdaALaDerechaEsCeldaVacia(Integer posicionX, Integer posicionY) {
        return !this.dameLaCelda(posicionX+1,posicionY).tieneMuro();
    }

    public void setearEnemigoEnCelda(Integer posicionX, Integer posicionY) {
        this.dameLaCelda(posicionX,posicionY).setearEnemigo();
    }

    public boolean celdaALaDerechaEsCeldaConEnemigo(Integer posicionX, Integer posicionY) {
        return this.dameLaCelda(posicionX+1,posicionY).tieneEnemigo();
    }

    // PRO: Quita muro en posicion de Cruz, como en el juego original.
    public void quitarElementosEnRadio(Integer radio, Integer posicionX, Integer posicionY, Bomberman bomberman) {
        this.quitarElementosXCeldasAlNorte(radio,posicionX, posicionY, bomberman);
        this.quitarElementosXCeldasAlSur(radio,posicionX, posicionY,bomberman);
        this.quitarElementosXCeldasAlOesteEnRadio(radio,posicionX, posicionY,bomberman);
        this.quitarElementosXCeldasAlEsteEnRadio(radio,posicionX, posicionY,bomberman);
    }

    private void quitarElementosXCeldasAlEsteEnRadio(Integer radio, Integer posicionX, Integer posicionY, Bomberman bomberman) {
        Integer hasta= posicionX + radio;

        if( hasta > this.cantidadDeFilas-1) hasta = this.cantidadDeFilas - 1; // Me aseguro de no irme del tablero.

        for(int i=posicionX; i<=hasta; i++){
            this.quitarElementosDeLaCelda(i,posicionY, bomberman);
        }
    }

    private void quitarElementosXCeldasAlOesteEnRadio(Integer radio, Integer posicionX, Integer posicionY, Bomberman bomberman) {
        Integer hasta= posicionX - radio;

        if( hasta < 0) hasta = 0; // Me aseguro de no irme del tablero.

        for(int i=posicionX; i>=hasta; i--){
            this.quitarElementosDeLaCelda(i,posicionY, bomberman);
        }
    }

    private void quitarElementosXCeldasAlSur(Integer radio, Integer posicionX, Integer posicionY,Bomberman bomberman) {
        Integer hasta= posicionY + radio;

        if( hasta > this.cantidadDeFilas-1) hasta = this.cantidadDeFilas - 1; // Me aseguro de no irme del tablero.

        for(int i=posicionY; i<=hasta; i++){
            this.quitarElementosDeLaCelda(posicionX,i, bomberman);
        }
    }

    private void quitarElementosXCeldasAlNorte(Integer radio, Integer posicionX, Integer posicionY,Bomberman bomberman) {
        Integer hasta= posicionY - radio;

        if( hasta < 0) hasta = 0; // Me aseguro de no irme del tablero.

        for(int i=posicionY; i>=hasta; i--){
            this.quitarElementosDeLaCelda(posicionX,i, bomberman);
        }
    }

    private void quitarElementosDeLaCelda(Integer posicionX, Integer posicionY, Bomberman bomberman){
        Celda celda= this.dameLaCelda(posicionX,posicionY);
        celda.quitarMuroDeMelamina();
        celda.quitarEnemigo(bomberman);
    }

    public void setearMuroDeAceroEnCelda(Integer posicionX, Integer posicionY) {
        this.dameLaCelda(posicionX, posicionY).setearMuroDeAcero();
    }


    public boolean tieneMuroEnCelda(Integer posicionX, Integer posicionY) {
        return this.dameLaCelda(posicionX,posicionY).tieneMuro();
    }

    public boolean tieneMuroDeAceroEnCelda(Integer posicionX, Integer posicionY) {
        return this.dameLaCelda(posicionX, posicionY).tieneMuroDeAcero();
    }

    public void setearBagulaaEnCelda(Integer posicionX, Integer posicionY) {
        this.dameLaCelda(posicionX,posicionY).setearBagulaa();
    }

    public Integer getCantidadDeFilas() {
        return this.cantidadDeFilas;
    }

    public Integer getCantidadDeColumnas() { return this.cantidadDeColumnas; }

    public void ponerUnProtoMaxJrEnCelda(int arg0, int arg1) {
        this.dameLaCelda(arg0,arg1).ponerUnProtoMaxJr();
    }

    public boolean celdaALaDerechaEsCeldaConMuro(Integer posicionX, Integer posicionY) {
        return this.dameLaCelda(posicionX+1,posicionY).tieneMuro();
    }


}
