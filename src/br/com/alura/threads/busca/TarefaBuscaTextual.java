package br.com.alura.threads.busca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

  private String fileName;
  private String name;



  public TarefaBuscaTextual(String fileName, String name) {
    super();
    this.fileName = fileName;
    this.name = name;
  }

  public String getFileName() {
    return fileName;
  }



  public void setFileName(String fileName) {
    this.fileName = fileName;
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  @Override
  public void run() {

    try {

      Scanner scanner = new Scanner(new File(fileName));
      int numeroLinha = 1;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        if (line.toLowerCase().contains(name.toLowerCase())) {
          System.out.println(fileName + " - " + numeroLinha + " - " + line);
        }

        numeroLinha++;
      }

      scanner.close();

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }


  }

}
