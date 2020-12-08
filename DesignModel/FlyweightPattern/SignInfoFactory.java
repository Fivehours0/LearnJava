package DesignModel.FlyweightPattern;

import java.util.HashMap;

public class SignInfoFactory {
    private static final HashMap<String, SignInfo> pool = new HashMap<>();

    @Deprecated
    //报名信息的对象工厂
    public static SignInfo getSignInfo(){
        return new SignInfo();
    }

    public static SignInfo getSignInfo(String key) {
        SignInfo result = pool.get(key);
        if (result == null) {
            SignInfo signInfo = new SignInfo4Pool(key);
            pool.put(key, signInfo);
            System.out.println("创建新的对象，放入到池中----" + key);
        } else {
            System.out.println("从对象池中获取----" + key);
        }

        return result;
    }
}