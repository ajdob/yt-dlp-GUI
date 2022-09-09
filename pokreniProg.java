package guiVjezba;

import java.io.File;

public class pokreniProg extends Thread {

	private String url = "";
	private String path = "";
	private String format = "";
	private String working = "";

	public pokreniProg(String working, String url, String path, String format) {

		setWorking(working);
		setUrl(url);
		setPath(path);
		setFormat(format);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getWorking() {
		return working;
	}

	public void setWorking(String working) {
		this.working = working;
	}

	@Override
	public void run() {

		Runtime rt = Runtime.getRuntime();
		File f = new File(getWorking());

		String[] command = { "cmd.exe", "/c", "start", "cmd.exe", "/k", "\" cd \"" + f.getAbsolutePath()
				+ "\\app\" && yt-dlp.exe -P " + getPath() + " -f " + getFormat() + " " + getUrl() + " && exit\"" };

		try {
			rt.exec(command);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
