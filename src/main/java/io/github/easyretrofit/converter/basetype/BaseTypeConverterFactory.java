package io.github.easyretrofit.converter.basetype;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class BaseTypeConverterFactory extends Converter.Factory {

    public static BaseTypeConverterFactory create() {
        return new BaseTypeConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (String.class.getTypeName().equals(type.getTypeName())) {
            return new StringResponseConverter();
        } else if (Short.class.getTypeName().equals(type.getTypeName())) {
            return new ShortResponseConverter();
        } else if (Integer.class.getTypeName().equals(type.getTypeName())) {
            return new IntegerResponseConverter();
        } else if (Long.class.getTypeName().equals(type.getTypeName())) {
            return new LongResponseConverter();
        } else if (Boolean.class.getTypeName().equals(type.getTypeName())) {
            return new BooleanResponseConverter();
        } else if (Float.class.getTypeName().equals(type.getTypeName())) {
            return new FloatResponseConverter();
        } else if (Double.class.getTypeName().equals(type.getTypeName())) {
            return new DoubleResponseConverter();
        } else {
            return null;
        }
    }

    private static final class StringResponseConverter implements Converter<ResponseBody, String> {

        @Override
        public String convert(ResponseBody value) throws IOException {
            return value.string();
        }
    }

    private static final class ShortResponseConverter implements Converter<ResponseBody, Short> {
        @Override
        public Short convert(ResponseBody value) throws IOException {
            return Short.valueOf(value.string());
        }
    }

    private static class IntegerResponseConverter implements Converter<ResponseBody, Integer> {

        @Override
        public Integer convert(ResponseBody value) throws IOException {
            return Integer.valueOf(value.string());
        }
    }

    private static class LongResponseConverter implements Converter<ResponseBody, Long> {
        @Override
        public Long convert(ResponseBody value) throws IOException {
            return Long.valueOf(value.string());
        }
    }

    private static class BooleanResponseConverter implements Converter<ResponseBody, Boolean> {
        @Override
        public Boolean convert(ResponseBody value) throws IOException {
            return Boolean.valueOf(value.string());
        }
    }

    private static class FloatResponseConverter implements Converter<ResponseBody, Float> {
        @Override
        public Float convert(ResponseBody value) throws IOException {
            return Float.valueOf(value.string());
        }
    }

    private static class DoubleResponseConverter implements Converter<ResponseBody, Double> {
        @Override
        public Double convert(ResponseBody value) throws IOException {
            return Double.valueOf(value.string());
        }
    }
}
