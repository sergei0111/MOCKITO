public class FilmRepository {
    private MoviePicture[] items = new MoviePicture[0];
    private int limit;

    public FilmRepository() {
        this.limit = 5;
    }

    public FilmRepository(int limit) {
        this.limit = limit;
    }

    public void add(MoviePicture item) {
        MoviePicture[] tmp = new MoviePicture[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];

        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public MoviePicture[] findAll() {
        return items;
    }

    public MoviePicture[] findLast() {
        int resultLenght;
        if (limit < items.length) {
            resultLenght = limit;
        } else {
            resultLenght = items.length;
            ;
        }

        MoviePicture[] result = new MoviePicture[resultLenght];
        for (int i = 0; i < resultLenght; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}
