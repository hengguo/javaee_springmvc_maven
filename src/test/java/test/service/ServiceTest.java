package test.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class ServiceTest {
	 @Test
	 public void appSync(){
		 String pre = "user/getDynamicUsers";
	        String url = "http://localhost:8090/springmvc_demo/" + pre;
	        JSONObject jo = new JSONObject();
	        jo.put("A", "aaa");
	        try {
	            HttpPost httppost = new HttpPost(url);
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
	            HttpResponse httpResponse = new DefaultHttpClient().execute(httppost);
	            HttpEntity entity2 = httpResponse.getEntity();
	            System.out.println(EntityUtils.toString(entity2));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }

}
