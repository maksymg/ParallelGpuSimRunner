/**
 * Created with IntelliJ IDEA.
 * User: maksym
 * Date: 11/2/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Runner {

    private static String CONFIG = "config%s.xml";
    private static String OUTPUT = "output%s.xml";

    private static ThreadListener threadListener = new ThreadListener();

    public static void main(final String[] args) throws Exception {
        /*long startTime = System.currentTimeMillis();*/

        for (int j = 0; j < Integer.parseInt(args[0]) / Integer.parseInt(args[1]); j++) {
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {

                NotifyingThread notifyingThread = new WorkerThread(args[2], String.format(CONFIG, (i + j * Integer.parseInt(args[1]))),
                        String.format(OUTPUT, (i + j * Integer.parseInt(args[1]))));
                notifyingThread.addListener(threadListener);
                notifyingThread.start();

            /*Process process = Runtime.getRuntime().exec("java -jar " + args[1] + " " + String.format(CONFIG, i) + " " + String.format(OUTPUT, i));
            System.out.println("Process" + i + " is started: " + process);
            process.waitFor();
            System.out.println("Exit value " + i + ": " + process.exitValue());*/
            }

            while (threadListener.quantityOfEndedThreads != Integer.parseInt(args[1])) {
                continue;
            }

            threadListener.quantityOfEndedThreads = 0;
        }
        /*
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);*/
    }
}
