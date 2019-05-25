import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

	public static void main(String[] args) throws SchedulerException{

		//Add Job class to JobDetails
		JobDetail job = JobBuilder.newJob(SimpleTask.class).build();
		
		//Create a simple Trigger to schedule a job 
		//Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Simple Trigger").startNow().build();
		
		//This Cron Trigger Schedule to run for every 1 minute continuously 
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Cron Trigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		
		//Create a Scheduler to run above Trigger 
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		//Start a scheduler
		scheduler.start();
		
		//Assign Job and Trigger to Scheduler 
		scheduler.scheduleJob(job, trigger);
		

	}

}
