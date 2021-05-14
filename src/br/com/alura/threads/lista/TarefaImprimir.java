package br.com.alura.threads.lista;

public class TarefaImprimir implements Runnable {

  private Lista lista;

  public TarefaImprimir(Lista lista) {
    super();
    this.lista = lista;
  }


  @Override
  public void run() {
    synchronized (lista) {

      if (!lista.estaCheia()) {
        try {
          System.out.println("sleeping, waiting notification");
          lista.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      for (int i = 0; i < lista.tamanho(); i++) {
        System.out.println(i + " - " + lista.pegaElemento(i));
      }

    }

  }

}
