abstract public class Satellite {

    protected String name;
    protected boolean isActive;
    protected double batteryLevel;

    public boolean activate() {
        if (batteryLevel > 20) {
            System.out.println("✅ " + name + ": Активация успешна");
            isActive = true;
            return true;
        }
        else {
            System.out.println(String.format("\uD83D\uDED1 %s: Ошибка активации (заряд: %.2f%%)", name, batteryLevel));
            return false;
        }
    }

    void setBatteryLevel(double batteryLevel)
    {
        System.out.println("Уровень заряда спутника: " + name + " изменён с " + this.batteryLevel + "% на " + batteryLevel + "%");
        this.batteryLevel = batteryLevel;
    }

    public void deactivate() {
        if (isActive) {
            isActive = false;
            System.out.println("🛑 " + name + ": Деактивация успешна");
        }
    }
    public void consumeBattery(double charge) {
        batteryLevel -= charge;
        if (batteryLevel < 20) deactivate();
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    abstract protected void performMission();
}