package crackingTheCodingInterview.objectDesign.customerCenter;

public class Manager extends Person {

  public Manager (String name){
    this.name = name;
  }


  @Override
  public Res reciveCall(Call call) throws Exception {
//    役職固有の処理

    isBusy = true;
    Res res = new Res();
    Thread.sleep(10L);
    isBusy = false;
    return res;
  }


}
