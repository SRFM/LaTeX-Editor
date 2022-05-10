package latexData;

import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.LatexEditorView;

public class EditCommand implements Command {
	
	private LatexEditorView view;
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private int i = 0;
	
	public EditCommand(LatexEditorView view) {
		this.view = view;
		this.documentManager = view.getDocumentManager();
		this.versionsManager = view.getVersionManager();
	}
	
	public void execute() {
		VersionsStrategy VolatileStrategy = new VolatileVersionsStrategy();
		VersionsStrategy StableStrategy = new StableVersionsStrategy();
		
		if(this.versionsManager.isEnable() && this.versionsManager.getStrategy().getClass() == VolatileStrategy.getClass()) {
			String template = view.getTemplateType();
			Document doc = this.documentManager.createDocument(template);
			doc.setName(this.view.getName());
			
			TextArea textarea = this.view.getTextArea();
			doc.setContents(textarea.getText());
			this.versionsManager.setCurrentVersion(doc);
			
			String contents = textarea.getText();
			System.out.println("Edited DOC:" + contents);
			
			JLabel temp = this.view.getCurrentVersionLabel();
			this.view.setVersionID(1);
			temp.setText("Document Version: " + this.view.getVersionID());
			i = 1;
			return;			
		}
		else if(this.versionsManager.isEnable() && this.versionsManager.getStrategy().getClass() == StableStrategy.getClass()) {
			String template = view.getTemplateType();
			Document doc = this.documentManager.createDocument(template);
			doc.setName(this.view.getName());
			
			TextArea textarea = this.view.getTextArea();
			doc.setContents(textarea.getText());
			this.versionsManager.setCurrentVersion(doc);
			
			String contents = textarea.getText();
			System.out.println("Edited DOC:" + contents);
			JLabel temp = this.view.getCurrentVersionLabel();
			this.view.setVersionID(1);
			temp.setText("Document Version: " + this.view.getVersionID());
			this.versionsManager.getStrategy().getVersion().save();
			i = 2;
			return;			
		}
		else {
			String message = "Versions tracking mechanism is OFF. Cannot commit anything!";
				    JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
				        JOptionPane.ERROR_MESSAGE);
		    i = 3;
		}

	}





	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public DocumentManager getDocumentManager() {
		return documentManager;
	}

	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}

}
