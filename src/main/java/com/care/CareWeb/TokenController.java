package com.care.CareWeb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class TokenController {
    private final AtomicLong counter = new AtomicLong();

    public static void main(String[] args) {
	SpringApplication.run(TokenController.class, args);
    }
    
    @GetMapping("/token")
    public Token token() {
        return new Token(counter.incrementAndGet());
    }
}
