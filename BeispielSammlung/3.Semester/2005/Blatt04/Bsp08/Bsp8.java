package reference;

import java.io.*;

public class Bsp8
{
  public static void main(String[] args) throws Exception
  {
    // read size from user
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Array Groesse eingeben: ");
    int size = Integer.parseInt(br.readLine());

    // create array
    int[] data = new int[size];
    // random data
    for (int i = 0; i < data.length; i++) {
      data[i] = (int) (Math.random() * 10);
      System.out.print(data[i] + " ");
    }
    System.out.println();

    // read sum from user
    System.out.print("Summe eingeben: ");
    int sumToSearchFor = Integer.parseInt(br.readLine());

    // search for sum
    for (int i = 0; i < data.length-1; i++)
      for (int j = i+1; j < data.length; j++)
        if(data[i] + data[j] == sumToSearchFor) {
          System.out.println("Found " + data[i] + " + " + data[j]);
  }
}
