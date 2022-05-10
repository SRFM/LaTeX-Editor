package latexData;

import GUI.LatexEditorView;

public class BibliographyCommand implements Command {

	public LatexEditorView getView() {
		return view;
	}

	public void setView(LatexEditorView view) {
		this.view = view;
	}

	private LatexEditorView view;
	private DocumentManager docMan;
	
	public BibliographyCommand(LatexEditorView view) {
		this.view = view;
		this.docMan = this.view.getDocumentManager();
	}
	
	public void execute() {
		String bibliography = this.docMan.getTemplateText(7, "");
		this.view.getTextArea().setText(bibliography);
		return;
	}
}
