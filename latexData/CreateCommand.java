package latexData;

import java.awt.TextArea;

import GUI.LatexEditorView;

public class CreateCommand implements Command {

	private LatexEditorView view;
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private Document doc;
	
	public CreateCommand(LatexEditorView view) {
		this.view = view;
		this.documentManager = view.getDocumentManager();
		this.versionsManager = view.getVersionManager();
	}
	
	public void execute() {
		String template = view.getTemplateType();	
		this.doc = this.documentManager.createDocument(template);
		doc.setName(this.view.getName());
		
		TextArea textarea = this.view.getTextArea();
		textarea.setText(this.doc.getContents());
		this.versionsManager.setCurrentVersion(doc);
		System.out.println("DOC:" + doc.getContents().toString());
		return;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
}
