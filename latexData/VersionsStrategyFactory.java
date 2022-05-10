package latexData;

public class VersionsStrategyFactory {
	
	public VersionsStrategyFactory() {
		
	}
	
	public VersionsStrategy createStrategy(String strategy) {
		if(strategy.equals("StableVersionsStrategy")) {
			return (new StableVersionsStrategy());
		}
		else if(strategy.equals("VolatiteVersionsStrategy")) {
			return (new VolatileVersionsStrategy());
		}
		else {
			System.out.println("There is no such version-strategy!");
			return null;
		}
	}
}