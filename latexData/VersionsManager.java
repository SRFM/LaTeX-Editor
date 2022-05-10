package latexData;
import java.awt.TextArea;
import java.util.ArrayList;

import GUI.LatexEditorView;

public class VersionsManager {

	private boolean enabled;
	private VersionsStrategy strategy;
	private LatexEditorView view;
	
	public VersionsManager(VersionsStrategy strategy, LatexEditorView view) {
		this.strategy = strategy;
		this.view = view;
		return;
	}
	
	public void enable() {
		this.enabled = true;
		return;
	}
	
	public void disable() {
		this.enabled = false;
		return;
	}
	
	public boolean isEnable() {
		return this.enabled;
	}
	
	public void setStrategy(VersionsStrategy strategy) {
		strategy.getEntireHistory().addAll(this.strategy.getEntireHistory());
		this.strategy = strategy;
		return;
	}
	
	public void setCurrentVersion(Document doc) {
		if(enabled == false) {
			System.out.println("ENABLED == FALSE");
			return;
		}
		this.strategy.putVersion(doc);
		return;
	}
	
	public Document getPreviousVersion() {
		Document doc = strategy.getEntireHistory().get((strategy.getEntireHistory()).size() - 1);
		return doc;
	}
	
	public void rollbackToPrevioysVersion() {
		if(enabled == true) {
			strategy.removeVersion();
			return;
		}
		else {
			System.out.println("VersionsManager is disabled");
			return;
		}
	}
	public VersionsStrategy getStrategy() {
		return this.strategy;
	}
}
