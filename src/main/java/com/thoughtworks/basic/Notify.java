package com.thoughtworks.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author Administrator
 */
public class Notify {
    private final static String QUEUE_NAME = "school";


    public static void notify(Student student) throws Exception {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = student.introduce();
        message = message.substring(0, message.length() - 1) + " now.";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [" + student.getName() + "] Sent '" + message + "'");
        try {
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
