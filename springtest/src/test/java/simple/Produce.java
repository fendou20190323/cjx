package simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.RabbitMQConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: cjx
 * @Date: 2020-07-21 11:46
 * @Description;
 */
public class Produce {
    static final String QUEUE="FENDOU";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection con = RabbitMQConnectionUtil.getConnection();
        Channel channel = con.createChannel();
        channel.queueDeclare(QUEUE,true,false,false,null);
        for (int i = 0; i < 10; i++) {
            String message="fendou!!!!!!!!!!!!崔"+i;
            channel.basicPublish("", QUEUE,null,message.getBytes());
        }
        channel.close();
        con.close();
    }
}
