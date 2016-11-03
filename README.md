# LogcatFilter

Tools for android java log fitter by tag,type,process and thread.

Usage

java -jar /your_path/your_jar_name.apk log_file_path -t tag,-i type,-p process id,-g thread id

you can also mutil fitor a args or more args eg: java -jar locat.jar -p 1102 -p 1102 ....

also can java -jar locat.jar -t MyTag -p 1102

output a fitter log text same your log file path, and the name is your log file name add ".fittrt.log" in the last.
