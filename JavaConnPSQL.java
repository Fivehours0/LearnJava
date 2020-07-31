import java.sql.*;

public class JavaConnPSQL {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /* SQL的连接信息 */
        Connection con;
        Statement st;
        ResultSet rs;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "aA650428";

        /* 定义JDBC驱动 */
        Class.forName("org.postgresql.Driver");

        /* 连接PostgreSQL */
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();

        /* 执行SELECT语句 */
        rs = st.executeQuery("SELECT 1 AS col_1");

        /* 在画面中显示结果 */
        rs.next();
        System.out.print(rs.getInt("col_1"));

        /* 切断与PostgreSQL的连接 */
        rs.close();
        st.close();
        con.close();
    }
}