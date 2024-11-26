package NotificationsSystemPackage;
import java.util.Map;
import java.util.HashMap;

 class NotificationFactory {
     //user story 8
    private static final Map<String, Class<? extends NotificationDecorator>> channelRegistry = new HashMap<>();

    static {
        //known notification types
        channelRegistry.put("sms", SMSNotification.class);
        channelRegistry.put("email", EmailNotification.class);
        channelRegistry.put("slack", SlackNotification.class);
        channelRegistry.put("whatsapp", WhatsAppNotification.class);
        channelRegistry.put("push", PushNotification.class);
    }

    public static Notification createNotification(String channel, Notification baseNotification) {
        try {
            Class<? extends NotificationDecorator> decoratorClass = channelRegistry.get(channel.toLowerCase());
            if (decoratorClass != null) {
                return decoratorClass.getConstructor(Notification.class).newInstance(baseNotification);
            } else {
                throw new IllegalArgumentException("Unknown notification channel: " + channel);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error creating notification for channel: " + channel, e);
        }
    }

    //register new notification types (for extensibility)
    public static void registerChannel(String channel, Class<? extends NotificationDecorator> decoratorClass) {
        channelRegistry.put(channel.toLowerCase(), decoratorClass);
    }
}
