package com.example.dltexported.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dltexported.attributes.Constant;
import com.example.dltexported.attributes.Utility;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyCacheRequestClass {

    private VolleyResponseInterface volleyResponseInterface;
    private static VolleyCacheRequestClass volleyCacheRequestClass;


    private VolleyCacheRequestClass() {

    }

    public static VolleyCacheRequestClass getInstance() {
        if (volleyCacheRequestClass == null) {
            volleyCacheRequestClass = new VolleyCacheRequestClass();
        }
        return volleyCacheRequestClass;
    }


    public void getCache(Context mContext, final int req, String mUrl, Map<String, String> params) {
        Log.e("params", params.toString());
        try {
            volleyResponseInterface = (VolleyResponseInterface) mContext;

            CacheRequest cacheRequest = new CacheRequest(0, mUrl, params,
                    new Response.Listener<NetworkResponse>() {
                        @Override
                        public void onResponse(NetworkResponse response) {
                            try {
                                Log.e("response", response.toString());
                                String jsonString = new String(response.data,
                                        HttpHeaderParser.parseCharset(response.headers));
                                volleyResponseInterface.vResponse(req, jsonString.toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(Constant.TAG, "Error: " + error.getMessage());
                    volleyResponseInterface.vErrorMsg(req, error.getMessage().toString());
                }
            });

            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(cacheRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void volleyJsonAPI(final Context mContext, final int req, String mUrl, Map<String, String> params) {
        try {
            volleyResponseInterface = (VolleyResponseInterface) mContext;
            Log.d(Constant.TAG, "Request: " + params.toString());
            JsonObjectRequest cacheRequest = new JsonObjectRequest(mUrl, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d(Constant.TAG, "Response: " + response.toString());
                                volleyResponseInterface.vResponse(req, response.toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(Constant.TAG, "Error: " + error.getMessage());
                    volleyResponseInterface.vErrorMsg(req, error.getMessage());
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    if (!Utility.getAppPrefString(mContext, Constant.Authorization).equalsIgnoreCase("")) {
                        headers.put(Constant.Authorization, Utility.getAppPrefString(mContext, Constant.Authorization));
                    }
                    return headers;
                }
            };


            cacheRequest.setRetryPolicy(new DefaultRetryPolicy(Constant.MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(cacheRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void volleyGetJsonAPI(final Context mContext, final int req, String mUrl) {
        try {
            volleyResponseInterface = (VolleyResponseInterface) mContext;
            Log.d(Constant.TAG, "Request URL: " + mUrl);
            JsonObjectRequest cacheRequest = new JsonObjectRequest(mUrl, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d(Constant.TAG, "Response: " + response.toString());
                                volleyResponseInterface.vResponse(req, response.toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(Constant.TAG, "Error: " + error.getMessage());
                    volleyResponseInterface.vErrorMsg(req, error.getMessage());
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    if (!Utility.getAppPrefString(mContext, Constant.Authorization).equalsIgnoreCase("")) {
                        headers.put(Constant.Authorization, Utility.getAppPrefString(mContext, Constant.Authorization));
                    }
                    return headers;
                }
            };

            cacheRequest.setRetryPolicy(new DefaultRetryPolicy(Constant.MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(cacheRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
