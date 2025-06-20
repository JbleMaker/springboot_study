package com.korit.authstudy.init;

import com.korit.authstudy.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@RequiredArgsConstructor
class OptionalStudy <T>{
    private final T present;

    public void ifPresentOrElse(Consumer<T> action, Runnable runnable) {
        if(present != null){
            action.accept(present);
        } else {
            runnable.run();
        }
    }
}

@Component
public class Lambda implements CommandLineRunner {
    // lambda consumer

    @Override
    public void run(String... args) throws Exception {
        // 초기셋팅을 위해서 사용
        //스프링부트 실행시 단 한번 실행
        User user = User.builder()
                .id(100)
                .username("jasdf")
                .password("123123")
                .build();
        OptionalStudy<User> optionalStudy = new OptionalStudy<>(user);
        
        Consumer<User> consumer = new Consumer<User> () {
            @Override
            public void accept(User user) {
//                System.out.println("user객체 찾음: " + user);
            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                System.out.println("user객체를 못찾아서 여기서 다른 작업 진행");
            }
        };
        optionalStudy.ifPresentOrElse(consumer, runnable);
        Consumer<User> consumerLambda = (u) -> System.out.println("user객체 찾음: " + u);
        Runnable runnableLamdba = () -> System.out.println("user 객체를 찾지 못해 다음 작업 진행");
        optionalStudy.ifPresentOrElse(
                (u) -> System.out.println("user객체 찾음: " + u),
                () -> System.out.println("user 객체를 찾지 못해 다음 작업 진행"));
    }
}
