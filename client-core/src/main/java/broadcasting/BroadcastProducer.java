package broadcasting;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @ClassName BroadcastProducer
 * @Description TODO
 * @Author madepeng
 * @Date 2019/9/27 13:51
 * @Version 1.0
 */
public class BroadcastProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("test_6");
        producer.setNamesrvAddr("172.19.184.152:9876");
        producer.start();

        for (int i = 0; i < 5; i++){
            Message msg = new Message("test_6",
                    "TagA",
                    "OrderID188",
                    ("Hello world" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }
}
