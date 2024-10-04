package ch9.sec06.exam01;

public class Button {

    // Button 객체 없이 사용할 수 있는 static 중첩 인터페이스
    public static interface ClickListener {
        void onClick();
    }
}
