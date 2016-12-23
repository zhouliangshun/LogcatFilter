
public class Log {

	private String date;
	private String time;
	private String tid;
	private String pid;
	private String type;
	private String tag;
	private String content;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGid() {
		return tid;
	}
	public void setGid(String gid) {
		this.tid = gid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Parse log from logcat string
	 * @param line
	 * @return
	 */
	public static Log parse(String line) {
		
		if(line.startsWith("* ")||line.startsWith("---------"))
			return null;
		
		String[] strings = line.split(" +");
		if(strings.length<5)
			return null;

		Log log = new Log();
		
		int i = 0;
		log.date = strings[i++];
		log.time = strings[i++];
		log.pid  = strings[i++];
		log.tid  = strings[i++];
		log.type = strings[i++];


//		System.out.println("tag:"+strings[i]);
		log.tag = strings[i].trim().replace(":","");
		log.content = line.substring(line.indexOf(strings[i])+strings[i].length());
		
		return log;
		
	}
	
}
