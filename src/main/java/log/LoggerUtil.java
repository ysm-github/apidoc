package log;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggerUtil {
	/**
	 * 自定日子文件名称
	 * 
	 * @param name
	 * @return
	 */
	public static Logger getLoggerByName(String name) {
		// 生成新的Logger
		// 如果已經有了一個Logger實例返回現有的
		Logger logger = Logger.getLogger(name);
		// 清空Appender。特別是不想使用現存實例時一定要初期化
		logger.removeAllAppenders();
		// 設定Logger級別。
		logger.setLevel(Level.INFO);
		logger.setAdditivity(false);
		// 生成新的Appender
		MyRollingFileAppender appender = new MyRollingFileAppender();
		PatternLayout layout = new PatternLayout();
		// log的输出形式
		String conversionPattern = "%d[%-5p](%c:%L) - %m%n";
		layout.setConversionPattern(conversionPattern);
		appender.setLayout(layout);
		// log输出路径
		appender.setMaxFileSize("5MB");
		appender.setMaxBackupIndex(200);
		appender.setFile("./logs/" + name + ".log");
		//		appender.setFile(name+".log");
		// log的文字码
		appender.setEncoding("UTF-8");
		appender.setMaxBackupIndex(65535);
		// true:在已存在log文件后面追加 false:新log覆盖以前的log
		appender.setAppend(true);
		// 适用当前配置
		appender.activateOptions();
		// 将新的Appender加到Logger中
		logger.addAppender(appender);
		return logger;
	}

}
