package ru.kptc.server.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kptc.server.mock.pojo.Data;
import ru.kptc.server.mock.service.MockService;

@RestController
@RequestMapping
public class MockController {
    @Autowired
    MockService mockService;
    @PostMapping("/request")
    public Data addRecieptTime(@RequestBody Data body) {
        return mockService.AddRecieptTime(body);
    }
}
