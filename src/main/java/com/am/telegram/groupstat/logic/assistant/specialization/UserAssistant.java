package com.am.telegram.groupstat.logic.assistant.specialization;

import com.am.telegram.groupstat.logic.Operations;
import com.am.telegram.groupstat.logic.assistant.Assistant;
import com.am.telegram.groupstat.logic.user.UserDTO;
import com.am.telegram.groupstat.logic.user.UserService;
import java.util.Optional;

public class UserAssistant {

  private final Assistant assistant;
  private final UserService userService;

  public UserAssistant(Assistant assistant, UserService userService) {
    this.assistant = assistant;
    this.userService = userService;
  }

  public Optional<UserDTO> removeUser() {
    if (!assistant.isAdmin()) {
      assistant.provideMessageToUser("You have no permissions for this operation");
      return Optional.empty();
    }
    if (assistant.userWroteSomething()) {
      String userName = assistant.lastGivenAnswer();
      Optional<UserDTO> userByName = userService.getUserByName(userName);
      if (userByName.isPresent()) {
        assistant.provideMessageToUser(
            "User with nickname " + assistant.lastGivenAnswer() + " has been removed");
      } else {
        assistant.provideMessageToUser(
            "User with nickname " + assistant.lastGivenAnswer() + " does not exist");
      }

      assistant.memorizeLastActiveOperation(Operations.EMPTY);
      assistant.memorizeLastGivenAnswer(null);
      return userByName;

    } else {
      assistant.memorizeLastActiveOperation(Operations.REMOVE_USER);
      assistant.provideMessageToUser("Please, provide username");
      return Optional.empty();
    }
  }

  public Optional<UserDTO> addAdmin() {
    return addUser(
        Operations.ADD_ADMIN,
        UserDTO.createAdmin(assistant.getUserDTO().getUserName()));
  }

  public Optional<UserDTO> addRegularUser() {
    return addUser(
        Operations.ADD_USER, UserDTO.createUser(assistant.getUserDTO().getUserName()));
  }

  public Optional<UserDTO> addUser(Operations operation, UserDTO user) {

    if (!assistant.isAdmin()) {
      assistant.provideMessageToUser("You have no permissions for this operation");
      return Optional.empty();
    }

    if (assistant.userWroteSomething()) {
      String userName = assistant.lastGivenAnswer();
      user.setUserName(userName);

      assistant.provideMessageToUser(
          "User with nickname " + assistant.lastGivenAnswer() + " has been added");

      assistant.memorizeLastActiveOperation(Operations.EMPTY);
      assistant.memorizeLastGivenAnswer(null);
      return Optional.of(user);

    } else {
      assistant.memorizeLastActiveOperation(operation);
      assistant.provideMessageToUser("Please, provide username");
      return Optional.empty();
    }
  }
}
