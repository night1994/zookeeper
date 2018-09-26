
/*
 * 文件名：ZookeeperUtil.java
 * 版权：Copyright by www.rsrtech.net
 * 描述：
 * 修改人：night
 * 修改时间：2018年9月26日
 */

package com.night.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookeeperUtil {
    
    /**
     * 创建节点
     * @param zk
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException 
     * 创建时间:  2018年9月26日
     * 创建人:  night
     */
    public static void create(ZooKeeper zk, String path, byte[] data)
        throws KeeperException, InterruptedException {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
    
    /**
     * 判断节点是否存在
     * @param zk
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException 
     * 创建时间:  2018年9月26日
     * 创建人:  night
     */
    public static Stat znode_exists(ZooKeeper zk,String path) throws
    KeeperException,InterruptedException {
    return zk.exists(path, true);
 }
}
