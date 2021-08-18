package batch;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;

public class BatchProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("192.168.138.129:9876");
        producer.setRetryTimesWhenSendFailed(3);
        producer.setSendMsgTimeout(5000);
        producer.start();
        // 即将消息封装成list发送
        ArrayList<Message> list = new ArrayList<>();
        byte[] body = ("Hi," + 1).getBytes();
        list.add(new Message("TopicB", "TagB", body));
        list.add(new Message("TopicB", "TagB", body));
        SendResult sendResult = producer.send(list);
            // 输出消息被发送的时间
        System.out.println(sendResult);
        System.out.println("," + sendResult);
        producer.shutdown();
    }
}
