package org.code.janitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application {
//	  @Autowired
//		JobLauncher jobLauncher;
//
//		@Autowired
//		Job job;
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  /**The pattern is a list of six single space-separated fields: 
	  * representing second, minute, hour, day, month, weekday. 
	  * Month and weekday names can be given as the first three letters of the English names.
	  * Example patterns:

	     "0 0 * * * *" = the top of every hour of every day.*
	     "*\/10 * * * * *" = every ten seconds. Remove 2nd character, it is escape
	     "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
	     "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
	     "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
	     "0 0 0 25 12 ?" = every Christmas Day at midnight

	  */

//	@Scheduled(cron = "*/10 * * * * *")
//	public void perform() throws Exception {
//		JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
//				.toJobParameters();
//		jobLauncher.run(job, params);
//	}
}
