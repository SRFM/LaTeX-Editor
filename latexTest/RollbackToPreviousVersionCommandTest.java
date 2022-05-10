package latexTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.Document;
import latexData.DocumentManager;
import latexData.RollbackToPreviousVersionCommand;

class RollbackToPreviousVersionCommandTest {

	@Test
	void RollBackToTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		DocumentManager dm = new DocumentManager();
		Document d1 = dm.createDocument("Empty");
		d1.setContents("hahaha");
		Document d2 = dm.createDocument("Empty");
		d2.setContents("...");
		RollbackToPreviousVersionCommand rb = new RollbackToPreviousVersionCommand(tsiouGui);
		rb.getView().getVersionManager().getStrategy().putVersion(d1);
		rb.getView().getVersionManager().getStrategy().putVersion(d2);
		rb.execute();
		assertEquals(rb.getView().getTextArea().getText(), "hahaha");
	}

}
