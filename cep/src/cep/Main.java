package cep;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;



public class Main {
  public static void main(String[] args) throws Exception {

    HttpClient client = new HttpClient();
    //http://viacep.com.br/ws/96207-010/json/
    //
    GetMethod method = new GetMethod("http://ingresso.ifrs.edu.br/2015/wp-content/themes/ps-2015-1/img/foto-ingresso.jpg");

    client.executeMethod(method);

    byte[] responseBody = method.getResponseBody();

    String s = new String(responseBody);
    System.out.println(s);

  }
}