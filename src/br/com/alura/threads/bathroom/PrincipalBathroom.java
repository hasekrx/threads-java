package br.com.alura.threads.bathroom;

public class PrincipalBathroom {

  public static void main(String[] args) {


    Bathroom bathroom = new Bathroom();

    Thread guest1 = new Thread(new TaskNumber1(bathroom), "Joao");
    Thread guest2 = new Thread(new TaskNumber2(bathroom), "Maria");

    Thread limpeza = new Thread(new TaskClean(bathroom), "Clean");
    limpeza.setDaemon(true);

    guest1.start();
    guest2.start();
    limpeza.start();

  }

}
