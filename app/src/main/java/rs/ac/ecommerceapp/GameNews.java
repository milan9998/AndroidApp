package rs.ac.ecommerceapp;
import com.fasterxml.jackson.annotation.JsonProperty;
public class GameNews {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;
    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("thumbnail")

    private String thumbnail;
    @JsonProperty("main_image")
    private String mainImage;
    @JsonProperty("article_content")
    private String articleContent;
    @JsonProperty("article_url")
    private String articleUrl;


    @Override
    public String toString() {
        return "GuildWars2News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
}
