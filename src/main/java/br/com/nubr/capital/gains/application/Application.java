package br.com.nubr.capital.gains.application;

import br.com.nubr.capital.gains.application.functions.CapitalGains;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static br.com.nubr.capital.gains.application.functions.InputHandler.inputHandle;

public class Application {

    @SneakyThrows
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var lists = inputHandle(reader);

        var taxa = CapitalGains.calculateCapitalGains(lists);
        System.out.println(taxa);
    }

}