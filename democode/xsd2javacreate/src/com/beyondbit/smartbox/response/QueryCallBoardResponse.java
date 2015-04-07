package com.beyondbit.smartbox.response;

import com.beyondbit.smartbox.common.CallBoard;

public class QueryCallBoardResponse extends Response {
	private int total;

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	private int unReadedCount;

	public void setUnReadedCount(int unReadedCount) {
		this.unReadedCount = unReadedCount;
	}

	public int getUnReadedCount() {
		return unReadedCount;
	}

	private CallBoard[] callBoard;

	public void setCallBoard(CallBoard[] callBoard) {
		this.callBoard = callBoard;
	}

	public CallBoard[] getCallBoard() {
		return callBoard;
	}

}