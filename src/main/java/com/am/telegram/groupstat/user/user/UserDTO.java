package com.am.telegram.groupstat.user.user;

import java.time.LocalDateTime;

public class UserDTO {
  private int userId;
  private String userName;
  private boolean isAdmin;
  private boolean hasReadAccess;
  private boolean isSubscribed;
  private String addedBy;
  private LocalDateTime addedAt;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public boolean isHasReadAccess() {
    return hasReadAccess;
  }

  public void setHasReadAccess(boolean hasReadAccess) {
    this.hasReadAccess = hasReadAccess;
  }

  public boolean isSubscribed() {
    return isSubscribed;
  }

  public void setSubscribed(boolean subscribed) {
    isSubscribed = subscribed;
  }

  public String getAddedBy() {
    return addedBy;
  }

  public void setAddedBy(String addedBy) {
    this.addedBy = addedBy;
  }

  public LocalDateTime getAddedAt() {
    return addedAt;
  }

  public void setAddedAt(LocalDateTime addedAt) {
    this.addedAt = addedAt;
  }
}