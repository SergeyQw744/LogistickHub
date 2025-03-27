package org.example.service;

import org.example.entity.Cargo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface CargoService {

    void saveBatch(MultipartFile file) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    Cargo save(Cargo cargo);

    Cargo findById(Long id);

    void delete(Long id);
}
