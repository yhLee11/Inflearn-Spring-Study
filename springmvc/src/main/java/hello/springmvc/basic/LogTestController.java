package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //LEVEL: TRACE > DEBUG > INFO > WARN > ERROR
        //개발 서버는 debug, 운영 서버는 info
        //log.trace("trace log={}"+name); -> trace 츌력안할 때 불필요한 연산으로 리소스 낭비, 비권장
        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info("info log={}", name);
        log.warn("warn log={}",name);
        log.error("error log={}", name);
        
        return "OK";
    }
}
