package kr.co.ensecure.piias.util;

import org.springframework.scheduling.annotation.Scheduled;

public class LogDownloadScheduler {
//	private static final Logger logger = LoggerFactory.getLogger(LogDownloadScheduler.class);
	
	@Scheduled(cron="0 * * * * *")
	public void logFileDownloadShceduler() {
		
	}

}
