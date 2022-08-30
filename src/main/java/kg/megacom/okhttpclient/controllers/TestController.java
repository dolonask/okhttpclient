package kg.megacom.okhttpclient.controllers;

import kg.megacom.okhttpclient.services.OkHttpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final OkHttpService okHttpService;

    public TestController(OkHttpService okHttpService) {
        this.okHttpService = okHttpService;
    }

    @GetMapping("/test")
    public Object test(){
        return okHttpService.test();
    }
}
