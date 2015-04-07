package com.txc.xsd2java;
import com.beyondbit.smartbox.request.AddCalendarRequest;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;


public class testmain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddCalendarRequest a=new AddCalendarRequest();
		RequestSerializer.serialize(a);
	}

}
