package guiVjezba;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class vjezbaguija extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton but1;
	JButton but2;
	JTextField jtf1;
	JTextField jtf2;
	JFileChooser jfc;
	JRadioButton jrb1;
	JRadioButton jrb2;
	JLabel jl0;
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	JComboBox<String> jcb;

	String url = "";
	String path = "";
	String format = "";
	String opcije1[] = { "best audio", "mp3", "flac", "opus(exp)" };
	String opcije2[] = { "best video", "mp4", "mkv", "mov" };
	String working = System.getProperty("user.dir");

	public vjezbaguija() {

		ImageIcon image = new ImageIcon("app\\Social-Networks-Youtube-icon.png");

		ImageIcon image2 = new ImageIcon("app\\logo.png");

		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(100, 0, 0));

		this.setSize(500, 500);
		this.setTitle("YT downloader");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(null);

		but1 = new JButton("Start");
		but1.setBounds(200, 400, 100, 50);
		but1.setBackground(new Color(50, 0, 0));
		but1.setForeground(Color.white);
		but1.addActionListener(this);

		jl0 = new JLabel("");
		jl0.setIcon(image2);
		jl0.setBounds(160, -30, 180, 148);

		jl1 = new JLabel("link:");
		jl1.setBounds(36, 100, 50, 25);
		jl1.setHorizontalAlignment(JLabel.CENTER);
		jl1.setBackground(new Color(100, 0, 0));
		jl1.setForeground(Color.white);
		jl1.setOpaque(true);

		jtf1 = new JTextField();
		jtf1.setBounds(100, 100, 300, 25);

		jl2 = new JLabel("download\n\r path:");
		jl2.setBounds(6, 200, 90, 25);
		jl2.setHorizontalAlignment(JLabel.CENTER);
		jl2.setBackground(new Color(100, 0, 0));
		jl2.setForeground(Color.white);
		jl2.setOpaque(true);

		jtf2 = new JTextField();
		jtf2.setBounds(100, 200, 250, 25);

		but2 = new JButton("Select");

		but2.addActionListener(this);

		but2.setBounds(350, 200, 90, 25);
		but2.setHorizontalAlignment(JLabel.CENTER);
		but2.setBackground(new Color(50, 0, 0));
		but2.setForeground(Color.white);
		but2.setOpaque(true);

		jfc = new JFileChooser();

		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		jl3 = new JLabel("format:");
		jl3.setBounds(36, 300, 50, 25);
		jl3.setHorizontalAlignment(JLabel.CENTER);
		jl3.setBackground(new Color(100, 0, 0));
		jl3.setForeground(Color.white);
		jl3.setOpaque(true);

		jrb1 = new JRadioButton("Audio");
		jrb2 = new JRadioButton("Video");

		jrb1.addActionListener(this);
		jrb2.addActionListener(this);

		jrb1.setBounds(100, 300, 75, 25);
		jrb1.setBackground(new Color(100, 0, 0));
		jrb1.setForeground(Color.white);

		jrb2.setBounds(200, 300, 75, 25);
		jrb2.setBackground(new Color(100, 0, 0));
		jrb2.setForeground(Color.white);

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		jcb = new JComboBox<String>();
		jcb.addActionListener(this);

		jcb.setBounds(350, 300, 90, 25);

		this.add(jrb1);
		this.add(jrb2);
		this.add(jl0);
		this.add(jl1);
		this.add(jl2);
		this.add(jl3);
		this.add(jtf1);
		this.add(jtf2);
		this.add(jcb);
		this.add(but1);
		this.add(but2);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == but2) {

			int odziv = jfc.showOpenDialog(null);

			if (odziv == JFileChooser.APPROVE_OPTION) {

				File f = new File(jfc.getSelectedFile().getAbsolutePath());
				jtf2.setText(f.getAbsolutePath());

			}

		}

		if (e.getSource() == jrb1) {

			int k = 0;

			for (String i : opcije1) {
				jcb.insertItemAt(i, k);
				k++;
			}

			if (jcb.getItemCount() == 8) {
				for (int i = 7; i > 3; i--) {
					jcb.removeItemAt(i);
				}
			}
			jcb.setSelectedIndex(0);
		}

		if (e.getSource() == jrb2) {

			int k = 0;

			for (String i : opcije2) {
				jcb.insertItemAt(i, k);
				k++;
			}

			if (jcb.getItemCount() == 8) {
				for (int i = 7; i > 3; i--) {
					jcb.removeItemAt(i);
				}
			}
			jcb.setSelectedIndex(0);
		}

		if (e.getSource() == jcb) {

//			System.out.print("odabir: " + jcb.getSelectedItem() + "\r\n");

//			String odabir = (String) jcb.getSelectedItem();

			String komanda = "";

			switch ((String) jcb.getSelectedItem()) {

			case "best audio":
				komanda = "ba";
				break;

			case "mp3":
				komanda = "ba --ffmpeg-location bin\\ffmpeg.exe -x --audio-format mp3";
				break;

			case "flac":
				komanda = "ba --ffmpeg-location bin\\ffmpeg.exe -x --audio-format flac";
				break;

			case "opus(exp)":
				komanda = "opus";
				break;

			case "best video":
				komanda = "b";
				break;

			case "mp4":
				komanda = "b --ffmpeg-location bin\\ffmpeg.exe --recode-video mp4";
				break;

			case "mkv":
				komanda = "b --ffmpeg-location bin\\ffmpeg.exe --recode-video mkv";
				break;

			case "mov":
				komanda = "b --ffmpeg-location bin\\ffmpeg.exe --recode-video mov";
				break;
			}

			format = komanda;

//			System.out.print("select: " + format + "\r\n");
		}

		if (e.getSource() == but1) {

			url = jtf1.getText();
//			System.out.print(url);

			path = jtf2.getText();
//			System.out.print(path);

			String trenutni = working;

			pokreniProg pp = new pokreniProg(trenutni, url, path, format);
			pp.start();

		}
	}

	public static void main(String args[]) {

		new vjezbaguija();

	}

}
