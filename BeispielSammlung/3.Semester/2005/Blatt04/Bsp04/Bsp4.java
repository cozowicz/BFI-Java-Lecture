package reference;

public class Bsp4
{
  public static void insertAt(char[] array, int pos, char c) {

    if(pos >= array.length)
      return;

    for (int i = array.length-1 ; i > pos && i > 0; i--)
      array[i] = array[i-1];
    array[pos] = c;
  }

  public static void main(String[] args)
  {
    char[] arr = "Markus".toCharArray();
    insertAt(arr, 0, 'A');
    insertAt(arr, 4, 'S');
    insertAt(arr, 5, 'X');
    insertAt(arr, 1, 'U');

    System.out.println(new String(arr));
  }
}
