package br.com.alura.threads.lista;

import java.util.List;
import java.util.Vector;

public class PrincipalLista {

  public static void main(String[] args) throws InterruptedException {

    List<String> lista = new Vector<String>();

    for (int i = 0; i < 100; i++) {
      Thread thread = new Thread(new TarefaAdicionarElement(lista, i));

      thread.start();
    }

    Thread.sleep(2000);

    for (int i = 0; i < lista.size(); i++) {
      System.out.println(i + " - " + lista.get(i));
    }

  }

}
