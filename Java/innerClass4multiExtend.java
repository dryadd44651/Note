class Call {
	public void callSomebody(String phoneNum){
		System.out.println("calling : " + phoneNum);
	}
}

class SendMessage {
	public void sendToSomebody(String phoneNum){
		System.out.println("texting : " + phoneNum);
	}
}


public class Phone {
	private class MyCall extends Call{
		
	}
	private class MySendMessage extends SendMessage{
		
	}
	
	private MyCall call = new MyCall();
	private MySendMessage send = new MySendMessage();
	
	public void phoneCall(String phoneNum){
		call.callSomebody(phoneNum);
	}
	
	public void phoneSend(String phoneNum){
		send.sendToSomebody(phoneNum);
	}
	
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.phoneCall("110");
		phone.phoneSend("119");
	}
}
