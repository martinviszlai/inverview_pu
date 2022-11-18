package com.infobip.interviewdemo.service;

import com.infobip.interviewdemo.domain.AnalyticsData;
import com.infobip.interviewdemo.repository.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class AnalyticsService {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    /**
     * This is simplification of some analytics collector.
     *
     * For sake of this exercise, let's say that we need to save a data into our DB and also to external service,
     * but we have to ensure that the id stored in external service is valid id in our DB. We must ensure
     * that there will be no entry on external source that is not stored in our DB. If we store data in our DB
     * and storing to external service fails, let's say we have some backup solution for such scenario,
     * so we don't cover that.
     */
    public void recordCreateAction(String author){
        var analyticsData = new AnalyticsData();
        analyticsData.setAction("Comment created!");
        analyticsData.setAuthor(author);
        analyticsData.setTimestamp(Instant.now());

        analyticsRepository.save(analyticsData);

        sendToExternalStorage(analyticsData);
    }

    private void sendToExternalStorage(AnalyticsData analyticsData){
        // let's pretend that here is a call to external service, that requires our stored id
        System.out.println("Sending data to external source, id: "+ analyticsData.getId());
    }
}
