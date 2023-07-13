package com.java.employee;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@SpringBootApplication
public class Employee {

    // Connect to firebase
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Employee.class.getClassLoader();

        InputStream serviceAccount = classLoader.getResourceAsStream("serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        SpringApplication.run(Employee.class, args);
    }
}
