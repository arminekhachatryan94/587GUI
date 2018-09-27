/*
Commands to run

Linux:
javac -cp .:./lib/* Student.java
java  -cp .:./lib/* -Dlog4j.configurationFile=./log4j.xml Student

Windows:
javac -cp .;.\lib\* Student.java
java  -cp .;.\lib\* -Dlog4j.configurationFile=.\log4j.xml Student
*/

import org.apache.log4j.Logger;

public class Student {

    final static Logger logger = Logger.getLogger(Student.class);

    public static void main(String[] args) {        
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.fatal("This is fatal message");
        logger.error("This is error message");
        System.out.println("Logic executed successfully....");
    }
}
