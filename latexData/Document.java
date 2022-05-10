package latexData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Document {

	private String author;
	private String date;
	private String copyright;
	private String versionID;
	private String contents;
	private String name;
	private String path;
	
	public Document(String author, String date, String copyright, String versionID, String contents, String name, String path) {
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
		this.name = name;
		this.path = path;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
		return;
	}
	
	public void save() {
		 BufferedWriter output = null;
	        try {
	            File file = new File(this.path + "\\" + this.name +".tex");
	            output = new BufferedWriter(new FileWriter(file));
	            output.write(this.contents);
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	          if ( output != null ) {
	            try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	          }
	        }
	    }
	
	public Document clone() {
		Document cloned = new Document(this.author, this.date, this.copyright, this.versionID, this.contents, this.name, this.path);
		return cloned;
	}
	
	//my setters-->getters
	public String getAuthor() {
		return this.author;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getCopyright() {
		return this.copyright;
	}
	
	public String getVersionID() {
		return this.versionID;
	}
	
	public void setAuthor(String author) {
		this.author = author;
		return;
	}
	
	public void setDate(String date) {
		this.date = date;
		return;
	}
	
	public void setCopyright(String copyright) {
		this.copyright = copyright;
		return;
		
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}
	public void setName(String name) {
		this.name = name;
		return;
	}
	public String getName() {
		return this.name;
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	public void setPath(String path)
	{
		this.path = path;
		return;
	}
}