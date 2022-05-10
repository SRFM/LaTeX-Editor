package latexData;

import java.util.ArrayList;

public class StableVersionsStrategy  extends VersionsStrategy {

	private ArrayList <Document> list = new ArrayList <Document> ();
	
	public StableVersionsStrategy() {
		
	}
	
	public void putVersion(Document doc) {
		list.add(doc);
	}

	public Document getVersion() {
		Document doc = list.get(list.size() - 1);
		return doc;
	}

	public void setEntireHistory(ArrayList <Document> list) {
		this.list.addAll(list);
	}

	public ArrayList <Document> getEntireHistory() {
		return list;
	}

	public void removeVersion() {
		list.remove(list.size() - 1);
	}
}