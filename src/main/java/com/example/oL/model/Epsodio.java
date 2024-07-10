package com.example.oL.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Epsodio {
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Epsodio(Integer numeroTemporada, DadosEP dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.TitulodoEP();
        this.numeroEpisodio = Integer.valueOf(dadosEpisodio.EP());

        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        } catch (NumberFormatException ex) {
            this.avaliacao = 0.0;
        }

        try {
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        } catch (DateTimeParseException ex) {
            this.dataLancamento = null;
        }
    }


    @Override
    public String toString() {
        return "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento ;
    }
}