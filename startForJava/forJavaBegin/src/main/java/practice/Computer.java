package practice;

public class Computer {
  private String name;
  private int price;
  private String color;
  private String maketName;

  // constract
  public Computer(String name, int price, String color, String maketName) {

    this.name = name;
    this.price = price;
    this.color = color;
    this.maketName = maketName;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getMaketName() {
    return maketName;
  }

  public void setMaketName(String maketName) {
    this.maketName = maketName;
  }

}
