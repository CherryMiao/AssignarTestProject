package com.util;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static String[] sendHttpPost(String url, String body) throws Exception 
	{  
		CloseableHttpClient httpClient = createSSLInsecureClient();  
		HttpPost httpPost = new HttpPost(url);  
		
		httpPost.setEntity(new StringEntity(body)); 
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		CloseableHttpResponse response = httpClient.execute(httpPost);  
//		System.out.println(response.getStatusLine().getStatusCode() + "\n");  
		
		HttpEntity entity = response.getEntity();  
		String responseContent = EntityUtils.toString(entity, "UTF-8");   
//		System.out.println(responseContent);  
		
		response.close();  
		httpClient.close();  
		
		return new String[] {response.getStatusLine().getStatusCode() + "", responseContent}; 
	}
	
	public static String[] sendHttpPostWithToken(String url, String token, String body) throws Exception 
	{  
		CloseableHttpClient httpClient = createSSLInsecureClient();  
		HttpPost httpPost = new HttpPost(url);  
		
		httpPost.setEntity(new StringEntity(body)); 
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setHeader("Authorization", "Bearer " + token);
		
		CloseableHttpResponse response = httpClient.execute(httpPost);  
//		System.out.println(response.getStatusLine().getStatusCode() + "\n");  
		
		HttpEntity entity = response.getEntity();  
		String responseContent = EntityUtils.toString(entity, "UTF-8");   
//		System.out.println(responseContent);  
		
		response.close();  
		httpClient.close();  
		
		return new String[] {response.getStatusLine().getStatusCode() + "", responseContent}; 
	}
	
	private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException { 
		try { 
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, 
				new TrustStrategy() { 
		        	public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException { 
		        		return true; 
		        	} 
			}).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, 
				new HostnameVerifier() { 
					public boolean verify(String hostname, SSLSession session) { 
						return true; 
					}
			});

			return HttpClients.custom().setSSLSocketFactory(sslsf).build();

		} catch (GeneralSecurityException e) { 
			throw e; 
			} 
	}
	

}
