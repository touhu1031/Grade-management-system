import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cls_stu_page extends JFrame {
	//メンバ変数の宣言
	JButton shibori;
	JLabel count;
	JLabel taninName;
	JLabel StuName;
	JComboBox<String> clsBox;
	JTable mainTable;
	JPanel north;
	JPanel northWest;
	JPanel northEast;

	//コンストラクタ
	public cls_stu_page(){
		//列名データの初期化
		String[] colName = {"出席番号","名前","性別","部活","前期委員会","後期委員会","備考"};
		String[][] data = {};

		//インスタンスの生成
		mainTable = new JTable(data,colName);
		mainTable.setPreferredScrollableViewportSize(new Dimension(980, 200)); // サイズ
		mainTable.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(mainTable);
		//ラベルの準備
		taninName = new JLabel("担任の名前");
		StuName = new JLabel("生徒氏名検索");
		count = new JLabel("○名");

		//ボタンの準備
		shibori = new JButton("絞り込み");

		//コンボボックスの準備
		String[] clsdata = {"学年組"};
		clsBox = new JComboBox<String>(clsdata);

		//Panelの準備
		north = new JPanel();
		northWest = new JPanel();
		northEast = new JPanel();

		//panelの設定
		north.setLayout( new BorderLayout() );
		northWest.setLayout( new BoxLayout( northWest,BoxLayout.Y_AXIS) );
		northEast.setLayout( new BoxLayout ( northEast,BoxLayout.Y_AXIS) );

		northWest.add(clsBox);
		northWest.add(taninName);
		northWest.add(count);

		northEast.add(StuName);
		northEast.add(shibori);

		//JFrameへの設定
		this.setLayout(new BorderLayout() );
		this.add(scrollPane,"Center");
		this.add(north,"North");

		north.add(northWest,"West");
		north.add(northEast,"East");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("クラス別生徒一覧表");
		pack();
		setVisible(true);
	}

	//メインメソッド
	public static void main(String[] args){
		new cls_stu_page();
	}
}
