import java.util.Random;

public class Car implements Runnable{
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        Khởi tạo điểm start
        int runDistance = 0;
//        Khởi tạo time bắt đầu cuộc đua
        long startTime = System.currentTimeMillis();
//        Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua xe vẫn tiếp tục chạy
        while (runDistance < Main.DISTANCE) {
            try {
//                Random Speed km/h
                int speed = (new Random()).nextInt(20);
//                Calculate traveled distance
                runDistance += speed;
                String log = "| ";
                int percentTravel = (runDistance * 100) / Main.DISTANCE;
                for (int i = 0; i < Main.DISTANCE; i+= Main.STEP) {
                    if (percentTravel >= i + Main.STEP) {
                        log += "=";
                    } else if (percentTravel  >= i && percentTravel < i + Main.STEP) {
                        log += "o";
                    }else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ":" + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println("Car " +  this.name + " broken ...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + "Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
