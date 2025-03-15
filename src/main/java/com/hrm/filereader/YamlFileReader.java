package com.hrm.filereader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.LoaderOptions;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YamlFileReader implements FileReader{

    private final ObjectMapper objectMapper;

    public YamlFileReader() {
        LoaderOptions loaderOptions = new LoaderOptions();
        loaderOptions.setCodePointLimit(10* 1024 * 1024);
        YAMLFactory yamlFactory = YAMLFactory.builder()
                .loaderOptions(loaderOptions)
                .build();
        objectMapper = new ObjectMapper(yamlFactory);
        objectMapper.coercionConfigDefaults()
                .setCoercion(CoercionInputShape.EmptyString, CoercionAction.AsEmpty);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    }

    @Override
    public <T> T read(File data, Class<?> responseClass) {
        T result = null;
        try {
            result = (T) objectMapper.readValue(data, responseClass);
        } catch (IOException ex) {
            System.out.println("Failed to read data from the file. Exception: " + ex);
        }
        return result;
    }

    @Override
    public <T> T read(String data, Class<?> responseClass) {
        T result = null;
        try {
            result = (T) objectMapper.readValue(data, responseClass);
        } catch (IOException ex) {
            System.out.println("Failed to read data . Exception: " + ex);
        }
        return result;
    }

    @Override
    public <T> T readList(File data, Class<?> reponseClass) {
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(List.class, reponseClass);
        T result = null;
        try {
            result = objectMapper.readValue(data, collectionType);
        } catch (IOException ex) {
            System.out.println("Unable to parse the file " + data.getName() + " and excpetion is: " + ex);
        }
        return  result;
    }
}
