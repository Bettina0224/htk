package com.example._3beadando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    String sorrendModositas(String valtozo) {
        char[] szo = valtozo.toCharArray();
        int begin = 0;
        int end = valtozo.length()-1;
        char kimenet;
        while (end>begin)
        {
            kimenet = szo[begin];
            szo[begin] = szo[end];
            szo[end] = kimenet;
            end--;
            begin++;
        }
        return new String(szo);
    }

    @GetMapping("/")
    public String sayHello(@RequestParam(value = "name", defaultValue = "Felhasználó") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/")
    public String sayHelloPost(@RequestParam(value = "name", defaultValue = "Alma a fa alatt") String name) {
        return String.format(sorrendModositas(name));
    }
}
