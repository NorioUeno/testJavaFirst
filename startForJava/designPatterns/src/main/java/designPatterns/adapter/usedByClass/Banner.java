package designPatterns.adapter.usedByClass;

public class Banner {

  private String string;


  //constructor
  public Banner(String string) {
    this.string = string;
    }

  public void showWithParen() {
    System.out.println("("+ string + ")");
  }

  public void showWithAster() {
    System.out.println("*"+ string + "*");
  }


}
