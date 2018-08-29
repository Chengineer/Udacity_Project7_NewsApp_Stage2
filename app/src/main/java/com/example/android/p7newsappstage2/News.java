package com.example.android.p7newsappstage2;

import java.util.ArrayList;
import java.util.Date;

/**
 * A {@link News} object contains information related to a single news item.
 */
public class News {
    /**
     * Publication date and time of the news
     */
    private Date mPublicationDateTime;
    /**
     * Names of the news authors
     */
    private ArrayList<String> mContributorName;
    /**
     * Section of the news
     */
    private String mSection;
    /**
     * Title of the news
     */
    private String mTitle;
    /**
     * Image of the news
     */
    private String mImageUrl;
    /**
     * Website URL of the news
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title    is the title of the news item
     * @param authors  is an array of the authors' names
     * @param image    is the image posted in the news item
     * @param dateTime is the publication time and date of the news item
     * @param section  is the section that the news item belongs to
     * @param url      is the website URL to find more details about the news item
     */
    public News(String title, ArrayList<String> authors, String image, Date dateTime, String section, String url) {
        mTitle = title;
        mContributorName = authors;
        mImageUrl = image;
        mPublicationDateTime = dateTime;
        mSection = section;
        mUrl = url;
    }

    /**
     * Returns the title of the news item.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the an array that contains the names of the news-item's authors.
     */
    public ArrayList<String> getContributor() {
        return mContributorName;
    }

    /**
     * Returns the publication time and date of the news item.
     */
    public Date getPublicationDateAndTime() {
        return mPublicationDateTime;
    }

    /**
     * Returns the image url of the news item.
     */
    public String getImageUrl() {
        return mImageUrl;
    }

    /**
     * Returns the section that the news item belongs to.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the website URL to find more information about the news item.
     */
    public String getUrl() {
        return mUrl;
    }
}
