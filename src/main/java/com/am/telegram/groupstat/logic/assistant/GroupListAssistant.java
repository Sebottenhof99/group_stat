package com.am.telegram.groupstat.logic.assistant;

import com.am.telegram.groupstat.logic.group.GroupManagementService;

public class GroupListAssistant {

  private final Assistant assistant;
  private final GroupManagementService groupManagementService;

  public GroupListAssistant(Assistant assistant, GroupManagementService groupManagementService) {
    this.assistant = assistant;
    this.groupManagementService = groupManagementService;
  }

  public void listGroups() {
    if (assistant.isAdmin() || assistant.hasReadAccess()) {
      assistant.provideMessageToUser("Groups: \n" + groupManagementService.groups());
    }
  }
}