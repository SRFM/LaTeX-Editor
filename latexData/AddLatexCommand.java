package latexData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import GUI.LatexEditorView;

public class AddLatexCommand implements Command {
	
	private LatexEditorView view;
	
	public AddLatexCommand(LatexEditorView view) {
		this.view = view;
	}
	
	public void execute() {
		String records = "";
		if(this.view.getCommandToLoad().equals("chapter")) {
			String fileName = "chapter.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
			 
		}
		else if(this.view.getCommandToLoad().equals("section")) {
			String fileName = "section.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("subsection")) {
			String fileName = "subsection.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);;
		}
		else if(this.view.getCommandToLoad().equals("subsubsection")) {
			String fileName = "subsubsection.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);;
			
		}
		else if(this.view.getCommandToLoad().equals("begin{itemize}")) {
			String fileName = "begin{itemize}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
			
		}
		else if(this.view.getCommandToLoad().equals("item")) {
			String fileName = "item.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
			
		}
		else if(this.view.getCommandToLoad().equals("end{itemize}")) {
			String fileName = "end{itemize}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);;
		}
		else if(this.view.getCommandToLoad().equals("begin{enumerate}")) {
			String fileName = "begin{enumerate}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("end{enumerate}")) {
			String fileName = "end{enumerate}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("begin{table}")) {
			String fileName = "begin{table}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("caption{...}\\\\label{...}")) {
			String fileName = "caption{....}label{...tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("begin{tabular}{|c|c|c|}")) {
			String fileName = "begin{tabular}{c}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("hline")) {
			String fileName = "hline.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("end{tabular}")) {
			String fileName = "end{tabular}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("end{table}")) {
			String fileName = "end{table}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("begin{figure}")) {
			String fileName = "begin{figure}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("inlcudegraphics[width, height]{...}")) {
			String fileName = "includegraphics.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
		else if(this.view.getCommandToLoad().equals("end{figure}")) {
			String fileName = "end{figure}.tex";
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
			 int position = this.view.getTextArea().getCaretPosition();
			 System.out.println("Position: "+ position);
			 this.view.getTextArea().insert(records, position);
		}
	}
}
