import java.util.Random;

public class Baralho {

    private Pilha<Carta> baralho = new Pilha<>(52);

    public Baralho() {
        String[] faces = new String[]{"Ás","2","3","4","5","6","7","8","9","10","Valete","Dama","Rei"};
        String[] naipes = new String[]{"Copas","Paus","Ouros","Espadas"};
        int cont=0;
        while (!baralho.isFull()){
            baralho.push(new Carta(faces[cont%13],cont%13+1,naipes[cont/13]));
            cont++;
        }

    }

    public Carta removeCarta(int indice){
        Pilha<Carta> pilhaAuxiliar = new Pilha<>(52);

        for (int i = 0; i < indice; i++) {
            pilhaAuxiliar.push(baralho.pop());
        }
        Carta alvo= baralho.pop();
        while (!pilhaAuxiliar.isEmpty()){
            baralho.push(pilhaAuxiliar.pop());
        }
        return alvo;
    }

    public void embaralhar(){
        Random nmr = new Random();
        Carta random = null;
        for (int i = 0; i < 52; i++) {
            int nmrRandom = nmr.nextInt(52);
            if (nmrRandom != 0 ){
                random = removeCarta(nmrRandom);
                baralho.push(random);
            }
        }
    }

    public Carta virarCarta(){
        return baralho.pop();
    }

    public void exibeBaralho(){
        baralho.exibe();
    }

    public Pilha<Carta> getBaralho() {
        return baralho;
    }

    public void setBaralho(Pilha<Carta> baralho) {
        this.baralho = baralho;
    }
}
