package net.antra.design.decorator;

public class ShortEmailSender implements EmailSender {

    private EmailSender sender;
    private int maxLength;

    public ShortEmailSender(EmailSender sender, int maxLength) {
        this.sender = sender;
        this.maxLength = maxLength;
    }

    @Override
    public void sendEmail(String message) {
        if (message.length() > maxLength) {
            System.out.println("Cannot send this message. Too long");
            return;
        }
        sender.sendEmail(message);
    }
}
