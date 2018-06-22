package com.graction.lumi.util;

import java.util.Iterator;
import java.util.LinkedList;

public class DataProvideManager{
	private Execution execution;
	private Complete complete;
	private LinkedList<Execution> executionList = new LinkedList<Execution>();
	private Iterator<Execution> iterator;
	private static final int DEFAULT_CYCLE = 200;
	private boolean isProceeding = true;
	private int proceedCycle, idx = 0;
	
	public DataProvideManager(Execution execution, Complete complete, int proceedCycle) {
//		this.execution = execution;
		this.complete = complete;
		this.proceedCycle = proceedCycle;
		executionList.add(execution);
	}
	
	public DataProvideManager(Execution execution, Complete complete) {
		this(execution, complete, DEFAULT_CYCLE);
	}
	
	public void addExecution(Execution execution) {
		executionList.addLast(execution);
	}

	public void execution() throws InterruptedException {
		stopProcceding();
		nextExecution();
		proceeding();
	}

	public void nextExecution() {
		if(executionList.size() > idx) {
			execution = executionList.get(idx++);
			execution.execution();
		}else
			complete.complete();
	}
	
	public void complete() {
		stopProcceding();
		complete.complete();
	}

	private void stopProcceding() {
		if(isProceeding)
			isProceeding = false;
	}
	
	private void proceeding() throws InterruptedException{
		isProceeding = true;
		while(isProceeding)
			Thread.sleep(proceedCycle);
	}
	
	public interface Execution{
		public void execution();
	}
	public interface Complete{
		public void complete();
	}
}
