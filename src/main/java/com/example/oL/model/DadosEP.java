package com.example.oL.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEP(@JsonAlias("Title")String TitulodoEP, @JsonAlias("Episode")String EP, @JsonAlias("imdbRating") String avaliacao,
                      @JsonAlias("Released") String dataLancamento) {
}
