package br.com.alura.threads.busca;

public class BuscaPrincipal {

  public static void main(String[] args) {

    String nome = "da";

    Thread threadAssinaturas1 =
        new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome), "Thread Assinatura 01");

    Thread threadAssinaturas2 =
        new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome), "Thread Assinatura 02");

    Thread threadAutores =
        new Thread(new TarefaBuscaTextual("autores.txt", nome), "Thread Autores 03");

    threadAssinaturas1.start();
    threadAssinaturas2.start();
    threadAutores.start();
  }

}
