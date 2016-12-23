# LogcatFilter

**Tools for android java log fitter by tag,type,process and thread.**

**Usage:**

* Java -jar /your_path/your_jar_name.apk log_file_path -t tag,-i type,-p process id,-g thread id

#1.You can also multi-filter a args or more args eg: java -jar logcat.jar -p 1102 -p 1102 ....

#2.Also can java -jar logcat.jar -t MyTag -p 1102

#3.Output a fitter log text same your log file path, and the name is your log file name add ".filter.log" in the last.

