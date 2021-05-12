package br.com.alura.threads.bathroom;

public class TaskNumber2 implements Runnable {

  private Bathroom bathroom;

  public TaskNumber2(Bathroom bathroom) {
    super();
    this.bathroom = bathroom;
  }


  @Override
  public void run() {
    bathroom.number2();
  }

}
