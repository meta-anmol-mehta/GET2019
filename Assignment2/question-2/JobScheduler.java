class JobScheduler {

	protected int noOfProcess;
	protected int[][] processes;
	// A constant to represent index of burst time in 2D array
	protected final int INDEX_OF__BURST_TIME;
	// A constant to represent index of arrival time in 2D array
	protected final int INDEX_OF_ARRIVAL_TIME;

	public JobScheduler(int noOfProcess, int[][] processes) {
		this.noOfProcess = noOfProcess;
		this.processes = processes;
		INDEX_OF__BURST_TIME = 1;
		INDEX_OF_ARRIVAL_TIME = 0;
	}

	// completionTime of process is equal to turn around time and arrival time
	// of that process
	// completion time is the time at which process executes completely

	protected int[] processCompletionTime(int[] turnAroundTime) {

		int[] completionTime = new int[noOfProcess];

		for (int i = 0; i < noOfProcess; ++i) {

			completionTime[i] = turnAroundTime[i]
					+ processes[i][INDEX_OF_ARRIVAL_TIME];

		}

		return completionTime;
	}

	// the time till which process has to wait for execution
	// waiting time in FCFS is equal to difference between its service time and
	// arrival time
	// service time is equal to sum of service time of previous process and
	// burst time of previous process

	protected int[] processWaitingTime() {

		int[] waitingTime = new int[noOfProcess];
		int[] serviceTime = new int[noOfProcess];

		waitingTime[0] = 0;
		serviceTime[0] = 0;

		for (int i = 0; i < noOfProcess - 1; ++i) {

			serviceTime[i + 1] = serviceTime[i]
					+ processes[i][INDEX_OF__BURST_TIME];
			waitingTime[i + 1] = serviceTime[i + 1]
					- processes[i + 1][INDEX_OF_ARRIVAL_TIME];

		}

		return waitingTime;
	}

	// turnAround time is the sum of waiting time of that process with Burst
	// time of that process

	protected int[] processTurnAroundTime(int[] waitingTime) {

		int[] turnAroundTime = new int[noOfProcess];

		for (int i = 0; i < noOfProcess; ++i) {

			turnAroundTime[i] = waitingTime[i]
					+ processes[i][INDEX_OF__BURST_TIME];

		}

		return turnAroundTime;
	}

	// Calculating average waiting time of all the process

	protected double averageWaitingTime(int[] waitingTime) {

		int totalWaitingTime = 0;
		double averageWaitingTime = 0.0;
		for (int i = 0; i < noOfProcess; ++i) {

			totalWaitingTime += waitingTime[i];

		}

		averageWaitingTime = ((double) totalWaitingTime) / noOfProcess;

		return averageWaitingTime;
	}

	// Calculating which process has maximum waiting time

	protected int maximumWaitingTime(int[] waitingTime) {

		int max = waitingTime[0];

		for (int i = 0; i < noOfProcess - 1; ++i) {

			if (waitingTime[i + 1] > max) {

				max = waitingTime[i + 1];

			}

		}

		return max;
	}
}