package tag6;

// JavaBeans
public class Product
{
  private String name;
  private String imageName;
  private float price;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }


  public float getPrice()
  {
    return price;
  }

  public void setPrice(float price)
  {
    if(price > 0)
      this.price = price;
  }

  public void setImageName(String imageName)
  {
    this.imageName = imageName;
  }

}
