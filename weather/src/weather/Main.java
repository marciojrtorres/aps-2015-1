package weather;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    CloseableHttpClient client = HttpClients.createDefault();
    //HttpGet get = new HttpGet("http://viacep.com.br/ws/96207-010/json/");
    HttpGet get = new HttpGet("http://api.openweathermap.org/data/2.5/weather?id=3451138");
    CloseableHttpResponse response = client.execute(get);
    String text = EntityUtils.toString(response.getEntity());
    System.out.println(text);
  }
}