package reference;

public class Bsp7
{
  public static float[] rowSum(float[][] data) {
    float[] sum = new float[data.length];
    for (int i = 0; i < data.length; i++)
      for (int j = 0; j < data[i].length; j++)
        sum[i] += data[i][j];

    return sum;
  }

  public static void main(String[] args)
  {
    float[][] d = {{1,2,3},{4,5}};
    float[] sum = rowSum(d);

    for (int i = 0; i < sum.length; i++)
    {
      System.out.println("row sum " + i + " = " + sum[i]);
    }
  }
}
