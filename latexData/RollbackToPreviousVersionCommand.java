package latexData;

import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.LatexEditorView;

public class RollbackToPreviousVersionCommand implements Command {
	
	private LatexEditorView view;
	private VersionsManager Vmanager;

	public RollbackToPreviousVersionCommand(LatexEditorView view) {
		this.view = view;
		this.Vmanager = view.getVersionManager();
	}

	public LatexEditorView getView() {
		return view;
	}

	public void setView(LatexEditorView view) {
		this.view = view;
	}

	public VersionsManager getVmanager() {
		return Vmanager;
	}

	public void setVmanager(VersionsManager vmanager) {
		Vmanager = vmanager;
	}

	public void execute() {
		if( this.Vmanager.isEnable() == false) {
			String message = "Versions manager is OFF. Please activate versions manager and try again!";
		    JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
		        JOptionPane.ERROR_MESSAGE);
		    return;
		}
		if(	this.Vmanager.getStrategy().getEntireHistory().size() > 1) {
			this.Vmanager.rollbackToPrevioysVersion();
			
			Document doc = this.Vmanager.getStrategy().getVersion();
			String toSet = doc.getContents().toString();
			System.out.println("ROLLED BACK:" + toSet);
			this.view.getTextArea().setText(toSet);
			System.out.println("ROLLING BACK OK");
			JLabel temp = this.view.getCurrentVersionLabel();
			this.view.setVersionID(-1);
			temp.setText("Document Version: " + this.view.getVersionID());
			return;
		}
		else {
			String message = "There is no other version to roll back to!";
		    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
		        JOptionPane.ERROR_MESSAGE);
		    return;

		}
	}
}
