import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: maksym
 * Date: 11/3/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkerThread extends NotifyingThread {

    private String runningJar;
    private String configFile;
    private String outputFile;

    public WorkerThread(String runningJar, String configFile, String outputFile) {
        this.runningJar = runningJar;
        this.configFile = configFile;
        this.outputFile = outputFile;
    }

    @Override
    public void doRun() {
        try {
            Process process = Runtime.getRuntime().exec("java -jar " + runningJar + " " + configFile + " " + outputFile);
            System.out.println("Process with " + configFile + " is started: " + process + "==== Start time: " + System.currentTimeMillis());
            process.waitFor();
            System.out.println("Exit value of process with " + configFile + ": " + process.exitValue() + "==== Exit time: " + System.currentTimeMillis());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
