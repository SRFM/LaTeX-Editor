package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileSystemView;

import latexData.DocumentManager;
import latexData.LatexEditorController;
import latexData.VersionsManager;
import latexData.VersionsStrategy;
import latexData.VolatileVersionsStrategy;

public class LatexEditorView {

	private TextArea textArea;
	private DocumentManager	docManager;
	private VersionsStrategy strategy;
	private LatexEditorController myController;
	private VersionsManager versionManager;
	private String templateType;
	private String name;
	private String path;
	private int versionID;
	private JLabel CurrentVersionLabel;
	private JFrame FrameToUse;
	private String commandToLoad;
	
	private JFrame GUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LatexEditorView window = new LatexEditorView();
					window.GUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LatexEditorView() 
	{
		DocumentManager	docManager = new DocumentManager();
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		VersionsManager versionManager = new VersionsManager(strategy,this);
		versionManager.enable();
		
		LatexEditorController myController = new LatexEditorController(this);
		this.docManager = docManager;
		this.myController = myController;
		this.versionManager = versionManager;
		JFrame frame = new JFrame("Frame To Use");
		this.FrameToUse = frame; 
		this.name = "default";
		this.getPath();
		try {
			File file = new File("Feeds.txt");
			file.createNewFile();
			String defaultPathWithName = file.getAbsolutePath();
			String defaultPath = defaultPathWithName.substring(0, defaultPathWithName.lastIndexOf(File.separator));
			System.out.println(defaultPath);
			this.path = defaultPath;
			file.delete();
		    } catch (IOException e) {
		    	
		    }
		docManager.initDocs();
		myController.init();
		initialize();
	}
	
	//################Some getters
	
	public void projectCommands(JMenu report, JMenu book, JMenu article, JMenu letter, JMenu empty) 
	{
		if(templateType.equals("Report")) 
		{
			report.setVisible(true);
			book.setVisible(false);
			article.setVisible(false);
			letter.setVisible(false);
			empty.setVisible(false);
		}
		if(templateType.equals("Book")) 
		{
			book.setVisible(true);
			report.setVisible(false);
			article.setVisible(false);
			letter.setVisible(false);
			empty.setVisible(false);
		}
		if(templateType.equals("Article")) 
		{
			article.setVisible(true);
			book.setVisible(false);
			report.setVisible(false);
			letter.setVisible(false);
			empty.setVisible(false);
		}
		if(templateType.equals("Letter")) 
		{
			book.setVisible(false);
			report.setVisible(false);
			article.setVisible(false);
			letter.setVisible(true);
			empty.setVisible(false);
		}
		if(templateType.equals("Empty")) 
		{
			book.setVisible(false);
			report.setVisible(false);
			article.setVisible(false);
			letter.setVisible(false);
			empty.setVisible(true);
		}
	}
	
	public void setCommandToLoad(String command) 
	{
		this.commandToLoad = command;
	}
	
	public String getCommandToLoad() 
	{
		return this.commandToLoad;
	}
	
	public JFrame getFrame() 
	{
		return this.FrameToUse;
	}
	
	public int getVersionID() 
	{
		return this.versionID;
	}
	
	public JLabel getCurrentVersionLabel() 
	{
		return this.CurrentVersionLabel;
	}
	
	public void setVersionID(int i) 
	{
		this.versionID += i;
	}
	
	public void setPath(String path) 
	{
		this.path = path;
		return;
	}
	
	public String getPath() 
	{
		return(this.path);
	}
	
	public TextArea getTextArea() 
	{
		return(this.textArea);
	}
	
	public DocumentManager	getDocumentManager() 
	{
		return(this.docManager);
	}
	
	public LatexEditorController getLatexEditorController() 
	{
		return this.myController;
	}
	
	public 	VersionsManager getVersionManager() 
	{
		return this.versionManager;
	}
	public String getTemplateType()
	{
		return this.templateType;
	}
	
	public String getName() 
	{
		return this.name;
	}
	//###############
	
	public void latexCommand(String command) 
	{
		this.commandToLoad = command;
		this.myController.enact("AddLatexCommand");
	}
	
	public void openFileExplorer() 
	{
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			this.path = selectedFile.getAbsolutePath();
			return;
		}
		else {
			System.out.println("No path");
			return;
		}
	}
		
	
	public void bibliography() {
		this.myController.enact("BibliograpgyCommand");
	}
	
	public void help() {
		this.myController.enact("ManualCommand");
	}
	
	public void createAction(String template, String name) {
		this.templateType = template;
		this.name = name;
		this.myController.enact("CreateCommand");
	}
	
	public void commit() {
		System.out.println("Commit changes");
		this.myController.enact("EditCommand");
	}
	
	public void save() {
		this.myController.enact("SaveCommand");
	}
	
	public void rollback() {
		this.myController.enact("RollbackToPreviousVersionCommand");
	}
	
	public void disTracking() {
		this.myController.enact("DisableVersionsManagementCommand");
	}
	
	public void EnTracking() {
		this.myController.enact("EnableVersionsManagementCommand");
	}

	public void changeStrategy(){
		this.myController.enact("ChangeVersionsStrategyCommand");
		return;
	}
	public void loadCommand() {
		this.myController.enact("LoadCommand");
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GUI = new JFrame();
		GUI.getContentPane().setBackground(Color.WHITE);
		GUI.setBounds(100, 100, 1381, 1078);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(null);
		
		this.textArea = new TextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(147, 34, 699, 912);
		GUI.getContentPane().add(textArea);
		
		JLabel lblLatexText = new JLabel("LaTeX File:");
		lblLatexText.setBounds(459, 12, 76, 16);
		GUI.getContentPane().add(lblLatexText);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(Color.BLACK);
		scrollBar.setBounds(831, 34, 15, 912);
		GUI.getContentPane().add(scrollBar);
		
		JMenuBar menuBar = new JMenuBar();
		GUI.setJMenuBar(menuBar);
		
		//###########################
		JMenu mnBookTemplate = new JMenu("Book Template");
		JMenu mnNewMenu_5 = new JMenu("Report Template");
		JMenu mnArticleTemplate = new JMenu("Article Template");
		JMenu mnLetterTemplate = new JMenu("Letter Template");
		JMenu mnNewMenu_1 = new JMenu("Empty Template");
		//############################
		
		 JMenuItem templateChoice = new JMenuItem();
		//##########################
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_4 = new JMenu("New Latex File");
		mnNewMenu.add(mnNewMenu_4);
				
		JMenuItem mntmNewMenuItem = new JMenuItem("Book Template");
		
		ImageIcon bookIcon = new ImageIcon("bookIcon.png"); // load the image to a imageIcon
		Image imagebook = bookIcon.getImage(); // transform it 
		Image newimgbook = imagebook.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		bookIcon = new ImageIcon(newimgbook);  // transform it back
		mntmNewMenuItem.setIcon(bookIcon);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Book Template");;
				 JFrame frame = new JFrame("InputDialog Example #2");
				    String name = JOptionPane.showInputDialog(
				        frame, 
				        "Enter the name of the Latex File", 
				        "Latex File name:",  
				        JOptionPane.QUESTION_MESSAGE
				    );
				    if(name == null) {
				    	System.out.println("Empty Name");	
				    }
				    else {
				    createAction("Book",name);
					projectCommands(mnNewMenu_5,mnBookTemplate,mnArticleTemplate,mnLetterTemplate,mnNewMenu_1);
				}
				JMenuItem templateChoice = (JMenuItem)e.getSource();
		        System.out.println("Button:"+templateChoice.getText());
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Article Template");
		
		ImageIcon articleIcon = new ImageIcon("articleIcon.png"); // load the image to a imageIcon
		Image imagearticle = articleIcon.getImage(); // transform it 
		Image newimgarticle = imagearticle.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		articleIcon = new ImageIcon(newimgarticle);  // transform it back
		mntmNewMenuItem_1.setIcon(articleIcon);
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Article Template");;
				 JFrame frame = new JFrame("InputDialog Example #2");
				    String name = JOptionPane.showInputDialog(
				        frame, 
				        "Enter the name of the Latex File:", 
				        "Latex File name:", 
				        JOptionPane.QUESTION_MESSAGE
				    );
				    if(name == null) {
				    	System.out.println("Empty Name");
				    }
				    else {
				    	createAction("Article",name);
				    	projectCommands(mnNewMenu_5,mnBookTemplate,mnArticleTemplate,mnLetterTemplate,mnNewMenu_1);
				    }
				JMenuItem templateChoice = (JMenuItem)e.getSource();
		        System.out.println("Button:"+templateChoice.getText());
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Letter Template");
		
		ImageIcon letterIcon = new ImageIcon("letterIcon.png"); // load the image to a imageIcon
		Image imageletter = letterIcon.getImage(); // transform it 
		Image newimgletter = imageletter.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		letterIcon = new ImageIcon(newimgletter);  // transform it back
		mntmNewMenuItem_3.setIcon(letterIcon);
		
		
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Letter Template");;
				 JFrame frame = new JFrame("InputDialog Example #2");
				    String name = JOptionPane.showInputDialog(
				        frame, 
				        "Enter the name of the Latex File", 
				        "Latex File name:", 
				        JOptionPane.QUESTION_MESSAGE
				    );
				    if(name == null) {
				    	System.out.println("Empty Name");
				    }
				    else {
				    	createAction("Letter", name);
						projectCommands(mnNewMenu_5,mnBookTemplate,mnArticleTemplate,mnLetterTemplate,mnNewMenu_1);
				    }
				JMenuItem templateChoice = (JMenuItem)e.getSource();
		        System.out.println("Button:"+templateChoice.getText());
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_3);
		
		JMenuItem mntmEmpty = new JMenuItem("Empty Template");
		
		ImageIcon emptyIcon = new ImageIcon("emptyIcon.jpg"); // load the image to a imageIcon
		Image imageempty = emptyIcon.getImage(); // transform it 
		Image newimgempty = imageempty.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		emptyIcon = new ImageIcon(newimgempty);  // transform it back
		mntmEmpty.setIcon(emptyIcon);
		
		
		mntmEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Empty Template");;
				JMenuItem templateChoice = (JMenuItem)e.getSource();
		        System.out.println("Button:"+templateChoice.getText());
				 JFrame frame = new JFrame("InputDialog Example #2");
				    String name = JOptionPane.showInputDialog(
				        frame, 
				        "Enter the name of the Latex File:", 
				        "Latex File name:",  
				        JOptionPane.QUESTION_MESSAGE
				    );
				    if(name == null) {
				    	System.out.println("Empty Name");
				    }
				    else {
				    	createAction("Empty", name);
						projectCommands(mnNewMenu_5,mnBookTemplate,mnArticleTemplate,mnLetterTemplate,mnNewMenu_1);
				    }
			}
		});
		
		JMenuItem ReportTemplateButton = new JMenuItem("Report Template");
		
		ImageIcon reportIcon = new ImageIcon("reportIcon.png"); // load the image to a imageIcon
		Image imagereport = reportIcon.getImage(); // transform it 
		Image newimgreport = imagereport.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		reportIcon = new ImageIcon(newimgreport);  // transform it back
		ReportTemplateButton.setIcon(reportIcon);
		
		ReportTemplateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Report Template");
				JMenuItem templateChoice = (JMenuItem)e.getSource();
		        System.out.println("Button:"+templateChoice.getText());
				 JFrame frame = new JFrame("InputDialog Example #2");
				    String name = JOptionPane.showInputDialog(
				        frame, 
				        "Enter the name of the Latex File:", 
				        "Latex File name:",  
				        JOptionPane.QUESTION_MESSAGE
				    );
				    if(name == null) {
				    	System.out.println("Empty Name");
				    }
				    else {
						createAction("Report",name);
						projectCommands(mnNewMenu_5,mnBookTemplate,mnArticleTemplate,mnLetterTemplate,mnNewMenu_1);
				    }
			}
		});
		
		mnNewMenu_4.add(ReportTemplateButton);
		mnNewMenu_4.add(mntmEmpty);
		
		this.textArea.setText(templateChoice.getText());
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File...");
		
		ImageIcon openFileeIcon = new ImageIcon("openFileIcon.png"); // load the image to a imageIcon
		Image imageopenFile = openFileeIcon.getImage(); // transform it 
		Image newimgopenFile = imageopenFile.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		openFileeIcon = new ImageIcon(newimgopenFile);  // transform it back
		mntmOpenFile.setIcon(openFileeIcon);
		
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileExplorer();
				loadCommand();
				projectCommands(mnNewMenu_5,mnBookTemplate,mnArticleTemplate,mnLetterTemplate,mnNewMenu_1);			    
			}
		});
		mnNewMenu.add(mntmOpenFile);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmSaveFile = new JMenuItem("Save File");
		mntmSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileExplorer();
				save();
			}
		});
		mnNewMenu.add(mntmSaveFile);
		
		ImageIcon saveIcon = new ImageIcon("saveIcon.png"); // load the image to a imageIcon
		Image imagesave = saveIcon.getImage(); // transform it 
		Image newimgsave = imagesave.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		saveIcon = new ImageIcon(newimgsave);  // transform it back
		mntmSaveFile.setIcon(saveIcon);
		
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		mnNewMenu.add(separator_5);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mnNewMenu.add(mntmPrint);
		
		ImageIcon printIcon = new ImageIcon("printIcon.png"); // load the image to a imageIcon
		Image imageprint = printIcon.getImage(); // transform it 
		Image newimgoprint = imageprint.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		printIcon = new ImageIcon(newimgoprint);  // transform it back
		mntmPrint.setIcon(printIcon);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		mnNewMenu.add(separator_4);
		
		JMenuItem mntmQuitProgram = new JMenuItem("Quit Program");
		mntmQuitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmQuitProgram);
		
		ImageIcon exitIcon = new ImageIcon("exitIcon.jpg"); // load the image to a imageIcon
		Image imageexit = exitIcon.getImage(); // transform it 
		Image newimgoexit = imageexit.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		exitIcon = new ImageIcon(newimgoexit);  // transform it back
		mntmQuitProgram.setIcon(exitIcon);
		
		
		JMenu mnNewMenu_3 = new JMenu("LaTeX Commands");
		menuBar.add(mnNewMenu_3);
		
		mnNewMenu_3.add(mnNewMenu_5);
		
		JMenu mnNewMenu_30 = new JMenu("More...");
		menuBar.add(mnNewMenu_30);
		
		JMenuItem mntmBibliography = new JMenuItem("Bibliography");
		mntmBibliography.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bibliography();
			}
		});
		mnNewMenu_30.add(mntmBibliography);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		mnNewMenu_30.add(separator_7);
		
		JMenuItem mntmHelp = new JMenuItem("Help (?)");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help();
			}
		});
		mnNewMenu_30.add(mntmHelp);
		
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		
		//Report Template -> Chapter listener:
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\\chapter{...}");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("chapter");
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_2);
		
		//Report Template -> Section listener:
		JMenuItem mntmsection = new JMenuItem("\\section{}");
		mntmsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("section");
			}
		});
		mnNewMenu_5.add(mntmsection);
		
		//Report Template -> Subsection listener:
		JMenuItem mntmsubsection = new JMenuItem("\\subsection{}");
		mntmsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsection");
			}
		});
		mnNewMenu_5.add(mntmsubsection);
		
		//Report Template -> Subsubsection listener:
		JMenuItem mntmsubsubsection = new JMenuItem("\\subsubsection{}");
		mntmsubsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsubsection");
			}
		});
		mnNewMenu_5.add(mntmsubsubsection);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setForeground(Color.BLACK);
		mnNewMenu_5.add(separator_10);
		
		//Report Template -> \\begin{itemize} listener:
		JMenuItem mntmbeginitemize = new JMenuItem("\\begin{itemize}");
		mntmbeginitemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{itemize}");
			}
		});
		mnNewMenu_5.add(mntmbeginitemize);
		
		//Report Template -> \\item ... listener:
		JMenuItem mntmitem = new JMenuItem("\\item ...");
		mntmitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnNewMenu_5.add(mntmitem);
		
		//Report Template -> \\end{itemize} listener:
		JMenuItem mntmenditemize = new JMenuItem("\\end{itemize}");
		mntmenditemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{itemize}");
			}
		});
		mnNewMenu_5.add(mntmenditemize);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setForeground(Color.BLACK);
		mnNewMenu_5.add(separator_11);
		
		//Report Template -> \\begin{enumerate} listener:
		JMenuItem mntmbeginenumerate = new JMenuItem("\\begin{enumerate}");
		mntmbeginenumerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{enumerate}");
			}
		});
		mnNewMenu_5.add(mntmbeginenumerate);
		
		//Report Template -> \\item ... listener:
		JMenuItem mntmiem = new JMenuItem("\\item ...");
		mntmiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnNewMenu_5.add(mntmiem);
		
		//Report Template -> \\\\end{enumerate} listener
		JMenuItem mntmendenumerate = new JMenuItem("\\end{enumerate}");
		mntmendenumerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{enumerate}");
			}
		});
		mnNewMenu_5.add(mntmendenumerate);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setForeground(Color.BLACK);
		mnNewMenu_5.add(separator_12);
		
		//Report Template -> \\begin{table} listener:
		JMenuItem mntmbegintable = new JMenuItem("\\begin{table}");
		mntmbegintable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{table}");				
			}
		});
		mnNewMenu_5.add(mntmbegintable);
		
		//Report Template -> \\caption{...}\\label{...} listener:
		JMenuItem mntmcaptionlabel = new JMenuItem("\\caption{...}\\label{...}");
		mntmcaptionlabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\\\label{...}");	
			}
		});
		mnNewMenu_5.add(mntmcaptionlabel);
		
		//Report Template -> \\begin{tabular}{|c|c|c|}listener:
		JMenuItem mntmbegintabularccc = new JMenuItem("\\begin{tabular}{|c|c|c|}");
		mntmbegintabularccc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{tabular}{|c|c|c|}");
			}
		});
		mnNewMenu_5.add(mntmbegintabularccc);
		
		//Report Template -> \\hline listener:
		JMenuItem mntmhline = new JMenuItem("\\hline");
		mntmhline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("hline");
			}
		});
		mnNewMenu_5.add(mntmhline);
		
		//Report Template -> \\end{tabular} listener:
		JMenuItem mntmendtabular = new JMenuItem("\\end{tabular}");
		mntmendtabular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{tabular}");
			}
		});
		mnNewMenu_5.add(mntmendtabular);
		
		//Report Template -> \\end{table} listener:
		JMenuItem mntmendtable = new JMenuItem("\\end{table}");
		mntmendtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{table}");		
			}
		});
		mnNewMenu_5.add(mntmendtable);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setForeground(Color.BLACK);
		mnNewMenu_5.add(separator_13);
		
		//Report Template -> \\begin{figure} listener:
		JMenuItem mntmbeginfigure = new JMenuItem("\\begin{figure}");
		mntmbeginfigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{figure}");		
			}
		});
		mnNewMenu_5.add(mntmbeginfigure);
		
		//Report Template -> \\inlcudegraphics[width, height]{...} listener:
		JMenuItem mntminlcudegraphicswidthHeight = new JMenuItem("\\inlcudegraphics[width, height]{...}");
		mntminlcudegraphicswidthHeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("inlcudegraphics[width, height]{...}");	
			}
		});
		mnNewMenu_5.add(mntminlcudegraphicswidthHeight);
		
		//Report Template -> \\caption{...}\\label{...} listener:
		JMenuItem mntmcaptionlabel_1 = new JMenuItem("\\caption{...}\\label{...}");
		mntmcaptionlabel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\label{...}");	
			}
		});
		mnNewMenu_5.add(mntmcaptionlabel_1);
		
		//Report Template -> \\end{figure} listener:
		JMenuItem mntmendfigure = new JMenuItem("\\end{figure}");
		mntmendfigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{figure}");	
			}
		});
		mnNewMenu_5.add(mntmendfigure);
		
		mnNewMenu_3.add(mnBookTemplate);
		
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		
		//Book Template -> Chapter listener:
		JMenuItem menuItem = new JMenuItem("\\chapter{...}");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("chapter");
			}
		});
		mnBookTemplate.add(menuItem);
		
		//Book Template -> \\section{} listener:
		JMenuItem menuItem_1 = new JMenuItem("\\section{}");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("section");
			}
		});
		mnBookTemplate.add(menuItem_1);
		
		//Book Template -> \\subsection{} listener:
		JMenuItem menuItem_2 = new JMenuItem("\\subsection{}");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsection");
			}
		});
		mnBookTemplate.add(menuItem_2);
		
		//Book Template -> \\subsubsection{} listener:
		JMenuItem menuItem_3 = new JMenuItem("\\subsubsection{}");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsubsection");
			}
		});
		mnBookTemplate.add(menuItem_3);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setForeground(Color.BLACK);
		mnBookTemplate.add(separator_14);
		
		//Book Template -> \\begin{itemize} listener:
		JMenuItem menuItem_4 = new JMenuItem("\\begin{itemize}");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{itemize}");
			}
		});
		mnBookTemplate.add(menuItem_4);
		
		//Book Template -> \\item ... listener:
		JMenuItem menuItem_5 = new JMenuItem("\\item ...");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnBookTemplate.add(menuItem_5);
		
		//Book Template -> \\end{itemize} listener:
		JMenuItem menuItem_6 = new JMenuItem("\\end{itemize}");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{itemize}");
			}
		});
		mnBookTemplate.add(menuItem_6);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setForeground(Color.BLACK);
		mnBookTemplate.add(separator_15);
		
		//Book Template -> \\begin{enumerate} listener:
		JMenuItem menuItem_7 = new JMenuItem("\\begin{enumerate}");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{enumerate}");
			}
		});
		mnBookTemplate.add(menuItem_7);
		
		//Book Template -> \\item ... listener:
		JMenuItem menuItem_8 = new JMenuItem("\\item ...");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnBookTemplate.add(menuItem_8);
		
		//Book Template -> \\end{enumerate} listener:
		JMenuItem menuItem_9 = new JMenuItem("\\end{enumerate}");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{enumerate}");
			}
		});
		mnBookTemplate.add(menuItem_9);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setForeground(Color.BLACK);
		mnBookTemplate.add(separator_16);
		
		//Book Template -> \\begin{table} listener:
		JMenuItem menuItem_10 = new JMenuItem("\\begin{table}");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{table}");			
			}
		});
		mnBookTemplate.add(menuItem_10);
		
		//Book Template -> \\caption{...}\\label{...} listener:
		JMenuItem menuItem_11 = new JMenuItem("\\caption{...}\\label{...}");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\\\label{...}");	
			}
		});
		mnBookTemplate.add(menuItem_11);
		
		//Book Template -> \\begin{tabular}{|c|c|c|} listener:
		JMenuItem menuItem_12 = new JMenuItem("\\begin{tabular}{|c|c|c|}");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{tabular}{|c|c|c|}");
			}
		});
		mnBookTemplate.add(menuItem_12);
		
		//Book Template -> \\hline listener:
		JMenuItem menuItem_13 = new JMenuItem("\\hline");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("hline");
			}
		});
		mnBookTemplate.add(menuItem_13);
		
		//Book Template -> \\end{tabular} listener:
		JMenuItem menuItem_14 = new JMenuItem("\\end{tabular}");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{tabular}");
			}
		});
		mnBookTemplate.add(menuItem_14);
		
		//Book Template -> \\end{table} listener:
		JMenuItem menuItem_15 = new JMenuItem("\\end{table}");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{table}");		
			}
		});
		mnBookTemplate.add(menuItem_15);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setForeground(Color.BLACK);
		mnBookTemplate.add(separator_17);
		
		//Book Template -> \\begin{figure} listener:
		JMenuItem menuItem_16 = new JMenuItem("\\begin{figure}");
		menuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{figure}");	
			}
		});
		mnBookTemplate.add(menuItem_16);
		
		//Book Template -> \\inlcudegraphics[width, height]{...} listener:
		JMenuItem menuItem_17 = new JMenuItem("\\inlcudegraphics[width, height]{...}");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("inlcudegraphics[width, height]{...}");	
			}
		});
		mnBookTemplate.add(menuItem_17);
		
		//Book Template -> \\caption{...}\\label{...} listener:
		JMenuItem menuItem_18 = new JMenuItem("\\caption{...}\\label{...}");
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\\\label{...}");	
			}
		});
		mnBookTemplate.add(menuItem_18);
		
		//Book Template -> \\end{figure} listener:
		JMenuItem menuItem_19 = new JMenuItem("\\end{figure}");
		menuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{figure}");
			}
		});
		mnBookTemplate.add(menuItem_19);
		
		mnNewMenu_3.add(mnArticleTemplate);
		
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		
		//Article Template -> \\section{} listener:
		JMenuItem menuItem_20 = new JMenuItem("\\section{}");
		menuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("section");
			}
		});
		mnArticleTemplate.add(menuItem_20);
		
		//Article Template -> \\subsection{} listener:
		JMenuItem menuItem_21 = new JMenuItem("\\subsection{}");
		menuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsection");
			}
		});
		mnArticleTemplate.add(menuItem_21);
		
		//Article Template -> \\subsubsection{} listener:
		JMenuItem menuItem_22 = new JMenuItem("\\subsubsection{}");
		menuItem_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsubsection");
			}
		});
		mnArticleTemplate.add(menuItem_22);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setForeground(Color.BLACK);
		mnArticleTemplate.add(separator_18);
		
		//Article Template -> \\begin{itemize} listener:
		JMenuItem menuItem_23 = new JMenuItem("\\begin{itemize}");
		menuItem_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{itemize}");
			}
		});
		mnArticleTemplate.add(menuItem_23);
		
		//Article Template -> \\item ... listener:
		JMenuItem menuItem_24 = new JMenuItem("\\item ...");
		menuItem_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnArticleTemplate.add(menuItem_24);
		
		//Article Template -> \\end{itemize} listener:
		JMenuItem menuItem_25 = new JMenuItem("\\end{itemize}");
		menuItem_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{itemize}");
			}
		});
		mnArticleTemplate.add(menuItem_25);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setForeground(Color.BLACK);
		mnArticleTemplate.add(separator_19);
		
		//Article Template -> \\begin{enumerate} listener:
		JMenuItem menuItem_26 = new JMenuItem("\\begin{enumerate}");
		menuItem_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{enumerate}");
			}
		});
		mnArticleTemplate.add(menuItem_26);
		
		//Article Template -> \\item ... listener:
		JMenuItem menuItem_27 = new JMenuItem("\\item ...");
		menuItem_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnArticleTemplate.add(menuItem_27);
		
		//Article Template -> \\end{enumerate} listener:
		JMenuItem menuItem_28 = new JMenuItem("\\end{enumerate}");
		menuItem_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{enumerate}");
			}
		});
		mnArticleTemplate.add(menuItem_28);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setForeground(Color.BLACK);
		mnArticleTemplate.add(separator_20);
		
		//Article Template -> \\begin{table} listener:
		JMenuItem menuItem_29 = new JMenuItem("\\begin{table}");
		menuItem_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{table}");			
			}
		});
		mnArticleTemplate.add(menuItem_29);
		
		//Article Template -> \\caption{...}\\label{...} listener:
		JMenuItem menuItem_30 = new JMenuItem("\\caption{...}\\label{...}");
		menuItem_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\\\label{...}");	
			}
		});
		mnArticleTemplate.add(menuItem_30);
		
		//Article Template -> \\begin{tabular}{|c|c|c|} listener:
		JMenuItem menuItem_31 = new JMenuItem("\\begin{tabular}{|c|c|c|}");
		menuItem_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{tabular}{|c|c|c|}");
			}
		});
		mnArticleTemplate.add(menuItem_31);
		
		//Article Template -> \\hline listener:
		JMenuItem menuItem_32 = new JMenuItem("\\hline");
		menuItem_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("hline");
			}
		});
		mnArticleTemplate.add(menuItem_32);
		
		//Article Template -> \\end{tabular} listener:
		JMenuItem menuItem_33 = new JMenuItem("\\end{tabular}");
		menuItem_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{tabular}");
			}
		});
		mnArticleTemplate.add(menuItem_33);
		
		//Article Template -> \\end{table} listener:
		JMenuItem menuItem_34 = new JMenuItem("\\end{table}");
		menuItem_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{table}");		
			}
		});
		mnArticleTemplate.add(menuItem_34);
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setForeground(Color.BLACK);
		mnArticleTemplate.add(separator_21);
		
		//Article Template -> \\begin{figure} listener:
		JMenuItem menuItem_35 = new JMenuItem("\\begin{figure}");
		menuItem_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{figure}");	
			}
		});
		mnArticleTemplate.add(menuItem_35);
		
		//Article Template -> \\inlcudegraphics[width, height]{...} listener:
		JMenuItem menuItem_36 = new JMenuItem("\\inlcudegraphics[width, height]{...}");
		menuItem_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("inlcudegraphics[width, height]{...}");	
			}
		});
		mnArticleTemplate.add(menuItem_36);
		
		//Article Template -> \\caption{...}\\label{...} listener:
		JMenuItem menuItem_37 = new JMenuItem("\\caption{...}\\label{...}");
		menuItem_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\\\label{...}");	
			}
		});
		mnArticleTemplate.add(menuItem_37);
		
		//Article Template -> \\end{figure} listener:
		JMenuItem menuItem_38 = new JMenuItem("\\end{figure}");
		menuItem_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{figure}");
			}
		});
		mnArticleTemplate.add(menuItem_38);
		
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		
		mnNewMenu_3.add(mnLetterTemplate);
		
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
		
		mnNewMenu_3.add(mnNewMenu_1);
		
		//Empty Template -> \\chapter{...} listener:
		JMenuItem menuItem_39 = new JMenuItem("\\chapter{...}");
		menuItem_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("chapter");
			}
		});
		mnNewMenu_1.add(menuItem_39);
		
		//Empty Template -> \\section{} listener:
		JMenuItem menuItem_40 = new JMenuItem("\\section{}");
		menuItem_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("section");
			}
		});
		mnNewMenu_1.add(menuItem_40);
		
		//Empty Template -> \\subsection{} listener:
		JMenuItem menuItem_41 = new JMenuItem("\\subsection{}");
		menuItem_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsection");
			}
		});
		mnNewMenu_1.add(menuItem_41);
		
		//Empty Template -> \\subsubsection{} listener:
		JMenuItem menuItem_42 = new JMenuItem("\\subsubsection{}");
		menuItem_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("subsubsection");
			}
		});
		mnNewMenu_1.add(menuItem_42);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		mnNewMenu_1.add(separator);
		
		//Empty Template -> \\begin{itemize} listener:
		JMenuItem menuItem_43 = new JMenuItem("\\begin{itemize}");
		menuItem_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{itemize}");
			}
		});
		mnNewMenu_1.add(menuItem_43);
		
		//Empty Template -> \\item ... listener:
		JMenuItem menuItem_44 = new JMenuItem("\\item ...");
		menuItem_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnNewMenu_1.add(menuItem_44);
		
		//Empty Template -> \\end{itemize} listener:
		JMenuItem menuItem_45 = new JMenuItem("\\end{itemize}");
		menuItem_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{itemize}");
			}
		});
		mnNewMenu_1.add(menuItem_45);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		mnNewMenu_1.add(separator_2);
		
		//Empty Template -> \\begin{enumerate} listener:
		JMenuItem menuItem_46 = new JMenuItem("\\begin{enumerate}");
		menuItem_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{enumerate}");
			}
		});
		mnNewMenu_1.add(menuItem_46);
		
		//Empty Template -> \\item ... listener:
		JMenuItem menuItem_47 = new JMenuItem("\\item ...");
		menuItem_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("item");
			}
		});
		mnNewMenu_1.add(menuItem_47);
		
		//Empty Template -> \\end{enumerate} listener:
		JMenuItem menuItem_48 = new JMenuItem("\\end{enumerate}");
		menuItem_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{enumerate}");
			}
		});
		mnNewMenu_1.add(menuItem_48);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		mnNewMenu_1.add(separator_3);
		
		//Empty Template -> \\begin{table} listener:
		JMenuItem menuItem_49 = new JMenuItem("\\begin{table}");
		menuItem_49.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{table}");			
			}
		});
		mnNewMenu_1.add(menuItem_49);
		
		//Empty Template -> \\caption{...}\\label{...} listener:
		JMenuItem menuItem_50 = new JMenuItem("\\caption{...}\\label{...}");
		menuItem_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\\\label{...}");	
			}
		});
		mnNewMenu_1.add(menuItem_50);
		
		//Empty Template -> \\begin{tabular}{|c|c|c|}} listener:
		JMenuItem menuItem_51 = new JMenuItem("\\begin{tabular}{|c|c|c|}");
		menuItem_51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{tabular}{|c|c|c|}");
			}
		});
		mnNewMenu_1.add(menuItem_51);
		
		//Empty Template -> \\hline:
		JMenuItem menuItem_52 = new JMenuItem("\\hline");
		menuItem_52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("hline");
			}
		});
		mnNewMenu_1.add(menuItem_52);
		
		//Empty Template -> \\end{tabular} listener:
		JMenuItem menuItem_53 = new JMenuItem("\\end{tabular}");
		menuItem_53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{tabular}");
			}
		});
		mnNewMenu_1.add(menuItem_53);
		
		//Empty Template -> \\end{table} listener:
		JMenuItem menuItem_54 = new JMenuItem("\\end{table}");
		menuItem_54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{table}");	
			}
		});
		mnNewMenu_1.add(menuItem_54);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		mnNewMenu_1.add(separator_6);
		
		//Empty Template -> \\begin{figure} listener:
		JMenuItem menuItem_55 = new JMenuItem("\\begin{figure}");
		menuItem_55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("begin{figure}");	
			}
		});
		mnNewMenu_1.add(menuItem_55);
		
		//Empty Template -> \\inlcudegraphics[width, height]{...} listener:
		JMenuItem menuItem_56 = new JMenuItem("\\inlcudegraphics[width, height]{...}");
		menuItem_56.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("inlcudegraphics[width, height]{...}");	
			}
		});
		mnNewMenu_1.add(menuItem_56);
		
		//Empty Template -> \\caption{...}\\label{...} listener:
		JMenuItem menuItem_57 = new JMenuItem("\\caption{...}\\label{...}");
		menuItem_57.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("caption{...}\\\\label{...}");	
			}
		});
		mnNewMenu_1.add(menuItem_57);
		
		//Empty Template -> \\end{figure}:
		JMenuItem menuItem_58 = new JMenuItem("\\end{figure}");
		menuItem_58.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexCommand("end{figure}");
			}
		});
		mnNewMenu_1.add(menuItem_58);
		
		ImageIcon manualIcon = new ImageIcon("manualIcon.png"); // load the image to a imageIcon
		Image imagemanual = manualIcon.getImage(); // transform it 
		Image newimgomanual= imagemanual.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		manualIcon = new ImageIcon(newimgomanual);
		
		this.CurrentVersionLabel = new JLabel("Document Version: "+ versionID);
		CurrentVersionLabel.setBounds(852, 94, 162, 16);
		GUI.getContentPane().add(CurrentVersionLabel);
		
		JButton btnRollBackTo = new JButton("Rollback to Previous Version");
		btnRollBackTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollback();
			}
		});
		btnRollBackTo.setBounds(852, 121, 230, 29);
		
		ImageIcon undoIcon = new ImageIcon("UndoIcon.png"); // load the image to a imageIcon
		Image imageundo = undoIcon.getImage(); // transform it 
		Image newimgoundo= imageundo.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		undoIcon = new ImageIcon(newimgoundo);  // transform it back
		btnRollBackTo.setIcon(undoIcon);
		
		GUI.getContentPane().add(btnRollBackTo);
		
		JLabel lblVersionTracking = new JLabel("Version Tracking Enabled: "+this.versionManager.isEnable());
		lblVersionTracking.setBounds(852, 170, 230, 16);
		GUI.getContentPane().add(lblVersionTracking);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("OFF");
		tglbtnNewToggleButton.setBounds(852, 197, 95, 29);
		GUI.getContentPane().add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton.getText().equals("ON"))
				{
					tglbtnNewToggleButton.setText("OFF");
					GUI.getContentPane().add(tglbtnNewToggleButton);
					lblVersionTracking.setText("Version Tracking Enabled: TRUE");
					GUI.getContentPane().add(lblVersionTracking);
					EnTracking();
				}
				else {
					tglbtnNewToggleButton.setText("ON");
					GUI.getContentPane().add(tglbtnNewToggleButton);
					lblVersionTracking.setText("Version Tracking Enabled: FALSE");
					GUI.getContentPane().add(lblVersionTracking);
					disTracking();
				}
				
			}
		});
		
		JLabel lblVersionStrategy = new JLabel("Version Strategy: VOLATILE");
		lblVersionStrategy.setBounds(852, 240, 300, 16);
		GUI.getContentPane().add(lblVersionStrategy);
		
		JToggleButton tglbtnNewStrategyButton = new JToggleButton("STABLE");
		tglbtnNewStrategyButton.setBounds(852, 267, 95, 29);
		GUI.getContentPane().add(tglbtnNewStrategyButton);
		
		JButton btnCommiteChanges = new JButton("Commit Changes");
		btnCommiteChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commit();
			}
		});
		btnCommiteChanges.setBounds(852, 41, 230, 29);
		
		ImageIcon commitIcon = new ImageIcon("commitIcon.png"); // load the image to a imageIcon
		Image imagecommit = commitIcon.getImage(); // transform it 
		Image newimgcommit = imagecommit.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		commitIcon = new ImageIcon(newimgcommit);  // transform it back
		btnCommiteChanges.setIcon(commitIcon);
		
		GUI.getContentPane().add(btnCommiteChanges);
		tglbtnNewStrategyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewStrategyButton.getText().equals("VOLATILE"))
				{
					tglbtnNewStrategyButton.setText("STABLE");
					GUI.getContentPane().add(tglbtnNewStrategyButton);
					lblVersionStrategy.setText("Version Strategy: VOLATILE");
					GUI.getContentPane().add(lblVersionStrategy);
					changeStrategy();
				}
				else {
					tglbtnNewStrategyButton.setText("VOLATILE");
					GUI.getContentPane().add(tglbtnNewStrategyButton);
					lblVersionStrategy.setText("Version Strategy: STABLE");
					GUI.getContentPane().add(lblVersionStrategy);
					changeStrategy();
				}
				
			}
		});
	}

	public DocumentManager getDocManager() {
		return docManager;
	}

	public void setDocManager(DocumentManager docManager) {
		this.docManager = docManager;
	}

	public VersionsStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(VersionsStrategy strategy) {
		this.strategy = strategy;
	}

	public LatexEditorController getMyController() {
		return myController;
	}

	public void setMyController(LatexEditorController myController) {
		this.myController = myController;
	}

	public JFrame getFrameToUse() {
		return FrameToUse;
	}

	public void setFrameToUse(JFrame frameToUse) {
		FrameToUse = frameToUse;
	}

	public JFrame getGUI() {
		return GUI;
	}

	public void setGUI(JFrame gUI) {
		GUI = gUI;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}

	public void setVersionManager(VersionsManager versionManager) {
		this.versionManager = versionManager;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentVersionLabel(JLabel currentVersionLabel) {
		CurrentVersionLabel = currentVersionLabel;
	}
}