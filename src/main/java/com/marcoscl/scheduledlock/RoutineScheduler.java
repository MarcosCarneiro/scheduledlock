package com.marcoscl.scheduledlock;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RoutineScheduler {

    @Scheduled(fixedRateString = "5", timeUnit = TimeUnit.MINUTES)
    @SchedulerLock(name = "RoutineScheduler.scheduledTask", lockAtLeastFor = "PT5M", lockAtMostFor = "PT10M")
    public void scheduledTask() {
        System.out.println("Scheduler open: " + LocalDateTime.now());
    }
}
