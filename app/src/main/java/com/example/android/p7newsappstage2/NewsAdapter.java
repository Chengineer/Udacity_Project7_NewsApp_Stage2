package com.example.android.p7newsappstage2;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news item
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news items, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Find the news item at the given position in the list of news
        News currentNew = getItem(position);
        // TITLE
        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the title of the current news item in that TextView
        titleView.setText(currentNew.getTitle());
        // AUTHORS
        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        // Create a formatted string ("author1" if there's more than one author: +" and author2 and author3...") of the authors' names
        String authors = null;
        for (int i = 0; i < currentNew.getContributor().size(); i++) {
            // if that's the first author, set authors string to his/her name
            if (i == 0)
                authors = currentNew.getContributor().get(i);
            // if that's not the first and last author, concatenate that author's name to the former's name with "," between them
            else if (i > 0 && i<(currentNew.getContributor().size()-1))
                authors += (", " + currentNew.getContributor().get(i));
            // if that's the last author, concatenate that author's name to the former's name with "and" between them
            else if(i==(currentNew.getContributor().size()-1))
                authors += (" and " + currentNew.getContributor().get(i));
        }
        // Display the authors string of the current news item in that TextView
        authorView.setText(authors);
        // SECTION
        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        // Display the section of the current news item in that TextView
        sectionView.setText(currentNew.getSection());
        // IMAGE
        // Find the ImageView with view ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Display the image from the image-url of the current news item in that ImageView
        if (currentNew != null) {
            new DownloadImageTask(imageView).execute(currentNew.getImageUrl());
        }
        // DATE
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(currentNew.getPublicationDateAndTime());
        // Display the date of the current news item in that TextView
        dateView.setText(formattedDate);
        // TIME
        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "04:30PM")
        String formattedTime = formatTime(currentNew.getPublicationDateAndTime());
        // Display the time of the current news item in that TextView
        timeView.setText(formattedTime);
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "04:30") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm ");
        return timeFormat.format(dateObject);
    }
}
