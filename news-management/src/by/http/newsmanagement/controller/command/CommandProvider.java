package by.http.newsmanagement.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.http.newsmanagement.controller.command.impl.CreateNewsCommand;
import by.http.newsmanagement.controller.command.impl.DeleteNewsCommand;
import by.http.newsmanagement.controller.command.impl.DeleteSelectedNewsCommand;
import by.http.newsmanagement.controller.command.impl.FillNewsCommandImpl;
import by.http.newsmanagement.controller.command.impl.ViewAllNewsCommand;
import by.http.newsmanagement.controller.command.impl.ViewNewsCommand;
import by.http.newsmanagement.controller.command.impl.LocalizationCommand;
import by.http.newsmanagement.controller.command.impl.MainPageCommand;
import by.http.newsmanagement.controller.command.impl.UpdateNewsCommand;
import by.http.newsmanagement.controller.command.impl.UpdateNewsSaveCommand;
import by.http.newsmanagement.controller.command.impl.WelcomeCommandImpl;
import by.http.newsmanagement.controller.command.impl.localization.LocalizationCreateNewsCommand;
import by.http.newsmanagement.controller.command.impl.localization.LocalizationMainCommand;
import by.http.newsmanagement.controller.command.impl.localization.LocalizationUpdateNewsCommand;
import by.http.newsmanagement.controller.command.impl.localization.LocalizationViewNewsCommand;

public class CommandProvider {
private Map<String, Command> command = new HashMap<>();
	
public CommandProvider() {
	command.put(ParameterCommand.CREATE_NEWS, new CreateNewsCommand());
	
	command.put(ParameterCommand.VIEW_NEWS, new ViewNewsCommand());
	command.put(ParameterCommand.VIEW_ALL_NEWS, new ViewAllNewsCommand());
	
	command.put(ParameterCommand.UPDATE_NEWS, new UpdateNewsCommand());
	command.put(ParameterCommand.UPDATE_NEWS_SAVE, new UpdateNewsSaveCommand());
	
	command.put(ParameterCommand.DELETE_NEWS, new DeleteNewsCommand());
	command.put(ParameterCommand.DELETE_SELECTED_NEWS, new DeleteSelectedNewsCommand());
	

	command.put(ParameterCommand.WELCOME_PAGE, new WelcomeCommandImpl());
	command.put(ParameterCommand.MAIN_PAGE, new MainPageCommand());
	command.put(ParameterCommand.FILL_NEWS, new FillNewsCommandImpl());
	
	command.put(ParameterCommand.LOCALIZATION, new LocalizationCommand());
	
	command.put(ParameterCommand.LOCALIZATION_VIEW_NEWS_PAGE, new LocalizationViewNewsCommand());
	command.put(ParameterCommand.LOCALIZATION_UPDATE_NEWS_COMMAND, new LocalizationUpdateNewsCommand());
	command.put(ParameterCommand.LOCALIZATION_MAIN_PAGE, new LocalizationMainCommand());
	command.put(ParameterCommand.LOCALIZATION_CREATE_NEWS_PAGE, new LocalizationCreateNewsCommand());
}

public Command getCommand(String commandName) {
	return command.get(commandName);
	}
}
