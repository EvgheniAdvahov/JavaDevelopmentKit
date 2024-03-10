package org.example.client;


import org.example.server.ServerController;

/**
 * класс содержащий логику работы клиента
 *
 * @clientView абстракция графического интерфейса
 * @server объект для связи с сервером
 */
public class ClientController {

    private boolean connected;
    private String name;
    private ClientView clientView;
    private ServerController server;

    /**
     * Сеттеры
     *
     * @param clientView
     */
    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    public void setServer(ServerController server) {
        this.server = server;
    }

    public boolean isConnected() {
        return connected;
    }

    /**
     * Метод попытки подключения к серверу. Вызывается из GUI
     *
     * @param clientGUI имя пользователя, которым будем подписывать исходящие сообщения
     * @return ответ от сервера. true, если прошли авторизацию
     */
    public boolean connectToServer(ClientGUI clientGUI) {
        if (server.connectUser(clientGUI)) {
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null) {
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }


    public void message(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.message(text);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    /**
     * Метод отключения от сервера инициализированное сервером
     */
    public void disconnectedFromServer(ClientView clientView) {
        connected = false;
        clientView.disconnectedFromServer();
        clientView.showMessage("Вы были отключены от сервера!");
//        почему не работает
//        showOnWindow("Вы были отключены от сервера!");
    }

    /**
     * Метод вывода сообщения на GUI
     *
     * @param text текст, который требуется вывести на экран
     */
    private void showOnWindow(String text) {
        clientView.showMessage(text);
    }

    /**
     * Метод отключения от сервера инициализированное клиентом (например закрыто GUI)
     */
    public void disconnectUserFromServer(ClientView clientView) {
        server.disconnectUser(clientView);
    }


}

