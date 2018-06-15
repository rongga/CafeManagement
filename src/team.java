import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class team extends JFrame implements ActionListener{

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
	
	Date date = new Date(2017,1,1);
	private int revenue = 0;
	private int balance = 0;
	
	JPanel basicPanel = new JPanel();
	
	JPanel closingPanel = new JPanel();
	JLabel dateLabel = new JLabel(date.getYear() + "년 " + date.getMonth() + "월 " + date.getDate() + "일");
	
	JPanel moneyPanel = new JPanel();
	JLabel revenueLabel = new JLabel("오늘 매출: " + revenue + "원/");
	JLabel balanceLabel = new JLabel("전체 잔고: " + balance + "원");
	
	JTabbedPane selectPanel = new JTabbedPane();
	
	JPanel exitPanel = new JPanel();
	
	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("마감")) {
			closingAction();
		}
		
		if(actionCmd.equals("종료")) {
			System.exit(0);
		}
		
	}
	public void closingAction() {
		date.setDate(date.getDate()+1);
		dateLabel.setText(date.getYear() + "년 " + date.getMonth() + "월 " + date.getDate() + "일");
	}
	public team() {
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		basicPanel.setLayout(new GridLayout(2,2));
		closingPanel.setLayout(new FlowLayout());
		JButton closingButton = new JButton("마감");
		closingButton.addActionListener(this);
		closingPanel.add(dateLabel);
		closingPanel.add(closingButton);
		basicPanel.add(closingPanel);
		
		moneyPanel.setLayout(new FlowLayout());
		moneyPanel.add(revenueLabel);
		moneyPanel.add(balanceLabel);
		basicPanel.add(moneyPanel);
		
		
		
		
		//selectPanel.setLayout(new FlowLayout());
		  JTable table = new JTable(2,3);
		  JButton btn = new JButton("button");
		  table.setValueAt("no.1", 0, 0);
		  table.setValueAt("no.2", 0, 1);
		  table.setValueAt("no.3", 0, 2);
		  table.setValueAt("no.4", 1, 0);
		  table.setValueAt("no.5", 1, 2);
		  
		  table.add(btn,1,1);

		  table.setShowHorizontalLines(true);
		  table.setShowVerticalLines(true);
		  selectPanel.addTab("테이블", table);
		  
		  
		  
		  
		  
		  JPanel warePanel = new JPanel();
		  selectPanel.addTab("창고", warePanel);
		  
		  
		  
		  
		  
		  
		  JLabel memberLabel = new JLabel("회원");
		  JPanel memberPanel = new JPanel();
		  memberPanel.add(memberLabel);
		  selectPanel.addTab("회원", memberPanel);
		  
		  
		  
		  
		  
		  
		  
		  JLabel menuLabel = new JLabel("메뉴");
		  JPanel menuPanel = new JPanel();
		  menuPanel.add(menuLabel);
		  selectPanel.addTab("메뉴", menuPanel);
		  
		  
		  
		  
		  
		  
		  
		  
		  JLabel staffLabel = new JLabel("직원");
		  JPanel staffPanel = new JPanel();
		  staffPanel.add(staffLabel);
		  selectPanel.addTab("직원",staffPanel);
		  

		
		
//		JLabel tableButton = new JLabel("테이블");
//		JLabel wareButton = new JLabel("창고");
//		JLabel memberButton = new JLabel("회원");
//		JLabel menuButton = new JLabel("메뉴");
//		JLabel staffButton = new JLabel("직원");
//		selectPanel.addTab("1",tableButton);
//		selectPanel.addTab("2",wareButton);
//		selectPanel.addTab("3",memberButton);
//		selectPanel.addTab("4",menuButton);
//		selectPanel.addTab("5",staffButton);
		
		basicPanel.add(selectPanel);

		
		JButton exitButton = new JButton("종료");
		exitPanel.add(exitButton);
		exitButton.addActionListener(this);
		basicPanel.add(exitPanel);
		
		add(basicPanel,BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		team frame = new team();
		frame.setVisible(true);
		
	}
}
