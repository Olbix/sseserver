package pl.wlodarski.etserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class EyetrackerSseService {
    Map<String, EyetrackerMsg> hashMap = new ConcurrentHashMap<>();


    public EyetrackerSseService() {
        hashMap.put("asd", EyetrackerMsg.builder().x(321.3).y(32.3).build());
    }

    public ServerSentEvent<Map<String, EyetrackerMsg>> getMapAsSse() {
        log.info("Data hase been sent do client");
        return ServerSentEvent.<Map<String, EyetrackerMsg>>builder()
                .event("periodic-eyetracker-send-event")
                .data(hashMap)
                .build();
    }

    public void updateEyetrackerMap(String id, EyetrackerMsg eyetrackerMsg) {
        hashMap.put(id, eyetrackerMsg);
    }
}
