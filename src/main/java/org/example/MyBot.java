package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.text;

public class MyBot extends TelegramLongPollingBot {

    private MyBotService myBotService = new MyBotService();
    private Map<Long, String> portfolioAdd = new HashMap<>();
    private Map<String, String> portfolioAddInfo = new HashMap<>();
    private Map<Long, String> portfolioUpdate = new HashMap<>();
    private Map<String, String> portfolioUpdateInfo = new HashMap<>();
    private Map<Long, String> portfolioDelete = new HashMap<>();
    private Map<String, String> portfolioDeleteInfo = new HashMap<>();


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();




            if (message.equals("Add profile")) {
                switch ((portfolioAdd.getOrDefault(chatId, "start"))) {
                    case "start":
                        sendMessage(chatId, "Id ni kiriting :");
                        portfolioAdd.put(chatId, "name");
                        break;
                }
            } else if ("name".equals(portfolioAdd.get(chatId))) {
                portfolioAddInfo.put(chatId + "id", message);
                sendMessage(chatId, "Ismingizni kiriting:");
                portfolioAdd.put(chatId, "familiya");
            } else if ("familiya".equals(portfolioAdd.get(chatId))) {
                portfolioAddInfo.put(chatId + "name", message);
                sendMessage(chatId, "Familiyangizni kiriting:");
                portfolioAdd.put(chatId, "staj");
            } else if ("staj".equals(portfolioAdd.get(chatId))) {
                portfolioAddInfo.put(chatId + "name", message);
                sendMessage(chatId, " \uD83E\uDDFE Qanchalik tajribangiz bor :");
                portfolioAdd.put(chatId, "location");
            } else if ("location".equals(portfolioAdd.get(chatId))) {
                portfolioAddInfo.put(chatId + "name", message);
                sendMessage(chatId, "\uD83D\uDCCD Salon joylashuvingizni yuboring :");
                portfolioAdd.put(chatId, "works");
            } else if ("works".equals(portfolioAdd.get(chatId))) {
                portfolioAddInfo.put(chatId + "name", message);
                sendMessage(chatId, "\uD83D\uDCF8 Endi ishingizning 10 tagacha suratini yuklang." + " Ishingiz tugagach, \"Bajarildi\" tugmasini bosing.");
                portfolioAdd.put(chatId, "finish");
            } else if ("finish".equals(portfolioAdd.get(chatId))) {
                portfolioAddInfo.put(chatId + "name", message);
                int id = Integer.parseInt(portfolioAdd.get(chatId + "id"));
                String name = portfolioAddInfo.get(chatId + "name");
                String familiya = portfolioAddInfo.get(chatId + "familiya");
                String staj = portfolioAddInfo.get(chatId + "staj");
                String location = portfolioAddInfo.get(chatId + "location");
                String works = portfolioAddInfo.get(chatId + "works");

                System.out.println(" Name : " + name + " \n Familiya " + familiya);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("Name : " + name + "\nFamiliya" + familiya);


                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

            if (message.equals("/start")) {
                try {
                    execute(myBotService.language(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }
            if (message.equals("Uzbek \uD83C\uDDFA\uD83C\uDDFF")) {
                try {
                    execute(myBotService.Uzbek(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            Long chatId = callbackQuery.getMessage().getChatId();
            String data = callbackQuery.getData();
            String userName = update.getMessage().getChat().getUserName();

            System.out.println(data);
            System.out.println(userName);


            if(data.equals("call")){
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("""
                        <a href = '@umidovna_ru'> Aloqaga chiqish </a>
                        """);
                sendMessage.setParseMode(ParseMode.HTML);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

            if (data.equals("date_1")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_2")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_3")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_4")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_5")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_6")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_7")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_8")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_9")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_10")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_11")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_12")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_13")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_14")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_15")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_16")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_17")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_18")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_19")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_20")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_21")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_22")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_23")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_24")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_25")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_26")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_27")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_28")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_29")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("date_30")) {
                try {
                    execute(myBotService.Time(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("bron")) {
                try {
                    execute(myBotService.HomeOrSalon(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("t_1")) {
                try {
                    execute(myBotService.TipMakeup(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("t_2")) {
                try {
                    execute(myBotService.TipMakeup(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("t_3")) {
                try {
                    execute(myBotService.TipMakeup(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("t_4")) {
                try {
                    execute(myBotService.TipMakeup(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("t_5")) {
                try {
                    execute(myBotService.TipMakeup(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("t_6")) {
                try {
                    execute(myBotService.TipMakeup(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("salon")) {
                try {
                    execute(myBotService.Brontext(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("home")) {
                try {
                    execute(myBotService.Brontext(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("salon")) {
                try {
                    execute(myBotService.Date(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("home")) {
                try {
                    execute(myBotService.Date(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("wedding")) {
                try {
                    execute(myBotService.Wedding(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("kelin")) {
                try {
                    execute(myBotService.Wed2(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("kelin1")) {
                try {
                    execute(myBotService.Wed3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("kelin2")) {
                try {
                    execute(myBotService.Wed4(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("ok")) {
                try {
                    execute(myBotService.Ok(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("ok1")) {
                try {
                    execute(myBotService.Ok(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("ok2")) {
                try {
                    execute(myBotService.Ok(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("ok3")) {
                try {
                    execute(myBotService.Ok(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party")) {
                try {
                    execute(myBotService.Party(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("partyOne")) {
                try {
                    execute(myBotService.Party1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party1")) {
                try {
                    execute(myBotService.Party2(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party2")) {
                try {
                    execute(myBotService.Party3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party3")) {
                try {
                    execute(myBotService.Party4(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party_ok")) {
                try {
                    execute(myBotService.Ok1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party_ok1")) {
                try {
                    execute(myBotService.Ok1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party_ok2")) {
                try {
                    execute(myBotService.Ok1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party_ok3")) {
                try {
                    execute(myBotService.Ok1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("party_ok4")) {
                try {
                    execute(myBotService.Ok1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo")) {
                try {
                    execute(myBotService.Photo(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo1")) {
                try {
                    execute(myBotService.Photo1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo2")) {
                try {
                    execute(myBotService.Photo2(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo3")) {
                try {
                    execute(myBotService.Photo3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo_ok")) {
                try {
                    execute(myBotService.Ok3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo_ok1")) {
                try {
                    execute(myBotService.Ok3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo_ok2")) {
                try {
                    execute(myBotService.Ok3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("photo_ok3")) {
                try {
                    execute(myBotService.Ok3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("yes")) {
                try {
                    execute(myBotService.Visagist(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("yes1")) {
                try {
                    execute(myBotService.Visagist(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("yes2")) {
                try {
                    execute(myBotService.Visagist(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("works1")) {
                try {
                    execute(myBotService.Works(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("works1")) {
                try {
                    execute(myBotService.Work1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("works1")) {
                try {
                    execute(myBotService.Work2(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("works1")) {
                try {
                    execute(myBotService.Work3(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("works1")) {
                try {
                    execute(myBotService.Work4(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("works1")) {
                try {
                    execute(myBotService.VisagistText(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("ha")) {
                try {
                    execute(myBotService.Save(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }
            if (data.equals("portfolio")) {
                try {
                    execute(myBotService.Visagist1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public SendMessage sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        return sendMessage;
    }


    @Override
    public String getBotUsername() {
        return "t.me/makeupToOrder_bot";
    }

    @Override
    public String getBotToken() {
        return "7751496059:AAH0gaBUtn8tMxueMeCzYh9ydGZh_3qaUs0";
    }
}
