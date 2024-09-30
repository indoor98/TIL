package com.asynctest.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ThreadPoolApi {
    @GetMapping("/")
    public ResponseEntity<String> api() {
        try {
            Thread.sleep(5000);
            log.info("http call");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
