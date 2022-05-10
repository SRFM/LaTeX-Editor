package latexData;

import GUI.LatexEditorView;

public class LoadCommand implements Command {
	
	private LatexEditorView view;
	private DocumentManager docMan;
	
	public LoadCommand(LatexEditorView view) {
		this.view = view;
		this.docMan = this.view.getDocumentManager();
	}
	
	public void execute() {
		String path = this.view.getPath();
		int index = path.lastIndexOf("\\");
		String fileName = path.substring(index + 1);
		this.view.setName(fileName);
		String contents = this.docMan.getTemplateText(8, path);
		this.view.getTextArea().setText(contents);
		System.out.println("Name:" + this.view.getName());
		
		if(contents != null) {
			String firstLine = contents.substring(0, contents.indexOf("\n"));
			if(firstLine.contains("book")) {
				this.view.setTemplateType("Book");
				System.out.println("Template Type: " + this.view.getTemplateType());
				return;
			}
			else if(firstLine.contains("article")) {
				this.view.setTemplateType("Article");
				System.out.println("Template Type: " + this.view.getTemplateType());
				return;
			}
			else if(firstLine.contains("report")) {
				this.view.setTemplateType("Report");
				System.out.println("Template Type: " + this.view.getTemplateType());
				return;
			}
			else if(firstLine.contains("letter")) {
				this.view.setTemplateType("Letter");
				System.out.println("Template Type: " + this.view.getTemplateType());
				return;
			}
			else {
				this.view.setTemplateType("Empty");
				System.out.println("Template Type: " + this.view.getTemplateType());
				return;
			}
		}
		this.view.setTemplateType("Empty");
		System.out.println("Template Type: " + this.view.getTemplateType());
		return;
	}

	public DocumentManager getDocMan() {
		return docMan;
	}

	public void setDocMan(DocumentManager docMan) {
		this.docMan = docMan;
	}

	public LatexEditorView getView() {
		return view;
	}

	public void setView(LatexEditorView view) {
		this.view = view;
	}
}
