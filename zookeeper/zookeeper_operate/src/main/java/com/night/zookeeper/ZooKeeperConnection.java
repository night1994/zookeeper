
/*
 * 文件名：ZooKeeperConnection.java
 * 版权：Copyright by www.rsrtech.net
 * 描述：
 * 修改人：night
 * 修改时间：2018年9月26日
 */

package com.night.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperConnection {
 // declare zookeeper instance to access ZooKeeper ensemble
    private ZooKeeper zoo;
    final CountDownLatch connectedSignal = new CountDownLatch(1);

    // Method to connect zookeeper ensemble.
    public ZooKeeper connect(String host) throws IOException,InterruptedException {
     
       zoo = new ZooKeeper(host,5000,new Watcher() {
         
          public void process(WatchedEvent we) {

             if (we.getState() == KeeperState.SyncConnected) {
                connectedSignal.countDown();
             }
          }
       });
         
       connectedSignal.await();
       return zoo;
    }

    // Method to disconnect from zookeeper server
    public void close() throws InterruptedException {
       zoo.close();
    }
}

