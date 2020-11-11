package JDBC;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 建立连接  Connection conn = DriverManager.getConnection(url,user,pass);
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String username = "root";
        String password = "aA650428";
        conn = DriverManager.getConnection(url, username, password);


        PreparedStatement st = null;
        String sql = "select * from student where student_id=? and age=?";
        //3.获取用于向数据库发送sql语句的statement
        st = conn.prepareStatement(sql);
        st.setInt(1, 3);
        st.setInt(2, 18);

        //4.向数据库发sql 并获得返回的结果
        ResultSet rs = null;
        rs = st.executeQuery();
        rs.next();
        System.out.println("student_id: " + rs.getObject("student_id"));
        System.out.println("age: " + rs.getObject("age"));


        //6.关闭链接，释放资源
        if(rs!=null){
            try{
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;

        }
        if(st!=null){
            try{
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(conn!=null){
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
