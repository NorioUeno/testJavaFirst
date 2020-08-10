package designPatterns.Facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {

  // singlton
  private Database() {
  }

  public static Properties getProperties(String dbname) {

    String filename = dbname + ".txt";
    Properties prop = new Properties();
    try {
      prop.load(new FileInputStream(filename));
    } catch (IOException e) {
      System.out.println("Warning:" + filename + " is not found.");
    }
    return prop;

  }

}
