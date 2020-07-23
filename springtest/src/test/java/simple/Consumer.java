package simple;

import com.rabbitmq.client.*;
import util.RabbitMQConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: cjx
 * @Date: 2020-07-21 11:47
 * @Description;
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection con = RabbitMQConnectionUtil.getConnection();

        Channel channel = con.createChannel();
        channel.queueDeclare(Produce.QUEUE,true,false,false,null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.err.println(new String(body,"utf-8"));
            }
        };
        channel.basicConsume(Produce.QUEUE,true,defaultConsumer);
    }
}
