package latexTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.LoadCommand;

class LoadCommandTest {

	@Test
	void LoadCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();

 		 LoadCommand lc = new LoadCommand(tsiouGui);
		 System.out.println("C:" + lc.getView().getTextArea().getText());
		 lc.getView().setPath("C:\\Users\\NVLACHO\\Documents\\Latex\\BookTemplate.tex");
		 lc.execute();
		 System.out.println("C:" + lc.getView().getTextArea().getText());
		 assertNotEquals(lc.getView().getTextArea().getText(), "");
		 
		 
	}

}
