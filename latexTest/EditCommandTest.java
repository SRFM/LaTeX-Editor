package latexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.DocumentManager;
import latexData.EditCommand;
import latexData.StableVersionsStrategy;
import latexData.VersionsManager;
import latexData.VersionsStrategy;
import latexData.VolatileVersionsStrategy;

class EditCommandTest {

	@Test
	void test() {
		VersionsStrategy VolatileStrategy=new VolatileVersionsStrategy();
		LatexEditorView tsiouGui =  new LatexEditorView();
		tsiouGui.getVersionManager().isEnable();
		tsiouGui.getVersionManager().setStrategy(VolatileStrategy);
		tsiouGui.setTemplateType("Book");
		EditCommand ec = new EditCommand(tsiouGui);
		ec.setI(0);
		int x1 = ec.getI();
		ec.execute();
		int x2 = ec.getI();
		assertNotEquals(x2 ,x1);
		
	}
}