package tag6;

/**
 * @author Markus Cozowicz
 * @version 1.0
 */
public class McFress
{
  public static void main(String[] args)
  {
    // String text = "Welcome to homer";
    // Strin pattern = "hom";
    // int pos = text.indexOf(pattern);

    // Name, Image Name, Price, Group
    String line = "BigMac,big_mac,2.75,Burger";

    int pos = line.indexOf(",",0); // beistrich an erster position
    int pos1 = line.indexOf(",",pos+1); // an zweiter position

    String name = line.substring(0,pos);
    // ausschneiden des restes
    String priceStr = "2.75";

    float price = Float.parseFloat(priceStr);

    System.out.println("Name: " + name);
    System.out.println("2x Price: " + (2*price));

    line.substring(10); // alles von pos 10 bis zum ende

    Product p = new Product();
    p.setName(name);
    p.setPrice(price);
  }
}
