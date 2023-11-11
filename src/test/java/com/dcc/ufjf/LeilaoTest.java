package com.dcc.ufjf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeilaoTest {

    @Test
    void naoDeveNotificarParticipantesSemNovoLance() {
        Leilao leilao = new Leilao("Item B");
        Participante participante1 = new Participante("Participante 1");
        Participante participante2 = new Participante("Participante 2");

        leilao.adicionarParticipante(participante1);
        leilao.adicionarParticipante(participante2);

        leilao.fazerLance(participante1, 0.0);
        leilao.fazerLance(participante2, 0.0);

        assertEquals("Ainda sem lances", participante1.getUltimaNotificacao());
        assertEquals("Ainda sem lances", participante2.getUltimaNotificacao());
    }

    @Test
    void deveNotificarTodosParticipantes() {
        Leilao leilao = new Leilao("Item C");
        Participante participante1 = new Participante("Participante 1");
        Participante participante2 = new Participante("Participante 2");

        leilao.adicionarParticipante(participante1);
        leilao.adicionarParticipante(participante2);

        leilao.fazerLance(participante1, 70.0);

        assertEquals("Participante 1 fez o lance de R$70.0", participante1.getUltimaNotificacao());
        assertEquals("Participante 1 fez o lance de R$70.0", participante2.getUltimaNotificacao());

        leilao.fazerLance(participante2, 80.0);

        assertEquals("Participante 2 fez o lance de R$80.0", participante1.getUltimaNotificacao());
        assertEquals("Participante 2 fez o lance de R$80.0", participante2.getUltimaNotificacao());
    }
}