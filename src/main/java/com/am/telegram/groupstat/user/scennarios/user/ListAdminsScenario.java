package com.am.telegram.groupstat.user.scennarios.user;

import com.am.telegram.groupstat.user.assistant.Assistant;
import com.am.telegram.groupstat.user.assistant.ListAssistant;
import com.am.telegram.groupstat.user.scennarios.Scenario;
import com.am.telegram.groupstat.user.user.UserService;

public class ListAdminsScenario implements Scenario {

  private final Assistant assistant;

  private final UserService userService;

  public ListAdminsScenario(Assistant assistant, UserService userService) {
    this.assistant = assistant;
    this.userService = userService;
  }

  @Override
  public void execute(long chatId) {
    new ListAssistant(assistant, userService).listAdmins(chatId);
  }
}