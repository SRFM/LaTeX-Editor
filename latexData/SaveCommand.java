package latexData;

import java.awt.TextArea;

import GUI.LatexEditorView;

public class SaveCommand implements Command {
	
	private LatexEditorView view;
	private VersionsManager versionsManager;
	private String path;

	public SaveCommand(LatexEditorView view) {
		this.view = view;
		this.versionsManager = view.getVersionManager();
		this.path = this.view.getPath();
	}

	public void execute() {
		VersionsStrategy strategy = this.versionsManager.getStrategy();
		Document doc = strategy.getVersion();
		doc.setPath(this.view.getPath());
		doc.save();
	}

	public LatexEditorView getView() {
		return view;
	}

	public void setView(LatexEditorView view) {
		this.view = view;
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}