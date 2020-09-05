package pl.wlodarski.etserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("sse-server")
public class ServerController {

    final EyetrackerSseService sseService;

    public ServerController(EyetrackerSseService sseService) {
        this.sseService = sseService;
    }

    @GetMapping(value = "/stream-sse", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<ServerSentEvent<Map<String, EyetrackerMsg>>> streamEvents() {
        return Flux.interval(Duration.ofMillis(35))
                .map(sequence -> sseService.getMapAsSse());

    }

    @PostMapping("upload/{id}")
    public void uploadData(@RequestBody EyetrackerMsg eyetrackerMsg, @RequestParam String id) {
        log.info("Server has received data from client: " + id);
        sseService.updateEyetrackerMap(id, eyetrackerMsg);

    }
}
