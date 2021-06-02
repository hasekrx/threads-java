package br.com.alura.threads2.tarefas;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumir implements Runnable {

  private BlockingQueue<String> filaComando;


  public TarefaConsumir(BlockingQueue<String> filaComando) {
    this.filaComando = filaComando;
  }



  @Override
  public void run() {

    try {

      String comando = null;

      while ((comando = filaComando.take()) != null) {
        System.out.println("consumindo comando c3 " + comando);
        Thread.sleep(5000);

      }

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

}
