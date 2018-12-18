package clock;

public class Clock {
    private Integer hours = 0;
    private Integer minutes = 0;

    public void getTime() {
        String hours = checkNeedForZero(this.hours);
        String minutes = checkNeedForZero(this.minutes);

        System.out.printf("The current time is %s:%s hours\n\n", hours, minutes);
    }

    private String checkNeedForZero(Integer time) {
        if (time < 10) {
            return "0" + time;
        } else {
            return "" + time;
        }
    }

    public void addMinutes(Integer newMinutes) {
        Integer totalMinutes = (hours * 60) + minutes + newMinutes;

        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void subtractMinutes(Integer newMinutes) {
        Integer totalMinutes = (hours * 60) + minutes - newMinutes;

        Integer currentHours = totalMinutes / 60;
        Integer currentMinutes = totalMinutes % 60;

        if (currentHours < 0 || currentMinutes < 0) {
            System.out.println("Your time becomes negative. Please enter correct value!");
        } else {
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }
}
