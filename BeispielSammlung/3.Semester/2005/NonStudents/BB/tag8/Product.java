package tag8;

// JavaBean
public class Product
{
  private String name;
  private float preis;

  // Property
  // getter/setter methoden
  // bzw. accessor
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public float getPreis()
  {
    return preis;
  }

  public void setPreis(float preis)
  {
    if(preis < 0)
      throw new IllegalArgumentException("Nur positiver Preis erlaubt");

    this.preis = preis;
  }




  private String bild;
  private String gruppe;


  public String getBild()
  {
    return bild;
  }

  public String getGruppe()
  {
    return gruppe;
  }

  public void setBild(String bild)
  {
    this.bild = bild;
  }

  public void setGruppe(String gruppe)
  {
    this.gruppe = gruppe;
  }
}
