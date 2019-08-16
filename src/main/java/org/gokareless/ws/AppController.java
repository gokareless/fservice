package org.gokareless.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/release")
    Release release() {
        return new Release("@fservice",  "1.0");
    }
    @RequestMapping("/dependency-release")
    Release dependencyRelease() {
        Release release = restTemplate.getForObject("http://sservice/release", Release.class);
        return release;
    }

    static class Release {
        String name;
        String version;
        public Release(){};
        public Release(String name, String version) {
            this.name = name;
            this.version = version;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
