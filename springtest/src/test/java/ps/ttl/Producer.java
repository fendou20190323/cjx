package ps.ttl;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.RabbitMQConnectionUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * 路由模式的交换机类型为：direct
 */
public class Producer {

    //交换机名称
    static final String DEAD_EXCHAGE = "dead_exchange_t3";
    static final String DEAD_QUEUE = "dead_queue_t3";

    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMQConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

//        channel.exchangeDeclare(DEAD_EXCHAGE, BuiltinExchangeType.DIRECT);

//        Map<String,Object> map = new HashMap<>();
//        map.put("x-dead-letter-exchange", "deadExchange2");
//        map.put("x-dead-letter-routing-key", "dead");
//        map.put("x-message-ttl", 10000);
//        channel.queueDeclare(DEAD_QUEUE,true,false,false,map);
//
//        channel.queueBind(DEAD_QUEUE,DEAD_EXCHAGE,"abc");
//
        String message = "修改了商品。"+System.currentTimeMillis() ;

        channel.basicPublish(DEAD_EXCHAGE,"abc", null,message.getBytes());

        channel.close();
        connection.close();
    }
}