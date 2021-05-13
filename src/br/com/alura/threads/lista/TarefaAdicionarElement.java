package br.com.alura.threads.lista;

import java.util.List;

public class TarefaAdicionarElement implements Runnable {

  private List<String> lista;
  private int numeroThread;


  public TarefaAdicionarElement(List<String> lista, int numeroThread) {
    super();
    this.lista = lista;
    this.numeroThread = numeroThread;
  }



  @Override
  public void run() {

    for (int i = 0; i < 10; i++) {
      lista.add("Thread " + numeroThread + " - " + i);
    }
  }

}
