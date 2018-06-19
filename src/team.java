
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class team extends JFrame implements ActionListener{

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
	

	int c = 0;
	Date date = new Date(2018,1,1);
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
	
//--------------------테이블메뉴 관련 변수--------------------------
	JPanel tableInfo = new JPanel(new GridLayout(13,2));
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
	JLabel currentTable = new JLabel("선택된 테이블");
//-----------------------재료관련 변수------------------------------
	int jaeryoNum = 0;
	String[][] jaeryoList = new String[100][6];
	JTable jaeryoTable = new JTable();
	JTextField jaeryoName = new JTextField("이름",40);
	JTextField jaeryoStock = new JTextField("재고",10);	
	JTextField jaeryoorder = new JTextField("주문",10);
	JTextField jaeryoprice = new JTextField("가격",20);
	JTextField jaeryomarket = new JTextField("판매처",40);
	JTextField jaeryomarketnum = new JTextField("연락처",40);
	
	JLabel jaenameinfoLabel = new JLabel();
	JLabel jaepriceinfoLabel = new JLabel();
	JLabel jaemarketinfoLabel = new JLabel();
	JLabel jaemarketnuminfoLabel = new JLabel();
	JLabel jaestockinfoLabel = new JLabel();
	JLabel jaeorderinfoLabel = new JLabel();
	
	JDialog addjaeryoDialog = new JDialog();
	JButton goAddjaeryo = new JButton("재료추가하기");
	
	JDialog deljaeryoDialog = new JDialog();
	JTextField deljaeryoName = new JTextField("삭제할 이름", 10);
	JButton goDeljaeryo = new JButton("재료삭제하기");
	
	JDialog jaeryoorderDialog = new JDialog();
	JTextField addjaeryoorderName = new JTextField("주문할 재료", 10);
	JTextField addjaeryoorderNum = new JTextField("주문할 수량", 10);
	JButton gojaeryoorder = new JButton("주문하기");
	
	JDialog jaeryoordercancelDialog = new JDialog();
	JTextField deljaeryoorderName = new JTextField("취소할 재료", 10);
	JButton gojaeryoordercancel = new JButton("주문취소하기");
	  
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
	JDialog editMemDialog = new JDialog();
	
	JTextField delName = new JTextField("삭제할 이름",10);
	JButton goDel = new JButton("삭제하기");
	
	JTextField editName = new JTextField("이름",10);
	JTextField editGrade = new JTextField("등급",10);
	JTextField editPhone = new JTextField("연락처",20);
	JTextField editMile = new JTextField("마일리지",5);
	JLabel editMemNum = new JLabel();
	
	JTable memberTable;
//-----------------메뉴관련 변수-------------------------------------------
	
	menu[] menuList = new menu[10];
	int menuNum=0;
	
	JButton[] menuButton = new JButton[10];
		
	JDialog addmenuDialog = new JDialog();
	JTextField addmenuName = new JTextField("메뉴 이름", 10);
	JTextField addmenuprice = new JTextField("가격", 10);
	JTextField addmenurecipe = new JTextField("재료 이름", 30);
	
	JButton goAddmenu = new JButton("메뉴추가하기");
	
	JDialog[] menuDialog = new JDialog[10];
	JTextField[] menunametext = new JTextField[10];
	JLabel[] menuprice = new JLabel[10];
	JTextField[] menupricetext = new JTextField[10];
	JLabel[] menuorigin = new JLabel[10];
	JTextField[] menujaetext = new JTextField[10];
	
	JButton delmenuButton[] = new JButton[10];
	JButton changemenuButton[] = new JButton[10];

	
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
	JDialog editStaffDialog = new JDialog();
	
	JTextField delStaffName = new JTextField("삭제할 이름",10);
	JButton goDelStaff= new JButton("직원삭제하기");
	JTextField editNameStaff = new JTextField(10);
	JTextField editSal= new JTextField(5);
	JTextField editPhoneStaff = new JTextField(20);
	JTextField editGradeStaff = new JTextField(10);
	JTextField editDateStaff = new JTextField(30);
	JLabel editStaffNum = new JLabel();
	JTable staffTable;
//---------------------액션리스너------------------------------------------
	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("마감")) {
			
			closingAction();
				
		}
		
		if(actionCmd.equals("종료")) {
			
			System.exit(0);
			
		} if (actionCmd.equals("불러오기")) {
			
			Scanner inputStream = null;
			
			try {
				inputStream = new Scanner(new FileInputStream("save.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (inputStream != null) {
				date.setYear(inputStream.nextInt());
				date.setMonth(inputStream.nextInt());
				date.setDate(inputStream.nextInt());
				balance = inputStream.nextInt();
				
				int loopNum = inputStream.nextInt();
				for(int i=0;i<loopNum;i++) {
	            		for(int j=0;j<6;j++) {
	            			jaeryoList[i][j] = inputStream.next();
	            		}
	            }
				
				loopNum = inputStream.nextInt();
				for(int i=0;i<loopNum;i++) {
	            		for(int j=0;j<5;j++) {
	            			memList[i][j] = inputStream.next();
	            		}
	            }
				
				dateLabel.setText(date.getYear() + "년 " + date.getMonth() + "월 " + date.getDate() + "일");
				balanceLabel.setText("전체 잔고: " + balance + "원");
			}
			
			
			
		}if(actionCmd.equals("테이블 1")) {
			
			currentTable.setText(actionCmd);
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
			
			currentTable.setText(actionCmd);
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
			
			currentTable.setText(actionCmd);
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
			
			currentTable.setText(actionCmd);
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
			
			currentTable.setText(actionCmd);
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
			
			currentTable.setText(actionCmd);
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
				   StringTokenizer recipetoken = new StringTokenizer(menuList[i].jae, " ");
				   int recipecount = recipetoken.countTokens();
				   for(int j = 0;j<recipecount;j++) {
					   String smalljae = recipetoken.nextToken();
					   for(int k = 0;k<jaeryoNum;k++) {
						   
						   if(smalljae.equals(jaeryoList[k][0])) {
							   
							   if(Integer.parseInt(jaeryoList[k][1]) == 0) {
								   JOptionPane.showMessageDialog(this,"재료 부족");
								   return;
							   }
						   }
					   }
				   }
				   recipetoken = new StringTokenizer(menuList[i].jae, " ");
				   for(int j = 0;j<recipecount;j++) {
					   String smalljae = recipetoken.nextToken();
					   for(int k = 0;k<jaeryoNum;k++) {
						   if(smalljae.equals(jaeryoList[k][0])) {
							   jaeryoList[k][1] = ""+(Integer.parseInt(jaeryoList[k][1])-1);
							   
						   }
					   }
				   }
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
					StringTokenizer recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   int recipecount = recipetoken.countTokens();
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   
							   if(smalljae.equals(jaeryoList[k][0])) {
								   
								   if(Integer.parseInt(jaeryoList[k][1]) == 0) {
									   JOptionPane.showMessageDialog(this,"재료 부족");
									   return;
								   }
							   }
						   }
					   }
					   recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   if(smalljae.equals(jaeryoList[k][0])) {
								   jaeryoList[k][1] = ""+(Integer.parseInt(jaeryoList[k][1])-1);
								   
							   }
						   }
					   }
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
					StringTokenizer recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   int recipecount = recipetoken.countTokens();
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   
							   if(smalljae.equals(jaeryoList[k][0])) {
								   
								   if(Integer.parseInt(jaeryoList[k][1]) == 0) {
									   JOptionPane.showMessageDialog(this,"재료 부족");
									   return;
								   }
							   }
						   }
					   }
					   recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   if(smalljae.equals(jaeryoList[k][0])) {
								   jaeryoList[k][1] = ""+(Integer.parseInt(jaeryoList[k][1])-1);
								   
							   }
						   }
					   }
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
					StringTokenizer recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   int recipecount = recipetoken.countTokens();
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   
							   if(smalljae.equals(jaeryoList[k][0])) {
								   
								   if(Integer.parseInt(jaeryoList[k][1]) == 0) {
									   JOptionPane.showMessageDialog(this,"재료 부족");
									   return;
								   }
							   }
						   }
					   }
					   recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   if(smalljae.equals(jaeryoList[k][0])) {
								   jaeryoList[k][1] = ""+(Integer.parseInt(jaeryoList[k][1])-1);
								   
							   }
						   }
					   }
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
					StringTokenizer recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   int recipecount = recipetoken.countTokens();
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   
							   if(smalljae.equals(jaeryoList[k][0])) {
								   
								   if(Integer.parseInt(jaeryoList[k][1]) == 0) {
									   JOptionPane.showMessageDialog(this,"재료 부족");
									   return;
								   }
							   }
						   }
					   }
					   recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   if(smalljae.equals(jaeryoList[k][0])) {
								   jaeryoList[k][1] = ""+(Integer.parseInt(jaeryoList[k][1])-1);
								   
							   }
						   }
					   }
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
					StringTokenizer recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   int recipecount = recipetoken.countTokens();
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   
							   if(smalljae.equals(jaeryoList[k][0])) {
								   
								   if(Integer.parseInt(jaeryoList[k][1]) == 0) {
									   JOptionPane.showMessageDialog(this,"재료 부족");
									   return;
								   }
							   }
						   }
					   }
					   recipetoken = new StringTokenizer(menuList[i].jae, " ");
					   for(int j = 0;j<recipecount;j++) {
						   String smalljae = recipetoken.nextToken();
						   for(int k = 0;k<jaeryoNum;k++) {
							   if(smalljae.equals(jaeryoList[k][0])) {
								   jaeryoList[k][1] = ""+(Integer.parseInt(jaeryoList[k][1])-1);
								   
							   }
						   }
					   }
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
			for(int i=0;i<tableMenuNum[1];i++) 
				tp += tableMenuList[1][i].price;
			
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
			for(int i=0;i<tableMenuNum[2];i++) 
				tp += tableMenuList[2][i].price;
			
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
			for(int i=0;i<tableMenuNum[3];i++) 
				tp += tableMenuList[3][i].price;
			
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
			for(int i=0;i<tableMenuNum[4];i++) 
				tp += tableMenuList[4][i].price;
			
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
			for(int i=0;i<tableMenuNum[5];i++) {
				tp += tableMenuList[5][i].price;
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
			
			memName.setText("회원이름");
			memGrade.setText("회원등급");
			phone.setText("연락처");
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
			
		}if(actionCmd.equals("회원편집") && (memberTable.getSelectedRow() < memberNum)){
			
			editMemNum.setText(memList[memberTable.getSelectedRow()][0]);
			editName.setText(memList[memberTable.getSelectedRow()][2]);
			editGrade.setText(memList[memberTable.getSelectedRow()][1]);
			editMile.setText(memList[memberTable.getSelectedRow()][3]);
			editPhone.setText(memList[memberTable.getSelectedRow()][4]);
			editMemDialog.setModal(true);
			editMemDialog.setVisible(true);
			
		}if(actionCmd.equals("회원편집하기")) {
			
			int n = Integer.parseInt(editMemNum.getText()) - 1;
			memList[n][1] = editGrade.getText();
			memList[n][2] = editName.getText();
			memList[n][3] = editMile.getText();
			memList[n][4] = editPhone.getText();
			editMemDialog.setVisible(false);
			
		}if(actionCmd.equals("직원추가")) {
		
			staffName.setText("이름");
			staffGrade.setText("직급");
			staffPh.setText("연락처");
			staffSal.setText("급여");
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
		
			delName.setText("삭제할 이름");
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
		}if(actionCmd.equals("직원편집") && (staffTable.getSelectedRow() < staffNum)) {
			
			editStaffNum.setText(staffList[staffTable.getSelectedRow()][0]);
			editNameStaff.setText(staffList[staffTable.getSelectedRow()][1]);
			editGradeStaff.setText(staffList[staffTable.getSelectedRow()][3]);
			editSal.setText(staffList[staffTable.getSelectedRow()][2]);
			editDateStaff.setText(staffList[staffTable.getSelectedRow()][4]);
			editPhoneStaff.setText(staffList[staffTable.getSelectedRow()][5]);
			editStaffDialog.setModal(true);
			editStaffDialog.setVisible(true);
			
		}if(actionCmd.equals("직원편집하기")) {
			
			int n = Integer.parseInt(editStaffNum.getText()) - 1;
			staffList[n][3] = editGradeStaff.getText();
			staffList[n][1] = editNameStaff.getText();
			staffList[n][2] = editSal.getText();
			staffList[n][5] = editPhoneStaff.getText();
			staffList[n][4] = editDateStaff.getText();
			editStaffDialog.setVisible(false);
			
		} if (actionCmd.equals("재료정보")) {
			
			if (jaeryoTable.getSelectedRow() < jaeryoNum) {
				jaenameinfoLabel.setText("이름 : " + jaeryoList[jaeryoTable.getSelectedRow()][0]);
				jaepriceinfoLabel.setText("가격 : " + jaeryoList[jaeryoTable.getSelectedRow()][3]);
				jaemarketinfoLabel.setText("판매처 : " + jaeryoList[jaeryoTable.getSelectedRow()][4]);
				jaemarketnuminfoLabel.setText("연락처 : " + jaeryoList[jaeryoTable.getSelectedRow()][5]);
				jaestockinfoLabel.setText("수량 : " + jaeryoList[jaeryoTable.getSelectedRow()][1]);
				jaeorderinfoLabel.setText("주문량 : " + jaeryoList[jaeryoTable.getSelectedRow()][2]);
			}
			
		} if (actionCmd.equals("재료추가")) {
			
			addjaeryoDialog.setModal(true);
			addjaeryoDialog.setVisible(true);
			
		} if (actionCmd.equals("재료추가하기")) {
			
			addjaeryoDialog.setVisible(false);
			jaeryoList[jaeryoNum][0] = jaeryoName.getText();
			jaeryoList[jaeryoNum][1] = ""+0;
			jaeryoList[jaeryoNum][2] = ""+0;
			jaeryoList[jaeryoNum][3] = jaeryoprice.getText();
			jaeryoList[jaeryoNum][4] = jaeryomarket.getText();
			jaeryoList[jaeryoNum][5] = jaeryomarketnum.getText();
			
			jaeryoNum++;
			
		} if (actionCmd.equals("재료삭제") && (jaeryoTable.getSelectedRow() < jaeryoNum)) {
			
			for(int i = jaeryoTable.getSelectedRow();i<jaeryoNum-1;i++) {
				for(int k=0;k<6;k++)
					jaeryoList[i][k] = jaeryoList[i+1][k];					
			}
			for(int k=0;k<6;k++)
				jaeryoList[jaeryoNum-1][k] = null;
			jaeryoNum--; 
			
		} if (actionCmd.equals("주문")) {
			
			jaeryoorderDialog.setModal(true);
			jaeryoorderDialog.setVisible(true);
			
		} if (actionCmd.equals("주문하기")) {
			
			jaeryoorderDialog.setVisible(false);
			
			for(int i=0;i<jaeryoNum;i++) {
				if (jaeryoList[i][0].equals(addjaeryoorderName.getText())) {
					jaeryoList[i][2] = jaeryoorder.getText();
					break;
				}
			}
			
		} if (actionCmd.equals("주문취소")) {
			
			jaeryoordercancelDialog.setModal(true);
			jaeryoordercancelDialog.setVisible(true);
			
		} if (actionCmd.equals("주문취소하기")) {
			
			jaeryoordercancelDialog.setVisible(false);
			
			for(int i=0;i<jaeryoNum;i++) {
				if (jaeryoList[i][0].equals(deljaeryoorderName.getText())) {
					jaeryoList[i][2] = ""+0;
					break;
				}
			}
			
		} if (actionCmd.equals("메뉴추가")) {
			
			addmenuDialog.setModal(true);
			addmenuDialog.setVisible(true);
			
		} if (actionCmd.equals("메뉴추가하기")) {
			
			addmenuDialog.setVisible(false);
			
			menuList[menuNum] = new menu(addmenuName.getText(),
					Integer.parseInt(addmenuprice.getText()), addmenurecipe.getText());
			
			menuButton[menuNum].setText(addmenuName.getText());
			
			String totalrecipe = addmenurecipe.getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[menuNum].setOrigin(totalmenucost);
			
			menuNum++;
			
		} if (actionCmd.equals(menuList[0].name)) {
			
			menunametext[0].setText(menuList[0].name);
			menupricetext[0].setText(Integer.toString(menuList[0].price));
			menuorigin[0].setText("원가 : " + Integer.toString(menuList[0].origin));
			menujaetext[0].setText(menuList[0].jae);
			
			menuDialog[0].setModal(true);
			menuDialog[0].setVisible(true);
			
		} if (actionCmd.equals(menuList[1].name)) {
			
			menunametext[1].setText(menuList[1].name);
			menupricetext[1].setText(Integer.toString(menuList[1].price));
			menuorigin[1].setText("원가 : " + Integer.toString(menuList[1].origin));
			menujaetext[1].setText(menuList[1].jae);
			
			menuDialog[1].setModal(true);
			menuDialog[1].setVisible(true);
			
		} if (actionCmd.equals(menuList[2].name)) {
			
			menunametext[2].setText(menuList[2].name);
			menupricetext[2].setText(Integer.toString(menuList[2].price));
			menuorigin[2].setText("원가 : " + Integer.toString(menuList[2].origin));
			menujaetext[2].setText(menuList[2].jae);
			
			menuDialog[2].setModal(true);
			menuDialog[2].setVisible(true);
			
		} if (actionCmd.equals(menuList[3].name)) {
			
			menunametext[3].setText(menuList[3].name);
			menupricetext[3].setText(Integer.toString(menuList[3].price));
			menuorigin[3].setText("원가 : " + Integer.toString(menuList[3].origin));
			menujaetext[3].setText(menuList[3].jae);
			
			menuDialog[3].setModal(true);
			menuDialog[3].setVisible(true);
			
		} if (actionCmd.equals(menuList[4].name)) {
			
			menunametext[4].setText(menuList[4].name);
			menupricetext[4].setText(Integer.toString(menuList[4].price));
			menuorigin[4].setText("원가 : " + Integer.toString(menuList[4].origin));
			menujaetext[4].setText(menuList[4].jae);
			
			menuDialog[4].setModal(true);
			menuDialog[4].setVisible(true);
			
		} if (actionCmd.equals(menuList[5].name)) {
			
			menunametext[5].setText(menuList[5].name);
			menupricetext[5].setText(Integer.toString(menuList[5].price));
			menuorigin[5].setText("원가 : " + Integer.toString(menuList[5].origin));
			menujaetext[5].setText(menuList[5].jae);
			
			menuDialog[5].setModal(true);
			menuDialog[5].setVisible(true);
		
		} if (actionCmd.equals(menuList[6].name)) {
			
			menunametext[6].setText(menuList[6].name);
			menupricetext[6].setText(Integer.toString(menuList[6].price));
			menuorigin[6].setText("원가 : " + Integer.toString(menuList[6].origin));
			menujaetext[6].setText(menuList[6].jae);
			
			menuDialog[6].setModal(true);
			menuDialog[6].setVisible(true);
			
		} if (actionCmd.equals(menuList[7].name)) {
			
			menunametext[7].setText(menuList[7].name);
			menupricetext[7].setText(Integer.toString(menuList[7].price));
			menuorigin[7].setText("원가 : " + Integer.toString(menuList[7].origin));
			menujaetext[7].setText(menuList[7].jae);
			
			menuDialog[7].setModal(true);
			menuDialog[7].setVisible(true);
			
		} if (actionCmd.equals(menuList[8].name)) {
			
			menunametext[8].setText(menuList[8].name);
			menupricetext[8].setText(Integer.toString(menuList[8].price));
			menuorigin[8].setText("원가 : " + Integer.toString(menuList[8].origin));
			menujaetext[8].setText(menuList[8].jae);
			
			menuDialog[8].setModal(true);
			menuDialog[8].setVisible(true);
			
		} if (actionCmd.equals(menuList[9].name)) {
			
			menunametext[9].setText(menuList[9].name);
			menupricetext[9].setText(Integer.toString(menuList[9].price));
			menuorigin[9].setText("원가 : " + Integer.toString(menuList[9].origin));
			menujaetext[9].setText(menuList[9].jae);
			
			menuDialog[9].setModal(true);
			menuDialog[9].setVisible(true);
			
		} if (actionCmd.equals("편집 1")) {
			
			menuDialog[0].setVisible(false);
			
			menuList[0] = new menu(menunametext[0].getText(),
					Integer.parseInt(menupricetext[0].getText()), menujaetext[0].getText());
			
			menuButton[0].setText(menunametext[0].getText());
			
			String totalrecipe = menujaetext[0].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[0].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 2")) {
			
			menuDialog[1].setVisible(false);
			
			menuList[1] = new menu(menunametext[1].getText(),
					Integer.parseInt(menupricetext[1].getText()), menujaetext[1].getText());
			
			menuButton[1].setText(menunametext[1].getText());
			
			String totalrecipe = menujaetext[1].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=1;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=1;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[1].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 3")) {
			
			menuDialog[2].setVisible(false);
			
			menuList[2] = new menu(menunametext[2].getText(),
					Integer.parseInt(menupricetext[2].getText()), menujaetext[2].getText());
			
			menuButton[2].setText(menunametext[2].getText());
			
			String totalrecipe = menujaetext[2].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[2].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 4")) {
			
			menuDialog[3].setVisible(false);
			
			menuList[3] = new menu(menunametext[3].getText(),
					Integer.parseInt(menupricetext[3].getText()), menujaetext[3].getText());
			
			menuButton[3].setText(menunametext[3].getText());
			
			String totalrecipe = menujaetext[3].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[3].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 5")) {
			
			menuDialog[4].setVisible(false);
			
			menuList[4] = new menu(menunametext[4].getText(),
					Integer.parseInt(menupricetext[4].getText()), menujaetext[4].getText());
			
			menuButton[4].setText(menunametext[4].getText());
			
			String totalrecipe = menujaetext[4].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[4].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 6")) {
			
			menuDialog[5].setVisible(false);
			
			menuList[5] = new menu(menunametext[5].getText(),
					Integer.parseInt(menupricetext[5].getText()), menujaetext[5].getText());
			
			menuButton[5].setText(menunametext[5].getText());
			
			String totalrecipe = menujaetext[5].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[5].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 7")) {
			
			menuDialog[6].setVisible(false);
			
			menuList[6] = new menu(menunametext[6].getText(),
					Integer.parseInt(menupricetext[6].getText()), menujaetext[6].getText());
			
			menuButton[6].setText(menunametext[6].getText());
			
			String totalrecipe = menujaetext[6].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[6].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 8")) {
			
			menuDialog[7].setVisible(false);
			
			menuList[7] = new menu(menunametext[7].getText(),
					Integer.parseInt(menupricetext[7].getText()), menujaetext[7].getText());
			
			menuButton[7].setText(menunametext[7].getText());
			
			String totalrecipe = menujaetext[7].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[7].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 9")) {
			
			menuDialog[8].setVisible(false);
			
			menuList[8] = new menu(menunametext[8].getText(),
					Integer.parseInt(menupricetext[8].getText()), menujaetext[8].getText());
			
			menuButton[8].setText(menunametext[8].getText());
			
			String totalrecipe = menujaetext[8].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[8].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("편집 10")) {
			
			menuDialog[9].setVisible(false);
			
			menuList[9] = new menu(menunametext[9].getText(),
					Integer.parseInt(menupricetext[9].getText()), menujaetext[9].getText());
			
			menuButton[9].setText(menunametext[9].getText());
			
			String totalrecipe = menujaetext[9].getText();
			StringTokenizer recipetoken = new StringTokenizer(totalrecipe, " ");
			
			int recipecount = recipetoken.countTokens();
			
			int totalmenucost = 0;
			
			for(int i=0;i<recipecount;i++) {
				String smalljae = recipetoken.nextToken();
				for(int j=0;j<jaeryoNum;j++) {
					if (smalljae.equals(jaeryoList[j][0])) {
						totalmenucost += Integer.parseInt(jaeryoList[j][3]);
						break;
					}
				}
			}
			
			menuList[9].setOrigin(totalmenucost);
			
		} if (actionCmd.equals("삭제 1")) {
			
			menuDialog[0].setVisible(false);
			
			for(int i=0;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 2")) {
			
			menuDialog[1].setVisible(false);
			
			for(int i=1;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 3")) {
			
			menuDialog[2].setVisible(false);
			
			for(int i=2;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
		
		} if (actionCmd.equals("삭제 4")) {
			
			menuDialog[3].setVisible(false);
			
			for(int i=3;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 5")) {
			
			menuDialog[4].setVisible(false);
			
			for(int i=4;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 6")) {
			
			menuDialog[5].setVisible(false);
			
			for(int i=5;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 7")) {
			
			menuDialog[6].setVisible(false);
			
			for(int i=6;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 8")) {
			
			menuDialog[7].setVisible(false);
			
			for(int i=7;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 9")) {
			
			menuDialog[8].setVisible(false);
			
			for(int i=8;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		} if (actionCmd.equals("삭제 10")) {
			
			menuDialog[9].setVisible(false);
			
			for(int i=9;i<menuNum-1;i++) {
				menuList[i] = menuList[i+1];
				menuButton[i].setText(menuList[i+1].name);
			}
			
			menuNum--;
			menuButton[menuNum].setText("메뉴 " + (menuNum+1));
			
		}
		
	}
	public void closingAction() {
		
		boolean okay = true;
		for(int i=0;i<6;i++) {
			if(!tableTotalPrice[i].getText().equals("빈테이블")) {
				JOptionPane.showMessageDialog(this,"마감되지 않은 테이블이 있습니다.");
				return;
			}
		}
		date.setDate(date.getDate()+1);
		dateLabel.setText(date.getYear() + "년 " + date.getMonth() + "월 " + date.getDate() + "일");
		
		balance += revenue;
		revenue = 0;
		if(date.getDate() == 1) {
			int totalSal = 0;
			for(int i=0;i<staffNum;i++) {
				totalSal += Integer.parseInt(staffList[i][2]);
			}
			balance -= totalSal;
		}
		int totalJaeCost = 0;
		for(int i=0;i<jaeryoNum;i++) {
			jaeryoList[i][1] = ""+(Integer.parseInt(jaeryoList[i][1]) + Integer.parseInt(jaeryoList[i][2]));
			totalJaeCost += Integer.parseInt(jaeryoList[i][2]) * Integer.parseInt(jaeryoList[i][3]);
			jaeryoList[i][2] = "0";
		}
		balance -= totalJaeCost;
		revenueLabel.setText("오늘 매출: " + revenue + "원/");
		balanceLabel.setText("전체 잔고: " + balance + "원");
		
		File file = new File("save.txt");
        FileWriter writer = null;
        
        try {
        	
            writer = new FileWriter(file, false);
            writer.write(date.getYear() +  " " + date.getMonth() +  " " + date.getDate() +  " " + balance + " ");
            writer.flush();
            
            writer.write(jaeryoNum + " ");
            
            for(int i=0;i<jaeryoNum;i++) {
            		for(int j=0;j<6;j++) {
            			writer.write(jaeryoList[i][j] + " ");
            		}
            		writer.flush();
            }
            
            writer.write(memberNum + " ");
            
            for(int i=0;i<memberNum;i++) {
        		for(int j=0;j<5;j++) {
        			writer.write(memList[i][j] + " ");
        		}
        		writer.flush();
        }
            
            System.out.println("DONE");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
		
	}
	public String dateToString() {
		return (date.getYear() + "년 " + date.getMonth() + "월 " + date.getDate() + "일");
	}
	public team() {
		
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//menuList[0] = new menu("menu 1",1000);
		//menuList[1] = new menu("menu 2",2000);
		//menuList[2] = new menu("menu 3",3000);
		//menuNum = 3;
		
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
		 tableInfo.add(currentTable);
		 tableInfo.add(gradeAtBill);
		  
		  
		  bigTable.add(tablePanel,BorderLayout.WEST);
		  bigTable.add(tableInfo,BorderLayout.EAST);
		 
		  
		  selectPanel.addTab("테이블",bigTable);
//-----------------------창고-----------------------------------------------------		
		  
		  
		  
		  JPanel warePanel = new JPanel();
		  selectPanel.addTab("창고", warePanel);
		  String[] wareheader = {"이름", "재고", "주문", "가격"};           //테이블 만들기
		  jaeryoTable = new JTable(jaeryoList, wareheader);
		  jaeryoTable.getColumn("이름").setPreferredWidth(40);				//너비설정
		  jaeryoTable.getColumn("재고").setPreferredWidth(10);
		  jaeryoTable.getColumn("주문").setPreferredWidth(10);
		  jaeryoTable.getColumn("가격").setPreferredWidth(20);
		  JScrollPane jaeryoScroll = new JScrollPane(jaeryoTable);
		  
		  JButton addjaeryo = new JButton("재료추가");  //추가버튼
		  addjaeryo.addActionListener(this);
		  
		  addjaeryoDialog.setLayout(new FlowLayout());
		  addjaeryoDialog.setSize(500,200);
		  addjaeryoDialog.add(jaeryoName);
		  addjaeryoDialog.add(jaeryoprice);
		  addjaeryoDialog.add(jaeryomarket);
		  addjaeryoDialog.add(jaeryomarketnum);
		  addjaeryoDialog.add(goAddjaeryo);
		  
		  goAddjaeryo.addActionListener(this);
		  
		  JButton deljaeryo = new JButton("재료삭제");   //삭제버튼
		  deljaeryo.addActionListener(this);
		 
		  deljaeryoDialog.setLayout(new FlowLayout());
		  deljaeryoDialog.setSize(500,100);
		  deljaeryoDialog.add(deljaeryoName);
		  deljaeryoDialog.add(goDeljaeryo);
		  
		  goDeljaeryo.addActionListener(this);
		  
		  JButton getorder = new JButton("주문");
		  getorder.addActionListener(this);
		  
		  jaeryoorderDialog.setLayout(new FlowLayout());
		  jaeryoorderDialog.setSize(500,100);
		  jaeryoorderDialog.add(addjaeryoorderName);
		  jaeryoorderDialog.add(jaeryoorder);
		  jaeryoorderDialog.add(gojaeryoorder);
		  
		  gojaeryoorder.addActionListener(this);
		  
		  JButton cancelorder = new JButton("주문취소");
		  cancelorder.addActionListener(this);
		  
		  jaeryoordercancelDialog.setLayout(new FlowLayout());
		  jaeryoordercancelDialog.setSize(500,100);
		  jaeryoordercancelDialog.add(deljaeryoorderName);
		  jaeryoordercancelDialog.add(gojaeryoordercancel);
		  gojaeryoordercancel.addActionListener(this);
		  
		  JButton jaeinfoButton = new JButton("재료정보");
		  jaeinfoButton.addActionListener(this);
		  
		  JPanel right = new JPanel();
		  right.setLayout(new BorderLayout());
		  
		  JPanel infoPanel = new JPanel();
		  infoPanel.setLayout(new BorderLayout());
		  
		  JPanel infonamePanel = new JPanel();
		  infonamePanel.setLayout(new GridLayout(2,1));
		  JPanel infomarketPanel = new JPanel();
		  infomarketPanel.setLayout(new GridLayout(2,2));
		  JPanel infoButtonPanel = new JPanel();
		  
		  infoPanel.add(infonamePanel, BorderLayout.NORTH);
		  infoPanel.add(infomarketPanel, BorderLayout.CENTER);
		  infoPanel.add(infoButtonPanel, BorderLayout.SOUTH);
		  
		  infonamePanel.add(jaenameinfoLabel);
		  infonamePanel.add(jaepriceinfoLabel);
		  infomarketPanel.add(jaemarketinfoLabel);
		  infomarketPanel.add(jaemarketnuminfoLabel);
		  infomarketPanel.add(jaestockinfoLabel);
		  infomarketPanel.add(jaeorderinfoLabel);
		  infoButtonPanel.add(jaeinfoButton);
		  
		  JPanel centerPanel = new JPanel();
		  
		  centerPanel.add(getorder);
		  centerPanel.add(cancelorder);
		  
		  JPanel bottomPanel = new JPanel();
		  
		  bottomPanel.add(addjaeryo);
		  bottomPanel.add(deljaeryo);
		  
		  right.add(infoPanel, BorderLayout.NORTH);
		  right.add(centerPanel, BorderLayout.CENTER);
		  right.add(bottomPanel, BorderLayout.SOUTH);
		  
		  warePanel.add(jaeryoScroll);
		  warePanel.add(right);
		  
		  
		  
//------------------회원메뉴------------------------------------		  
		  
		  
		  JPanel memberPanel = new JPanel();
		  String[] header = {"번호","등급","이름","마일리지","연락처"};
		  
		  memberTable = new JTable(memList,header);
		  memberTable.getColumn("번호").setPreferredWidth(10);
		  memberTable.getColumn("이름").setPreferredWidth(40);
		  memberTable.getColumn("마일리지").setPreferredWidth(20);
		  memberTable.getColumn("등급").setPreferredWidth(50);
		  memberTable.getColumn("연락처").setPreferredWidth(100);
		  JScrollPane memberScroll = new JScrollPane(memberTable);
		  JButton editMember = new JButton("회원편집");
		  editMember.addActionListener(this);
		  addMemDialog.setLayout(new FlowLayout());
		  addMemDialog.setSize(700,100);
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
		  
		  JButton goEditMem = new JButton("회원편집하기");
		  goEditMem.addActionListener(this);
		  editMemDialog.setSize(800,100);
		  editMemDialog.setLayout(new FlowLayout());
		  editMemDialog.add(editMemNum);
		  editMemDialog.add(editName);
		  editMemDialog.add(editGrade);
		  editMemDialog.add(editPhone);
		  editMemDialog.add(editMile);
		  editMemDialog.add(goEditMem);
		  
		  
		  selectPanel.addTab("회원", memberPanel);
		  
		  
		  
		  
//-------------------------메뉴----------------------------------------		  
		  
		  
		  
		  JPanel menuPanel = new JPanel();
		  selectPanel.addTab("메뉴", menuPanel);
		  menuPanel.setLayout(new BorderLayout());
		  
		  JPanel menuButtonPanel = new JPanel();
		  menuButtonPanel.setLayout(new GridLayout(5,2));
		  menuPanel.add(menuButtonPanel,BorderLayout.CENTER);
		  
		  for(int i=0;i<10;i++) {
			  menuList[i] = new menu();
			  menuButton[i] = new JButton("메뉴 " + (i+1));
			  menuButtonPanel.add(menuButton[i]);
			  menuButton[i].addActionListener(this);
		  }
		  
		  for(int i=0;i<10;i++) {
			  delmenuButton[i] = new JButton("삭제 " + (i+1));
			  delmenuButton[i].addActionListener(this);
			  changemenuButton[i] = new JButton("편집 " + (i+1));
			  changemenuButton[i].addActionListener(this);
			  menuDialog[i] = new JDialog();
			  menuDialog[i].setSize(450, 100);
			  menuDialog[i].setLayout(new FlowLayout());
			  menunametext[i] = new JTextField("이름", 8);
			  menuprice[i] = new JLabel("가격 :");
			  menupricetext[i] = new JTextField("가격", 8);
			  menuorigin[i] = new JLabel("원가");
			  menujaetext[i] = new JTextField("재료", 15);
			  menuDialog[i].add(menunametext[i]);
			  menuDialog[i].add(menuprice[i]);
			  menuDialog[i].add(menupricetext[i]);
			  menuDialog[i].add(menuorigin[i]);
			  menuDialog[i].add(menujaetext[i]);
			  menuDialog[i].add(delmenuButton[i]);
			  menuDialog[i].add(changemenuButton[i]);
		  }
		  
		  JButton addmenu = new JButton("메뉴추가");
		  menuPanel.add(addmenu,BorderLayout.SOUTH);
		  addmenu.addActionListener(this);
		  
		  addmenuDialog.setLayout(new FlowLayout());
		  addmenuDialog.setSize(500,100);
		  addmenuDialog.add(addmenuName);
		  addmenuDialog.add(addmenuprice);
		  addmenuDialog.add(addmenurecipe);
		  addmenuDialog.add(goAddmenu);
		  goAddmenu.addActionListener(this);
		  
		  
		  
//-------------------------직원---------------------------------------	  
		  
		  
		  
		  
		  
		  JPanel staffPanel = new JPanel();
		  String[] headerStaff = {"번호","이름","급여","직급","입사일","연락처"};
		  
		  staffTable = new JTable(staffList,headerStaff);
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
		  addStaffDialog.setSize(800,100);
		  goAddStaff.addActionListener(this);
		  addStaffDialog.add(staffName);
		  addStaffDialog.add(staffGrade);
		  addStaffDialog.add(staffPh);
		  addStaffDialog.add(staffSal);
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
		  
		  JButton goEditStaff = new JButton("직원편집하기");
		  goEditStaff.addActionListener(this);
		  editStaffDialog.setSize(900,100);
		  editStaffDialog.setLayout(new FlowLayout());
		  editStaffDialog.add(editStaffNum);
		  editStaffDialog.add(editNameStaff);
		  editStaffDialog.add(editGradeStaff);
		  editStaffDialog.add(editPhoneStaff);
		  editStaffDialog.add(editSal);
		  editStaffDialog.add(editDateStaff);
		  editStaffDialog.add(goEditStaff);
		  
		  selectPanel.addTab("직원", staffPanel);
		  

//-----------------------------------------------------------------------		
		

		
		basicPanel.add(selectPanel,BorderLayout.SOUTH);

		JButton loadButton = new JButton("불러오기");
		JButton exitButton = new JButton("종료");
		exitPanel.setLayout(new BorderLayout());
		exitPanel.add(loadButton, BorderLayout.NORTH);
		exitPanel.add(exitButton, BorderLayout.CENTER);
		loadButton.addActionListener(this);
		exitButton.addActionListener(this);
		basicPanel.add(exitPanel);
		
		add(basicPanel);
	}
	
	public static void main(String[] args) {
		team frame = new team();
		frame.setVisible(true);
		
	}
}
