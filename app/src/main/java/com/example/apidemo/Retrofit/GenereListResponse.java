package com.example.apidemo.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenereListResponse {
    @SerializedName("genres_id")
    @Expose
    private Integer genresId;
    @SerializedName("genres_name")
    @Expose
    private String genresName;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;

    public Integer getGenresId() {
        return genresId;
    }

    public void setGenresId(Integer genresId) {
        this.genresId = genresId;
    }

    public String getGenresName() {
        return genresName;
    }

    public void setGenresName(String genresName) {
        this.genresName = genresName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}
