public class ImagingSatellite extends Satellite {
    private double resolution;
    private int photosTaken;

    public double getResolution() {
        return resolution;
    }

    public int getPhotosTaken() {
        return photosTaken;
    }

    ImagingSatellite(String name, double resolution) {
        this.name = name;
        this.resolution = resolution;
        batteryLevel = 100.0;
        System.out.println(String.format("Создан спутник: %s (заряд: %f%%)", name, batteryLevel));
    }

    @Override
    public void performMission() {
        if (isActive) {
            takePhoto();
            consumeBattery(0.08);
            System.out.println(String.format("%s: Съемка территории с разрешением %.2f м/пиксель", name, resolution));
            System.out.println(String.format("%s: Снимок #%d сделан!", name, photosTaken));
        }
        else {
            System.out.println("🛑 " + name + ": Не может выполнить съемку - не активен");
        }
    }

    private void takePhoto() {
        photosTaken ++;
    }

    @Override
    public String toString() {
        return String.format("ImagingSatellite{resolution=%.2f, photosTaken=%d, name='%s', isActive=%b, batteryLevel=%.2f}", resolution, photosTaken, name, isActive, batteryLevel);
    }
}
