import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Seja bem vindo a calculadora de médias. ");

        int quantidadeDeNumeros = recebeInteiro();

        ArrayList<Double> numeros = recebeNumeros(quantidadeDeNumeros);

        calculaMedia(numeros);
    }

    public static void calculaMedia (ArrayList numeros) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Agora, escolha o tipo de média:");
        System.out.println();
        System.out.println("Se deseja calcula média aritimética digite ARITIMETICA");
        System.out.println("Se deseja calcula média hamonica digite HARMONICA");

        String opcao = sc.nextLine();
        boolean b = true;

        while (b) {
            if (opcao.equalsIgnoreCase("ARITIMETICA")) {
                System.out.println("A média escolhida foi a Aritimetica.");
                calculaMediaAritimetica(numeros);
                b = false;
            } else if (opcao.equalsIgnoreCase("HARMONICA")) {
                System.out.println("A média escolhida foi a Harmonica");
                calculaMediaHarmonica(numeros);
                b = false;
            } else {
                System.out.println("Nao entendi digite novamente 'harmonica' ou 'aritimetica'.");
                b = true;
                opcao = sc.nextLine();
            }
        }
    }

    public static void calculaMediaAritimetica (ArrayList < Double > numeros) {

        double soma = 0;

        for (Double nota : numeros) {
            soma += nota;
        }

        double mediaAritimetica = soma / numeros.size();

        System.out.println("Os números escolhidos foram:  " + numeros);
        System.out.println("A média aritimética dos números é " + mediaAritimetica);
    }

    public static void calculaMediaHarmonica (ArrayList <Double> numeros) {

        int n = numeros.size();

        double somaDeInversos = 0;

        for (Double numero : numeros) {
            somaDeInversos += inverteNota(numero);
        }

        double mediaHarmonica = n/somaDeInversos;
        System.out.println("Os números escolhidos foram:  " + numeros);
        System.out.println("A média harmonica dos números é " + mediaHarmonica);
    }

    public static int recebeInteiro() {
        System.out.println("Informe a quantidade de números que vai inserir:");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Integer inteiro;

        try {
            inteiro = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números inteiros: ");
            inteiro = recebeInteiro();
        }

        return inteiro;
    }

    public static ArrayList<Double> recebeNumeros(int quantidadeDeNumeros) {
        System.out.println("Agora, você vai informar os números para o cálculo:");

        ArrayList<Double> numeros = new ArrayList();

        for (int i = 1; i <= quantidadeDeNumeros; i++) {
            System.out.println("Informe o " + i + "º número.");
            Double numero = recebeNumero();
            numeros.add(numero);
        }

        return numeros;
    }

    public static double recebeNumero() {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Double nota = 0.0;

        try {
            nota = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números nesse item.");
            nota = recebeNumero();
        }
        return nota;
    }
    public static double inverteNota(double nota){
        double notaInvertida = 1/nota;
        return notaInvertida;
    }
}