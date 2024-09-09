package io.github.easyretrofit.converter.basetype;

import io.github.easyretrofit.adapter.simplebody.SimpleBodyCallAdapterFactory;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import io.github.easyretrofit.converter.basetype.MyService.MyServiceApi;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class BaseTypeConverterFactoryTest {
    @Rule
    public final MockWebServer server = new MockWebServer();
    private MyService myService;
    private MyServiceApi myServiceApi;
    Retrofit retrofit;

    @Before
    public void setUp() {
        myService = new MyService();

        retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(BaseTypeConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(SimpleBodyCallAdapterFactory.create())
                .build();
        myServiceApi = retrofit.create(MyServiceApi.class);
    }

    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    public void testStringResponse() {
        server.enqueue(new MockResponse().setBody("hello"));
        String s = myServiceApi.stringResponse();
        assert "hello".equals(s);
    }

    @Test
    public void testBooleanResponse() {
        server.enqueue(new MockResponse().setBody("true"));
        boolean b = myServiceApi.booleanResponse();
        assert b;
    }

    @Test
    public void testShortResponse() {
        server.enqueue(new MockResponse().setBody("1"));
        short s = myServiceApi.shortResponse();
        assert s == 1;
    }

    @Test
    public void testIntResponse() {
        server.enqueue(new MockResponse().setBody("1"));
        int i = myServiceApi.intResponse();
        assert i == 1;
    }

    @Test
    public void testLongResponse() {
        server.enqueue(new MockResponse().setBody("1"));
        long l = myServiceApi.longResponse();
        assert l == 1;
    }

    @Test
    public void testFloatResponse() {
        server.enqueue(new MockResponse().setBody("1"));
        float f = myServiceApi.floatResponse();
        assert f == 1;
    }

    @Test
    public void testDoubleResponse() {
        server.enqueue(new MockResponse().setBody("1"));
        double d = myServiceApi.doubleResponse();
        assert d == 1;
    }

    @Test
    public void testVoidResponse() {
        server.enqueue(new MockResponse());
        Void unused = myServiceApi.voidResponse();
    }
}
