package QuartzPackage;
import static org.quartz.CronScheduleBuilder.cronSchedule;
//import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
public class dddd {
    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            
            JobDetail job = JobBuilder.newJob(jobt.class)
                .withIdentity("jobName", Scheduler.DEFAULT_GROUP)
                .build();
            
            Trigger trigger = newTrigger()
            	.withIdentity("trggerName", Scheduler.DEFAULT_GROUP)
                .withSchedule(cronSchedule("2 * * * * ?"))
                .build();
                        
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch(Exception e) {
            e.printStackTrace();
        }        
    }
}