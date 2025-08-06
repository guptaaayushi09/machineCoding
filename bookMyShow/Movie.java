package machineCoding.bookMyShow;

public class Movie {
    private final String id;
    private final String title;
    private final String description;
    private final int durationIndMinutes;

    public Movie(String id, String title, String description, int durationIndMinutes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.durationIndMinutes = durationIndMinutes;
    }

    public int getDurationTimeInMinutes() {
        return this.durationIndMinutes;
    }
}
