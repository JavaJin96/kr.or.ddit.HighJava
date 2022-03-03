package QuartzPackage;

import java.util.Date;
import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest001 {

	public static void main(String[] args) throws SchedulerException {
		JobDetail jobdetail = (JobDetail) JobBuilder
				.newJob(JobTest01.class).build();
		
		
		SimpleTrigger trigger1 = (SimpleTrigger) TriggerBuilder.newTrigger()
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(5, 10))
				.build();
		
		//Trigger trigger1 = (SimpleTrigger) TriggerBuilder.newTrigger().withSchedule(cronSchedule("0/5 * * * * ?"));
		
		//CronTrigger trigger1 = new CronTrigger("trigger2", "group2", "20 * * * * ?"); 
			

	
		/*SimpleTrigger trigger1 = (SimpleTrigger) TriggerBuilder.newTrigger()
				.withSchedule(CronScheduleBuilder.cronSchedule("5 * * * * ?"))
				.build();
		*/
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobdetail, trigger1);
			

	}



}
