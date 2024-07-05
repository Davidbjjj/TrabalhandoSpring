package com.example.oL;

import com.example.oL.model.ConverterDados;
import com.example.oL.model.DadosMoeda;
import com.example.oL.service.CosumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OLApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OLApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	 var consumo= new CosumoAPI();
	 var json=consumo.ObterDados("https://v6.exchangerate-api.com/v6/bcf66faadad8704e370fc32a/latest/USD");
		System.out.println(json);
		ConverterDados converterDados = new ConverterDados();
		DadosMoeda dadosMoeda =converterDados.obterDados(json, DadosMoeda.class);
		System.out.println(dadosMoeda);
	}
}
