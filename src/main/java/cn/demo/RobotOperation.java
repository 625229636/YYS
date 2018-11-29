package cn.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class RobotOperation {
    public static void mouseOp(double startX, double startY, double secX, double secY, double endX, double endY, double timeInterval, double timeWait, double timeStart, double timeEnd) {
        Random rand = new Random();
        try {
            Robot rbt = new Robot();
            rbt.delay((int) timeInterval + rand.nextInt(100));
            KeyFrame.state.setText("点击yys1经验结算");
            rbt.mouseMove((int) startX, (int) startY);
            rbt.delay(300);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);
            rbt.delay(200);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);
            rbt.delay((int) timeInterval);

            KeyFrame.state.setText("点击yys2经验结算");
            rbt.mouseMove((int) secX, (int) secY);
            rbt.delay(300);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);
            rbt.delay(200);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);
            rbt.delay((int) timeWait + rand.nextInt(500));

            KeyFrame.state.setText("点击yys1御魂结算");
            rbt.mouseMove((int) startX, (int) startY);
            rbt.delay(300);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);
            rbt.delay((int) timeInterval);
            rbt.delay(200);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);

            KeyFrame.state.setText("点击yys2御魂结算");
            rbt.mouseMove((int) secX, (int) secY);
            rbt.delay(300);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);
            rbt.delay(200);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);
            int time1 = (int) timeStart + rand.nextInt(500);
            KeyFrame.state.setText("等待点击开始 " + time1 + "ms");
            rbt.delay(time1);

            rbt.mouseMove((int) endX, (int) endY);
            rbt.delay(300);
            rbt.mousePress(1024);
            rbt.mouseRelease(1024);

            int time2 = (int) timeEnd + rand.nextInt(500);
            KeyFrame.state.setText("等待点击结算 " + time2 + "ms");
            rbt.delay(time2);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}