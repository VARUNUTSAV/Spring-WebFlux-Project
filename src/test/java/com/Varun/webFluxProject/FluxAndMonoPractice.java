package com.Varun.webFluxProject;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoPractice {

    @Test
    public void fluxTest(){
        Flux<String> flux_demo = Flux.just("Spring", "Spring Boot", "Reactive Spring")
//                .concatWith(Flux.error(new RuntimeException("Error Occured!!")))
                .log();

        flux_demo
                .subscribe(System.out::println,
                        (e) -> System.err.println("Exception is " + e),
                        () -> System.out.println("Event Completed"));
    }
}
