package br.com.alura.threads.lista;

public class TarefaAdicionarElement implements Runnable {

  private Lista lista;
  private int numeroThread;


  public TarefaAdicionarElement(Lista lista, int numeroThread) {
    super();
    this.lista = lista;
    this.numeroThread = numeroThread;
  }



  @Override
  public void run() {

    for (int i = 0; i < 100; i++) {
      lista.adicionaElementos("Thread " + numeroThread + " - " + i);
    }
  }

}
