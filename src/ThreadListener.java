/**
 * Created with IntelliJ IDEA.
 * User: maksym
 * Date: 11/8/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadListener implements ThreadCompleteListener {

    public int quantityOfEndedThreads;

    @Override
    public void notifyOfThreadComplete(Thread thread) {
        quantityOfEndedThreads++;
        System.out.println(thread.getName() + " ended!");

        if (quantityOfEndedThreads == 50) {
            System.out.println("Quantity Of Threads = 50 and last Thread stops");
        }
    }
}
