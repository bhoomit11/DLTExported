package com.example.dltexported.volley;


public interface VolleyResponseInterface {
    void vResponse(int reqCode, String response);

    void vErrorMsg(int reqCode, String error);
}
