package br.com.alura.threads.database;

public class TarefaAcessaBancoProcedimento implements Runnable {

  private PoolDeConexao pool;
  private GerenciadorDeTransacao tx;

  public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
    this.pool = pool;
    this.tx = tx;
  }

  @Override
  public void run() {

    synchronized (pool) {
      System.out.println("comecando a tx");
      tx.begin();

      synchronized (tx) {
        pool.getConnection();
        System.out.println("peguei a conexao");
      }

    }


  }

}
