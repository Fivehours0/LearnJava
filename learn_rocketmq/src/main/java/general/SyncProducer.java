package general;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 同步发送消息
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // 创建一个producer，参数为Producer Group的名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        // 指定NameServer地址
        producer.setNamesrvAddr("192.168.138.129:9876");
        // 设置当发送失败时重试发送发次数，默认为2次
        producer.setRetryTimesWhenSendFailed(3);
        // 设置发送超时时间为5s，默认3s
        producer.setSendMsgTimeout(5000);
//        producer.setDefaultTopicQueueNums(2); // 设置topic的queue个数为2个，默认为4
        // 开启生产者
        producer.start();

        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("someTopic", "someTag", body);
            // msg.setKeys("key"); // 用户指定的key

            /*
             *     SEND_OK,
             *     FLUSH_DISK_TIMEOUT,  刷盘超时（刷盘超时是同步刷盘策略时，才会出现）
             *     FLUSH_SLAVE_TIMEOUT, slave同步超时，同步复制策略时会出现
             *     SLAVE_NOT_AVAILABLE, 当broker集群设置master，slave的复制方式为同步复制才会出现
             */
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
