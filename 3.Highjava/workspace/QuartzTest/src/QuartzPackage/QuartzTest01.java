/*package QuartzPackage;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

public class QuartzTest01 implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello World! - " + new Date());
    }
}

 class SimpleExample {
  public static void main(String[] args) throws Exception {
	  SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
	  Scheduler sched = schedFact.getScheduler();	//Scheduler를 가져 옴
	  sched.start();								//Scheduler 시작

	  JobDetail job = (JobDetail) newJob(QuartzTest01.class);		//HelloJob.class지정한 Job을
			  
			  
	      job.withIdentity("myJob", "group1")				//이름과 그룹이름 지정
	      .build();										//Job만듬

	  Trigger trigger = new Trigger()				//새로운 Trigger
	      .withIdentity("myTrigger", "group1")			//이름과 그룹이름 지정
	      .startNow()									//start함
	      .withSchedule(simpleSchedule()				//스케줄 지정 
	          .withIntervalInSeconds(5)						//5초마다
	          .repeatForever())								//계속 반복함
	      .build();										//트리거 만듬

	  sched.scheduleJob(job, trigger);	//Scheduler에 job을 trigger에 따라 실행하도록 추가 함  
	  try {
        Thread.sleep(65L * 1000L); 		//65초 동안 Scheduler가 실행되도록 시간을 줌
      } catch (Exception e) {}
  }
  
}*/
