import java.util.Scanner;

public class Main {
    // 如果你是一个领导，需要给员工分配任务，
    // 每个员工只能做一个任务（任务不能重复分配给员工），且员工都有一个能力值x ，同时每个任务都有适宜完成系数y
    // 如果y>=x,可以把任务分配给这个员工且认为该员工能完成任务。
    // 请问给定任务列表最多能有多少个员工可以完成任务。

    // 输入描述
    // 员工数组，数组的值为能力值，数组的个数为员工数量
    // 任务数组，数组的值为任务适宜的完成系数，数组的个数为任务数量
    // 输出描述
    // 能完成任务的最大员工数量

    // 样例输入
    // 1 2 3 4
    // 1 1
    // 样例输出
    // 1

    // 提示
    // 输入：
    // 1 2 3 4
    // 1 1
    // 说明：有4个员工，能力值从1-4，现在有2个任务，适宜完成系数都是1，所以只有让能力是1的员工来做这个任务，输出是1
    // 输入：
    // 1 2
    // 1 2 3
    // 说明：有2个员工，能力值从1-2，现在有3个任务，适宜完成系数是1-3，所以能力1和2的员工都能完成，输出是2

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            String str = sc.nextLine();
            String[] power = strs.split(" ");
            String[] task = str.split(" ");
            int max = 0;
            int count = 0;
            for (int i = 0; i < task.length; i++) {
                int y = Integer.parseInt(task[i]);
                count = 0;
                for (int j = 0; j < power.length; j++) {
                    int x = Integer.parseInt(power[j]);
                    if (y >= x) {
                        count++;
                        break;
                    }
                }
                if (count >= power.length) {
                    max = power.length;
                    break;
                } else {
                    if (count > max) {
                        max = count;
                    }
                }
            }
            System.out.println(max);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            String str = sc.nextLine();
            String[] power = strs.split(" ");
            String[] task = str.split(" ");
            int max = 0;
            int count = 0;
            for (int j = 0; j < task.length; j++) {
                int x = Integer.parseInt(task[j]);
                if (max < x) {
                    max = x;
                }
            }
            for (int i = 0; i < power.length; i++) {
                int y = Integer.parseInt(power[i]);
                if (max >= y) {
                    count++;
                }
                if (count >= task.length) {
                    count--;
                    continue;
                }
            }
            System.out.println(count);
        }
    }
}

class Test {
    // 题目描述：
    // 现有一张服务请求日志记录表 tbl_service_request_log，有以下关键字段：
    // ID: 记录ID，主键。
    // ServiceID：服务ID
    // RequestTime：请求时间
    // 请用一条SQL语句对该表进行数据查询操作，
    // 要求只显示每个服务请求日志中最后两天（注：不是最近两天）的请求记录。

    // 输入描述
    // select * from tbl_service_request_log limit 5;
    // +---------+----------+----------+
    // | ID | ServiceID |RequestTime |
    // +---------+----------+----------+
    // | 1 | 21 |2019-11-07 13:01:39 |
    // | 2 | 22 |2019-11-07 13:02:46 |
    // | 3 | 21 |2019-11-07 13:12:12 |
    // | 4 | 14 |2019-11-07 15:15:15 |
    // | 5 | 15 |2019-11-07 15:44:54 |
    // +---------+----------+----------+
    // 输出描述
    // 执行语句后，只显示每个服务最后两天（注：不是最近两天）的请求日志记录。

    // 样例输入
    // CREATE TABLE `tbl_service_request_log` (
    // `ID` bigint(20) NOT NULL ,
    // `ServiceID` int(11) NOT NULL,
    // `RequestTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    // PRIMARY KEY (`ID`)
    // ) ;
    // INSERT INTO `tbl_service_request_log` (`ID`, `ServiceID`, `RequestTime`) VALUES (1,21,'2019-11-07 00:01:39');
    // INSERT INTO `tbl_service_request_log` (`ID`, `ServiceID`, `RequestTime`) VALUES (2,22,'2019-11-07 09:02:39');
    // INSERT INTO `tbl_service_request_log` (`ID`, `ServiceID`, `RequestTime`) VALUES (3,21,'2019-11-07 09:12:12');
    // INSERT INTO `tbl_service_request_log` (`ID`, `ServiceID`, `RequestTime`) VALUES (4,21,'2019-11-08 10:00:15');
    // INSERT INTO `tbl_service_request_log` (`ID`, `ServiceID`, `RequestTime`) VALUES (5,21,'2019-11-09 12:39:25');
    // INSERT INTO `tbl_service_request_log` (`ID`, `ServiceID`, `RequestTime`) VALUES (6,22,'2019-11-09 13:26:47');
    // INSERT INTO `tbl_service_request_log` (`ID`, `ServiceID`, `RequestTime`) VALUES (7,22,'2019-11-10 10:01:22');
    // 样例输出
    // ID	ServiceID	RequestTime
    // 4	21	2019-11-08 10:00:15
    // 5	21	2019-11-09 12:39:25
    // 6	22	2019-11-09 13:26:47
    // 7	22	2019-11-10 10:01:22
}