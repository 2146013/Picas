package edu.escuelaing.arsw.picas.modelo;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Picasmodelo {
    private int picas;
    private int famas;
    private String num;
    private int numRandom;
    private List<String> lista  = new ArrayList<>();
    public Picasmodelo(){
        num = null;
        this.picas = 0;
        this.famas = 0;
        this.numRandom = (int) (Math.random() * 1000);

    }
    public void reiniciar(){
        //reiniciar intentos de juego del usuario
        lista.clear();
        this.picas = 0;
        this.famas = 0;
        this.numRandom = (int) (Math.random() * 1000);
    }
    public void checknum(String num){
        picas = 0;
        famas = 0;
        String stringRandom = Integer.toString(numRandom);
        for (int pos = 0; pos < num.length(); pos++){
            int val = stringRandom.indexOf(num.charAt(pos));
            if (val >= 0){
                if (val == pos){
                    famas+=1;
                }
                else {
                    picas+=1;
                }
            }
        }


    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getPicas() {
        return picas;
    }

    public int getFamas() {
        return famas;
    }

    public String getNum() {
        return num;
    }

    public int getNumRandom() {
        return numRandom;
    }

    public List<String> getLista() {
        return lista;
    }
}
