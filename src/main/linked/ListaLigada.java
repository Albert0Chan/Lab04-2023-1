package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;

    public ListaLigada() {

    }

    @Override
    public boolean buscaElemento(int valor) {
        No atual = cabeca;

        while(atual != null){

            if(atual.getValor() == valor){
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        No atual = cabeca;
        int i = 0;
       
        while(atual != null){
            if(i == valor){
                return atual.getValor();
            }
            atual = atual.getProximo();
            i++;
        }
        throw new IndexOutOfBoundsException("Índice não encontrado na lista.");
    }

    @Override
    public int minimo() {
       if(cabeca == null){
        throw new IllegalStateException("A lista está vazia.");
       }

       int valorMinimo = cabeca.getValor();
       No atual = cabeca.getProximo();

       while(atual != null){
        if(atual.getValor() < valorMinimo){
            valorMinimo = atual.getValor();
        }
        atual = atual.getProximo();
       }
       return valorMinimo;
    }

    @Override
    public int maximo() {
        if(cabeca == null){
            throw new IllegalStateException("A lista está vazia.");
        }

        int valorMaximo = cabeca.getValor();
        No atual = cabeca.getProximo();

        while(atual != null){
            if(atual.getValor() > valorMaximo){
                valorMaximo = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return valorMaximo;
    }

    @Override
    public int predecessor(int valor) {
       if(cabeca == null || cabeca.getValor() == valor){
            throw new IllegalStateException("Não há predecessor para o valor " + value);
       }

       No atual = cabeca;
       
       while(atual.getProximo() != null){
        if(atual.getProximo().getValor() == valor){
            return atual.getValor();
        }
        atual = atual.getProximo();
       }
       throw new IllegalStateException("Valor " + valor + " não encontrado na lista.");
    }

    @Override
    public int sucessor(int valor) {
        No atual = cabeca;

        while(atual != null){
            if(atual.getValor() == valor && atual.getProximo() != null){
                return atual.getProximo().getValor();
            }
            atual = atual.getProximo();
        }
        throw new IllegalStateException("Não há sucessor para o valor " + valor);
    }

    @Override
    public void insereElemento(int valor) {
        No novoNo = new No(valor);

        if(cabeca == null){
            cabeca = novoNo;
            return;
        }
        
        No atual = cabeca;
        while(atual.getProximo() != null){
            atual = atual.getProximo();
        }
        atual.getProximo() = novoNo;
    }
    

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insereElementoPosicao'");
    }

    @Override
    public void insereInicio(int valor) {
        if(this.cabeca == null){
            this.cabeca = new No(valor);
        }else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }
    }

    @Override
    public void insereFim(int valor) {
        No novoNo = new No(valor);

        if (cabeca == null) {
            cabeca = novoNo;
            return;
        }

        No atual = cabeca;
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        atual.getProximo() = novoNo;
    }

    @Override
    public void remove(int valor) {
        if (cabeca == null) {
            // Lista vazia, nada para remover.
            return;
        }

        if (cabeca.getValor() == valor) {
            // Se o valor a ser removido está na cabeça, atualiza a cabeça.
            cabeca = cabeca.getProximo();
            return;
        }

        No atual = cabeca;
        while (atual.getProximo() != null && atual.getProximo().getValor() != valor) {
            atual = atual.getProximo();
        }

        if (atual.getProximo() == null) {
            // Se não encontrou o valor na lista, nada para remover.
            return;
        }

        // Atualiza o ponteiro próximo para pular o nó a ser removido.
        atual.getProximo() = atual.getProximo().getProximo();
    }

    }

    @Override
    public void removeIndice(int indice) {
        if (cabeca == null || indice < 0) {
            // Lista vazia ou índice inválido, nada para remover.
            return;
        }

        if (indice == 0) {
            // Se o índice for 0, remove a cabeça.
            cabeca = cabeca.getProximo();
            return;
        }

        No atual = cabeca;
        int indiceAtual = 0;

        while (atual != null && indiceAtual < indice - 1) {
            atual = atual.getProximo();
            indiceAtual++;
        }

        if (atual == null || atual.getProximo() == null) {
            // Se não encontrou o índice na lista, nada para remover.
            return;
        }

        // Atualiza o ponteiro próximo para pular o nó a ser removido.
        atual.getProximo() = atual.getProximo().getProximo();

    @Override
    public void removeInicio() {
        if (cabeca != null) {
            cabeca = cabeca.getProximo();
        }
    }

    @Override
    public void removeFim() {
        if (cabeca == null || cabeca.getProximo() == null) {
            // Lista vazia ou contém apenas um nó, remove a cabeça.
            cabeca = null;
            return;
        }

        No atual = cabeca;
        No anterior = null;

        while (atual.getProximo() != null) {
            anterior = atual;
            atual = atual.getProximo();
        }

        // Remove o último nó, atualizando o ponteiro próximo do nó anterior.
        anterior.getProximo() = null;
    }

}
    

