package code.tofu.useLogback.controller;

import code.tofu.useLogback.service.NormalLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@Slf4j
public class LogbackController {

    @Autowired
    NormalLogService normalLogService;

    @GetMapping("/log-info")
    public String logInfo(@RequestParam String param) {
        log.info(param);
        return new String(param);
    }

    @GetMapping("/log-warn")
    public String logWarn(@RequestParam String param) {
        log.warn(param);
        return new String(param);
    }

    @GetMapping("/log-error")
    public String logError(@RequestParam String param) {
        log.error(param);
        return new String(param);
    }

    @GetMapping("/log-level")
    public String logError() {
        normalLogService.logLevelTest();
        return new String("Completed");
    }

    //Note - modifed xml must be in target/classes for configuration scan to pick up
    @GetMapping("/log-repeat")
    public String logRepeat() {
        try{
            int i = 0;
            while(i<6){
                i++;
                log.info("log id {}",i);
                Thread.sleep(5000);
            }
        } catch (InterruptedException err){
            log.error("Thread Interrupted",err);
        }
        log.info("Completed");
        return new String();
    }
        
    @GetMapping("/log-exception")
    public String logException(@RequestParam String param) {
        try{
            throw new Exception("Exception Thrown");
        } catch (Exception err){
            log.error("Exception Thrown",err);
        }
        return new String(param);
    }



}
