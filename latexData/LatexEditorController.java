package latexData;

import java.util.HashMap;
import latexData.Command;
import GUI.LatexEditorView;

public class LatexEditorController {
	
	private HashMap <String,Command> commands  = new HashMap <String,Command> ();
	private LatexEditorView view;
	
	public LatexEditorController(LatexEditorView view) {
		this.view = view;
	}
	
	public void init() {
		CommandsFactory factory = new CommandsFactory();
		Command CreateCommand = factory.createCommand("CreateCommand", view);
		Command AddLatexCommand = factory.createCommand("AddLatexCommand", view);
		Command RollbackToPreviousVersionCommand = factory.createCommand("RollbackToPreviousVersionCommand", view);
		Command EditCommand = factory.createCommand("EditCommand", view);
		Command LoadCommand = factory.createCommand("LoadCommand", view);
		Command SaveCommand = factory.createCommand("SaveCommand", view);
		Command EnableVersionsManagementCommand = factory.createCommand("EnableVersionsManagementCommand", view);
		Command DisableVersionsManagementCommand = factory.createCommand("DisableVersionsManagementCommand", view);
		Command ChangeVersionsStrategyCommand = factory.createCommand("ChangeVersionsStrategyCommand", view);
		Command BibliographyCommand = factory.createCommand("BibliograpgyCommand", view);
		Command ManualCommand = factory.createCommand("ManualCommand", view);
		
		commands.put("CreateCommand", CreateCommand);
		commands.put("AddLatexCommand", AddLatexCommand);
		commands.put("RollbackToPreviousVersionCommand", RollbackToPreviousVersionCommand);
		commands.put("EditCommand", EditCommand);
		commands.put("LoadCommand", LoadCommand);
		commands.put("SaveCommand", SaveCommand);
		commands.put("EnableVersionsManagementCommand", EnableVersionsManagementCommand);
		commands.put("DisableVersionsManagementCommand", DisableVersionsManagementCommand);
		commands.put("ChangeVersionsStrategyCommand", ChangeVersionsStrategyCommand);
		commands.put("BibliograpgyCommand", BibliographyCommand);
		commands.put("ManualCommand", ManualCommand);
	}
	
	public HashMap <String,Command> getCommands() {
		return this.commands;
	}
	
	public void enact(String name) {
        Command command = commands.get(name);
        command.execute();
		return;
	}
}