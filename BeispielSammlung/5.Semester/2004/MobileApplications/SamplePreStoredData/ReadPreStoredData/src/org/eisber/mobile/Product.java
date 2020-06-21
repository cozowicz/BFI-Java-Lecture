package org.eisber.mobile;

public class Product
{
  private String name;
  private String group;
  private int price;
  private String image;
  public String getName()
  {
    return name;
  }

  public String getGroup()
  {
    return group;
  }

  public int getPrice()
  {
    return price;
  }

  public String getImage()
  {
    return image;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setGroup(String group)
  {
    this.group = group;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }

  public void setImage(String image)
  {
    this.image = image;
  }
}
