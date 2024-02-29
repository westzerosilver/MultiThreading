
public class QueueTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 큐 생성 
		Queue queue = new Queue();
		
		// 스레드 생성 
		InsertThread insertThread = new InsertThread(queue);
		DeleteThread deleteThread = new DeleteThread(queue);
		
		// 스레드 시작 
		insertThread.start();
		deleteThread.start();
		
	}
}
