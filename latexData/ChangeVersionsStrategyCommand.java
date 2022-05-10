package latexData;

import GUI.LatexEditorView;

public class ChangeVersionsStrategyCommand implements Command {
	
	private LatexEditorView view;
	private VersionsManager Vmanager;
	
	public ChangeVersionsStrategyCommand(LatexEditorView view) {
		this.view = view;
		this.Vmanager = this.view.getVersionManager();
	}
	
	public void execute() {
		VolatileVersionsStrategy volatileStrategy = new VolatileVersionsStrategy();
		if (this.Vmanager.getStrategy().getClass() == volatileStrategy.getClass()) {
			StableVersionsStrategy stableStrategy = new StableVersionsStrategy();			
			this.Vmanager.setStrategy(stableStrategy);
			System.out.println("Changed from Volatile to Stable");
		}
		else {
			this.Vmanager.setStrategy(volatileStrategy);
			System.out.println("Changed from Stable to Volatile");
		}
	}

	public VersionsManager getVmanager() {
		return Vmanager;
	}

	public void setVmanager(VersionsManager vmanager) {
		Vmanager = vmanager;
	}
}