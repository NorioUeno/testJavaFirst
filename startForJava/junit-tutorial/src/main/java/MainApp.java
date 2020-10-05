import org.yaml.snakeyaml.Yaml;
import practice.section7TestFixture.Book;

public class MainApp {

  public static void main(String[] args) {
    // TODO 自動生成されたメソッド・スタブ

    System.out.println("[junit-tutorial]");

//    Make LRUCashe
//    LruCache<String, String> cashe = new LruCache<String, String>();
//    cashe.put("key1", "value1");
//    cashe.put("key2", "value2");
//    cashe.put("key3", "value3");
//    cashe.getValue("key2");
//    cashe.getKey(2);

//    Use SnakeYaml
    Book book;
    Yaml yaml = new Yaml();
    book = yaml.loadAs(ClassLoader.getSystemResourceAsStream("testFixture.yml"), Book.class);

    System.out.println(book);



//
//    try (InputStream in = Files.newInputStream(input)) {
//        Yaml yaml = new Yaml();
//        User user = yaml.loadAs(in, User.class);

  }

}
