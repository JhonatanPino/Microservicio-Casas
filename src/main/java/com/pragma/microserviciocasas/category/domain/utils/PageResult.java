package com.pragma.microserviciocasas.category.domain.utils;

import java.util.List;

public class PageResult<T> {
    private final List<T> content;
    private final int page;
    private final int size;
    private final boolean orderAsc;
    private final long totalElements;
    private final int totalPages;

    public PageResult(List<T> content, int page, int size, boolean orderAsc, long totalElements, int totalPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.orderAsc = orderAsc;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public boolean isOrderAsc() {
        return orderAsc;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
