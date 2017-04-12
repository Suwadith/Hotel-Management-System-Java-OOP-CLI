
public class Queue {

    String queueItems[] = new String[7];
    String[] temp = new String[7];
    int front = 0, end = 0;

    //Constructor of the Queue class
    public Queue() {
        //initialization process
        for (int x = 0; x < queueItems.length; x++) {
            queueItems[x] = "e";
        }
    }

    //method to add customer names according to their registration order
    void addToQueue(String name) {
        try {
            queueItems[end] = name;
            end++;
            //exception to handle when the registration process exceeds the array size
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Queue Overload!!!!");
            takeFromQueue();
            queueItems[6] = name;
        }

    }

    //method to re-arrange the Queue array when length is exceeded. (Last in first out)
    void takeFromQueue() {
        try {
            if (end > front && !queueItems[front].equals("e")) {
                System.out.println("Mr. " + queueItems[front] + " Removed from the queue.");
                System.arraycopy(queueItems, 1, temp, 0, queueItems.length - 1);
                System.arraycopy(temp, 0, queueItems, 0, temp.length);
            } else {
                System.out.println("Queue is Empty");
                end = 0;
            }
        } catch(NullPointerException e){
            System.out.println("Empty Queue");
        }
    }

    //display method which displays the first 3 customers and also removes them instantly from the queue array
    void displayQueue() {
        takeFromQueue();
        takeFromQueue();
        takeFromQueue();
        System.out.println("");
    }
}