package hello0703.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLiftCycleTest {
    @Test
    public void lifeCycleTest(){
        //ConfigurableApplicationContext가 AnnotationConfigAC의 상위 인터페이스이기 때문에 가능, 부모는 자식을 담을 수 있다.
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycle.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }
    @Configuration
    static class LifeCycle{
//        @Bean(initMethod = "init",destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
