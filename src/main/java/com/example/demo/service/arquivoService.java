package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.example.demo.config.arquivoStorageProperties;
import com.example.demo.exception.uploadArquivoException;

@Service
public class arquivoService {

    private final Path fileStorageLocation;

    public arquivoService(arquivoStorageProperties fileStorageProperties) {
            this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
            
                try {
                    Files.createDirectories(this.fileStorageLocation);
                } catch (IOException e) {
                    throw new uploadArquivoException("Algo deu errado ao tentar criar a pasta", e);
                }
        }
}
