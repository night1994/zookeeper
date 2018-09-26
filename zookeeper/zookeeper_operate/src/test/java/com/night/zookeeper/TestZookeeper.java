
/*
 * 文件名：TestZookeeper.java
 * 版权：Copyright by www.rsrtech.net
 * 描述：
 * 修改人：night
 * 修改时间：2018年9月26日
 */

package com.night.zookeeper;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import sun.util.logging.resources.logging;

public class TestZookeeper {
    
    private Log log = LogFactory.getLog(TestZookeeper.class);
    
    private static ZooKeeper zk;
    
    private static ZooKeeperConnection conn;
    
    /**
     * 初始化连接
     * 创建时间:  2018年9月26日
     * 创建人:  night
     */
    @Before
    public void beforTest(){
        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("60.205.221.223:2181");
        }
        catch (Exception e) {
            
            log.error("连接zookeeper失败");
            
        }
    }
    
    /**
     * 测试创建节点
     * 创建时间:  2018年9月26日
     * 创建人:  night
     */
    @Test
    public void testCreateNode(){
        
        String path = "/MyFirstZnode_night"; // Assign path to znode

        // data in byte array
        byte[] data = "My first zookeeper app".getBytes(); 
        
      
        try {
            ZookeeperUtil.create(zk,path, data);
        }
        catch (Exception e) {
            
            log.error("创建节点失败",e);
            
        }
    }
    
    @Test
    public void testExist(){
        String path = "/MyFirstZnode_night"; // Assign path to znode
        
        try {
            Stat stat = ZookeeperUtil.znode_exists(zk, path);
            if(stat != null) {
                System.out.println("Node exists and the node version is " +
                stat.getVersion());
             } else {
                System.out.println("Node does not exists");
             }
        }
        catch (Exception e) {
            
            log.error("判断节点是否存在失败",e);
        }
    }
}

