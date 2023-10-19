package com.marcoscl.scheduledlock;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RoutineScheduler {

    @Scheduled(fixedRateString = "15", timeUnit = TimeUnit.SECONDS)
    @SchedulerLock(name = "RoutineScheduler.scheduledTask", lockAtLeastFor = "PT15S", lockAtMostFor = "PT30S")
    public void scheduledTask() {
        System.out.println("Scheduler open: " + LocalDateTime.now());
    }
}
