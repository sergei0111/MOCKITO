import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmRepositoryTest {
    MoviePicture item1 = new MoviePicture(1, "Боевик", "Бладшот");
    MoviePicture item2 = new MoviePicture(2, "Мультфильм", "Вперёд");
    MoviePicture item3 = new MoviePicture(3, "Комедия", "Отель Белград");
    MoviePicture item4 = new MoviePicture(4, "Боевик", "Джентельмены");
    MoviePicture item5 = new MoviePicture(5, "Ужасы", "Человек-невидимка");
    MoviePicture item6 = new MoviePicture(6, "Мультфильм", "Тролли. Мировой тур");
    MoviePicture item7 = new MoviePicture(7, "Комедия", "Номер один");

    @Test
    public void addNewFilm() {
        FilmRepository repo = new FilmRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);
        repo.add(item7);

        MoviePicture[] expected = {item1, item2, item3, item4, item5, item6, item7};
        MoviePicture[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllFilm() {
        FilmRepository repo = new FilmRepository(7);
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);
        repo.add(item7);

        MoviePicture[] expected = {item7, item6, item5, item4, item3, item2, item1};
        MoviePicture[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeHigherLimitFilm() {
        FilmRepository repo = new FilmRepository(10);
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);
        repo.add(item7);

        MoviePicture[] expected = {item7, item6, item5, item4, item3, item2, item1};
        MoviePicture[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeMinLimitFilm() {
        FilmRepository repo = new FilmRepository(4);
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);
        repo.add(item7);

        MoviePicture[] expected = {item7, item6, item5, item4};
        MoviePicture[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
