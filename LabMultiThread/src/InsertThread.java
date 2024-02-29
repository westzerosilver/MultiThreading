
public class InsertThread extends Thread {

	Queue queue;			// 메인 함수에서 받아온 큐 저장하는 매개변수 
	int cnt;				// 반복 횟수 
	
	// 스레드 생성자 함수 
	public InsertThread(Queue queue) {
		this.queue = queue;
		this.cnt = 100;
	}
	
	public void run() {
		int queueValue;
		
		for (int i = 0; i < cnt; i++) {
			queueValue = (int)(Math.random() * 10);
			synchronized (queue) {
				queue.enqueue(queueValue);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}