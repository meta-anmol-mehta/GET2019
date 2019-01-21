import java.util.Scanner;

public class JobSchedulerDriver {
	static final int MAX_COLUMN = 2;
	public static void main(String[] args) {
		// MAX_COLUMN define index 0 for burst time and index 1 for arrival time
		// of 2D array
		

		Scanner input = new Scanner(System.in);
		// noOfProcess defines the no of process in queue
		int noOfProcess;
		// 2D array processes define every process in queue with index 0
		// represent arrival time and index 1 represent burst time of process in
		// a queue
		int[][] processes;

		System.out.println("Enter no of processes");
		noOfProcess = input.nextInt();

		processes = new int[noOfProcess][MAX_COLUMN];

		System.out.println("Enter process  arrival time and burst time ");

		for (int i = 0; i < noOfProcess; ++i) {
			for (int j = 0; j < MAX_COLUMN; ++j) {

				processes[i][j] = input.nextInt();

			}
			System.out.println();
		}

		// JobScheduler is a class which calculate completion
		// time,turnAroundTime,waitingTime of each process in a queue
		JobScheduler scheduler = new JobScheduler(noOfProcess, processes);

		int[] waitingTime = new int[noOfProcess];

		waitingTime = scheduler.processWaitingTime();

		int[] turnAroundTime = new int[noOfProcess];

		turnAroundTime = scheduler.processTurnAroundTime(waitingTime);

		int[] processCompletionTime = new int[noOfProcess];

		processCompletionTime = scheduler.processCompletionTime(turnAroundTime);

		double averageWaitingTime = scheduler.averageWaitingTime(waitingTime);

		int maxWaitingTime = scheduler.maximumWaitingTime(waitingTime);

		System.out.println("Waiting time of all the process");

		scheduler.Display(processCompletionTime, noOfProcess, "Waiting");
		
		System.out.println("Turn Around time of all the process");
		scheduler.Display(processCompletionTime, noOfProcess, "Turn Around");
		
		System.out.println("Completion time of all the process");
		scheduler.Display(processCompletionTime, noOfProcess, "Completion");
		System.out.println("Average waiting time=" + averageWaitingTime);
		System.out.println("Maximum waiting time=" + maxWaitingTime);

	}
	

}
