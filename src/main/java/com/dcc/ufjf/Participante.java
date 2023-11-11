package com.dcc.ufjf;

import java.util.Observable;
import java.util.Observer;

public class Participante implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            this.ultimaNotificacao = "" + arg;
        }
    }
}