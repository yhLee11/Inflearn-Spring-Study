package hello0703.core.beanfind;

import hello0703.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Print All Bean")
    public void findAllBean() throws Exception{
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = "+beanDefinitionName+" object = "+bean);
        }
    }

    @Test
    @DisplayName("Print Application Bean")
    public void findApplicationBean() throws Exception{
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){//내가 애플리케이션을 위해서 제작한 빈
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = "+beanDefinitionName+" object = "+bean);
            }
        }
    }
}
