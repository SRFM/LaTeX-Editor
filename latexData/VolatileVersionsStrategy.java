package latexData;

import java.util.ArrayList;

public class VolatileVersionsStrategy extends VersionsStrategy {

	private ArrayList<Document> list = new ArrayList<Document>();
	
	public VolatileVersionsStrategy() {
		
	}
	
	public void putVersion(Document doc) {
		doc.setVersionID("v" + this.list.size() + 1);
		this.list.add(doc);
		return;
	}

	public Document getVersion() {
		Document doc = this.list.get(this.list.size() - 1);
		return doc;
	}

	public void setEntireHistory(ArrayList <Document> list) {
		this.list.addAll(list);
	}

	public ArrayList <Document> getEntireHistory() {
		return this.list;
	}

	public void removeVersion() {
		if(list.size() > 0) {
			list.remove(list.size() - 1);
		}
		else {
			System.out.println("There is no other version to remove the current and go back.");
		}
	}

}