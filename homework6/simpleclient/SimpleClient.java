package java2.homework6.simpleclient;

import java2.homework6.transceiver.Transceiver;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class SimpleClient {

    private final static String SERVER_HOST = "localhost";
    private final static int SERVER_PORT = 8081;
    private static Socket clientSocket;

    public static void main(String[] args) {
        System.out.println("Домашняя работа №6. Клиент консольного чата.");

        initConnection();
        startTransceiver();
        closeConnection();
        System.out.println("До свидания...");
        System.exit(-1);
    }


    private static void startTransceiver() {
        Transceiver transceiver = new Transceiver("Клиент", "/stop");
        transceiver.setSocket(clientSocket);

        Thread sender = transceiver.checkAndRunSender();
        Thread receiver = transceiver.checkAndRunReceiver();


        try {
            /*Если сервер отвалится, то receiver сразу среагирует.
              Поэтому делаем ожидание этого потока. Если receiver завершится - будет завершение работы*/
            receiver.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    private static void initConnection() {
        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);

            System.out.println("Соединение установлено");
        } catch (ConnectException e) {
            System.out.println("Не удалось установить соединение с сервером");
            e.printStackTrace();
            System.exit(-2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {


        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
