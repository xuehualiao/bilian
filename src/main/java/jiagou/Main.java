package jiagou;


import jiagou.api.Client;

public class Main {
    public static void main(String[] args) {
        Client jedis = new Client("localhost", 6379);
        jedis.set("name","666");
        String name = jedis.get("name");
        System.out.println(name);
    }
}
