package latexData;

import GUI.LatexEditorView;

public class EnableVersionsManagementCommand implements Command {
	
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

	private LatexEditorView view;
	private VersionsManager Vmanager;

	public EnableVersionsManagementCommand(LatexEditorView view) {
		this.view = view;
		this.Vmanager = this.view.getVersionManager();
	}
	
	public void execute() {
		this.Vmanager.enable();
		return;
	}
}