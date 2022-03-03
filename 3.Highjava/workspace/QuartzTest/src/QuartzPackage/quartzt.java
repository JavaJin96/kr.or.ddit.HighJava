package QuartzPackage;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.newJob;

public class quartzt {
	private SchedulerFactory schedFact;
	private Scheduler sched;
	
	
	public quartzt() throws SchedulerException {
		// 스케쥴 생성후 시작
		schedFact = new StdSchedulerFactory();
		sched = schedFact.getScheduler();
		sched.start();
		
		JobDetail jobDetail = (JobDetail) newJob(jobt.class);
		
	}



}
