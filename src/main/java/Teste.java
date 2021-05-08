import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        String[] faces = new String[]{"Ás","2","3","4","5","6","7","8","9","10","Valete","Dama","Rei"};
        String[] naipes = new String[]{"Copas","Paus","Ouros","Espadas"};
        Pilha<Carta> cartas = new Pilha<Carta>(52);
        for (int i = 0; i < 52; i++) {
            cartas.push(new Carta(faces[i%13],i%13+1,naipes[i/13]));
        }

        Baralho baralho = new Baralho();
        System.out.println("Baralho completo\n");
        baralho.exibeBaralho();

        System.out.println("Embaralhando o baralho...\n");
        baralho.embaralhar();

        System.out.println("Baralho embaralhado\n");
        baralho.exibeBaralho();

        System.out.println("Embaralhando o baralho...novamente\n");
        baralho.embaralhar();

        Scanner scanner = new Scanner(System.in);
        boolean erro = true;

        while(erro){
            try {
                int pontosCopas = 0;
                int pontosOuros = 0;
                System.out.println("pf insira quantas cartas quer ser virada? entre 5 a 8");
                int valor = scanner.nextInt();
                if (valor < 5 || valor >8)
                    throw new Exception("pf entre 5 a 8");
                for (int i = 0; i < valor; i++) {
                    Carta cartaVirada = baralho.virarCarta();
                    System.out.println("Carta virada: "+ cartaVirada);
                    if (cartaVirada.getNaipe().equals("Copas")){
                        pontosCopas++;
                    }
                    if (cartaVirada.getNaipe().equals("Ouros")){
                        pontosOuros++;
                    }
                }
                if (pontosCopas == valor || pontosOuros == valor)
                    System.out.println("vc ganhou\n");
                else {
                    System.out.println(pontosCopas);
                    System.out.println(pontosOuros);
                    System.out.println("vc perdeu\n");
                }
                erro=false;
            } catch (Exception e){
                System.out.println("errooooo");
            }

        }


    }

}
