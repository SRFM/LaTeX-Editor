package latexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.AddLatexCommand;

class AddLatexCommandTest {

	@Test
	void beginEnumerateCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("begin{enumerate}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\begin{enumerate}");
	}
	@Test
	void beginFigureCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("begin{figure}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\begin{figure}");
	}
	@Test
	void beginItemizeCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("begin{itemize}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\begin{itemize}");
	}
	@Test
	void beginTableCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("begin{table}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\begin{table}");
	}
	@Test
	void beginTabularCCCCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("begin{tabular}{|c|c|c|}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\begin{tabular}{|c|c|c|}");
	}
	@Test
	void captionLabelCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("caption{...}\\\\label{...}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\caption{....}\\label{...}");
	}
	@Test
	void chapterCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("chapter");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\chapter{...}");
	}
	@Test
	void endEnumerateCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("end{enumerate}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\end{enumerate} ");
	}
	@Test
	void endFigureCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("end{figure}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\end{figure}");
	}

	@Test
	void endTableCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("end{table}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\end{table}");
	}
	@Test
	void endTabularCommandTest(){
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("end{tabular}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\end{tabular}");
	}
	@Test
	void hlineCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("hline");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\ hline");
	}
	@Test
	void includegraphicsWidthHeightCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("inlcudegraphics[width, height]{...}");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\includegraphics[width=...,height=...]{...}");
	}
	@Test
	void itemCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("item");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\item ...");
	}
	@Test
	void sectionCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("section");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\section{}");
	}
	@Test
	void subsectionCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("subsection");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\subsection{} ");
	}
	@Test
	void subsubsectionCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		tsiouGui.setCommandToLoad("subsubsection");
		AddLatexCommand alc = new AddLatexCommand(tsiouGui);
		alc.execute();
		assertEquals(tsiouGui.getTextArea().getText(), "\\subsubsection{}");
	}

}
