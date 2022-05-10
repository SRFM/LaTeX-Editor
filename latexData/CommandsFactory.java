package latexData;

import GUI.LatexEditorView;

public class CommandsFactory {

	public CommandsFactory() {	
	}
	
	public Command createCommand(String command, LatexEditorView view) {
		if(command.equals("CreateCommand")) {
			return (new CreateCommand(view));
		}
		else if(command.equals("EnableVersionsManagementCommand")) {
			return (new EnableVersionsManagementCommand(view));
		}
		else if(command.equals("DisableVersionsManagementCommand")) {
			return (new DisableVersionsManagementCommand(view));
		}
		else if(command.equals("ChangeVersionsStrategyCommand")) {
			return (new ChangeVersionsStrategyCommand(view));
		}
		else if(command.equals("AddLatexCommand")) {
			return (new AddLatexCommand(view));
		}
		else if(command.equals("EditCommand")) {
			return (new EditCommand(view));
		}
		else if(command.equals("LoadCommand")) {
			return (new LoadCommand(view));
		}
		else if(command.equals("SaveCommand")) {
			return (new SaveCommand(view));
		}
		else if(command.equals("RollbackToPreviousVersionCommand")) {
			return (new RollbackToPreviousVersionCommand(view));
		}
		else if(command.equals("BibliograpgyCommand")) {
			return (new BibliographyCommand(view));
		}
		else if(command.equals("ManualCommand")) {
			return (new ManualCommand(view));
		}
		return null;
	}
}
