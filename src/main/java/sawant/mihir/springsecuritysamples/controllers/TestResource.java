package sawant.mihir.springsecuritysamples.controllers;

import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;


@Controller
public class TestResource {


   @ResponseBody
   @GetMapping("/")
    public ResponseEntity<Map<String, String>> simpleEndpoint(){
        return ResponseEntity.ok(Map.of("Hello World", getTodaysDate()));
    }

    private static String getTodaysDate() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

}
