package io.github.easyretrofit.converter.basetype;

import retrofit2.http.GET;

import java.util.List;

public class MyService {

    public interface MyServiceApi {

        @GET("/void")
        Void voidResponse();

        @GET("/string")
        String stringResponse();

        @GET("/long")
        Integer intResponse();

        @GET("/boolean")
        Boolean booleanResponse();

        @GET("/short")
        Short shortResponse();

        @GET("/long")
        Long longResponse();

        @GET("/float")
        Float floatResponse();

        @GET("/double")
        Double doubleResponse();


    }
}
