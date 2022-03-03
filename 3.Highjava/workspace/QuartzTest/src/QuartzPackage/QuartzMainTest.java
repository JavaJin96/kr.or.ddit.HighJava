package QuartzPackage;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import java.util.ArrayList;
import java.util.List;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMainTest {
	public static void main(String[] args) throws SchedulerException, InterruptedException {
					// TODO Auto-generated method stub
		
		
		//JobDataMap은 Quartz에서 실행되는 Job에 Key-value 형식으로 값을 전달할수 있다.
			JobDataMap jobDataMap = new JobDataMap();
			jobDataMap.put("jobName", "HELLO");
			JobDetail jobDetail = newJob(JobTest.class)
					
		//job Data 주입
						.usingJobData(jobDataMap)
						.build();
			Trigger trigger = newTrigger().build();
		// 스케줄러 실행 및 JobDetail과 Trigger 정보로 스케줄링
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);
	}
}

