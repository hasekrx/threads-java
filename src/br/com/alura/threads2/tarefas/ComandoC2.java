package br.com.alura.threads2.tarefas;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

  private PrintStream saidaCliente;

  public ComandoC2(PrintStream saidaCliente) {
    this.saidaCliente = saidaCliente;
  }

  @Override
  public void run() {
    System.out.println("executando comando c2");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    throw new RuntimeException("exception");

    // System.out.println("comando c2 executado com sucesso!");

  }

}
