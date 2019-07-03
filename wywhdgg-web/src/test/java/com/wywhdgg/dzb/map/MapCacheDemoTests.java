package com.wywhdgg.dzb.map;

public class MapCacheDemoTests {
    public static void main(String[] args) throws InterruptedException {
        // 将下面的数据缓存5秒钟
        MapCacheManager mapCacheDemo = new MapCacheManager();
        mapCacheDemo.add("uid_10001", "{1}", 5 * 1000);
        mapCacheDemo.add("uid_10002", "{2}", 5 * 1000);
        mapCacheDemo.add("uid_10003", "{3}", 5 * 1000);
        // 立马取出，值存在
        System.out.println("从缓存中取出值:" + mapCacheDemo.get("uid_10001"));
        System.out.println("从缓存中取出值:" + mapCacheDemo.get("uid_10002"));
        System.out.println("从缓存中取出值:" + mapCacheDemo.get("uid_10003"));
        // 5秒后再次获取
        Thread.sleep(5000L);
        System.out.println("5秒钟过后");
        System.out.println("从缓存中取出值:" + mapCacheDemo.get("uid_10001"));
        System.out.println("从缓存中取出值:" + mapCacheDemo.get("uid_10002"));
        System.out.println("从缓存中取出值:" + mapCacheDemo.get("uid_10003"));
        // 5秒后数据自动清除了~
    }
}
