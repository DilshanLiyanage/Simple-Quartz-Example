import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleTask implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		System.out.println("This is simple Job (task)");
	}

}
