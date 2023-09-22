package org.zhy.daily;

/**
 * 2591. 将钱分给最多的儿童
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 * 你需要按照如下规则分配：
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 */
public class LeetCode2591 {

    public int distMoney(int money, int children) {
        if (money < children) {
            // 钱小于儿童数，无法满足至少每人一块，返回-1
            return -1;
        }
        // 每个孩子先分一块，满足第二个条件
        money -= children;
        // 将剩余的钱给尽可能多的孩子再分配七块钱，凑到八块
        int eightOwners = Math.min(money / 7, children);
        // 减去再次分出去的钱
        money -= eightOwners * 7;
        // 剩下没有拿到八块钱的孩子数量
        children -= eightOwners;
        // 所有孩子都得到八块钱但还剩钱，不满足第一个条件；剩下的钱给某一个孩子，八块钱孩子数少一个
        // 还有一个孩子没拿到八块钱且刚好剩三块钱，为了满足第一个条件，钱都给剩下的孩子，得到了四块钱，不满足第三个条件。因此前面一个孩子不能拿八块钱，得分至少一块钱出来给最后一个孩子，因此八块钱孩子数少一个。
        if (children == 0 && money > 0 || children == 1 && money == 3) {
            eightOwners--;
        }
        return eightOwners;
    }
}
