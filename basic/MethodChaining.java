package WIL.basic;

class DBConnector {
    private String host;
    private String port;
    private String user;
    private String password;

    DBConnector(){}
    DBConnector(String host, String port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    DBConnector setHost(String host) {
        this.host = host;
        return this; // setter(host)의 리턴 타입 : DBConnector
    }

    DBConnector setPort(String port) {
        this.port = port;
        return this;
    }

    DBConnector setUser(String user) {
        this.user = user;
        return this;
    }

    DBConnector setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "DBConnector{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
public class MethodChaining {
    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();
        // 장점 : 하나의 문장처럼 읽을 수 있어 장기적으로는 유지보수에 용이
        // 단점 : 하나의 라인에 많은 함수가 있어 디버깅이 어려워짐
        dbConnector.setHost("localhost").setPort("3306").setUser("root").setPassword("1234");
        System.out.println("dbConnector = " + dbConnector);
        // dbConnector = DBConnector{host='localhost', port='3306', user='root', password='1234'}
    }
}