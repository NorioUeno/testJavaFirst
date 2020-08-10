package designPatterns;

import java.io.IOException;
import java.util.List;
import designPatterns.Bridge.CounttDisplay;
import designPatterns.Bridge.Display;
import designPatterns.Bridge.StringDisplayImpl;
import designPatterns.Builder.Director;
import designPatterns.Builder.TextBuilder;
import designPatterns.ChainOfResponsiblility.LimitSupport;
import designPatterns.ChainOfResponsiblility.NoSupport;
import designPatterns.ChainOfResponsiblility.OddSupport;
import designPatterns.ChainOfResponsiblility.SpecialSupport;
import designPatterns.ChainOfResponsiblility.Support;
import designPatterns.ChainOfResponsiblility.Trouble;
import designPatterns.Composite.Directory;
import designPatterns.Composite.File;
import designPatterns.Composite.FileTreatmentException;
import designPatterns.Facade.PageMaker;
import designPatterns.Singleton.Singleton;
import designPatterns.Singleton.practice.TicketMaker;
import designPatterns.Singleton.practice.Triple;
import designPatterns.Stratery.Hand;
import designPatterns.Stratery.Player;
import designPatterns.Stratery.RandomStrategy;
import designPatterns.Stratery.WinningStrategy;
import designPatterns.abstractFactory.factory.Link;
import designPatterns.abstractFactory.factory.Page;
import designPatterns.abstractFactory.factory.Tray;
import designPatterns.adapter.practice.FileIO;
import designPatterns.adapter.practice.FileProperties;
import designPatterns.adapter.usedByInstance.Print;
import designPatterns.adapter.usedByInstance.PrintBanner;
import designPatterns.factoryMethod.framework.Factory;
import designPatterns.factoryMethod.framework.Product;
import designPatterns.factoryMethod.idcard.IDCardFactory;
import designPatterns.iterator.Book;
import designPatterns.iterator.BookShelf;
import designPatterns.iterator.Iterator;
import designPatterns.prototype.Manager;
import designPatterns.prototype.MessageBox;
import designPatterns.prototype.UnderlinePen;
import designPatterns.templateMethod.AbstractDisplay;
import designPatterns.templateMethod.CharDisplay;
import designPatterns.templateMethod.StringDisplay;

/**
 * Hello world!
 */
public class App {

  // 改行コード取得
  final static String BR = System.getProperty("line.separator");

  public static void main(String[] args) throws IOException {
    System.out.println("★★★Main:start★★★" + System.getProperty("line.separator"));

    // 1 iterator
    // iterator();

    // 2 adapter
    // 2-1 by class & 2-2 by instance import文を切り替える必要あり
    // adapter();
//    adapterPracticeUseProperties();

    // 3 template Method
//    templateMethod();

    // 4 Factory Method
//    factoryMethod();

    // 5 Singleton
    // Singleton();

    // 6 Prototype
//    prototype();

    // 7 builder
    // buider("plain");

    // 8 abstract Factory
//    abstractFactory("designPatterns.abstractFactory.listfactory.ListFactory");

    // 9 Bridge
    // bridge();

    // 10 Strategy
    // strategy(new String[] { "111", "213" });

    // 11 Composite
    // composite();

    // 12 Decorator
    // decorator();

    // 13 Visitor
//    visitor();

    // 14 Chain of Resphonsiblitiy
    // chainOfResphosiblity();

    // 15 Facade
    facade();

    System.out.println(BR + "★★★Main:End★★★");

  }

  public static void iterator() {

    System.out.println("★Iterator:start★");
    BookShelf bk = new BookShelf(4, true);
    bk.appendBook(new Book("Arround the World in 80 days"));
    bk.appendBook(new Book("Bibrle"));
    bk.appendBook(new Book("Cinderella"));
    bk.appendBook(new Book("Daddy-Long-Legs"));
    bk.appendBook(new Book("Egg"));
    bk.appendBook(new Book("For"));

    Iterator it = bk.iterator();
    while (it.hasNext()) {
      Book book = (Book) it.next();
      System.out.println(book.getName());
    }
  }

  public static void adapter() {
    Print p = new PrintBanner("Hello");
    p.printStrong();
    ((PrintBanner) p).printWeak();
    p.printWeak();
  }

  public static void adapterPracticeUseProperties() throws IOException {

    FileIO fio = new FileProperties();
    fio.readFromFile("/Users/aa572057/Documents/GitHub/testJavaFirst/startForJava/designPatterns/file.txt");
    // fio.setValue("year", fio.getValue("year"));
    fio.setValue("month", "4");
    fio.setValue("day", "21");
    fio.writeToFile("/Users/aa572057/Documents/GitHub/testJavaFirst/startForJava/designPatterns/newfile.txt");

  }

  public static void templateMethod() {
    AbstractDisplay cd = new CharDisplay('H');
    cd.display();
    System.out.println(System.getProperty("line.separator"));

    AbstractDisplay sd = new StringDisplay("hello world!");
    sd.display();

  }

  public static void factoryMethod() {
    Factory factory = new IDCardFactory();
    Product card1 = factory.create("norio1");
    Product card2 = factory.create("norio2");
    Product card3 = factory.create("norio3");
    card1.use();
    card2.use();
    card3.use();

    List<String> owners = ((IDCardFactory) factory).getOwners();
    for (String owner : owners) {
      System.out.println(owner);
    }
  }

  public static void Singleton() {
    Singleton obj1 = designPatterns.Singleton.Singleton.getInstance();
    Singleton obj2 = designPatterns.Singleton.Singleton.getInstance();

    if (obj1 == obj2) {
      System.out.println("same one");
    } else {
      System.out.println("not same");
    }

    TicketMaker tm = designPatterns.Singleton.practice.TicketMaker.getInstance();
    System.out.println(tm.getNextTicketNumber());
    System.out.println(tm.getNextTicketNumber());
    System.out.println(tm.getNextTicketNumber());

    Triple triple1 = designPatterns.Singleton.practice.Triple.getInstance(0);
    Triple triple2 = designPatterns.Singleton.practice.Triple.getInstance(1);
    System.out.println(triple1);
    System.out.println(triple2);
  }

  public static void prototype() {
    // 準備
    Manager manager = new Manager();
    UnderlinePen upen = new UnderlinePen('~');
    MessageBox mbox = new MessageBox('*');
    MessageBox sbox = new MessageBox('/');
    manager.register("strong message", upen);
    manager.register("warning box", mbox);
    manager.register("slash box", sbox);

    // 生成
    designPatterns.prototype.Product p1 = manager.create("strong message");
    p1.use("Hello, World");
    designPatterns.prototype.Product p2 = manager.create("warning box");
    p2.use("Hello, World");
    designPatterns.prototype.Product p3 = manager.create("slash box");
    p3.use("Hello, World");

  }

  public static void buider(String type) {
    if (type.equals("plain")) {
      TextBuilder tb = new TextBuilder();
      Director director = new Director(tb);
      director.construct();
      String result = tb.getResult();
      System.out.println(result);

    } else if (type.equals("html")) {
      System.out.println("html");
    } else {
      System.out.println("chose below!");
      System.out.println("html or plain?");
    }
  }

  public static void abstractFactory(String string) {
//    if (string.length() != 1) {
//      System.out.println("Usage: java Main class.name.of.ConcreateFactory");
//      System.out.println("Example 1: java Main listfactory.ListFactory");
//      System.out.println("Example 2: java Main tablefactory.TableFactory");
//      System.exit(0);
//    }
    designPatterns.abstractFactory.factory.Factory factory = designPatterns.abstractFactory.factory.Factory.getfactory(string);

    Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
    Link yomiuri = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/");
    Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
    Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
    Link excite = factory.createLink("Excite", "http://www.excite.com/");
    Link google = factory.createLink("google", "http://www.google.com/");

    Tray traynews = factory.createTray("新聞");
    traynews.add(asahi);
    traynews.add(yomiuri);

    Tray trayyahoo = factory.createTray("Yahoo!");
    trayyahoo.add(us_yahoo);
    trayyahoo.add(jp_yahoo);

    Page page = factory.createPage("LingPage", "norio");
    page.add(traynews);
    page.add(trayyahoo);
    page.output();

  }

  public static void bridge() {
    Display d1 = new Display(new StringDisplayImpl("hello, Japan."));
    Display d2 = new CounttDisplay(new StringDisplayImpl("hello, Japan."));
    CounttDisplay d3 = new CounttDisplay(new StringDisplayImpl("hello, Universe."));
    d1.display();
    d2.display();
    d3.display();
    d3.multiDisplay(5);
  }

  public static void strategy(String[] s1) {
    int seed1 = Integer.parseInt(s1[0]);
    int seed2 = Integer.parseInt(s1[1]);
    Player player1 = new Player("taro", new WinningStrategy(seed1));
    Player player2 = new Player("hana", new RandomStrategy(seed2));
    // Player player2 = new Player("hana", new ProbStrategy(seed2));
    for (int i = 0; i < 10000; i++) {
      Hand nextHand1 = player1.nextHand();
      Hand nextHand2 = player2.nextHand();
      if (nextHand1.isStrongerThan(nextHand2)) {
        System.out.println("Winner" + player1);
        player1.win();
        player2.lose();
      } else if (nextHand2.isStrongerThan(nextHand1)) {
        System.out.println("Winner" + player2);
        player2.win();
        player1.lose();

      } else {
        System.out.println("Even...");
        player2.even();
        player1.even();
      }
    }
    System.out.println("Total result:");
    System.out.println(player1.toString());
    System.out.println(player2.toString());
  }

  public static void composite() {
    try {
      System.out.println("making root entries...");
      Directory rootdir = new Directory("root");
      Directory bindir = new Directory("bin");
      Directory tmpdir = new Directory("tmp");
      Directory usrdir = new Directory("usr");
      Directory etcdir = new Directory("etc");
      rootdir.add(bindir);
      rootdir.add(tmpdir);
      rootdir.add(usrdir);
      usrdir.add(etcdir);
      bindir.add(new File("vi", 10000));
      bindir.add(new File("latex", 22000));
      File file = new File("hello.java", 1000);
      ;
      etcdir.add(file);
      rootdir.prinList();

      System.out.println("");
      System.out.println("file = " + file.getFullName());
      System.out.println("usr = " + usrdir.getFullName());

    } catch (FileTreatmentException e) {
      e.printStackTrace();
    }
  }

  public static void decorator() {
    designPatterns.Decorator.Display b1 = new designPatterns.Decorator.StringDisplay("Hello, world.");
    designPatterns.Decorator.Display b2 = new designPatterns.Decorator.SideBorder(b1, '#');
    designPatterns.Decorator.Display b3 = new designPatterns.Decorator.FullBorder(b2);

//    b1.show();
//    b2.show();
//    b3.show();
    designPatterns.Decorator.Display b4 = new designPatterns.Decorator.SideBorder(new designPatterns.Decorator.FullBorder(
        new designPatterns.Decorator.FullBorder(new designPatterns.Decorator.SideBorder(new designPatterns.Decorator.FullBorder(new designPatterns.Decorator.StringDisplay("hello")), '*'))), '/');
    b4.show();

    System.out.println("");
    designPatterns.Decorator.Display b5 = new designPatterns.Decorator.SideBorder(new designPatterns.Decorator.UpDownBorder(b2), '!');
    b5.show();

    System.out.println("");
    designPatterns.Decorator.MultiStringDisplay b6 = new designPatterns.Decorator.MultiStringDisplay();
    b6.add("Good Morning");
    b6.add("goodNight");
    b6.add("goodEvening");
    b6.show();

    designPatterns.Decorator.Display d1 = new designPatterns.Decorator.SideBorder(b6, '#');
    d1.show();

  }

  public static void visitor() {
    try {
      System.out.println("Making root entries...");
      designPatterns.Visitor.Directory rootdir = new designPatterns.Visitor.Directory("root");
      designPatterns.Visitor.Directory bindir = new designPatterns.Visitor.Directory("bin");
      designPatterns.Visitor.Directory tmpdir = new designPatterns.Visitor.Directory("tmp");
      designPatterns.Visitor.Directory usrdir = new designPatterns.Visitor.Directory("usr");
      rootdir.add(bindir);
      rootdir.add(tmpdir);
      rootdir.add(usrdir);
      bindir.add(new designPatterns.Visitor.File("vi", 10000));
      bindir.add(new designPatterns.Visitor.File("latex", 20000));
      rootdir.accept(new designPatterns.Visitor.ListVisitor());

      System.out.println("");
      System.out.println("Making user entries...");
      designPatterns.Visitor.Directory yuki = new designPatterns.Visitor.Directory("yuki");
      designPatterns.Visitor.Directory hanako = new designPatterns.Visitor.Directory("hanako");
      designPatterns.Visitor.Directory tomura = new designPatterns.Visitor.Directory("tomura");
      usrdir.add(yuki);
      usrdir.add(hanako);
      usrdir.add(tomura);
      yuki.add(new designPatterns.Visitor.File("diary.html", 100));
      yuki.add(new designPatterns.Visitor.File("composite.java", 200));
      hanako.add(new designPatterns.Visitor.File("memo.java", 300));
      tomura.add(new designPatterns.Visitor.File("tomu.java", 400));
      rootdir.accept(new designPatterns.Visitor.ListVisitor());

    } catch (FileTreatmentException e) {
      e.printStackTrace();
    }
  }

  public static void chainOfResphosiblity() {
    Support alice = new NoSupport("Alice");
    Support bob = new LimitSupport("Bob", 100);
    Support charlie = new SpecialSupport("Charlie", 429);
    Support diana = new LimitSupport("Diana", 200);
    Support elmo = new OddSupport("Elmo");
    Support fred = new LimitSupport("Fred", 300);

    alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

    for (int i = 0; i < 500; i += 33) {
      alice.support(new Trouble(i));
    }
  }

  public static void facade() {
    PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");

  }

}
