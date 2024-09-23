package com.browsinghistory;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowsingHistory {
    private Deque<String> history = new ArrayDeque<>();
    private String currentPage = null;

    public void addPage(String page) {
        if (currentPage != null) {
            history.addFirst(currentPage);
        }
        currentPage = page;
    }

    public void goBack() {
        if (!history.isEmpty()) {
            currentPage = history.removeFirst();
        } else {
            System.out.println("No previous page.");
        }
    }

    public void goForward() {
        // Not implemented in this simple version
        System.out.println("Forward navigation not supported.");
    }

    public void displayCurrentPage() {
        System.out.println("Current page: " + currentPage);
    }

    public static void main(String[] args) {
        BrowsingHistory browser = new BrowsingHistory();

        // Example usage
        browser.addPage("Page 1");
        browser.addPage("Page 2");
        browser.goBack();
        browser.displayCurrentPage();
    }
}
