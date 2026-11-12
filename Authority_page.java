/*2026.11.12 Authority_page.java*/
/*J3 No.26 Tomoki Hanada*/
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;

public class ClubMain extends JFrame{
	//メンバ
	JLabel lblTitle;
	JPanel panLeft;
	JLabel lblLeft;

	JButton btn1,btn2,btn3;
	JPanel panRight;
	JLabel lblRight;
	JButton btn4;

	public ClubMain(String title){
		super(title);
		this.setSize(900,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//画面中央に表示
		this.setLocationRelativeTo(null);
		//コンテナト・ペイントの取得とレイアウト設計
		Container cont = this.getContentPane();
		cont.setLayout(new BorderLayout());
		//タイトル
		String str = "部活動検索データベース";
		lblTitle = new JLabel(str);
		lblTitle.setBorder(new LineBorder(Color.RED,2,true));//枠線
		lblTitle.setOpaque(true);//透明色設定(不透明)
		lblTitle.setForeground(Color.RED);//文字色
		lblTitle.setBackground(Color.WHITE);//背景色
		lblTitle.setFont(new Font("MS Gothic",Font.PLAIN,60));//フォントサイズ
		lblTitle.setHorizontalAlignment(JLabel.CENTER);//中央揃え
		lblTitle.setPreferredSize(new Dimension(900,150));//ラベルサイズ
		cont.add(lblTitle,BorderLayout.NORTH);

		//WEST(左)パネル設定
		panLeft = new JPanel();
		//パネル内ボックスレイアウト
		panLeft.setLayout(new BoxLayout(panLeft,BoxLayout.Y_AXIS));

		//lblLeft追加
		lblLeft  = new JLabel("<html><h1>一覧出力</h></html>");
		lblLeft.setPreferredSize(new Dimension(450,100));
		panLeft.add(lblLeft);

		//btn1追加
		btn1 = new JButton("<html><h1>クラス別生徒一覧</h1></html>");
		btn1.setPreferredSize(new Dimension(450,100));
		//btn1クリックイベント
		btn1.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				//クラス別生徒一覧
				ClassFrm frame = new ClassFrm("検索画面");
				frame.pack();
				frame.setVisible(true);
			}
		});
		panLeft.add(btn1);

		//btn2追加
		btn2 = new JButton("<html><h1>部活別所属生徒一覧</h1></html>");
		btn2.setPreferredSize(new Dimension(450,100));
		//btn2クリックイベント
		btn2.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				//部活動別所属生徒一覧
				ClubFrm frame = new ClubFrm("検索画面");
				frame.pack();
				frame.setVisible(true);
			}
		});
		panLeft.add(btn2);
	
		//btn3追加
		btn3 = new JButton("<html><h1>部活別所属人数一覧</h1></html>");
		btn3.setPreferredSize(new Dimension(450,100));
		//btnクリックイベント
		btn3.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				//部活動別所属人数一覧
				NinzuFrm frame = new NinzuFrm("検索画面");
				frame.pack();
				frame.setVisible(true);
			}
		});
		panLeft.add(btn3);

		//EAST(右)パネル設定
		panRight = new JPanel();
		panRight.setLayout(new BoxLayout(panRight,BoxLayout.Y_AXIS));

		//lblRight追加
		lblRight = new JLabel("<html><h1>情報変更</h1></html>");
		lblRight.setPreferredSize(new Dimension(450,100));
		panRight.add(lblRight);

		//btn4追加
		btn4 = new JButton("<html><h1>生徒所属変更</h1></html>");
		btn4.setPreferredSize(new Dimension(450,100));

		//btn4クリックイベント
		btn4.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				//生徒所属変更
				UpdateDialog dialog = new UpdateDialog("情報変更");
				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);
			}
		});
		panRight.add(btn4);

		//コンテナントのレイアウト設定
		cont.add(panLeft,BorderLayout.WEST);
		cont.add(panRight,BorderLayout.EAST);
	}
	public static void main(String[] args){
		ClubMain frame = new ClubMain("部活動検索システム");
		frame.pack();
		frame.setVisible(true);
	}
}

