package com.mageddo.bookmarks.service;

import com.mageddo.bookmarks.controller.res.BookmarkRes;
import com.mageddo.bookmarks.dao.BookmarkDAO;
import com.mageddo.bookmarks.entity.BookmarkEntity;

import javax.inject.Singleton;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Singleton
public class BookmarksService {

	private static final int SEARCH_MIN_SIZE = 3;
	private final BookmarkDAO bookmarkDAO;

	public BookmarksService(BookmarkDAO bookmarkDAO) {
		this.bookmarkDAO = bookmarkDAO;
	}

	public void saveBookmark(BookmarkEntity bookmarkEntity){
		bookmarkDAO.saveBookmark(bookmarkEntity);
	}

	public List<BookmarkRes> getBookmarks(String query, String tag, int offset, int quantity){

		tag = tag.trim();
		query = query.trim();

		if (isNotBlank(tag)) {
			return bookmarkDAO.getBookmarks(tag, offset, quantity);
		} else if (isNotBlank(query)) {
			if (query.length() < SEARCH_MIN_SIZE) {
				throw new IllegalArgumentException(String.format("Search text must have %d characters at least", SEARCH_MIN_SIZE));
			}
			return bookmarkDAO.getBookmarksByNameOrContent(query, offset, quantity);
		}
		return bookmarkDAO.getBookmarks(offset, quantity);
	}

}
