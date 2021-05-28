package br.com.alura.threads2.tarefas;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class JuntaFuturesWsAndBanco implements Callable<Void> {

  private Future<String> futureWS;
  private Future<String> futureBanco;
  private PrintStream saidaCliente;

  public JuntaFuturesWsAndBanco(Future<String> futureWS, Future<String> futureBanco,
      PrintStream saidaCliente) {
    this.futureWS = futureWS;
    this.futureBanco = futureBanco;
    this.saidaCliente = saidaCliente;
  }

  @Override
  public Void call() {

    System.out.println("Aguardando resultados do future ws e banco");


    try {
      String ws = futureWS.get(15, TimeUnit.SECONDS);
      String banco = futureBanco.get(15, TimeUnit.SECONDS);

      this.saidaCliente.println("resultado comando C2 " + ws + ", " + banco);
    } catch (Exception e) {
      System.out.println("cancelando execudao da tarefa do comando c2");
      this.saidaCliente.println("timeout na execuao do comando C2");
      futureWS.cancel(true);
      futureBanco.cancel(true);
    }


    return null;
  }

}
