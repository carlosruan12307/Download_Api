package com.example.demo.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.criteria.Path;




@RestController
@CrossOrigin(origins = "*")
public class testeController {
    private final java.nio.file.Path root = Paths.get("C:/Users/Ruan/Desktop/vscodeProjects/demo/src/main/java/com/example/demo/upload");
    @GetMapping(value = "/")
    public ResponseEntity<Map<String, String>> inicio() throws IOException{
        //utilizando pasta personalizada para servir 
   
        
       File[] files = new File("C:/Users/Ruan/Desktop/vscodeProjects/demo/src/main/java/com/example/demo/tek").listFiles();
       Map<String, String> imagensmap = new HashMap<>();
       for (int i = 0;i < files.length;i++) {
        if (files[i].isFile()) {
            InputStream targetStream = new FileInputStream(files[i]);
            byte[] bytes = IOUtils.toByteArray(targetStream);
            String base64 = Base64.encodeBase64String(bytes);
            imagensmap.put(String.valueOf(i), base64);

            
        }
    }
 
     
    
       return ResponseEntity.ok().body(imagensmap);
    }    

   
}
