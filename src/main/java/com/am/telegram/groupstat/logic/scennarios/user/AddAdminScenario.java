package com.am.telegram.groupstat.logic.scennarios.user;

import com.am.telegram.groupstat.logic.assistant.Assistant;
import com.am.telegram.groupstat.logic.assistant.AssistantService;
import com.am.telegram.groupstat.logic.assistant.UserAssistant;
import com.am.telegram.groupstat.logic.scennarios.Scenario;
import com.am.telegram.groupstat.logic.user.UserDTO;
import com.am.telegram.groupstat.logic.user.UserService;
import java.util.Optional;

public class AddAdminScenario implements Scenario {

  private final Assistant assistant;

  private final AssistantService assistantService;
  private final UserService userService;

  public AddAdminScenario(
      Assistant assistant, AssistantService assistantService, UserService userService) {
    this.assistant = assistant;
    this.assistantService = assistantService;
    this.userService = userService;
  }

  @Override
  public void execute(long chatId) {
    Optional<UserDTO> userDTO = new UserAssistant(assistant, userService).addAdmin();
    userDTO.ifPresent(userService::save);
    assistantService.save(assistant);
  }
}