package pl.wlodarski.etserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalTime;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class SseserverApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SseserverApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }



}
