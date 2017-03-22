package com.example.dltexported.volley;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.util.List;

public class CustomAsyncTask extends AsyncTask<String,String,String>
{	
	public VolleyResponseInterface volleyResponseInterface;
	private List<NameValuePair> data;
	private String url;
	private String result;
	private int reqCode;
	
	public CustomAsyncTask(Context activity, String url, List<NameValuePair> data, int reqCode)
	{
		volleyResponseInterface = (VolleyResponseInterface) activity;
		this.url = url;
		this.data = data;		
		this.reqCode = reqCode;
	}

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(String... params)
	{
		try 
		{
			HttpGet httpPost = new HttpGet(url);
		    HttpParams httpParameters = new BasicHttpParams();
			int timeoutConnection = 5000;
			HttpConnectionParams.setConnectionTimeout(httpParameters,timeoutConnection);
			
			int timeoutSocket = 5000;
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
			BasicHttpResponse httpResponse = (BasicHttpResponse) httpClient.execute(httpPost);
			
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null)
			{
				result = EntityUtils.toString(entity);
				result = result.trim();
				return result;
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			volleyResponseInterface.vErrorMsg(reqCode, e.getMessage());
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result)
	{
		super.onPostExecute(result);
		if(result == null)
		{
			volleyResponseInterface.vErrorMsg(reqCode, "No data");
		}
		else
		{
			volleyResponseInterface.vResponse(reqCode,result);
		}
	}
}
