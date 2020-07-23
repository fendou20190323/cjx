package util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: cjx
 * @Date: 2020-07-21 11:57
 * @Description;
 */
public class RabbitMQConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.218.128");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection con = connectionFactory.newConnection();
        return con;
    }
}
