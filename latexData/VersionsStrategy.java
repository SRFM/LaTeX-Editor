package latexData;
import java.util.ArrayList;
import java.util.List;

public abstract class VersionsStrategy {
	
	public abstract void putVersion(Document doc);	
	public abstract Document getVersion();
	
	public abstract void setEntireHistory(ArrayList <Document> list);
	public abstract ArrayList <Document> getEntireHistory();
	public abstract void removeVersion();
}