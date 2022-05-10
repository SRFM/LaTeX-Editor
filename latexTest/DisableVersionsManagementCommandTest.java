package latexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.DisableVersionsManagementCommand;
import latexData.StableVersionsStrategy;
import latexData.VolatileVersionsStrategy;

class DisableVersionsManagementCommandTest {

	@Test
	void DisableStableStrategyTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		StableVersionsStrategy stableStrategy = new StableVersionsStrategy();
		tsiouGui.setStrategy(stableStrategy);
		tsiouGui.getVersionManager().enable();
		DisableVersionsManagementCommand dvmc = new DisableVersionsManagementCommand(tsiouGui); 
		dvmc.execute();
		assertEquals(dvmc.getVmanager().isEnable(), false);
	}
	@Test
	void DisableVolatileStrategyTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		VolatileVersionsStrategy VolatileStrategy = new VolatileVersionsStrategy();
		tsiouGui.setStrategy(VolatileStrategy);
		tsiouGui.getVersionManager().enable();
		DisableVersionsManagementCommand dvmc = new DisableVersionsManagementCommand(tsiouGui); 
		dvmc.execute();
		assertEquals(dvmc.getVmanager().isEnable(), false);
	}

}