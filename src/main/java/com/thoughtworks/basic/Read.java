package com.thoughtworks.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.GetResponse;


/**
 * @author Administrator
 */
public class Read {
    private final static String QUEUE_NAME = "school";

    public static String read() throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        GetResponse getResponse = channel.basicGet(QUEUE_NAME, true);
        if (getResponse != null) {
            channel.close();
            connection.close();
            return new String(getResponse.getBody());
        }
        channel.close();
        connection.close();
        return null;
    }

    public static String listen() throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        MyConsumer myConsumer = new MyConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, myConsumer);
        channel.close();
        connection.close();
        //取不到消息，暂时不用。
        return myConsumer.getMessage();
    }

}

