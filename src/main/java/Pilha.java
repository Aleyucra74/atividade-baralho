public class Pilha<T> {

    int topo;
    T[] pilha;

    public Pilha(int pilha) {
        this.topo = -1;
        this.pilha = (T[]) new Object[pilha];
    }

    public boolean isEmpty(){
        return topo == -1;
    }

    public boolean isFull(){
        return (topo == pilha.length -1) ? true : false;
    }

    public void push(T info){
        if (!isFull()) {
            this.pilha[++this.topo] = info;
        }
        else {
            System.out.println("pilha cheia");
        }
    }

    public T pop(){
        return !isEmpty() ? this.pilha[this.topo--] : null;
    }

    public T peek() { return !isEmpty() ? this.pilha[this.topo] : null; }

    public void exibe(){
        for (int i=0; i<= topo;i++)
            System.out.println(pilha[i]);
    }

    public <T> Pilha multiPop(int n){
        Pilha pilhaAux = new Pilha(n);

        for (int i = 0; i < n; i++) {
            pilhaAux.push(peek());
            pop();
        }

        return pilhaAux;
    }

    public void multiPush(Pilha<T> aux){
        for (int i = 0; i < aux.topo;i++){
            this.push(aux.pop());
        }
    }

}
