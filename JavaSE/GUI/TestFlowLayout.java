/*
 用于测试FlowLayout
*/

import java.awt.*;
public class TestFlowLayout{
	public static void main(String [] args) throws Exception {
		Frame f=  new Frame("uTorrent");
		Button a = new Button("开始新游戏");
		Button b = new Button("继续游戏");
		Button c = new Button("退出");
		f.setLayout(new FlowLayout());
		f.add(a);f.add(b);f.add(c);
		f.setVisible(true);
		Frame f2 = new Frame("JAVA");
		FlowLayout t = new FlowLayout(FlowLayout.CENTER,20,10);
		f2.setLayout(t);
		for(int i = 0;i<8;i++){
			f2.add(new Button("START"));
		}
		f2.setSize(500,500);
		f2.setVisible(true);
	}
}