import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length > 1) {

			String filePath = args[0];
			TreeSet<String> tag  = new TreeSet<String>();
			TreeSet<String> type = new TreeSet<String>();
			TreeSet<String> pid  = new TreeSet<String>();
			TreeSet<String> gid  = new TreeSet<String>();

			for (int i = 1; i < args.length;) {

				String arg = args[i];
				if (arg.equalsIgnoreCase("-t")) {
					tag.add(args[i+1].trim());
				} else if (arg.equalsIgnoreCase("-i")) {
					type.add(args[i+1].toLowerCase().trim());
				} else if (arg.equalsIgnoreCase("-p")) {
					pid.add(args[i+1].toLowerCase().trim());
				} else if (arg.equalsIgnoreCase("-g")) {
					gid.add(args[i+1].toLowerCase().trim());
				}

				i += 2;
			}
			
		
			try {
				process(filePath, tag, pid, gid, type);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			

		} else {
			System.out.println("Usage:\r\nLogcatFilter	log_file_path args" +
					"\r\n -t		tag for log" +
					"\r\n -i		type for log" +
					"\r\n -p		pid for log" +
					"\r\n -g		tid for log");
		}
		
	}
	
	public static void process(String path,TreeSet<String> tag,TreeSet<String> pid,TreeSet<String> gid,TreeSet<String> type)throws Exception {
		
		InputStreamReader sReader = new InputStreamReader(new FileInputStream(path),"UTF-8");
		BufferedReader bR = new BufferedReader(sReader);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+".filter.log")));
		
		String sLine = null;
		while ((sLine=bR.readLine())!=null) {

			Log log = Log.parse(sLine);

			if(log==null)
				continue;

			if(!tag.isEmpty()&&!tag.contains(log.getTag()))
				continue;

			if(!pid.isEmpty()&&!pid.contains(log.getPid().toLowerCase()))
				continue;

			if(!gid.isEmpty()&&!pid.contains(log.getGid().toLowerCase()))
				continue;
			
			if(!type.isEmpty()&&!pid.contains(log.getType().toLowerCase()))
				continue;
			
			bw.write(sLine);
			bw.newLine();
		}
		
		bw.flush();
		
		bR.close();
		bw.close();
	}

}
