package net.antra.design.decorator;

public class EmailSenderImpl implements EmailSender {
    @Override
    public void sendEmail(String message) {
        System.out.println("Message is sent : " + message);
    }
}
