package DesignModel.FlyweightPattern;

public class SignInfo {
    //报名人员的ID
    private String id;
    //考试地点
    private String location;
    //考试科目
    private String subject;
    //邮寄地址
    private String postAddress;
    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }
}

class SignInfo4Pool extends SignInfo {
    //定义一个对象池提取的KEY值
    private final String key;
    //构造函数获得相同标志
    public SignInfo4Pool(String _key){
        this.key = _key;
    }
    public String getKey() {
        return key;
    }
}
