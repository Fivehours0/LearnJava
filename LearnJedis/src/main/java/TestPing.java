import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;

public class TestPing {
    public static void main(String[] args) throws InterruptedException {
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Jedis jedis = new Jedis("192.168.138.129", 6379);
        System.out.println(jedis.ping());
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        System.out.println(jedis.get("k1"));

        Set<String> set = jedis.keys("*");
        System.out.println(set.toString());

        // 开启一个事务, 并且模拟锁
        jedis.watch("balance");
        System.out.println(jedis.get("balance"));
        Thread.sleep(7000);
        Transaction transaction = jedis.multi();
        transaction.decrBy("balance", 20);
//        System.out.println(transaction.get("balance"));
        transaction.exec();
    }
}
