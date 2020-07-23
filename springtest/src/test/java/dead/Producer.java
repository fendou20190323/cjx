package dead;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.DirectExchange;
import util.RabbitMQConnectionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 发布与订阅使用的交换机类型为：fanout
 */
public class Producer {

    //交换机名称
    static final String DEAD_FANOUT_EXCHAGE = "dead_fanout_exchange";
    //队列名称
    static final String DEAD_FANOUT_QUEUE_1 = "dead_fanout_queue_1";
    //队列名称
    static final String DEAD_FANOUT_QUEUE_2 = "dead_fanout_queue_2";

    public static void main(String[] args) throws Exception {
        DirectExchange directExchange = new DirectExchange("dead_exchange");
        //创建连接
        Connection connection = RabbitMQConnectionUtil.getConnection();
        // 创建频道
        Channel channel = connection.createChannel();
        /**
         * 声明交换机
         * 参数1：交换机名称
         * 参数2：交换机类型，fanout、topic、direct、headers
         */
        channel.exchangeDeclare(DEAD_FANOUT_EXCHAGE, BuiltinExchangeType.FANOUT);

        // 声明（创建）队列
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其它参数
         */
        Map<String, Object> map = new HashMap<>();
        map.put("x-message-ttl", 3000);
        map.put("x-dead-letter-exchange", "dead_fanout_exchange");
        map.put("x-dead-letter-routing-key", "dead");
//        channel.queueDeclare(DEAD_FANOUT_QUEUE_1, true, false, false, map);
        channel.queueDeclare(DEAD_FANOUT_QUEUE_2, true, false, false, map);

        //队列绑定交换机
//        channel.queueBind(DEAD_FANOUT_QUEUE_1, DEAD_FANOUT_EXCHAGE, "");
        channel.queueBind(DEAD_FANOUT_QUEUE_2, DEAD_FANOUT_EXCHAGE, "dead");


        // 发送信息
        String message = "你好；小兔子！发布订阅模式--" + System.currentTimeMillis();
        /**
         * 参数1：交换机名称，如果没有指定则使用默认Default Exchage
         * 参数2：路由key,简单模式可以传递队列名称
         * 参数3：消息其它属性
         * 参数4：消息内容
         */
        channel.basicPublish(DEAD_FANOUT_EXCHAGE, "", null, message.getBytes());
        System.out.println("已发送消息：" + message);


        // 关闭资源
        channel.close();
        connection.close();
    }
}