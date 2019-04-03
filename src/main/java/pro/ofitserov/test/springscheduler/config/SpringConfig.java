package pro.ofitserov.test.springscheduler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class SpringConfig {

    /**
     * Schedule a Task at Fixed Delay
     * The fixedDelay property makes sure that there is a delay of n millisecond between the finish time of an execution of a task and the start time of the next execution of the task.
     */
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {

        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    /**
     * Schedule a Task at a Fixed Rate
     * The fixedRate property runs the scheduled task at every n millisecond. It doesn’t check for any previous executions of the task.
     */
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    /**
     * Schedule a Task with Initial Delay
     */
    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "Fixed rate task with one second initial delay - " + now);
    }

    /**
     * Schedule a Task using Cron Expressions
     * Command
     * Seconds Minutes Hours Day of mount Mount Day of week Year
     * * — выбирает все величины. То есть на месте позиции часа символ * означает, что задание будет выполняться каждый час;
     * ? — незначащая величина;
     * , — отделяет дополнительные величины. Например, триггер “0 0 11,12 * *  ?” будет срабатывать в 11 и 12 часов;
     * / — определяет инкремент величины. Например, “0 0 0/2 * *  ?” означает, что триггер будет срабатывать каждые 2 часа.
     */
    @Scheduled(cron = "0 1 4 * * ?")
    public void scheduleTaskUsingCronExpression() {

        System.out.println("I am a schedule-method with cron param.");
        System.out.println("Executes at 4:01 am everyday.");
        System.out.println(new Date());
    }
}

