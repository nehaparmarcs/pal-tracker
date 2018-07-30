package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    @Value("${PORT:NOT SET}")
    String port;

    private String memoryLimit, cfInstanceAddr, cfInstanceIndex;

    public EnvController(@Value("$PORT")String port,
                         @Value("$MEMORY_LIMIT")String memoryLimit,
                         @Value("$CF_INSTANCE_INDEX")String cfInstanceIndex,
                         @Value("$CF_INSTANCE_ADDR")String cfInstanceAddr){

            this.cfInstanceAddr = cfInstanceAddr;
            this.cfInstanceIndex = cfInstanceIndex;
            this.port = port;
            this.memoryLimit = memoryLimit;

    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> map = new HashMap<>();
        map.put("PORT", port);
        map.put("MEMORY_LIMIT", memoryLimit);
        map.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        map.put("CF_INSTANCE_ADDR", cfInstanceAddr);
        return map;
    }
}
