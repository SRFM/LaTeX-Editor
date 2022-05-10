package latexData;

import GUI.LatexEditorView;

public class ManualCommand implements Command {

	private LatexEditorView view;
	private DocumentManager docMan;
	
	public ManualCommand(LatexEditorView view) {
		this.view = view;
		this.docMan = this.view.getDocumentManager();
	}
	
	public void execute() {
		String manualText = this.docMan.getTemplateText(6, "");
		this.view.getTextArea().setText(manualText);
		return;
	}
}