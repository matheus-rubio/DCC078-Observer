package com.dcc.ufjf;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Leilao extends Observable {
    private String item;
    private double lanceAtual;
    private String maiorLance;
    private List<Participante> participantes;

    public Leilao(String item) {
        this.item = item;
        this.lanceAtual = 0.0;
        this.maiorLance = "Ainda sem lances";
        this.participantes = new ArrayList<>();
    }

    public void fazerLance(Participante participante, double lance) {
        if (lance > lanceAtual) {
            lanceAtual = lance;
            maiorLance = participante.getNome() + " fez o lance de R$" + lance;
            setChanged();
            notifyObservers(maiorLance);
        }
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
        addObserver(participante);
        setChanged();
        notifyObservers(maiorLance);
    }
}