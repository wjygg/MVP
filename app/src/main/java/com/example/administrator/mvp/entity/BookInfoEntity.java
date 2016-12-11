package com.example.administrator.mvp.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */

public class BookInfoEntity implements Serializable{

    private String id;
    private String title;
    private String subtitle;
    private String publisher;
    private BookRatingEntity rating;
    private String[] author;
    private String[] translator;
    private String pubdate;
    private List<BookTagEntity> tags;
    private String image;
    private String ebook_url;
    private String pages;
    private String binding;
    private String origin_title;
    private ImageEntity images;
    private String isbn13;
    private String author_intro;
    private String summary;
    private String ebook_price;
    private String price;
    private SeriesEntity series;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public BookRatingEntity getRating() {
        return rating;
    }

    public void setRating(BookRatingEntity rating) {
        this.rating = rating;
    }

    public List<BookTagEntity> getTags() {
        return tags;
    }

    public void setTags(List<BookTagEntity> tags) {
        this.tags = tags;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String[] getTranslator() {
        return translator;
    }

    public void setTranslator(String[] translator) {
        this.translator = translator;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEbook_url() {
        return ebook_url;
    }

    public void setEbook_url(String ebook_url) {
        this.ebook_url = ebook_url;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public ImageEntity getImages() {
        return images;
    }

    public void setImages(ImageEntity images) {
        this.images = images;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEbook_price() {
        return ebook_price;
    }

    public void setEbook_price(String ebook_price) {
        this.ebook_price = ebook_price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SeriesEntity getSeries() {
        return series;
    }

    public void setSeries(SeriesEntity series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "BookInfoEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", publisher='" + publisher + '\'' +
                ", rating=" + rating +
                ", author=" + Arrays.toString(author) +
                ", translator=" + Arrays.toString(translator) +
                ", pubdate='" + pubdate + '\'' +
                ", tags=" + tags +
                ", image='" + image + '\'' +
                ", ebook_url='" + ebook_url + '\'' +
                ", pages='" + pages + '\'' +
                ", binding='" + binding + '\'' +
                ", origin_title='" + origin_title + '\'' +
                ", images=" + images +
                ", isbn13='" + isbn13 + '\'' +
                ", author_intro='" + author_intro + '\'' +
                ", summary='" + summary + '\'' +
                ", ebook_price='" + ebook_price + '\'' +
                ", price='" + price + '\'' +
                ", series=" + series +
                '}';
    }
}
