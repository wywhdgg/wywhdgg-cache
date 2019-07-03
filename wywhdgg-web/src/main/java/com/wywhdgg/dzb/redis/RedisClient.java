package com.wywhdgg.dzb.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// 自己实现客户端
public class RedisClient {
    OutputStream write = null;
    InputStream read = null;

    public RedisClient(String host, int ip) throws IOException {
        Socket socket = new Socket(host, ip); // redis connection
        write = socket.getOutputStream();
        read = socket.getInputStream();
    }

    // get

    // set key value
    public void set(String key, String value) throws IOException {
        // RESP 请求数据包
        StringBuffer command = new StringBuffer();
        command.append("*3").append("\r\n");// 这次命令 分为几个部分

        command.append("$3").append("\r\n"); // 第一部分数据长度
        command.append("SET").append("\r\n");  // 第一部分的数据值

        command.append("$").append(key.getBytes().length).append("\r\n"); // 第2部分数据长度
        command.append(key).append("\r\n");  // 第2部分的数据值

        command.append("$").append(value.getBytes().length).append("\r\n"); // 第3部分数据长度
        command.append(value).append("\r\n");  // 第3部分的数据值

        // 发生数据包到redis服务器
        write.write(command.toString().getBytes());
        System.out.println("数据发送成功");
        System.out.println(command.toString());

        // 接受redis服务器的响应
        byte[] response = new byte[1024];
        read.read(response);
        System.out.println("接受到响应：" + new String(response));
    }

    public static void main(String[] args) throws IOException {
        RedisClient redisClient = new RedisClient("127.0.0.1", 6379);
        // set hello sun
        redisClient.set("hello", "卡卡尤里");
    }
}
