public class Queue{

	private int size = 2;							// 큐의 크기 지정 
	private int front = 0;							// 큐의 front값 변수  
	private int rear = 0;							// 큐의 rear값 변수 
	private int[] queueArray = new int[size]; 		// 원형 큐 변수 
	
	
	// 큐가 꽉찼는지 검사하는 함수 
	public boolean isFull() {
		if (front == (rear + 1) % size) {
			return true;
		}
		else return false;
	}
	
	// 큐가 비어있는지 검사하는 함수
	public boolean isEmpty() {
		if(front == rear) return true;
		else return false;
	}
	
	// 큐에 원소를 삽입하는 함수 
	synchronized public void enqueue(int value) {
		// 큐가 꽉 차 원소를 추가할 수 없을 때 대기 후 실행 
		if(isFull()) {
			try {
				System.out.println("~~~~~~~~ enqueue wait ~~~~~~~~" );
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		rear = (rear + 1) % size;
		queueArray[rear] = value;
		System.out.print("enqueue: ");
		displayQueue();
		notifyAll();
	}
	
	// 큐에 원소를 제거하고, 제거한 값을 반환하는 함수 
	synchronized public int dequeue() {
		// 큐에 삭제할 원소가 없을 경우 대기 후 실행 
		if(isEmpty()) {
			try {
				System.out.println("~~~~~~~~ dequeue wait ~~~~~~~~");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int returnValue = queueArray[front];
		front = (front + 1) % size;
		System.out.print("dequeue: ");
		displayQueue();
		notifyAll();
		return returnValue;
		
	}
	
	// 큐에 있는 모든 원소를 프린트하는 함수 
	public void displayQueue() {
		if(isEmpty()) {
			System.out.print(" EMPTY ");
		}
		else {
			int i = front;
			while(i != rear) {
				i = (i + 1) % size;
				System.out.print(queueArray[i] + "	");
			}
		}
		
		System.out.println();
		
	}
	
	
}
