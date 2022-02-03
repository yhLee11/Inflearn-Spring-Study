package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    //자바뜰 때 올라감
    private static final SingletonService instance = new SingletonService();//클래스 레벨에 올라가기 때문에 하나만 존재
    //항상 같은 하나의 인스턴스만 반환
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
//    @Test
//    @DisplayName()
}
