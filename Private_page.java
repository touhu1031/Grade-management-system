import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




public class Private_page extends JFrame implements ActionListener{

	// メンバ変数の宣言
	private JPanel panel_plate;
	private JPanel panelLeft;
	private JPanel panelContents;
	
	private JTextField Name_plate;
	private JTable info_plate;
	private JScrollPane plate_Scroll;
	private JLabel label;
	private JToggleButton Edit_button;
	
	//コンストラクタ
	public Private_page(){
		// ========================================
		// panel_plate
		// ========================================
		
		String[] colName = {"部活","委員会","担任","備考"};
		String[][] data = {{"パソコン部","帰宅部","百瀬さん","退学"}};
		
		// インスタンス生成とパネル配置
		label = new JLabel("生徒個人ページ");
		Name_plate = new JTextField("名前");
		info_plate = new JTable(data, colName);
		plate_Scroll = new JScrollPane(info_plate); 
		Edit_button = new JToggleButton("編集");
		
		panel_plate = new JPanel();
		
		panel_plate.setLayout( new BoxLayout( panel_plate, BoxLayout.X_AXIS ) );
		panel_plate.add(label);
		panel_plate.add(Name_plate);
		panel_plate.add(info_plate);
		panel_plate.add(plate_Scroll); 
		panel_plate.add(Edit_button);
		
		panel_plate.setPreferredSize(new Dimension(1300, 60));
		
		// テーブル設定
		info_plate.setPreferredSize(new Dimension(750, 60));
		plate_Scroll.setPreferredSize(new Dimension(750, 60));
		
		
		// 編集ボタン リスナー登録
		Edit_button.addChangeListener( new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				//トグルボタンの状況判定
				if( Edit_button.isSelected() ){
					Edit_button.setText("保存");
					Name_plate.setEditable(true);
				}else{
					Edit_button.setText("編集");
					Name_plate.setEditable(false);
				}
			}
		});
		
		
		
		this.add(panel_plate, BorderLayout.NORTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("個人ページ");
		this.pack();
		this.setSize(1300,800);
		this.setVisible(true);
			
		
		
	
	}
	
	public void actionPerformed(ActionEvent e) {
		// 現時点では中身は空で大丈夫です
	}
	
	public static void main( String[] args ){
			new Private_page();
	}
}
