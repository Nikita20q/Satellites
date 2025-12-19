public class CommunicationSatellite extends Satellite{
    private double bandWidth;

    public double getBandWidth() {
        return bandWidth;
    }

    CommunicationSatellite(String name, double bandWidth) {
        this.name = name;
        this.bandWidth = bandWidth;
        batteryLevel = 100.0;
        System.out.println(String.format("Создан спутник: %s (заряд: %f%%)", name, batteryLevel));
    }

    @Override
    protected void performMission() {
        if (isActive) {
            sendData(bandWidth);
            consumeBattery(0.05);
        } else {
            System.out.println("🛑 " + name + ": Не может выполнить передачу данных - не активен");
        }
    }

    private void sendData(double data) {
        if (isActive) {
            System.out.println(String.format("%s: Передача данных со скоростью %.2f Мбит/с", name, data));
            System.out.println(String.format("%s: Отправил %.2f Мбит данных!", name, data));
        }
    }

    @Override
    public String toString() {
        return String.format("CommunicationSatellite{bandwidth=%.2f, name='%s', isActive=%b, batteryLevel=%.2f}", bandWidth, name, isActive, batteryLevel);
    }
}
