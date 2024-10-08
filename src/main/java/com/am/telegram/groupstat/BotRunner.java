package com.am.telegram.groupstat;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class BotRunner implements ApplicationRunner {
  private final TelegramBot bot;
  private final StatController updateListener;

  public BotRunner(TelegramBot bot, StatController updateListener) {
    this.bot = bot;
    this.updateListener = updateListener;
  }

  @Override
  public void run(ApplicationArguments args) {
    bot.setUpdatesListener(updateListener);
  }
}
