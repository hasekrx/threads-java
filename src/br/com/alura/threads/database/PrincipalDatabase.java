package br.com.alura.threads.database;

public class PrincipalDatabase {

  public static void main(String[] args) {

    GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
    PoolDeConexao pool = new PoolDeConexao();
    System.out.println("oie");
    new Thread(new TarefaAcessaBanco(pool, tx)).start();
    new Thread(new TarefaAcessaBancoProcedimento(pool, tx)).start();

  }

}
