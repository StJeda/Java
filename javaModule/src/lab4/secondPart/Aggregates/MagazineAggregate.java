package lab4.secondPart.Aggregates;

import lab4.secondPart.Enums.Frequency;
import lab4.secondPart.ValueObjects.Article;

import java.util.*;
import java.util.stream.Collectors;

public final class MagazineAggregate {
    private final String name;
    private final Frequency frequency;
    private final Date releaseDate;
    private final int circulation;
    private final List<Article> articles;

    public MagazineAggregate(String name, Frequency frequency, Date releaseDate, int circulation, List<Article> articles) {
        this.name = name;
        this.frequency = frequency;
        this.releaseDate = new Date(releaseDate.getTime());
        this.circulation = circulation;
        this.articles = new ArrayList<>(articles);
    }

    public String getName() {
        return name;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public Date getReleaseDate() {
        return new Date(releaseDate.getTime());
    }

    public int getCirculation() {
        return circulation;
    }

    public List<Article> getArticles() {
        return Collections.unmodifiableList(articles);
    }

    public MagazineAggregate addArticles(Article... newArticles) {
        List<Article> updatedArticles = new ArrayList<>(articles);
        updatedArticles.addAll(Arrays.asList(newArticles));
        return new MagazineAggregate(name, frequency, releaseDate, circulation, updatedArticles);
    }

    public MagazineAggregate removeArticle(String title) {
        List<Article> updatedArticles = articles.stream()
                .filter(article -> !article.title().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        return new MagazineAggregate(name, frequency, releaseDate, circulation, updatedArticles);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", releaseDate=" + releaseDate +
                ", circulation=" + circulation +
                ", articles=" + articles +
                '}';
    }
}
