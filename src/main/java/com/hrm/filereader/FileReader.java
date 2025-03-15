package com.hrm.filereader;

import java.io.File;

public interface FileReader {
    <T>   T read(File data, Class<?> responseClass);
    <T>   T read(String data, Class<?> responseClass);
    <T>   T readList(File data, Class<?> reponseClass);
}
