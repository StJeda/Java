package lab4.secondPart.Listing;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import lab4.secondPart.Aggregates.MagazineAggregate;
import lab4.secondPart.Enums.Frequency;
import lab4.secondPart.ValueObjects.Article;
import lab4.secondPart.ValueObjects.Person;

public class Listing {
    public static void main(String[] args) {
        var author1 = new Person("John", "Doe", new Date(1985 - 1900, 5, 12));
        var author2 = new Person("Jane", "Smith", new Date(1990 - 1900, 8, 22));

        var article1 = new Article(author1, "Java VS NetCore", 4.5, 12.5);
        var article2 = new Article(author2, "Modern Java", 4.8, 15.2);
        var article3 = new Article(author1, "Streams in Java", 4.7, 10.0);
        var article4 = new Article(author2, "Advanced Rust", 4.9, 18.3);

        var mag1 = new MagazineAggregate("Tech Weekly", Frequency.Weekly, new Date(2024 - 1900, 11, 1), 10000, List.of(article1, article3));
        var mag2 = new MagazineAggregate("Java Monthly", Frequency.Monthly, new Date(2024 - 1900, 11, 15), 20000, List.of(article2, article4));

        mag1 = mag1.addArticles(new Article(author1, "Reactive Programming", 4.6, 11.5));

        mag2 = mag2.removeArticle("Modern Java");

        System.out.println("Articles by "
                + author1.firstName()
                + "" + author1.lastName()
                + ":");

        Stream.of(mag1, mag2)
                .flatMap(mag -> mag.getArticles().stream())
                .filter(article -> article.author().equals(author1))
                .forEach(System.out::println);

        Frequency userFrequency = Frequency.Monthly;

        System.out.println("\nMagazines with frequency " + userFrequency + ":");

        Stream.of(mag1, mag2)
                .filter(mag -> false)
                .forEach(System.out::println);

        System.out.println("\nMagazine with most articles:");

        Stream.of(mag1, mag2)
                .max(Comparator.comparingInt(mag -> mag.getArticles().size()))
                .ifPresent(System.out::println);

        System.out.println("\nMagazine with most content:");

        Stream.of(mag1, mag2)
                .max(Comparator.comparingDouble(mag -> mag.getArticles().stream()
                        .mapToDouble(Article::length)
                        .sum()))
                .ifPresent(System.out::println);
    }
}
