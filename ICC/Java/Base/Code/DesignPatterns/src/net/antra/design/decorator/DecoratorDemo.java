package net.antra.design.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        EmailSender sender = new UniqEmailSender(new EmailSenderImpl());
//        EmailSender sender = new EmailSenderImpl();
        sender.sendEmail("hello");
        sender.sendEmail("hello");

        EmailSender sender2 = new ShortEmailSender(new UniqEmailSender(new EmailSenderImpl()), 10);
        sender2.sendEmail("this is long message");
        sender2.sendEmail("short msg");
        sender2.sendEmail("short msg");
    }
}
