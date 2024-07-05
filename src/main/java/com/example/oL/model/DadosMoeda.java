package com.example.oL.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.Array;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMoeda(@JsonAlias("conversion_rates") Object moadas, @JsonAlias("base_code") String MoedaDeComparacao) {

}
