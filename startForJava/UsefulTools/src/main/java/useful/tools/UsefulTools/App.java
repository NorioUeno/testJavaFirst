package useful.tools.UsefulTools;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws IOException {
    System.out.println("★★★Start Main★★★");

//    Validations validations = new Validations();
//    validations.setCode("id1");
//    validations.setField("XX");
//    validations.setMessage("error!");
//
//    List<Validations> list = new ArrayList<Validations>();
//    Validations validations1 = new Validations();
//    validations1.setCode("list1");
//    validations1.setField("XX");
//    validations1.setMessage("List1");
//
//    Validations validations2 = new Validations();
//    validations2.setCode("list2");
//    validations2.setField("XX");
//    validations2.setMessage("List2");
//
//    list.add(validations1);
//    list.add(validations2);
//
//    ApiCommonRes<String, String> acr = new ApiCommonRes<String, String>();
//    acr.setCode("AMEM001R001");
//    acr.setComponent("契約SC");
//    acr.setValidations(validations);
//    acr.setList(list);
//
//    String json = "{\n" + "  \"code\" : \"AMEM001R001\",\n" + "  \"aaaaa\" : \"aaa\",\n" + "  \"message\" : \"Validation Error\",\n" + "  \"component\" : \"MemberManagement\",\n" + "  \"sqlcode\" : \"\"\n" + "}";
//    String jsonhoge = "[{\"id\":15, \"name\":\"hoge\"}, {\"id\":16, \"name\":\"fuga\"}]";
//
//    ★Call jsonServeices
//    JsonServices.readJson(jsonhoge);
//    JsonServices.makeJson(json);
//    JsonServices.makeJson(acr);
//    JsonServices.readJsonFile("/Users/aa572057/Documents/GitHub/testJavaFirst/startForJava/UsefulTools/acnt0401_response.json");

//    call apaach HttpclilentbyAppachHttpClient
//    ClientServices cs = new ClientServices();
//    cs.callGetByHttpClient("http://www.apache.org/");
//    cs.callPostByHttpClient("http://scrs001-dv1.apps.ocptest.os.zkai.jp/courses/rules/ajbr0055");
//
//    Use Jersey
//    ClientByJersey cb = new ClientByJersey();
//    cb.getMethod("https://www.google.com/");


    float a = -0.999999f;
    System.out.println(String.valueOf(a));

    int price = 1234567;
    System.out.println(String.format("%,d",price));

    System.out.println("★★★End Main★★★");

  }

}
