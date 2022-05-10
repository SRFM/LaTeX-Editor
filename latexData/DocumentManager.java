package latexData;
import java.io.*;
import java.util.HashMap;

public class DocumentManager {
	
	private static HashMap <String, Document> templates  = new HashMap <String,Document> ();
	
	public DocumentManager() {
	}
	
	public String getTemplateText(int mode, String path) {
		String records = "";
		if (mode == 1) {
			String fileName = "ReportTemplate.tex";
			String line = null;
			 try {
				 FileReader fileReader = new FileReader(fileName);
				 BufferedReader bufferedReader = new BufferedReader(fileReader);
				 while((line = bufferedReader.readLine()) != null) {
		                records += line + "\n";
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
		} else if(mode == 2) {
			String fileName = "LetterTemplate.tex";
			String line = null;
			 try {
				 FileReader fileReader = new FileReader(fileName);
				 BufferedReader bufferedReader = new BufferedReader(fileReader);
				 while((line = bufferedReader.readLine()) != null) {
		                records += line + "\n";
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
		}else if(mode == 3){
			String fileName = "BookTemplate.tex";
			String line = null;
			 try {
				 FileReader fileReader = new FileReader(fileName);
				 BufferedReader bufferedReader = new BufferedReader(fileReader);
				 while((line = bufferedReader.readLine()) != null) {
		                records += line + "\n";
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
		}else if(mode == 4){
			String fileName = "ArticleTemplate.tex";
			String line = null;
			 try {
				 FileReader fileReader = new FileReader(fileName);
				 BufferedReader bufferedReader = new BufferedReader(fileReader);
				 while((line = bufferedReader.readLine()) != null) {
		                records += line + "\n";
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
		}else if (mode == 5) {
			String fileName = "EmptyTemplate.tex";
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
		}
		else if(mode == 6) {
			String fileName = "Latex_Ref.txt";
			String line = null;
			 try {
				 FileReader fileReader = new FileReader(fileName);
				 BufferedReader bufferedReader = new BufferedReader(fileReader);
				 while((line = bufferedReader.readLine()) != null) {
		                records += line + "\n";
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
		}
		else if(mode == 7){
			String fileName = "manual.txt";
			String line = null;
			 try {
				 FileReader fileReader = new FileReader(fileName);
				 BufferedReader bufferedReader = new BufferedReader(fileReader);
				 while((line = bufferedReader.readLine()) != null) {
		                records += line + "\n";
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
		}
		else if(mode == 8) {
			String fileName = path;
			String line = null;
			 try {
				 FileReader fileReader = new FileReader(fileName);
				 BufferedReader bufferedReader = new BufferedReader(fileReader);
				 while((line = bufferedReader.readLine()) != null) {
		                records += line + "\n";
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
		}
		return records;
	}
	
	public void initDocs() {
		Document report = new Document(null ,null, null, "v1", this.getTemplateText(1, ""), null, null);
		Document book = new Document(null, null, null, "v1", this.getTemplateText(3, ""), null, null);
		Document article = new Document(null, null, null, "v1", this.getTemplateText(4, ""), null, null);
		Document letter = new Document(null, null, null, "v1", this.getTemplateText(2, ""), null, null);
		Document empty = new Document(null, null, null, "v1", this.getTemplateText(5, ""), null, null);
		templates.put("Report", report);
		templates.put("Book", book);
		templates.put("Article", article);
		templates.put("Letter", letter);
		templates.put("Empty", empty);
		return;
	}

	public Document createDocument(String DocId){ 
		System.out.println("CreateDocument");
        Document doc = templates.get(DocId);
        return (Document) doc.clone();
	}
	
	public HashMap <String, Document> getTemplates() {
		return this.templates;
	}
}