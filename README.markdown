SimpleLog
==========

_"A easy Logger"_


What is the goal?
-----------------

SimpleLog is a package that aimed at making easier the log in the application.

This package was very inspirated in Log4J, but without any complicated configuration. Just plug in play!


What does it do?
----------------

SimpleLog is able to log the INSTANCES, since classes (as Log4j). 

This characteristic gives the possibility to log a same class, which is used in distinct business modules, in different log files (separated by module, as example). 



How can I use it?
-----------------

**Instancing**

Is very simple begin to log a instance, just do it into the class:

	Log log = new DefaultLog();

The below command will be create a new DefaultLog instance, using the default configurations (Simple Log in console).

Case you want change the default configurations, set them using the DefaultLogConfig.setDefaultLogConfig() method.
Eg: To log on console, using date in INFO level (it's the original configurations) 
	DefaultLogConfig.setDefaultLogConfig(LogLevel.INFO, new ConsoleAppender(new DateLayout()))

Another way to instance a log is proving the config to DefaultLog constructon.
Eg: 
	LogConfig logConf = new DefaultLogConfig(LogLevel.WARNING, new RollingFileAppender(new DefaultLayout()));
	final Log log = new DefaultLog(logConf);

**Layouts**

Actually exists three Layouts:
-_DateLayout_: Simple layout, using only the date and log information
	Eg: [2010-05-27 22:08:57.359] INFO   : a logged message...
	 
-_DefaultLayout_: A useful log informations
	Eg: 2010-05-27 22:12:15 [INFO   ] [main                               ] a logged message...
	
-_FullLayout_: The more detailed (and slow) layout. Useful in special cases.
	Eg: 2010-05-27 22:14:44.406 [INFO   ] [main                               ] barenko.util.log.LogTest.testAllLogDateLayout (LogTest.java:32)
                                  a logged message...

**Appenders**

Actually exists two Layouts:
-_ConsoleAppender_: Log show in Java Console
-_RollingFileAppender_: Log show into a file, rolling file using the configurations setted by FileAppenderConfig.

Show the jUnit tests to more user samples.	