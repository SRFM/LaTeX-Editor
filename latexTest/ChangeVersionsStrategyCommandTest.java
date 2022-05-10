package latexTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.ChangeVersionsStrategyCommand;
import latexData.StableVersionsStrategy;
import latexData.VolatileVersionsStrategy;

class ChangeVersionsStrategyCommandTest {

	@Test
	void VolatileToStableStrategyTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		VolatileVersionsStrategy volatileStrategy = new VolatileVersionsStrategy();
		tsiouGui.setStrategy(volatileStrategy);
		ChangeVersionsStrategyCommand cvs = new ChangeVersionsStrategyCommand(tsiouGui);
		cvs.execute();
		StableVersionsStrategy stableStrategy = new StableVersionsStrategy();	
		assertEquals(cvs.getVmanager().getStrategy().getClass(), stableStrategy.getClass());
	}
	@Test
	void StableToVolatileStrategyTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		StableVersionsStrategy stableStrategy = new StableVersionsStrategy();	
		tsiouGui.setStrategy(stableStrategy);
		ChangeVersionsStrategyCommand cvs = new ChangeVersionsStrategyCommand(tsiouGui);
		cvs.getVmanager().setStrategy(stableStrategy);
		cvs.execute();
		VolatileVersionsStrategy volatileStrategy = new VolatileVersionsStrategy();
		assertEquals(cvs.getVmanager().getStrategy().getClass(), volatileStrategy.getClass());
	}

}