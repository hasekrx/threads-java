package br.com.alura.threads.numbers;

public class RunAllNumbers implements Runnable {

  private Integer startNumber;
  private Integer finalNumber;

  public RunAllNumbers(Integer startNumber, Integer finalNumber) {
    super();
    this.startNumber = startNumber;
    this.finalNumber = finalNumber;
  }

  public Integer getStartNumber() {
    return startNumber;
  }

  public void setStartNumber(Integer startNumber) {
    this.startNumber = startNumber;
  }

  public Integer getFinalNumber() {
    return finalNumber;
  }

  public void setFinalNumber(Integer finalNumber) {
    this.finalNumber = finalNumber;
  }



  @Override
  public void run() {

    for (int i = startNumber; i < finalNumber; i++) {
      System.out.println("Id da thread: " + Thread.currentThread().getId() + " - Numero: " + i);
    }

  }



}
