package ch9.sec07;

public class Chatting {

    // 인스턴스 멤버 클래스
    class Chat {
        void start() {}
        void sendMessage(String message) {}
    }

    void startChat(String chatId) {
        String nickName = chatId;
        Chat chat = new Chat() {
            @Override
            public void start() {
                while(true) {
                    String inputData = "hi";
                    String message = "[" + nickName + "]" + inputData;
                    sendMessage(message);
                }
            }
        };

        chat.start();
    }
}