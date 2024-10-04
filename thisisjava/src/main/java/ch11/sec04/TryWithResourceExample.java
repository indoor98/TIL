package ch11.sec04;

public class TryWithResourceExample {

    public static void main(String[] args) {
        try (MyResourece res = new MyResourece("A")) {
            String data = res.read1();
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        try (MyResourece res = new MyResourece("A")) {
            String data = res.read2();
            int value = Integer.parseInt(data);
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        MyResourece res1 = new MyResourece("A");
        MyResourece res2 = new MyResourece("B");
        try(res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read1();
        } catch (Exception e){
            System.out.println( e.getMessage());
        }
    }


}
