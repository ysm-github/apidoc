package log;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.CountingQuietWriter;

/**
 * copy from source
 */
public class MyRollingFileAppender extends RollingFileAppender {

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/");

	public void setDateFormat(DateFormat dateFormat) {
		System.out.println("~~~~~~~~~~~~~setDateFormat");
		if (dateFormat == null) {
			throw new NullPointerException();
		}
		this.dateFormat = dateFormat;
	}

	@Override
	public synchronized void setFile(String fileName, boolean append,
			boolean bufferedIO, int bufferSize) throws IOException {
		System.out.println("~~~~~~~~~~~~~setFile");
		int index = fileName.lastIndexOf('/');
		String fname = "./logs/" + dateFormat.format(new Date());
		File dir = new File(fname);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		fname += fileName.substring(index + 1);
		super.setFile(fname, append, this.bufferedIO, this.bufferSize);
		if (append) {
			File f = new File(fname);
			((CountingQuietWriter) qw).setCount(f.length());
		}
	}

}
