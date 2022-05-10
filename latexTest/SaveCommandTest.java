package latexTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import GUI.LatexEditorView;
import latexData.Document;
import latexData.SaveCommand;

class SaveCommandTest {

	@Test
	void SaveCommandTest() {
		LatexEditorView tsiouGui = new LatexEditorView();
		Document d = new Document("haha", "haha", "haha", "haha", "haha", "haha", "C:\\Users\\NVLACHO\\Documents");
		SaveCommand sv = new SaveCommand(tsiouGui);
		sv.getVersionsManager().getStrategy().putVersion(d);
		sv.execute();
		String records="";
		String fileName =tsiouGui.getPath()+"\\haha.tex";
		String line = null;
		 try {
			 FileReader fileReader = new FileReader(fileName);
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 while((line = bufferedReader.readLine()) != null) {
	                records += line;
	            } 
			 bufferedReader.close(); 
		 } catch(FileNotFoundException ex) {
	            System.out.println(
	                    "Unable to open file '" + 
	                    fileName + "'");                
	            }
	            catch(IOException ex) {
	                System.out.println(
	                    "Error reading file '" 
	                    + fileName + "'");
	            }


		 assertEquals(records, "haha");
	}
}
