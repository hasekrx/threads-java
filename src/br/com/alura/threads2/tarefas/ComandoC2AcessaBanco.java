package br.com.alura.threads2.tarefas;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2AcessaBanco implements Callable<String> {

  private PrintStream saidaCliente;

  public ComandoC2AcessaBanco(PrintStream saidaCliente) {
    this.saidaCliente = saidaCliente;
  }

  @Override
  public String call() throws Exception {
    System.out.println("executando comando c2 - BANCO");

    System.out.println("processando comando c2 - BANCO");

    Thread.sleep(12000);

    Integer numero = new Random().nextInt(100) - 1;

    System.out.println("comando c2 executado com sucesso - BANCO!");

    return numero.toString();
  }

}
