package sql;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {

    private static final String HOST = "localhost"; // MySQL 서버 주소
    private static final String DB_NAME = "survey"; // MySQL DATABASE 이름
    private static final String USER = "root"; //  MySQL 서버 아이디
    private static final String PASSWORD = "root"; // MySQL 서버 비밀번호

    private static DataSourceFactory instance;

    public static DataSourceFactory getInstance() {
        if (instance == null) {
            instance = new DataSourceFactory();
        }
        return instance;
    }

    private DataSourceFactory() {
    }

    public DataSource createDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser(USER);
        ds.setPassword(PASSWORD);
        ds.setUrl("jdbc:mysql://" + HOST + "/" + DB_NAME + "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false");
        return ds;
    }
}
