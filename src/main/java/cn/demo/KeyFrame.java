package cn.demo;

import com.melloware.jintellitype.JIntellitype;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyFrame extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;
    private JLabel startLabel = new JLabel("鼠标初始位置");
    private JTextArea startArea = new JTextArea();
    private JLabel secLabel = new JLabel("鼠标第二次点击");
    private JTextArea secArea = new JTextArea();
    private JLabel endLabel = new JLabel("鼠标最终位置");
    private JTextArea endArea = new JTextArea();
    private JLabel timeLabel = new JLabel("请输入每个周期时间范围(s)");
    private JLabel space = new JLabel("");
    private JLabel minTimeLabel = new JLabel("请输入最小时间(s)");
    private JLabel maxTimeLabel = new JLabel("请输入最大时间(s)");
    private JLabel timeIntervalLabel = new JLabel("切换yys时间间隔(s)");
    private JLabel timeWaitLabel = new JLabel("结算页面间隔(s)");
    private JLabel timeStartLabel = new JLabel("结算-点击开始间隔(s)");
    private JLabel timeEndLabel = new JLabel("开始-结算间隔(s)");
    private JLabel timesLabel = new JLabel("请输入周期次数");
    private JLabel lessTimes = new JLabel("剩余次数");
    private JTextField minTimeTextField = new JTextField();
    private JTextField maxTimeTextField = new JTextField();
    private JTextField timeIntervalTextField = new JTextField();
    private JTextField timeWaitField = new JTextField();
    private JTextField timeStartField = new JTextField();
    private JTextField timeEndField = new JTextField();
    private JTextField timesTextField = new JTextField();
    private JLabel lessTimeArea = new JLabel();

    public static JLabel state = new JLabel("当前状态");
    double pointY = 0.0D;
    double pointX = 0.0D;
    double startX = 0.0D;
    double startY = 0.0D;
    double secX = 0.0D;
    double secY = 0.0D;
    double endX = 0.0D;
    double endY = 0.0D;
    boolean autoFlag = false;
    double minTime = 1000.0D;
    double maxTime = 2000.0D;
    double timeInterval = 300.0D;
    double timeWait = 2000.0D;
    double timeStart = 5000.0D;
    double timeEnd = 35000.0D;
    int n = 0;
    int i = 0;

    public void showPanel() {
        setSize(500, 300);
        setDefaultCloseOperation(3);
        JPanel panel = new JPanel();
        this.startArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        this.secArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        this.endArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        this.lessTimeArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        panel.setLayout(new GridLayout(16, 2));
        panel.add(this.startLabel);
        panel.add(this.startArea);
        panel.add(this.secLabel);
        panel.add(this.secArea);
        panel.add(this.endLabel);
        panel.add(this.endArea);
        panel.add(this.timeLabel);
        panel.add(this.space);
        panel.add(this.minTimeLabel);
        panel.add(this.minTimeTextField);
        panel.add(this.maxTimeLabel);
        panel.add(this.maxTimeTextField);
        panel.add(this.timeIntervalLabel);
        panel.add(this.timeIntervalTextField);
        panel.add(this.timeWaitLabel);
        panel.add(this.timeWaitField);
        panel.add(this.timeStartLabel);
        panel.add(this.timeStartField);
        panel.add(this.timeEndLabel);
        panel.add(this.timeEndField);
        panel.add(this.timesLabel);
        panel.add(this.timesTextField);
        panel.add(this.lessTimes);
        panel.add(this.lessTimeArea);

        JLabel metionLabel1 = new JLabel("F1确认鼠标初始位置");
        JLabel metionLabel2 = new JLabel("F2确认鼠标第二位置");
        JLabel metionLabel3 = new JLabel("F3确认鼠标最终位置");
        JLabel metionLabel4 = new JLabel("");
        JLabel metionLabel5 = new JLabel("F4开始结束 ");
        JLabel metionLabel6 = new JLabel("F5退出 ");
        JLabel metionLabel7 = new JLabel("F6最小化");
        JLabel metionLabel8 = new JLabel("F7恢复窗口");

        panel.add(metionLabel1);
        panel.add(metionLabel2);
        panel.add(metionLabel3);
        panel.add(metionLabel4);
        panel.add(metionLabel5);
        panel.add(metionLabel6);
        panel.add(metionLabel7);
        panel.add(metionLabel8);

        this.minTimeTextField.setText("0.5");
        this.maxTimeTextField.setText("1");
        this.timeIntervalTextField.setText("0.3");
        this.timeWaitField.setText("2.2");
        this.timeStartField.setText("4.5");
        this.timeEndField.setText("32");
        this.timesTextField.setText("100");
        JPanel statePanel = new JPanel();
        statePanel.setLayout(new FlowLayout());
        statePanel.add(state);
        setLayout(new BorderLayout());
        add(panel, "Center");
        add(statePanel, "South");

        JIntellitype.getInstance().registerHotKey(0, 0, 112);
        JIntellitype.getInstance().registerHotKey(1, 0, 113);
        JIntellitype.getInstance().registerHotKey(2, 0, 114);
        JIntellitype.getInstance().registerHotKey(3, 0, 115);
        JIntellitype.getInstance().registerHotKey(4, 0, 116);
        JIntellitype.getInstance().registerHotKey(5, 0, 117);
        JIntellitype.getInstance().registerHotKey(6, 0, 118);
        JIntellitype.getInstance().addHotKeyListener(arg0 -> {
            Point mousePoint = MouseInfo.getPointerInfo().getLocation();
            KeyFrame.this.pointX = mousePoint.getX();
            KeyFrame.this.pointY = mousePoint.getY();
            if (arg0 == 0) {
                KeyFrame.this.startArea.setText("x:" + KeyFrame.this.pointX + "  y:" + KeyFrame.this.pointY);
                KeyFrame.this.startX = KeyFrame.this.pointX;
                KeyFrame.this.startY = KeyFrame.this.pointY;
            } else if (arg0 == 1) {
                KeyFrame.this.secArea.setText("x:" + KeyFrame.this.pointX + "  y:" + KeyFrame.this.pointY);
                KeyFrame.this.secX = KeyFrame.this.pointX;
                KeyFrame.this.secY = KeyFrame.this.pointY;
            } else if (arg0 == 2) {
                KeyFrame.this.endArea.setText("x:" + KeyFrame.this.pointX + "  y:" + KeyFrame.this.pointY);
                KeyFrame.this.endX = KeyFrame.this.pointX;
                KeyFrame.this.endY = KeyFrame.this.pointY;
            } else if ((arg0 == 3) && (!KeyFrame.this.autoFlag)) {
                if ((KeyFrame.this.secX == 0.0D) && (KeyFrame.this.secY == 0.0D)) {
                    KeyFrame.this.secX = KeyFrame.this.startX;
                    KeyFrame.this.secY = KeyFrame.this.startY;
                }
                if ((KeyFrame.this.endX == 0.0D) && (KeyFrame.this.endY == 0.0D)) {
                    KeyFrame.this.endX = KeyFrame.this.startX;
                    KeyFrame.this.endY = KeyFrame.this.startY;
                }
                try {
                    KeyFrame.this.maxTime = (Double.valueOf(KeyFrame.this.maxTimeTextField.getText()).doubleValue() * 1000.0D);
                    KeyFrame.this.minTime = (Double.valueOf(KeyFrame.this.minTimeTextField.getText()).doubleValue() * 1000.0D);
                    KeyFrame.this.timeInterval = (Double.valueOf(KeyFrame.this.timeIntervalTextField.getText()).doubleValue() * 1000.0D);
                    KeyFrame.this.timeWait = (Double.valueOf(KeyFrame.this.timeWaitField.getText()).doubleValue() * 1000.0D);
                    KeyFrame.this.timeStart = (Double.valueOf(KeyFrame.this.timeStartField.getText()).doubleValue() * 1000.0D);
                    KeyFrame.this.timeEnd = (Double.valueOf(KeyFrame.this.timeEndField.getText()).doubleValue() * 1000.0D);
                    KeyFrame.this.n = Integer.valueOf(KeyFrame.this.timesTextField.getText()).intValue();
                } catch (Exception e) {
                    KeyFrame.this.minTime = 1000.0D;
                    KeyFrame.this.maxTime = 2000.0D;
                    KeyFrame.this.timeInterval = 300.0D;
                    KeyFrame.this.timeWait = 2000.0D;
                    KeyFrame.this.timeStart = 5000.0D;
                    KeyFrame.this.timeEnd = 35000.0D;
                    KeyFrame.this.n = 10;
                }
                if ((KeyFrame.this.startX == 0.0D) && (KeyFrame.this.startY == 0.0D)) {
                    KeyFrame.this.autoFlag = false;
                } else {
                    KeyFrame.this.autoFlag = true;
                    KeyFrame.state.setText("开始执行");
                }
            } else if ((arg0 == 3) && (KeyFrame.this.autoFlag == true)) {
                KeyFrame.this.i = 0;
                KeyFrame.this.autoFlag = false;
                KeyFrame.state.setText("暂停执行");
            } else if (arg0 == 4) {
                System.exit(0);
            } else if (arg0 == 5) {
                KeyFrame.this.setExtendedState(1);
            } else if (arg0 == 6) {
                KeyFrame.this.setExtendedState(0);
            }
        });
        setTitle("yys按键精灵");
        setVisible(true);
        setAlwaysOnTop(true);
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if ((autoFlag) && (i <= n)) {
                lessTimeArea.setText(n - i + "次");
                i ++;
                double time = timeCal(minTime, maxTime);
                RobotOperation.mouseOp(this.startX * (Math.random() * 0.05D + 1.0D), this.startY * (Math.random() * 0.05D + 1.0D), this.secX * (Math.random() * 0.05D + 1.0D), this.secY * (Math.random() * 0.05D + 1.0D), this.endX * (Math.random() * 0.001D + 1.0D), this.endY * (Math.random() * 0.001D + 1.0D), this.timeInterval, this.timeWait, this.timeStart, this.timeEnd);
                try {
                    Thread.sleep((long)time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public double timeCal(double minTime, double maxTime) {
        double timeDev = maxTime - minTime;
        double time = timeDev * Math.random() + minTime;
        return time;
    }
}
