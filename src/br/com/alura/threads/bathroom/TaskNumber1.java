package br.com.alura.threads.bathroom;

public class TaskNumber1 implements Runnable {

  private Bathroom bathroom;

  public TaskNumber1(Bathroom bathroom) {
    super();
    this.bathroom = bathroom;
  }


  @Override
  public void run() {
    bathroom.number1();
  }

}
