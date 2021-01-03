package net.antra.design.decorator;

import java.util.HashSet;
import java.util.Set;

public class UniqEmailSender implements EmailSender {

    private EmailSender sender;
    private Set<String> messageHistory;
    public UniqEmailSender(EmailSender sender) {
        this.sender = sender;
        messageHistory = new HashSet<>();
    }

    @Override
    public void sendEmail(String message) {
        if (messageHistory.contains(message)) {
            System.out.println("This message is already sent.");
            return;
        }
        sender.sendEmail(message);
        messageHistory.add(message);
    }
}
