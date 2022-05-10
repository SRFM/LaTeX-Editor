package latexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.EnableVersionsManagementCommand;
import latexData.StableVersionsStrategy;
import latexData.VersionsManager;
import latexData.VolatileVersionsStrategy;

class EnableVersionsManagementCommandTest {

	@Test
	void EnableStableStrategyTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		StableVersionsStrategy stableStrategy=new StableVersionsStrategy();
		tsiouGui.setStrategy(stableStrategy);
		tsiouGui.getVersionManager().disable();
		EnableVersionsManagementCommand evmc = new EnableVersionsManagementCommand(tsiouGui);
		evmc.execute();
		assertEquals(evmc.getVmanager().isEnable(), true);
	}
	@Test
	void EnableVolatileStrategyTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		VolatileVersionsStrategy VolatileStrategy=new VolatileVersionsStrategy();
		tsiouGui.setStrategy(VolatileStrategy);
		tsiouGui.getVersionManager().disable();
		EnableVersionsManagementCommand evmc = new EnableVersionsManagementCommand(tsiouGui);
		evmc.execute();
		assertEquals(evmc.getVmanager().isEnable(), true);
	}

}
