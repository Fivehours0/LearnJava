package first;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestZookeeper {
    private String connectString = "192.168.138.129:2181,192.168.138.136:2181,192.168.138.138:2181";
    private int seesionTimeout = 300000;  // 2s
    private ZooKeeper zkCli;

    @Before
    public void init() throws IOException {
        // 连接上zk服务器， watch为监听器
        zkCli = new ZooKeeper(connectString, seesionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkCli.getChildren("/", false);
                    for (String s: children) {
                        System.out.println(s);
                    }
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 创建子节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zkCli.create("/guigu", "du".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    @Test
    public void getDataAndWatch () throws KeeperException, InterruptedException {
        // children为根目录下的所有节点，true表示对根目录进行监听
        // If the watch is true and the call is successful (no exception is thrown), a watch will be left on the node with the given path.
        // watch是一次性的
        List<String> children = zkCli.getChildren("/guigui", true);
        Thread.sleep(Long.MAX_VALUE);
    }

    // 判断节点是否存在
    @Test
    public void exist() throws KeeperException, InterruptedException {
        // 不存在返回false
        Stat stat = zkCli.exists("/guigu", false);
        System.out.println(stat);
    }
}
