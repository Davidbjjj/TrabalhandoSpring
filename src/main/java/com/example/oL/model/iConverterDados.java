package com.example.oL.model;

public interface iConverterDados {
    <T> T obterDados(String json, Class<T> classe);
}
