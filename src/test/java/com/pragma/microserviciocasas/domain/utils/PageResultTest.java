package com.pragma.microserviciocasas.domain.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageResultTest {

    private PageResult<String> pageResult;
    private List<String> content;

    @BeforeEach
    void setUp() {
        content = Arrays.asList("Item1", "Item2", "Item3");
        pageResult = new PageResult<>(content, 1, 3, true, 10, 4);
    }

    @Test
    void getContent() {
        assertEquals(content, pageResult.getContent());
    }

    @Test
    void getPage() {
        assertEquals(1, pageResult.getPage());
    }

    @Test
    void getSize() {
        assertEquals(3, pageResult.getSize());
    }

    @Test
    void isOrderAsc() {
        assertTrue(pageResult.isOrderAsc());
    }

    @Test
    void getTotalElements() {
        assertEquals(10, pageResult.getTotalElements());
    }

    @Test
    void getTotalPages() {
        assertEquals(4, pageResult.getTotalPages());
    }
}