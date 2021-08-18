package transaction;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

public class ICBCTransactionListener implements TransactionListener {
    // 回调操作
    // 消息预提交成功就会触发该方法的执行，用于完成本地事务
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // 预提交消息指的是将半消息（prepare消息）成功提交至broker中。broker执行成功这个预提交消息的过程后
        // 会回调这个函数，在该函数中执行本地事务,并根据事务执行的结果，返回给broker相应的状态。
        System.out.println("预提交消息成功,接下来进行本地事务的处理"+msg);
        // 这里只是利用TAG模拟执行情况，假设接收到TAGA的消息表示扣款操作成功，假设接收到TAGB的消息表示扣款操作失败，
        // TAGC的消息表示扣款结果不清楚，需要执行消息回查
        if (StringUtils.equals("TAGA", msg.getTags())) {
            return LocalTransactionState.COMMIT_MESSAGE;
        } else if (StringUtils.equals("TAGB", msg.getTags())) {
            return LocalTransactionState.ROLLBACK_MESSAGE;
        } else if (StringUtils.equals("TAGC", msg.getTags())) {
            return LocalTransactionState.UNKNOW;
        }
        return LocalTransactionState.UNKNOW;
    }

    // 消息回查
    // 引发消息回查的原因最常见的有两个
    // 1回调操作返回UNKNOWN
    // 2TC没有接收到TM的最终全局事务确认指令
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        System.out.println("执行消息回查"+msg.getTags());
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
