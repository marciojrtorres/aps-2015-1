package reajuste;

import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class CotacaoWebService {

	public double getCotacao() {
		double value = 0.0;
		try {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%3D%22USDBRL%22&format=json&diagnostics=false&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		CloseableHttpResponse response = httpclient.execute(httpget);
		String json = EntityUtils.toString(response.getEntity());
		response.close();
		
		
		Gson gs = new Gson();
		Map<String, Object> map = gs.fromJson(json, Map.class);
		value = Double.valueOf(((Map)((Map)((Map)map.get("query")).get("results")).get("rate")).get("Rate").toString());
		} catch (Exception e) { throw new RuntimeException(e); }
		
		return value;
	}
}
