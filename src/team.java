
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.Date;

public class team extends JFrame implements ActionListener{

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
	

	int c = 0;
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
	menu[] menuList = new menu[100];
	int menuNum=0;
	
//--------------------테이블메뉴 관련 변수--------------------------
	JPanel tableInfo = new JPanel(new GridLayout(12,2));
	JPanel[] table = new JPanel[6];

	JLabel[] tableItem = new JLabel[10];
	JLabel[] tablePrice = new JLabel[10];
	JLabel menuTitle = new JLabel("메뉴");
	JLabel priceTitle = new JLabel("가격");
	  
	JLabel[] tableTotalPrice = new JLabel[6];
	JLabel[] priceLabel = new JLabel[6];
	JButton addMenu = new JButton("추가");
	JButton cash = new JButton("결제");
	menu[][] tableMenuList = new menu[6][100];
	int[] tableMenuNum = {0,0,0,0,0,0};
	JTextField gradeAtBill = new JTextField("회원이름",5);
	  
//-----------------회원관련 변수--------------------------------------
	 //member[] memberList = new member[100];
	int memberNum = 0;
	String[][] memList = new String[100][5];
	JTextField memName = new JTextField("회원이름",10);
	JTextField memGrade = new JTextField("회원등급",10);
	JTextField phone = new JTextField("연락처",20);
	JButton goAddMem = new JButton("추가하기");
		
	JDialog addMemDialog = new JDialog();
	JDialog delMemDialog = new JDialog();
	JTextField delName = new JTextField("삭제할 이름",10);
	JButton goDel = new JButton("삭제하기");
	JDialog editMemDialog = new JDialog();
	JTextField editName = new JTextField(10);
	JTextField editGrade = new JTextField(10);
	JTextField editPhone = new JTextField(20);
	JTextField editMile = new JTextField(5);
		
//-----------------직원관련 변수-------------------------------------------

	
	
	int staffNum = 0;
	String[][] staffList = new String[100][6];
	JTextField staffName = new JTextField("이름",10);
	JTextField staffGrade = new JTextField("직급",10);
	JTextField staffSal = new JTextField("급여",10);
	JTextField staffPh = new JTextField("연락처",20);
	JButton goAddStaff = new JButton("직원추가하기");
		
	JDialog addStaffDialog = new JDialog();
	JDialog delStaffDialog = new JDialog();
	JTextField delStaffName = new JTextField("삭제할 이름",10);
	JButton goDelStaff= new JButton("직원삭제하기");
	JDialog editStaffDialog = new JDialog();
	JTextField editNameStaff = new JTextField(10);
	JTextField editSal= new JTextField(5);
	JTextField editPhoneStaff = new JTextField(20);
	JTextField editGradeStaff = new JTextField(10);
//---------------------액션리스너------------------------------------------
	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("마감")) {
			
			closingAction();
				
		}
		
		if(actionCmd.equals("종료")) {
			
			System.exit(0);
			
		}
		if(actionCmd.equals("테이블 1")) {
			
			for(int i=0;i<10;i++) {
				 tableItem[i].setText("");
				 tablePrice[i].setText("");
			 }
			for(int i=0;i<tableMenuNum[0];i++) {
				 tableItem[i].setText(tableMenuList[0][i].name);
				 tablePrice[i].setText(""+tableMenuList[0][i].price);
			 }
			
			addMenu.setText("추가1");
			addMenu.setActionCommand("추가1");
			cash.setText("결제1");
			cash.setActionCommand("결제1");
			
		}if(actionCmd.equals("테이블 2")) {
			
			for(int i=0;i<10;i++) {
				 tableItem[i].setText("");
				 tablePrice[i].setText("");
			 }
			for(int i=0;i<tableMenuNum[1];i++) {
				 tableItem[i].setText(tableMenuList[1][i].name);
				 tablePrice[i].setText(""+tableMenuList[1][i].price);
			 }
			
			addMenu.setText("추가2");
			addMenu.setActionCommand("추가2");
			cash.setText("결제2");
			cash.setActionCommand("결제2");
			
		}if(actionCmd.equals("테이블 3")) {
			
			for(int i=0;i<10;i++) {
				 tableItem[i].setText("");
				 tablePrice[i].setText("");
			 }
			for(int i=0;i<tableMenuNum[2];i++) {
				 tableItem[i].setText(tableMenuList[2][i].name);
				 tablePrice[i].setText(""+tableMenuList[2][i].price);
			 }
			
			addMenu.setText("추가3");
			addMenu.setActionCommand("추가3");
			cash.setText("결제3");
			cash.setActionCommand("결제3");
			
		}if(actionCmd.equals("테이블 4")) {
			
			for(int i=0;i<10;i++) {
				 tableItem[i].setText("");
				 tablePrice[i].setText("");
			 }
			for(int i=0;i<tableMenuNum[3];i++) {
				 tableItem[i].setText(tableMenuList[3][i].name);
				 tablePrice[i].setText(""+tableMenuList[3][i].price);
			 }
			
			addMenu.setText("추가4");
			addMenu.setActionCommand("추가4");
			cash.setText("결제4");
			cash.setActionCommand("결제4");
			
		}if(actionCmd.equals("테이블 5")) {
			
			for(int i=0;i<10;i++) {
				 tableItem[i].setText("");
				 tablePrice[i].setText("");
			 }
			for(int i=0;i<tableMenuNum[4];i++) {
				 tableItem[i].setText(tableMenuList[4][i].name);
				 tablePrice[i].setText(""+tableMenuList[4][i].price);
			 }
			
			addMenu.setText("추가5");
			addMenu.setActionCommand("추가5");
			cash.setText("결제5");
			cash.setActionCommand("결제5");
			
		}if(actionCmd.equals("테이블 6")) {
			
			for(int i=0;i<10;i++) {
				 tableItem[i].setText("");
				 tablePrice[i].setText("");
			 }
			for(int i=0;i<tableMenuNum[5];i++) {
				 tableItem[i].setText(tableMenuList[5][i].name);
				 tablePrice[i].setText(""+tableMenuList[5][i].price);
			 }
			
			addMenu.setText("추가6");
			addMenu.setActionCommand("추가6");
			cash.setText("결제6");
			cash.setActionCommand("결제6");
			
		}
		if(actionCmd.equals("추가1")) {
			
			String s = JOptionPane.showInputDialog(null,"메뉴 추가");
		   
			for(int i = 0;i<menuNum;i++) {
			   if(s.equals(menuList[i].name)) {
				   tableMenuList[0][tableMenuNum[0]] = menuList[i];
				   tableMenuNum[0]++;
				   break;
			   }
			}
			
			int t=0;
			for(int i=0;i<tableMenuNum[0];i++) {
				tableItem[i].setText(tableMenuList[0][i].name);
				tablePrice[i].setText(""+tableMenuList[0][i].price);
				t+=tableMenuList[0][i].price;
			}
			tableTotalPrice[0].setText(""+t);
			
		}if(actionCmd.equals("추가2")) {
			
			String s = JOptionPane.showInputDialog(null,"메뉴 추가");
			
			for(int i = 0;i<menuNum;i++) {
				if(s.equals(menuList[i].name)) {
					tableMenuList[1][tableMenuNum[1]] = menuList[i];
					tableMenuNum[1]++;
					break;
				}
			}
			
			int t = 0;
			for(int i=0;i<tableMenuNum[1];i++) {
				tableItem[i].setText(tableMenuList[1][i].name);
				tablePrice[i].setText(""+tableMenuList[1][i].price);
				t += tableMenuList[1][i].price;
			}
			tableTotalPrice[1].setText(""+t);
			
		}if(actionCmd.equals("추가3")) {
			
			String s = JOptionPane.showInputDialog(null,"메뉴 추가");
			for(int i = 0;i<menuNum;i++) {
				if(s.equals(menuList[i].name)) {
					tableMenuList[2][tableMenuNum[2]] = menuList[i];
					tableMenuNum[2]++;
					break;
				}
			}
			
		 	 int t=0;
		 	 for(int i=0;i<tableMenuNum[2];i++) {
		 		 tableItem[i].setText(tableMenuList[2][i].name);
		 		 tablePrice[i].setText(""+tableMenuList[2][i].price);
		 		 t += tableMenuList[2][i].price;
		 	 }
		 	 tableTotalPrice[2].setText(""+t);
		 	 
		}if(actionCmd.equals("추가4")) {
			
			String s = JOptionPane.showInputDialog(null,"메뉴 추가");
		   
			for(int i = 0;i<menuNum;i++) {
				if(s.equals(menuList[i].name)) {
					tableMenuList[3][tableMenuNum[3]] = menuList[i];
					tableMenuNum[3]++;
					break;
				}
			}
			
			int t = 0;
			for(int i=0;i<tableMenuNum[3];i++) {
				tableItem[i].setText(tableMenuList[3][i].name);
				tablePrice[i].setText(""+tableMenuList[3][i].price);
				t+=tableMenuList[3][i].price;
			}
			tableTotalPrice[3].setText(""+t);
			
		}if(actionCmd.equals("추가5")) {
			
			String s = JOptionPane.showInputDialog(null,"메뉴 추가");
		   
			for(int i = 0;i<menuNum;i++) {
				if(s.equals(menuList[i].name)) {
					tableMenuList[4][tableMenuNum[4]] = menuList[i];
					tableMenuNum[4]++;
					break;
				}
			}
			
			int t = 0;
			for(int i=0;i<tableMenuNum[4];i++) {
				tableItem[i].setText(tableMenuList[4][i].name);
				tablePrice[i].setText(""+tableMenuList[4][i].price);
				t+=tableMenuList[4][i].price;
			}
			tableTotalPrice[4].setText(""+t);
			
		}if(actionCmd.equals("추가6")) {
			
			String s = JOptionPane.showInputDialog(null,"메뉴 추가");
		   
			for(int i = 0;i<menuNum;i++) {
				if(s.equals(menuList[i].name)) {
					tableMenuList[5][tableMenuNum[5]] = menuList[i];
					tableMenuNum[5]++;
					break;
				   }
			}
			
		   int t = 0;
		   for(int i=0;i<tableMenuNum[5];i++) {
			   tableItem[i].setText(tableMenuList[5][i].name);
			   tablePrice[i].setText(""+tableMenuList[5][i].price);
			   t+=tableMenuList[5][i].price;
		   }
		   tableTotalPrice[5].setText(""+t);
		   
		}if(actionCmd.equals("결제1")) {
		
			double d = 1;
			String s = gradeAtBill.getText();
			gradeAtBill.setText("회원이름");
			
			int tp = 0;
			for(int i=0;i<tableMenuNum[0];i++) 
				tp += tableMenuList[0][i].price;
			
			
			for(int i=0;i<memberNum;i++) {
				if(s.equals(memList[i][2])) {
					
					int cp = Integer.parseInt(memList[i][3]);
					cp += tp*0.02;
					memList[i][3] = ""+cp;
					if(memList[i][1].equals("normal")) 
						d = 0.98;
					
					else if(memList[i][1].equals("gold"))
						d = 0.95;
					else if(memList[i][1].equals("platinum"))
						d = 0.9;
					break;
					
				}
			}
			
			for(int i=0;i<tableMenuNum[0];i++) {
				
				revenue += tableMenuList[0][i].price * d;
				tableMenuList[0][i] = new menu();
				tableItem[i].setText("");
				tablePrice[i].setText("");
				
			}
			tableMenuNum[0] = 0;
			revenueLabel.setText("오늘 매출: " + revenue + "원/");
			tableTotalPrice[0].setText("빈테이블");
			
		}if(actionCmd.equals("결제2")) {
			
			double d = 1;
			String s = gradeAtBill.getText();
			gradeAtBill.setText("회원이름");
			
			int tp = 0;
			for(int i=0;i<tableMenuNum[0];i++) 
				tp += tableMenuList[0][i].price;
			
			for(int i=0;i<memberNum;i++) {
				if(s.equals(memList[i][2])) {
					int cp = Integer.parseInt(memList[i][3]);
					cp += tp*0.02;
					memList[i][3] = ""+cp;
					if(memList[i][1].equals("normal"))
						d = 0.98;
					else if(memList[i][1].equals("gold"))
						d = 0.95;
					else if(memList[i][1].equals("platinum"))
						d = 0.9;
					break;
				}
			}
			for(int i=0;i<tableMenuNum[1];i++) {
				revenue += tableMenuList[1][i].price * d;
				tableMenuList[1][i] = new menu();
				tableItem[i].setText("");
				tablePrice[i].setText("");
			}
			tableMenuNum[1] = 0;
			revenueLabel.setText("오늘 매출: " + revenue + "원/");
			tableTotalPrice[1].setText("빈테이블");
			
		}if(actionCmd.equals("결제3")) {
			
			double d = 1;
			String s = gradeAtBill.getText();
			gradeAtBill.setText("회원이름");
			
			int tp = 0;
			for(int i=0;i<tableMenuNum[0];i++) 
				tp += tableMenuList[0][i].price;
			
			for(int i=0;i<memberNum;i++) {
				if(s.equals(memList[i][2])) {
					int cp = Integer.parseInt(memList[i][3]);
					cp += tp*0.02;
					memList[i][3] = ""+cp;
					if(memList[i][1].equals("normal"))
						d = 0.98;
					else if(memList[i][1].equals("gold"))
						d = 0.95;
					else if(memList[i][1].equals("platinum"))
						d = 0.9;
					break;
				}
			}
			for(int i=0;i<tableMenuNum[2];i++) {
				revenue += tableMenuList[2][i].price * d;
				tableMenuList[2][i] = new menu();
				tableItem[i].setText("");
				tablePrice[i].setText("");
			}
			tableMenuNum[2] = 0;
			revenueLabel.setText("오늘 매출: " + revenue + "원/");
			tableTotalPrice[2].setText("빈테이블");
			
		}if(actionCmd.equals("결제4")) {
			
			double d = 1;
			String s = gradeAtBill.getText();
			gradeAtBill.setText("회원이름");
			
			int tp = 0;
			for(int i=0;i<tableMenuNum[0];i++) 
				tp += tableMenuList[0][i].price;
			
			for(int i=0;i<memberNum;i++) {
				if(s.equals(memList[i][2])) {
					int cp = Integer.parseInt(memList[i][3]);
					cp += tp*0.02;
					memList[i][3] = ""+cp;
					if(memList[i][1].equals("normal"))
						d = 0.98;
					else if(memList[i][1].equals("gold"))
						d = 0.95;
					else if(memList[i][1].equals("platinum"))
						d = 0.9;
					break;
				}
			}
			for(int i=0;i<tableMenuNum[3];i++) {
				revenue += tableMenuList[3][i].price * d;
				tableMenuList[3][i] = new menu();
				tableItem[i].setText("");
				tablePrice[i].setText("");
			}
			tableMenuNum[3] = 0;
			revenueLabel.setText("오늘 매출: " + revenue + "원/");
			tableTotalPrice[3].setText("빈테이블");
			
		}if(actionCmd.equals("결제5")) {
			
			double d = 1;
			String s = gradeAtBill.getText();
			gradeAtBill.setText("회원이름");
			
			int tp = 0;
			for(int i=0;i<tableMenuNum[0];i++) 
				tp += tableMenuList[0][i].price;
			
			for(int i=0;i<memberNum;i++) {
				if(s.equals(memList[i][2])) {
					int cp = Integer.parseInt(memList[i][3]);
					cp += tp*0.02;
					memList[i][3] = ""+cp;
					if(memList[i][1].equals("normal"))
						d = 0.98;
					else if(memList[i][1].equals("gold"))
						d = 0.95;
					else if(memList[i][1].equals("platinum"))
						d = 0.9;
					break;
				}
			}
			for(int i=0;i<tableMenuNum[4];i++) {
				revenue += tableMenuList[4][i].price * d;
				tableMenuList[4][i] = new menu();
				tableItem[i].setText("");
				tablePrice[i].setText("");
			}
			tableMenuNum[4] = 0;
			revenueLabel.setText("오늘 매출: " + revenue + "원/");
			tableTotalPrice[4].setText("빈테이블");
			
		}if(actionCmd.equals("결제6")) {
			
			double d = 1;
			String s = gradeAtBill.getText();
			gradeAtBill.setText("회원이름");
			int tp = 0;
			for(int i=0;i<tableMenuNum[0];i++) {
				tp += tableMenuList[0][i].price;
			}
			for(int i=0;i<memberNum;i++) {
				if(s.equals(memList[i][2])) {
					int cp = Integer.parseInt(memList[i][3]);
					cp += tp*0.02;
					memList[i][3] = ""+cp;
					if(memList[i][1].equals("normal"))
						d = 0.98;
					else if(memList[i][1].equals("gold"))
						d = 0.95;
					else if(memList[i][1].equals("platinum"))
						d = 0.9;
					break;
				}
			}
			for(int i=0;i<tableMenuNum[5];i++) {
				revenue += tableMenuList[5][i].price * d;
				tableMenuList[5][i] = new menu();
				tableItem[i].setText("");
				tablePrice[i].setText("");
			}
			tableMenuNum[5] = 0;
			revenueLabel.setText("오늘 매출: " + revenue + "원/");
			tableTotalPrice[5].setText("빈테이블");
			
		}if(actionCmd.equals("회원추가")) {
			
			addMemDialog.setModal(true);
			addMemDialog.setVisible(true);
			
		}if(actionCmd.equals("추가하기")) {
			
			addMemDialog.setVisible(false);
			memList[memberNum][0] = ""+(memberNum+1);
			memList[memberNum][1] = memGrade.getText();
			memList[memberNum][2] = memName.getText();
			memList[memberNum][3] = ""+0;
			memList[memberNum][4] = phone.getText();
			
			memberNum++;
			
		}if(actionCmd.equals("회원삭제") && memberNum > 0) {
			
			delMemDialog.setModal(true);
			delMemDialog.setVisible(true);
			
		}if(actionCmd.equals("삭제하기")) {
			
			delMemDialog.setVisible(false);
			
			for(int i = 0;i<memberNum;i++) {
				if(memList[i][2].equals(delName.getText())){
					
					for(int j = i;j<memberNum-1;j++) {
						for(int k=1;k<5;k++)
							memList[j][k] = memList[j+1][k];					
					}
					for(int k=0;k<5;k++)
						memList[memberNum-1][k] = null;
					memberNum--;
					break;
				}
			}
			
		}if(actionCmd.equals("회원편집")){
			
			
		}if(actionCmd.equals("직원추가")) {
			
			addStaffDialog.setModal(true);
			addStaffDialog.setVisible(true);
			
		}if(actionCmd.equals("직원추가하기")) {
			
			addStaffDialog.setVisible(false);
			staffList[staffNum][0] = ""+(staffNum+1);
			staffList[staffNum][1] = staffName.getText();
			staffList[staffNum][2] = staffSal.getText();
			staffList[staffNum][3] = staffGrade.getText();
			staffList[staffNum][4] = dateToString();
			staffList[staffNum][5] = staffPh.getText();
			
			
			staffNum++;
		}if(actionCmd.equals("직원삭제") && staffNum > 0) {
			
			delStaffDialog.setModal(true);
			delStaffDialog.setVisible(true);
			
		}if(actionCmd.equals("직원삭제하기")) {
			
			delStaffDialog.setVisible(false);
			
			for(int i = 0;i<staffNum;i++) {
				if(staffList[i][1].equals(delStaffName.getText())){
					
					for(int j = i;j<staffNum-1;j++) {
						for(int k=1;k<6;k++)
							staffList[j][k] = staffList[j+1][k];					
					}
					for(int k=0;k<6;k++)
						staffList[staffNum-1][k] = null;
					staffNum--;
					break;
				}
			}
		}
		
	}
	public void closingAction() {
		date.setDate(date.getDate()+1);
		dateLabel.setText(date.getYear() + "년 " + date.getMonth() + "월 " + date.getDate() + "일");
	}
	public String dateToString() {
		return (date.getYear() + "년 " + date.getMonth() + "월 " + date.getDate() + "일");
	}
	public team() {
		
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		menuList[0] = new menu("menu 1",1000);
		menuList[1] = new menu("menu 2",2000);
		menuList[2] = new menu("menu 3",3000);
		menuNum = 3;
		
		//basicPanel.setLayout(new GridLayout(2,2));
		closingPanel.setLayout(new FlowLayout());
		JButton closingButton = new JButton("마감");
		closingButton.addActionListener(this);
		closingPanel.add(dateLabel);
		closingPanel.add(closingButton);
		
		
		basicPanel.add(closingPanel);
		
		moneyPanel.setLayout(new FlowLayout());
		moneyPanel.add(revenueLabel);
		moneyPanel.add(balanceLabel);
		basicPanel.add(moneyPanel,BorderLayout.NORTH);
		
		
//--------------table메뉴-------------------------------------------------------------		
		
		
		JPanel bigTable = new JPanel();
		
		
		  JPanel tablePanel = new JPanel();
	
		  
		  tablePanel.setLayout(new GridLayout(3,2));
		  
		  
		  

		  addMenu.addActionListener(this);
		  cash.addActionListener(this);
		  
		  for(int i=0;i<6;i++) {
			  
			  table[i] = new JPanel();
			  table[i].add(new JLabel("table" + (i+1)),BorderLayout.NORTH);
			  
			  tableTotalPrice[i] = new JLabel("빈테이블");
			  table[i].add(tableTotalPrice[i],BorderLayout.CENTER);
			  
			  JButton temp = new JButton("테이블 "+(i+1));
			  temp.addActionListener(this);
			  table[i].add(temp,BorderLayout.SOUTH);
			  
		  }
		  
		  for(int i=0;i<6;i++) {
			  tablePanel.add(table[i]);
		  }
		  
		  
		  for(int i=0;i<10;i++) {
			  tableItem[i] = new JLabel();
			  tablePrice[i] = new JLabel();
		  }
		  
		  
		  tableInfo.add(menuTitle);
		  tableInfo.add(priceTitle);
		  for(int i=0;i<10;i++) {
			  tableInfo.add(tableItem[i]);
			  tableInfo.add(tablePrice[i]);
			  
		  }
		 tableInfo.add(addMenu);
		 tableInfo.add(cash);
		 tableInfo.add(gradeAtBill);
		  
		  
		  bigTable.add(tablePanel,BorderLayout.WEST);
		  bigTable.add(tableInfo,BorderLayout.EAST);
		 
		  
		  selectPanel.addTab("테이블",bigTable);
//----------------------------------------------------------------------------		
		  
		  
		  
		  
		  JPanel warePanel = new JPanel();
		  selectPanel.addTab("창고", warePanel);
		  
		  
		  
		  
//------------------회원메뉴------------------------------------		  
		  
		  
		  JPanel memberPanel = new JPanel();
		  String[] header = {"번호","등급","이름","마일리지","연락처"};
		  
		  JTable memberTable = new JTable(memList,header);
		  memberTable.getColumn("번호").setPreferredWidth(10);
		  memberTable.getColumn("이름").setPreferredWidth(40);
		  memberTable.getColumn("마일리지").setPreferredWidth(20);
		  memberTable.getColumn("등급").setPreferredWidth(50);
		  memberTable.getColumn("연락처").setPreferredWidth(100);
		  JScrollPane memberScroll = new JScrollPane(memberTable);
		  JButton editMember = new JButton("회원편집");
		  editMember.addActionListener(this);
		  addMemDialog.setLayout(new FlowLayout());
		  addMemDialog.setSize(500,100);
		  goAddMem.addActionListener(this);
		  addMemDialog.add(memName);
		  addMemDialog.add(memGrade);
		  addMemDialog.add(phone);
		  addMemDialog.add(goAddMem);
			
		  JButton addMember = new JButton("회원추가");
		  addMember.addActionListener(this);
		  delMemDialog.setLayout(new FlowLayout());
		  delMemDialog.setSize(500,100);
		  goDel.addActionListener(this);
		  delMemDialog.add(delName);
		  delMemDialog.add(goDel);
		  JButton delMember = new JButton("회원삭제");
		  delMember.addActionListener(this);
		  memberPanel.add(memberScroll);
		  memberPanel.add(editMember);
		  memberPanel.add(delMember);
		  memberPanel.add(addMember);
		  
		  
		  selectPanel.addTab("회원", memberPanel);
		  
		  
		  
		  
//--------------------------------------------------------------------		  
		  
		  
		  JLabel menuLabel = new JLabel("메뉴");
		  JPanel menuPanel = new JPanel();
		  menuPanel.add(menuLabel);
		  selectPanel.addTab("메뉴", menuPanel);
		  
		  
		  
		  
		  
//-------------------------직원---------------------------------------	  
		  
		  
		  
		  
		  
		  JPanel staffPanel = new JPanel();
		  String[] headerStaff = {"번호","이름","급여","직급","입사일","연락처"};
		  
		  JTable staffTable = new JTable(staffList,headerStaff);
		  staffTable.getColumn("번호").setPreferredWidth(10);
		  staffTable.getColumn("이름").setPreferredWidth(40);
		  staffTable.getColumn("급여").setPreferredWidth(20);
		  staffTable.getColumn("직급").setPreferredWidth(50);
		  staffTable.getColumn("입사일").setPreferredWidth(100);
		  staffTable.getColumn("연락처").setPreferredWidth(100);
		  JScrollPane staffScroll = new JScrollPane(staffTable);
		  JButton editStaff = new JButton("직원편집");
		  editStaff.addActionListener(this);
		  addStaffDialog.setLayout(new FlowLayout());
		  addStaffDialog.setSize(500,100);
		  goAddStaff.addActionListener(this);
		  addStaffDialog.add(staffName);
		  addStaffDialog.add(staffGrade);
		  addStaffDialog.add(staffPh);
		  addStaffDialog.add(goAddStaff);
			
		  JButton addStaff = new JButton("직원추가");
		  addStaff.addActionListener(this);
		  delStaffDialog.setLayout(new FlowLayout());
		  delStaffDialog.setSize(500,100);
		  goDelStaff.addActionListener(this);
		  delStaffDialog.add(delStaffName);
		  delStaffDialog.add(goDelStaff);
		  JButton delStaff = new JButton("직원삭제");
		  delStaff.addActionListener(this);
		  staffPanel.add(staffScroll);
		  staffPanel.add(editStaff);
		  staffPanel.add(delStaff);
		  staffPanel.add(addStaff);
		  
		  
		  selectPanel.addTab("직원", staffPanel);
		  

//-----------------------------------------------------------------------		
		

		
		basicPanel.add(selectPanel,BorderLayout.SOUTH);

		
		JButton exitButton = new JButton("종료");
		exitPanel.add(exitButton);
		exitButton.addActionListener(this);
		basicPanel.add(exitPanel);
		
		add(basicPanel);
	}
	
	public static void main(String[] args) {
		team frame = new team();
		frame.setVisible(true);
		
	}
}
