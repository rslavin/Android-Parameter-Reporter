package edu.utsa.cs.sefm.xposed.parameterdetector;

import java.util.Arrays;
import java.util.List;


public class SearchCriteria {
    protected static final List<String> PACKAGES = Arrays.asList(
            "com.example.sean.myapplication",
            "cc.pacer.androidapp",
            "com.dayspringtech.envelopes",
            "com.dietcoacher.sos",
            "com.droid4you.application.wallet",
            "com.fitnow.loseit",
            "com.fooducate.nutritionapp",
            "com.mint"
    );

    /**
     * String packageName => List [n => [String apiClass, String apiMethod, List<int>[paramIndices], Object[] [paramTypes]]]
     * Set apiMethod to NULL for constructors
     */
    protected static final List<List<Object>> SEARCH_CRITERIA = Arrays.asList(
            Arrays.asList("org.apache.http.client.methods.HttpGet", null, Arrays.asList(0), new Object[]{
                    java.lang.String.class
            }),
            Arrays.asList("org.apache.http.client.methods.HttpPost", null, Arrays.asList(0), new Object[]{
                    java.lang.String.class
            }),
//            Arrays.asList("org.apache.http.HttpEntityEnclosingRequest", "setEntity", Arrays.asList(0), new Object[]{
//                    org.apache.http.HttpEntity.class
//            }),
//            Arrays.asList("org.apache.http.impl.client.DefaultHttpClient", "execute", Arrays.asList(0), new Object[]{
//                    org.apache.http.client.methods.HttpUriRequest.class
//            }),
            Arrays.asList("org.apache.http.client.methods.HttpPost", "setEntity", Arrays.asList(0), new Object[]{
                    org.apache.http.HttpEntity.class
            }),
            Arrays.asList("org.apache.http.client.methods.HttpGet", null, Arrays.asList(0), new Object[]{
                    java.net.URI.class
            }),
            Arrays.asList("org.apache.http.client.methods.HttpRequestBase", "setHeader", Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            }),
            Arrays.asList("org.apache.http.client.methods.HttpGet", "setURI", Arrays.asList(0), new Object[]{
                    java.net.URI.class
            }),
//            Arrays.asList("org.apache.http.params.HttpParams", "setParameter", Arrays.asList(0, 1), new Object[]{
//                    java.lang.String.class,
//                    java.lang.Object.class
//            }),
            Arrays.asList("org.apache.http.client.methods.HttpPost", "setHeader", Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            }),
            Arrays.asList("org.apache.http.message.BasicNameValuePair", null, Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            }),
            Arrays.asList("org.apache.http.client.methods.HttpPost", "addHeader", Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            }),
//            Arrays.asList("org.apache.http.HttpResponse", "setEntity", Arrays.asList(0), new Object[]{
//                    org.apache.http.HttpEntity.class
//            }),
            Arrays.asList("com.loopj.android.http.RequestParams", "put", Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            }),
            Arrays.asList("org.apache.http.client.HttpClient", "execute", Arrays.asList(0), new Object[]{
                    org.apache.http.client.methods.HttpUriRequest.class
            }),
            Arrays.asList("com.loopj.android.http.RequestParams", "add", Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            }),
            Arrays.asList("org.apache.http.message.BasicHeader", null, Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            }),
            Arrays.asList("com.squareup.okhttp.Request$Builder", "url", Arrays.asList(0), new Object[]{
                    java.lang.String.class
            }),
            Arrays.asList("com.squareup.okhttp.Request$Builder", "addHeader", Arrays.asList(0, 1), new Object[]{
                    java.lang.String.class,
                    java.lang.String.class
            })
    );


}
