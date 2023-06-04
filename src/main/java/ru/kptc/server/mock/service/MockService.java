package ru.kptc.server.mock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kptc.server.mock.model.Request;
import ru.kptc.server.mock.pojo.Data;
import ru.kptc.server.mock.repository.RequestRepo;

import java.util.Date;
import java.sql.Time;

@Service
public class MockService {
    @Autowired
    RequestRepo requestRepo;
    private static final Logger logger = LoggerFactory.getLogger(MockService.class);

    public Data AddRecieptTime(Data body) {
        Request request = new Request();
        Request gotRequest = requestRepo.findById(body.getId());

        Date dateNow = new Date();
        try {
            request.setId(body.getId());
            request.setReceiptTime(new Time(dateNow.getTime()));
            requestRepo.save(request);
            logger.info("Запрос {} обработан успешно", body);
        } catch (NullPointerException e){
            logger.info("Записи с id {} не существует", body.getId());
        }
        return body;
    }
}
