package org.example.ajedrezfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.UnsupportedEncodingException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Tablero implements Initializable {
    @FXML
    private GridPane mainGrid;
    Pieza[][] tablero = new Pieza[8][8];

    /**
     * constructor de la clase tablero
     */
    public Tablero() throws UnsupportedEncodingException {
        //piezas negras
        tablero[0][0] = new Torre(true);
        tablero[0][1] = new Caballo(true);
        tablero[0][2] = new Alfil(true);
        tablero[0][3] = new Dama(true);
        tablero[0][4] = new Rey(true);
        tablero[0][5] = new Alfil(true);
        tablero[0][6] = new Caballo(true);
        tablero[0][7] = new Torre(true);
        //piezas blancas
        tablero[7][0] = new Torre(false);
        tablero[7][1] = new Caballo(false);
        tablero[7][2] = new Alfil(false);
        tablero[7][3] = new Dama(false);
        tablero[7][4] = new Rey(false);
        tablero[7][5] = new Alfil(false);
        tablero[7][6] = new Caballo(false);
        tablero[7][7] = new Torre(false);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (i == 1)
                    tablero[i][j]=new Peon(true);
                else if (i == 6)
                    tablero[i][j]=new Peon(false);
            }
        }

    }
    /**
     * metodo que pinta el tablero identificando la casilla y colocando el nombre de la pieza que este en ella
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pintarTablero();
    }

    public void pintarTablero() {
        Pane pane;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                pane=new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    pane.setStyle("-fx-background-color: #684714;");
                    pane.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("imagenes/CaballoBlanco.png"))));
                } else {
                    pane.setStyle("-fx-background-color: #ffe68e");

                }


                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].getUnicode() + " ");
                }else {
                    System.out.print("\u29c9" + " ");
                }
                mainGrid.add(pane, j, i);
                String message = "Click on cell ["+i+", "+j+"]";
                int fila = i;
                int columna = j;
                pane.setOnMouseClicked(e -> {
                    System.out.println(message);
                    //accion(envio);

                });
            }
            System.out.println();
        }
    }
    /**
     * metodo que comprueba si hay alguna pieza en la posicion dada
     *
     * @param columna hace referencia a la columna
     * @param fila    hace referencia a la fila
     * @return si es true devolvera que la casilla esta vacia y si es false es que hay una pieza
     */
    public boolean hayPieza(int columna, int fila) {
        if (tablero[columna][fila] == null)
            return true;
        else
            return false;
    }
    /**
     * metodo que comprueba si hay alguna pieza en la posicion dada
     *
     * @param pos recoge la posicion dada
     * @return si es true devolvera que la casilla esta vacia y si es false es que hay una pieza
     */
    public boolean hayPieza(Posicion pos) {
        boolean vacio = false;
        if (tablero[pos.getColumna()][pos.getFila()] == null)
            vacio = true;
        return vacio;
    }
    /**
     * comprueva si hay piezas entre la posicion de la pieza y a la que se va a mover
     *
     * @param mov recoje el movimiento para comprobar si se encuentra alguna pieza
     * @return si es true devolvera que hay una pieza entre medias si es false devolvera que no hay piezas entre medias
     */
    public boolean hayPiezasEntre(Movimiento mov) {
        boolean piezaEntre = false;
        if (mov.esVertical()) {
            if (mov.getPosInicio().getFila() < mov.getPosFinal().getFila()) {
                for (int i = mov.getPosInicio().getFila() + 1; i < mov.getPosFinal().getFila() && !piezaEntre; i++) {
                    if (!hayPieza(mov.getPosInicio().getColumna(), i)) {
                        piezaEntre = true;
                    }
                }
            } else {
                for (int i = mov.getPosInicio().getFila() - 1; i > mov.getPosFinal().getFila() && !piezaEntre; i--) {
                    if (!hayPieza(mov.getPosInicio().getColumna(), i)) {
                        piezaEntre = true;
                    }
                }
            }
        } else if (mov.esHorizontal()) {
            if (mov.getPosInicio().getColumna() < mov.getPosFinal().getColumna()) {
                for (int i = mov.getPosInicio().getColumna() + 1; i < mov.getPosFinal().getColumna() && !piezaEntre; i++) {
                    if (!hayPieza(i, mov.getPosInicio().getFila())) {
                        piezaEntre = true;
                    }
                }
            } else {
                for (int i = mov.getPosInicio().getColumna() - 1; i > mov.getPosFinal().getColumna() && !piezaEntre; i--) {
                    if (!hayPieza(i, mov.getPosInicio().getFila())) {
                        piezaEntre = true;
                    }
                }
            }
        } else if (mov.esDiagonal()) {
            int columnaini=mov.getPosInicio().getColumna();
            int columnafin=mov.getPosFinal().getColumna();
            int filaini=mov.getPosInicio().getFila();
            int filafin=mov.getPosFinal().getFila();
            int aux1=mov.getPosInicio().getColumna();
            int aux2=mov.getPosInicio().getFila();
            if (mov.getPosInicio().getColumna()<mov.getPosFinal().getColumna() && mov.getPosInicio().getFila()<mov.getPosFinal().getFila()){
                aux1++;
                aux2++;
                while (aux1>columnaini && aux1<columnafin && aux2>filaini && aux2<filafin){
                    if (!hayPieza(aux1,aux2)){
                        piezaEntre=true;
                        break;
                    }else {
                        aux1++;
                        aux2++;
                    }
                }
                /*for (int i = mov.getPosInicio().getColumna(); i < mov.getPosFinal().getColumna(); i++) {
                    for (int j = mov.getPosInicio().getFila(); j < mov.getPosFinal().getFila(); j++) {
                        if (!hayPieza(i,j)){
                            piezaEntre=true;
                        }
                    }
                }*/
            } else if (mov.getPosInicio().getColumna()>mov.getPosFinal().getColumna() && mov.getPosInicio().getFila()>mov.getPosFinal().getFila()) {
                aux1--;
                aux2--;
                while (aux1<columnaini && aux1>columnafin && aux2<filaini && aux2>filafin){
                    if (!hayPieza(aux1,aux2)){
                        piezaEntre=true;
                        break;
                    }else {
                        aux1--;
                        aux2--;
                    }
                }
            }else if (mov.getPosInicio().getColumna()<mov.getPosFinal().getColumna() && mov.getPosInicio().getFila()>mov.getPosFinal().getFila()) {
                aux1++;
                aux2--;
                while (aux1>columnaini && aux1<columnafin && aux2<filaini && aux2>filafin){
                    if (!hayPieza(aux1,aux2)){
                        piezaEntre=true;
                        break;
                    }else {
                        aux1++;
                        aux2--;
                    }
                }
            }else if (mov.getPosInicio().getColumna()>mov.getPosFinal().getColumna() && mov.getPosInicio().getFila()<mov.getPosFinal().getFila()) {
                aux1--;
                aux2++;
                while (aux1<columnaini && aux1>columnafin && aux2>filaini && aux2<filafin){
                    if (!hayPieza(aux1,aux2)){
                        piezaEntre=true;
                        break;
                    }else {
                        aux1--;
                        aux2++;
                    }
                }
            }
        }
        return piezaEntre;
    }
    public boolean hayPromocion(Movimiento mov){
        boolean promocion=false;
        if (mov.getPosFinal().getColumna()==0||mov.getPosFinal().getColumna()==7){
            promocion=true;
        }
        return promocion;
    }
    public void piezaPromocion(Movimiento mov){
        Scanner scan = new Scanner(System.in);
        boolean cambio=false;
        int piezaProm;
        do{
            System.out.println("Promocionar a :\n1.Torre\n2.Caballo\n3.Alfil\n4.Dama");
             piezaProm =scan.nextInt();
            switch (piezaProm) {
                case 1:
                    if (!tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()].getColor()) {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Torre(false);
                        cambio=true;
                    } else {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Torre(true);
                        cambio=true;
                    }
                    break;
                case 2:
                    if (!tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()].getColor()) {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Caballo(false);
                        cambio=true;
                    } else {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Caballo(true);
                        cambio=true;
                    }
                    break;
                case 3:
                    if (!tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()].getColor()) {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Alfil(false);
                        cambio=true;
                    } else {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Alfil(true);
                        cambio=true;
                    }
                    break;
                case 4:
                    if (!tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()].getColor()) {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Dama(false);
                        cambio=true;
                    } else {
                        tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()] = new Dama(true);
                        cambio=true;
                    }
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }while(!cambio);
    }
    public boolean Enroque(Movimiento mov){
        boolean valido=false;
        if (tablero[mov.getPosInicio().getColumna()][mov.getPosInicio().getFila()].getClass().getSimpleName().equalsIgnoreCase("torre") && tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()].getClass().getSimpleName().equalsIgnoreCase("rey") && tablero[mov.getPosInicio().getColumna()][mov.getPosInicio().getFila()].getColor() == tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()].getColor() ){
            if (mov.getPosInicio().getColumna()==0 && mov.getPosFinal().getColumna()==0 || mov.getPosInicio().getColumna()==7 && mov.getPosFinal().getColumna()==7){
                valido=true;
            }
        }
        return valido;
    }
    /*public void hacerEnroque(Movimiento mov){
        if (tablero[mov.getPosInicio().getColumna()][mov.getPosInicio().getFila()].getColor()==tablero[mov.getPosFinal().getColumna()][mov.getPosFinal().getFila()].getColor() ){
            //return new Movimiento(new Posicion(mov.getPosInicio().getFila(),mov.getPosInicio().getColumna()),new Posicion(mov.getPosInicio().getFila(),mov.getPosInicio().getColumna()+1));
        }

    }*/
    /**
     * metodo que coloca la pieza en la posicion dada
     *
     * @param figura  hace referencia a una pieza del tablero
     * @param columna hace referencia a la columna a la que se colocara la pieza
     * @param fila    hace referencia a la fila a la que se colocara la pieza
     */
    public void ponPieza(Pieza figura, int columna, int fila) {
        if (hayPieza(columna, fila))
            tablero[columna][fila] = figura;
    }

    /**
     * metodo que coloca la pieza en la posicion dada
     *
     * @param figura hace referencia a una pieza del tablero
     * @param pos    hace referencia a la posicion a la que ira la pieza
     */
    public void ponPieza(Pieza figura, Posicion pos) {
        if (hayPieza(pos)) {
            tablero[pos.getColumna()][pos.getFila()] = figura;
        }
    }

    /**
     * metodo que elimina una pieza de una casilla
     *
     * @param columna hace referencia a la columna de la que se eliminara la pieza
     * @param fila    hace referencia a la fila de la que se eliminara la pieza
     */
    public void quitaPieza(int columna, int fila) {
        if (!hayPieza(columna, fila))
            tablero[columna][fila] = null;
    }

    /**
     * metodo que elimina una pieza de una casilla
     *
     * @param pos hace referencia a la casilla de la que se eliminara la pieza
     */
    public void quitaPieza(Posicion pos) {
        if (!hayPieza(pos))
            tablero[pos.getColumna()][pos.getFila()] = null;
    }

    /**
     * metodo que devuelve la pieza que se encuentra en una casilla
     *
     * @param columna hace referencia a la columna en la que se encuentra la pieza
     * @param fila    hace referencia a la fila en la que se encuentra la pieza
     * @return devuelve la pieza que se encuentra en esa casilla
     */
    public Pieza devolverPieza(int columna, int fila) {
        return tablero[columna][fila];
    }


    /**
     * metodo que devuelve la pieza que se encuentra en una casilla
     *
     * @param pos hace referencia a la casilla en la que se encuentra la pieza
     * @return devuelve la pieza que se encuentra en esa casilla
     */
    public Pieza DevolverPieza(Posicion pos) {
        return tablero[pos.getColumna()][pos.getFila()];
    }


}
