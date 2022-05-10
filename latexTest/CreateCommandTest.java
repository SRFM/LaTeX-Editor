package latexTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.TextArea;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.CreateCommand;
import latexData.Document;
import latexData.DocumentManager;
import latexData.VersionsManager;
import latexData.VersionsStrategy;

class CreateCommandTest {

	@Test
	void LatexBookDocCreationTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setTemplateType("Book");
		tsiouGui.setName("doc");
		DocumentManager dm = new DocumentManager();
		CreateCommand cc = new CreateCommand(tsiouGui);
		
		cc.execute();
		assertEquals(cc.getDoc().getName(), "doc");
	}
	@Test
	void LatexArticleDocCreationTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setTemplateType("Article");
		tsiouGui.setName("doc1");
		DocumentManager dm = new DocumentManager();
		CreateCommand cc = new CreateCommand(tsiouGui);
		
		cc.execute();
		assertEquals(cc.getDoc().getName(), "doc1");
	}
	@Test
	void LatexReportDocCreationTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setTemplateType("Report");
		tsiouGui.setName("doc2");
		DocumentManager dm = new DocumentManager();
		CreateCommand cc = new CreateCommand(tsiouGui);
		
		cc.execute();
		assertEquals(cc.getDoc().getName(), "doc2");
	}
	@Test
	void LatexLetterDocCreationTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setTemplateType("Letter");
		tsiouGui.setName("doc3");
		DocumentManager dm = new DocumentManager();
		CreateCommand cc = new CreateCommand(tsiouGui);
		
		cc.execute();
		assertEquals(cc.getDoc().getName(), "doc3");
	}
	@Test
	void LatexEmptyDocCreationTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setTemplateType("Empty");
		tsiouGui.setName("doc4");
		DocumentManager dm = new DocumentManager();
		CreateCommand cc = new CreateCommand(tsiouGui);
		
		cc.execute();
		assertEquals(cc.getDoc().getName(), "doc4");
	}
}
