import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	
	//Topテーブル
	private JPanel table_plate;
	private JTable info_plate;
	
	private JLabel label;
	private JToggleButton Edit_button;
	
	// left_panel
	private JPanel Left_panel;
	private JList Name_list;
	
	
	//コンストラクタ
	public Private_page(){
		// ========================================
		// panel_plate (Top)
		// ========================================
		
		int panel_plate_Width = 1300;
		int panel_plate_Height = 60;
		
		String[] colName = {"部活","委員会","担任","備考"};
		String[][] data = {{"パソコン部","帰宅部","百瀬さん","退学"}};
		
		// インスタンス生成 ===========================
		label = new JLabel("生徒個人ページ");
		Name_plate = new JTextField("名前");
		
		table_plate = new JPanel();
		info_plate = new JTable(data, colName);
		
		Edit_button = new JToggleButton("編集");
		panel_plate = new JPanel();
		
		// 各種設定 =====================================
		// 全体 
		panel_plate.setPreferredSize(new Dimension(panel_plate_Width, panel_plate_Height));
		
		// タイトルラベル
		label.setPreferredSize(new Dimension(180, panel_plate_Height));
		
		// 名前
		Name_plate.setPreferredSize(new Dimension(300, panel_plate_Height));
		
		// テーブル 
		table_plate.setLayout(new BorderLayout());
		table_plate.setPreferredSize(new Dimension(750, panel_plate_Height));
		  // 行の高さ
		info_plate.setRowHeight(panel_plate_Height / 2);
		info_plate.setPreferredSize(new Dimension(750, panel_plate_Height / 2));
		  // 列名の高さ
		javax.swing.table.JTableHeader header = info_plate.getTableHeader();
		header.setPreferredSize(new Dimension(750, panel_plate_Height / 2));
		
		//table_plate.setPreferredSize(new Dimension(750, panel_plate_Height/2));
		//table_plate.setMaximumSize(new Dimension(750, panel_plate_Height/2));
		
		
		// ボタン 
		Edit_button.setPreferredSize(new Dimension(70, panel_plate_Height));
		Edit_button.setMaximumSize(new Dimension(70, panel_plate_Height));
		Edit_button.setMinimumSize(new Dimension(50, panel_plate_Height));
		
		// 配置 ======================================
		panel_plate.setLayout( new BoxLayout( panel_plate, BoxLayout.X_AXIS ) );
		panel_plate.add(label);
		panel_plate.add(Name_plate);
		panel_plate.add(table_plate);
		table_plate.add(info_plate.getTableHeader(), BorderLayout.NORTH);
		table_plate.add(info_plate, BorderLayout.CENTER);
		panel_plate.add(Edit_button);
		
		
		// リスナー登録 ==============================
		// 編集・保存ボタン
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
		
		
		// ==========================================
		// リスト&セレクトボックス (Left_panel) 
		// ==========================================
		
		String Name_list_data[] = {"西海 透真", "上野 そうたろう" , "一里 リク",};
		 
		// インスタンス生成 ==========================
		Name_list = new JList<String>(Name_list_data);
		Left_panel = new JPanel();
		
		// 各種設定 =================================
		Name_list.setPreferredSize(new Dimension(180, 640));
		
		// 配置 =====================================
		Left_panel.setLayout(new BoxLayout( Left_panel, BoxLayout.Y_AXIS ));
		Left_panel.add(Name_list);
		
		// リスナー登録 ==============================
		
		
		
		
		
		// ==========================================
		// 全体
		// ==========================================
		
		this.add(panel_plate, BorderLayout.NORTH);
		this.add(Left_panel, BorderLayout.WEST);
		
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
