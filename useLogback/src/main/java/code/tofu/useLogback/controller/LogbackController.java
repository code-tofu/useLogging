package code.tofu.useLogback.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@Slf4j
public class LogbackController {

    @GetMapping("/log-info")
    public String logInfo(@RequestParam String param) {
        return n();
    }

    @GetMapping("/log-warn")
    public String logWarn(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/log-error")
    public String logError(@RequestParam String param) {
        return new String();
    }
        
    @GetMapping("/log-exception")
    public String logException(@RequestParam String param) {
        return new String();
    }



}
