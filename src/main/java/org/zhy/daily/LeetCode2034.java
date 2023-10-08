package org.zhy.daily;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2034. 股票价格波动
 * 给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
 * 不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
 * 请你设计一个算法，实现：
 * 更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
 * 找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
 * 找到当前记录里股票的 最高价格 。
 * 找到当前记录里股票的 最低价格 。
 * 请你实现 StockPrice 类：
 * StockPrice() 初始化对象，当前无股票价格记录。
 * void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
 * int current() 返回股票 最新价格 。
 * int maximum() 返回股票 最高价格 。
 * int minimum() 返回股票 最低价格 。
 */
public class LeetCode2034 {

    class StockPrice {

        Map<Integer, Integer> map;
        PriorityQueue<int[]> maxQueue;
        PriorityQueue<int[]> minQueue;
        int curTime;

        public StockPrice() {
            map = new HashMap<>();
            maxQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        }

        public void update(int timestamp, int price) {
            map.put(timestamp, price);
            curTime = Math.max(curTime, timestamp);
            maxQueue.offer(new int[]{price, timestamp});
            minQueue.offer(new int[]{price, timestamp});
        }

        public int current() {
            return map.get(curTime);
        }

        public int maximum() {
            while (!maxQueue.isEmpty()) {
                int[] tmp = maxQueue.peek();
                if (tmp[0] == map.getOrDefault(tmp[1], -1)) {
                    return tmp[0];
                }

                maxQueue.poll();
            }

            return -1;
        }

        public int minimum() {
            while (!minQueue.isEmpty()) {
                int[] tmp = minQueue.peek();
                if (tmp[0] == map.getOrDefault(tmp[1], -1)) {
                    return tmp[0];
                }

                minQueue.poll();
            }

            return -1;
        }

    }
}
