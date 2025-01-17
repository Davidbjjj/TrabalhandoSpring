package com.example.oL.principal;

import com.example.oL.model.*;
import com.example.oL.service.CosumoAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private CosumoAPI consumo = new CosumoAPI();
    private Scanner sc = new Scanner(System.in);
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=29334a08";

    private ConverterDados converterDados = new ConverterDados();


    public void Menu() throws IOException, InterruptedException {
        System.out.println("Digite o Nome da Série:");
        var nomeSerie = sc.nextLine();
        var json = consumo.ObterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSerie dadosSerie = converterDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);
        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= dadosSerie.totaldeTemporadas(); i++) {
            json = consumo.ObterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + APIKEY);
            DadosTemporada dadosTemporada = converterDados.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

        for (int i = 0; i < dadosSerie.totaldeTemporadas(); i++) {
            List<DadosEP> epTemp = temporadas.get(i).eps();
            System.out.println("Epsódios da temporada: " + i);
            for (int j = 0; j < epTemp.size(); j++) {
                System.out.println("Nome do EP: "+epTemp.get(j).TitulodoEP());
            }
        }

        //mesma coisa só que usando lambda
        //classe temporada. para toda temporada 't',onde 't.eps', cara elementos 'eps' será 'e' e escrevar o 'TituloEP' de cada 'e' respectivo.
        temporadas.forEach(t->t.eps().forEach(e-> System.out.println(e.TitulodoEP())));
        //foi criada uma classe Epsodio, essa classe é chamada de Ep e ela recebe o mapeamento de temporadas, onde cade temporada t, será pego o fuxo de t.eps(todos os epsódios de cada temporada), eles seram
        //mapeados e depois seram enviados para a classe Epsodios com as clases(será feito um construtor com os dois atributos envolvidos e eles seram coletados)
        List<Epsodio>Ep= temporadas.stream().flatMap(t->t.eps().stream().map(d->new Epsodio(t.numero(),d))).collect(Collectors.toList());
        Ep.forEach(System.out::println);



    }
}
