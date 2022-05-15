/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marie
 */
public class GeradorUtil {

    public static String gerarNumero(int qtd) {
        String numeroGerado = "";
        int indice;
        for (int i = 0; i < qtd; i++) {
            indice = (int) (Math.random() * 10);
            numeroGerado += indice;
        }
        return numeroGerado;
    }
    public static BigDecimal gerarSalario() {        
        BigDecimal salario = new BigDecimal(gerarNumero(8)).setScale(2);        
        return salario;
    }

    public static String gerarSenha(int qtd) {
        String[] letras = {"a", "b", "c",
            "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int tamanho = letras.length; // esse lenght não tem parenteses, ele é do vetor e não da classe String.
        String senha = "";
        int indice;
        for (int i = 0; i < qtd; i++) {
            indice = (int) (Math.random() * tamanho); //aqui sempre multiplica por um número a mais, tenho 62 caracter, faço x 63
            senha = senha + letras[indice];
        }
        return senha;
    }

    public static String gerarCpf() {
        return gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);
    }

    public static String gerarCnpj() {
        return gerarNumero(2) + "." + gerarNumero(3) + "." + gerarNumero(3) + "/0001-" + gerarNumero(2);
    }

    public static String gerarTelefoneFixo() {
        return "(48) 3" + gerarNumero(3) + "-" + gerarNumero(4);
    }
    
    public static String gerarRG() {
        return gerarNumero(1) + "." + gerarNumero(3) + "-" + gerarNumero(4);
    }

    public static String gerarTelefoneCelular() {
        return "(48)9" + gerarNumero(4) + "-" + gerarNumero(4);
    }

    public static String gerarCep() {
        return gerarNumero(5) + "-" + gerarNumero(3);
    }
//    public static String gerarNome() { PODE SER COM ARRAY
//        List<String> nomes = Arrays.asList("Mariele", "Matheus", "Vinicius A.", "Vitor", "Alisson", "Jonatas",
//                "Jeremias", "Bruno", "Karen", "Brayam", "Vinicius S.", "Jefferson", "Prego");
//        Collections.shuffle(nomes);
//        return nomes.get(0);
//    }
    public static String gerarLogin() {
        String nome = gerarNome();        
        return nome.toLowerCase() + "@";
    }
    
    public static String gerarEmail() {
        String nome = gerarNome();        
        return nome.toLowerCase() + "@gmail.com";
    }

    public static String gerarNome() { //PODE SER COM VETOR
        String[] nomes = {"Mariele", "Matheus", "Vinicius A.", "Vitor", "Alisson", "Jonatas",
            "Jeremias", "Bruno", "Karen", "Brayam", "Vinicius S.", "Jefferson", "Prego"};
        int indice = (int) (Math.random() * nomes.length);
        return nomes[indice];
    }

    private static String gerarSobrenome() {// é private para auxiliar outro método(gerarNome
        String[] sobrenomes = {"Silva", "Flores", "Ranger", "Almeida", "Oliveira", "Cunha", "Abravanel", "Souza",
            "Rocha", "Pires", "Moura", "Santos", "Zen", "Stark", "Peixes",
            "Fish", "Smith", "Tango", "Carvalho", "Pereira"};
        int tamanhoLista = sobrenomes.length;
        int indice = (int) (Math.random() * tamanhoLista);
        return sobrenomes[indice]; 
    }
    public static String gerarNomeCompleto() {
        return gerarNome() + " " + gerarSobrenome();
    }

    public String gerarCidade() {
        String[] cidades = {"Florianópolis", "Palhoça", "Biguaçu", "São Paulo", "Rio de Janeiro", "Porto Alegre", "Criciuma"};
        return null;//só pra parar de dar erro.
    }

    public static void main(String[] args) {
        System.out.println("Salario: " + gerarSalario());
    }

//    public static String gerarIdade() {
//
//        List<Integer> numeros = new ArrayList<>();
//        for (int i = 15; i <= 60; i++) {
//            numeros.add(i);
//        }
//        Collections.shuffle(numeros);
//
//        return Integer.toString(numeros.get(0));
//    }
//
//    public static int ultimaPosicaoList(List pregos) {
//        return pregos.size() - 1;
//    }
//
//    public static String gerarDataHoraAtual() {//quem  chamar esse método vai ter a data e hora
//        LocalDateTime dataAtual = LocalDateTime.now();
//        DateTimeFormatter conversorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");//aqui converte do horário padrãos
//
//        return conversorData.format(dataAtual);
//    }
//
//
//        
}
